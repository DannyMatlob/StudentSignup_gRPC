package edu.sjsu.cs158a.hello;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: messages.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AddExampleGrpc {

  private AddExampleGrpc() {}

  public static final String SERVICE_NAME = "hello.AddExample";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.AddExampleRequest,
      edu.sjsu.cs158a.hello.Messages.AddExampleResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = edu.sjsu.cs158a.hello.Messages.AddExampleRequest.class,
      responseType = edu.sjsu.cs158a.hello.Messages.AddExampleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.AddExampleRequest,
      edu.sjsu.cs158a.hello.Messages.AddExampleResponse> getAddMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.AddExampleRequest, edu.sjsu.cs158a.hello.Messages.AddExampleResponse> getAddMethod;
    if ((getAddMethod = AddExampleGrpc.getAddMethod) == null) {
      synchronized (AddExampleGrpc.class) {
        if ((getAddMethod = AddExampleGrpc.getAddMethod) == null) {
          AddExampleGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs158a.hello.Messages.AddExampleRequest, edu.sjsu.cs158a.hello.Messages.AddExampleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.AddExampleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.AddExampleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddExampleMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddExampleStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddExampleStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddExampleStub>() {
        @java.lang.Override
        public AddExampleStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddExampleStub(channel, callOptions);
        }
      };
    return AddExampleStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddExampleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddExampleBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddExampleBlockingStub>() {
        @java.lang.Override
        public AddExampleBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddExampleBlockingStub(channel, callOptions);
        }
      };
    return AddExampleBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddExampleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddExampleFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddExampleFutureStub>() {
        @java.lang.Override
        public AddExampleFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddExampleFutureStub(channel, callOptions);
        }
      };
    return AddExampleFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void add(edu.sjsu.cs158a.hello.Messages.AddExampleRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.AddExampleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AddExample.
   */
  public static abstract class AddExampleImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AddExampleGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AddExample.
   */
  public static final class AddExampleStub
      extends io.grpc.stub.AbstractAsyncStub<AddExampleStub> {
    private AddExampleStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddExampleStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddExampleStub(channel, callOptions);
    }

    /**
     */
    public void add(edu.sjsu.cs158a.hello.Messages.AddExampleRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.AddExampleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AddExample.
   */
  public static final class AddExampleBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AddExampleBlockingStub> {
    private AddExampleBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddExampleBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddExampleBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.sjsu.cs158a.hello.Messages.AddExampleResponse add(edu.sjsu.cs158a.hello.Messages.AddExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AddExample.
   */
  public static final class AddExampleFutureStub
      extends io.grpc.stub.AbstractFutureStub<AddExampleFutureStub> {
    private AddExampleFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddExampleFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddExampleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs158a.hello.Messages.AddExampleResponse> add(
        edu.sjsu.cs158a.hello.Messages.AddExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((edu.sjsu.cs158a.hello.Messages.AddExampleRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.AddExampleResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.sjsu.cs158a.hello.Messages.AddExampleRequest,
              edu.sjsu.cs158a.hello.Messages.AddExampleResponse>(
                service, METHODID_ADD)))
        .build();
  }

  private static abstract class AddExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddExampleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.sjsu.cs158a.hello.Messages.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AddExample");
    }
  }

  private static final class AddExampleFileDescriptorSupplier
      extends AddExampleBaseDescriptorSupplier {
    AddExampleFileDescriptorSupplier() {}
  }

  private static final class AddExampleMethodDescriptorSupplier
      extends AddExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AddExampleMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AddExampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddExampleFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .build();
        }
      }
    }
    return result;
  }
}
