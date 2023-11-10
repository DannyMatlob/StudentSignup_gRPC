package edu.sjsu.cs158a.hello;

import edu.sjsu.cs158a.hello.Messages.CodeRequest;
import edu.sjsu.cs158a.hello.Messages.RegisterRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.sql.Array;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@Command
public class Main {
    @Command
    int add(@Parameters(paramLabel = "hostPort") String hostPort,
            @Parameters(paramLabel = "a") int a,
            @Parameters(paramLabel = "b") int b) {
        try {
            ManagedChannel channel = ManagedChannelBuilder.forTarget(hostPort).usePlaintext().build();
            var stub = AddExampleGrpc.newBlockingStub(channel);
            var request = Messages.AddExampleRequest.newBuilder().setA(a).setB(b).build();
            var rsp = stub.add(request);
            System.out.println(rsp.getResult());
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            System.out.println("problem communicating with " + hostPort);
        }
        return 0;
    }
    @Command
    int requestCode(@Parameters(paramLabel = "hostPort") String hostPort,
                    @Parameters(paramLabel = "course") String course,
                    @Parameters(paramLabel = "ssid") int ssid) {
        int addCodeRecv = 0;
        try {
            ManagedChannel channel = ManagedChannelBuilder.forTarget(hostPort).usePlaintext().build();
            var stub = HelloGrpc.newBlockingStub(channel);
            var request = Messages.CodeRequest.newBuilder().setCourse(course).setSsid(ssid).build();
            var rsp = stub.requestCode(request);
            int errorCode = rsp.getRc();
            addCodeRecv = rsp.getAddcode();
            if (errorCode==0) {
                //System.out.println("request successful");
                addCodeRecv = rsp.getAddcode();
            } else if (errorCode==1) {
                //System.out.println("invalid course");
            } else if (errorCode==2) {
                //System.out.println("invalid id");
            }
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            System.out.println("problem communicating with " + hostPort);
        }
        return addCodeRecv;
    }

    @Command
    int register(@Parameters(paramLabel = "hostPort") String hostPort,
                 @Parameters(paramLabel = "course") String course,
                 @Parameters(paramLabel = "ssid") int ssid,
                 @Parameters(paramLabel = "name") String name) {
        try {
            ManagedChannel channel = ManagedChannelBuilder.forTarget(hostPort).usePlaintext().build();
            var stub = HelloGrpc.newBlockingStub(channel);

            int addCodeRecv = requestCode(hostPort, course, ssid);
            if (addCodeRecv==0) {
                //System.out.println("No add code received");
                return 1;
            } else {
               //System.out.println("Received Add code. Registering");
            }

            var request = Messages.RegisterRequest.newBuilder().setAddCode(addCodeRecv).setSsid(ssid).setName(name).build();
            var rsp = stub.register(request);
            int errorCode = rsp.getRc();
            if (errorCode==0) {
                System.out.println("registration successful");
            } else if (errorCode==1) {
                System.out.println("problem getting add code: " + errorCode);
            } else if (errorCode==2) {
                System.out.println("problem registering: " + errorCode);
            }
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            System.out.println("problem communicating with " + hostPort);
        }
        return 0;
    }

    @Command
    int listStudents(@Parameters(paramLabel = "hostPort") String hostPort,
             @Parameters(paramLabel = "course") String course) {
        try {
            ManagedChannel channel = ManagedChannelBuilder.forTarget(hostPort).usePlaintext().build();
            var stub = HelloGrpc.newBlockingStub(channel);
            var request = Messages.ListRequest.newBuilder().setCourse(course).build();
            var rsp = stub.list(request);
            if (rsp.getRc()==1) {
                System.out.println("problem listing students: " + rsp.getRc());
            } else {
                var sortedList = new ArrayList<>(rsp.getRegisterationsList());
                sortedList.sort((p1, p2) -> Integer.compare(p1.getSsid(), p2.getSsid()));
                for (RegisterRequest rr : sortedList) {
                    System.out.println(rr.getAddCode() + " " + rr.getSsid() + " " + rr.getName());
                }
            }
        } catch (StatusRuntimeException e) {
            //e.printStackTrace();
            System.out.println("problem communicating with " + hostPort);
        }
        return 0;
    }

