package edu.sjsu.cs158a.hello;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: messages.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloGrpc {

  private HelloGrpc() {}

  public static final String SERVICE_NAME = "hello.Hello";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.CodeRequest,
      edu.sjsu.cs158a.hello.Messages.CodeResponse> getRequestCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestCode",
      requestType = edu.sjsu.cs158a.hello.Messages.CodeRequest.class,
      responseType = edu.sjsu.cs158a.hello.Messages.CodeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.CodeRequest,
      edu.sjsu.cs158a.hello.Messages.CodeResponse> getRequestCodeMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.CodeRequest, edu.sjsu.cs158a.hello.Messages.CodeResponse> getRequestCodeMethod;
    if ((getRequestCodeMethod = HelloGrpc.getRequestCodeMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getRequestCodeMethod = HelloGrpc.getRequestCodeMethod) == null) {
          HelloGrpc.getRequestCodeMethod = getRequestCodeMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs158a.hello.Messages.CodeRequest, edu.sjsu.cs158a.hello.Messages.CodeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "requestCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.CodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.CodeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("requestCode"))
              .build();
        }
      }
    }
    return getRequestCodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.RegisterRequest,
      edu.sjsu.cs158a.hello.Messages.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = edu.sjsu.cs158a.hello.Messages.RegisterRequest.class,
      responseType = edu.sjsu.cs158a.hello.Messages.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.RegisterRequest,
      edu.sjsu.cs158a.hello.Messages.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.RegisterRequest, edu.sjsu.cs158a.hello.Messages.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = HelloGrpc.getRegisterMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getRegisterMethod = HelloGrpc.getRegisterMethod) == null) {
          HelloGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs158a.hello.Messages.RegisterRequest, edu.sjsu.cs158a.hello.Messages.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.ListRequest,
      edu.sjsu.cs158a.hello.Messages.ListResponse> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "list",
      requestType = edu.sjsu.cs158a.hello.Messages.ListRequest.class,
      responseType = edu.sjsu.cs158a.hello.Messages.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.ListRequest,
      edu.sjsu.cs158a.hello.Messages.ListResponse> getListMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs158a.hello.Messages.ListRequest, edu.sjsu.cs158a.hello.Messages.ListResponse> getListMethod;
    if ((getListMethod = HelloGrpc.getListMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getListMethod = HelloGrpc.getListMethod) == null) {
          HelloGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs158a.hello.Messages.ListRequest, edu.sjsu.cs158a.hello.Messages.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "list"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.ListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs158a.hello.Messages.ListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloMethodDescriptorSupplier("list"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloStub>() {
        @java.lang.Override
        public HelloStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloStub(channel, callOptions);
        }
      };
    return HelloStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloBlockingStub>() {
        @java.lang.Override
        public HelloBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloBlockingStub(channel, callOptions);
        }
      };
    return HelloBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloFutureStub>() {
        @java.lang.Override
        public HelloFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloFutureStub(channel, callOptions);
        }
      };
    return HelloFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void requestCode(edu.sjsu.cs158a.hello.Messages.CodeRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.CodeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestCodeMethod(), responseObserver);
    }

    /**
     */
    default void register(edu.sjsu.cs158a.hello.Messages.RegisterRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.RegisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    default void list(edu.sjsu.cs158a.hello.Messages.ListRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.ListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Hello.
   */
  public static abstract class HelloImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HelloGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Hello.
   */
  public static final class HelloStub
      extends io.grpc.stub.AbstractAsyncStub<HelloStub> {
    private HelloStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloStub(channel, callOptions);
    }

    /**
     */
    public void requestCode(edu.sjsu.cs158a.hello.Messages.CodeRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.CodeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestCodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void register(edu.sjsu.cs158a.hello.Messages.RegisterRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.RegisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(edu.sjsu.cs158a.hello.Messages.ListRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.ListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Hello.
   */
  public static final class HelloBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HelloBlockingStub> {
    private HelloBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.sjsu.cs158a.hello.Messages.CodeResponse requestCode(edu.sjsu.cs158a.hello.Messages.CodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestCodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.sjsu.cs158a.hello.Messages.RegisterResponse register(edu.sjsu.cs158a.hello.Messages.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.sjsu.cs158a.hello.Messages.ListResponse list(edu.sjsu.cs158a.hello.Messages.ListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Hello.
   */
  public static final class HelloFutureStub
      extends io.grpc.stub.AbstractFutureStub<HelloFutureStub> {
    private HelloFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs158a.hello.Messages.CodeResponse> requestCode(
        edu.sjsu.cs158a.hello.Messages.CodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestCodeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs158a.hello.Messages.RegisterResponse> register(
        edu.sjsu.cs158a.hello.Messages.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs158a.hello.Messages.ListResponse> list(
        edu.sjsu.cs158a.hello.Messages.ListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_CODE = 0;
  private static final int METHODID_REGISTER = 1;
  private static final int METHODID_LIST = 2;

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
        case METHODID_REQUEST_CODE:
          serviceImpl.requestCode((edu.sjsu.cs158a.hello.Messages.CodeRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.CodeResponse>) responseObserver);
          break;
        case METHODID_REGISTER:
          serviceImpl.register((edu.sjsu.cs158a.hello.Messages.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.RegisterResponse>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((edu.sjsu.cs158a.hello.Messages.ListRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs158a.hello.Messages.ListResponse>) responseObserver);
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
          getRequestCodeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.sjsu.cs158a.hello.Messages.CodeRequest,
              edu.sjsu.cs158a.hello.Messages.CodeResponse>(
                service, METHODID_REQUEST_CODE)))
        .addMethod(
          getRegisterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.sjsu.cs158a.hello.Messages.RegisterRequest,
              edu.sjsu.cs158a.hello.Messages.RegisterResponse>(
                service, METHODID_REGISTER)))
        .addMethod(
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.sjsu.cs158a.hello.Messages.ListRequest,
              edu.sjsu.cs158a.hello.Messages.ListResponse>(
                service, METHODID_LIST)))
        .build();
  }

  private static abstract class HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.sjsu.cs158a.hello.Messages.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Hello");
    }
  }

  private static final class HelloFileDescriptorSupplier
      extends HelloBaseDescriptorSupplier {
    HelloFileDescriptorSupplier() {}
  }

  private static final class HelloMethodDescriptorSupplier
      extends HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloMethodDescriptorSupplier(String methodName) {
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
      synchronized (HelloGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloFileDescriptorSupplier())
              .addMethod(getRequestCodeMethod())
              .addMethod(getRegisterMethod())
              .addMethod(getListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