    @Command
    int breakRegister(  @Parameters(paramLabel = "hostPort") String hostPort,
                        @Parameters(paramLabel = "course") String course,
                        @Parameters(paramLabel = "ssid") int ssid,
                        @Parameters(paramLabel = "name") String name) {
        int numThreads = 20;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i<numThreads; i++) {
            final int threadID = i;
            threads[threadID] = new Thread(() -> {
                // Code to be executed in the new thread
                //System.out.println("New thread" + threadID);
                register(hostPort,course,ssid + threadID,name + threadID);
            });
            threads[threadID].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    @Command
    int server(@Parameters(paramLabel = "port") int port) throws InterruptedException {
        class HelloImpl extends HelloGrpc.HelloImplBase {
            private Object lock = new Object();
            boolean isValidSsid(int n) {
                if (n >= 100000 && n <= 90000000) return true;
                return false;
            }
            HashSet<String> validCourses = new HashSet<>(Arrays.asList("CS158A", "CS158B"));
            AtomicInteger addCounter = new AtomicInteger(1);
            ConcurrentHashMap<CodeRequest, Integer> request_addcode_map = new ConcurrentHashMap<>();
            ConcurrentHashMap<String, List<RegisterRequest>> course_regrequest_map = new ConcurrentHashMap<>();
            ConcurrentHashMap<Integer, CodeRequest> addcode_request_map = new ConcurrentHashMap<>();
            @Override
            public void requestCode(Messages.CodeRequest request, StreamObserver<Messages.CodeResponse> responseObserver) {
                var responseBuilder = Messages.CodeResponse.newBuilder();

                var course = request.getCourse();
                var ssid = request.getSsid();
                responseBuilder.setRc(2);
                //Check valid ssid
                if (!isValidSsid(ssid)) {
                    System.out.println("invalid ssid :" +  ssid + ", " + course);
                    responseBuilder.setRc(2);
                } else if (!validCourses.contains(course)) { //Check valid course
                    System.out.println("invalid course for ssid and course: " +  ssid + ", " + course);
                    responseBuilder.setRc(1);
                } else { //Fulfill new request
                    //System.out.println("Handling new addcode for ssid and course: " +  ssid + ", " + course);
                    synchronized (lock) {
                        int addCode = addCounter.getAndAdd(1);
                        System.out.println("handing out add code: " + addCode);
                        request_addcode_map.put(request, addCode);
                        addcode_request_map.put(addCode,request);
                        responseBuilder.setAddcode(addCode);
                        responseBuilder.setRc(0);
                    }
                }

                //Build and send response
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                var response = responseBuilder.build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
            @Override
            public void register(Messages.RegisterRequest request, StreamObserver<Messages.RegisterResponse> responseObserver) {
                var responseBuilder = Messages.RegisterResponse.newBuilder();

                var addCode = request.getAddCode();
                var ssid = request.getSsid();
                var name = request.getName();
                synchronized (lock) {
                    if (!request_addcode_map.containsValue(addCode)) {
                        //if Addcode not generated by server, return error
                        System.out.println("Addcode not in server for: " + addCode + ", " + ssid + "," + name);
                        responseBuilder.setRc(1);
                    } else if (addcode_request_map.get(addCode).getSsid() != ssid) {
                        //if ssid does not match addcode, return error
                        System.out.println("ssid does not match: " + addCode + ", " + ssid + "," + name + " : " + addcode_request_map.get(addCode).getSsid());
                        responseBuilder.setRc(2);
                    } else {
                        //ssid matches and is valid, fulfill request

                        String courseName = addcode_request_map.get(addCode).getCourse();
                        if (course_regrequest_map.get(courseName) == null)
                            course_regrequest_map.put(courseName, new ArrayList<>());
                        List<RegisterRequest> courseSignups = course_regrequest_map.get(courseName);

                        //Check if ssid already registered before in order to rename
                        for (RegisterRequest signup : courseSignups) {
                            if (signup.getSsid() == ssid) {
                                courseSignups.remove(signup);
                                break;
                            }
                        }
                        courseSignups.add(request);
                        responseBuilder.setRc(0);
                    }
                }

                //Build and send response
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var response = responseBuilder.build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
            @Override
            public void list(Messages.ListRequest request, StreamObserver<Messages.ListResponse> responseObserver) {
                var responseBuilder = Messages.ListResponse.newBuilder();

                var course = request.getCourse();
                if (!validCourses.contains(course)) {
                    responseBuilder.setRc(1);
                } else if (course_regrequest_map.get(course)!=null) {
                    for (RegisterRequest rr : course_regrequest_map.get(course)) {
                        responseBuilder.addRegisterations(rr);
                    }
                }

                //Build and send response
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var response = responseBuilder.build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }

        try {
            var server = ServerBuilder.forPort(port).addService(new HelloImpl()).build();
            server.start();
            server.awaitTermination();
        } catch (IOException e) {
            System.out.println("couldn't serve on " + port);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.exit(new CommandLine(new Main()).execute(args));
    }
}