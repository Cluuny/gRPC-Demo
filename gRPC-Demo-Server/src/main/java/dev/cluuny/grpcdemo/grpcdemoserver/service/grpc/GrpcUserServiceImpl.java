package dev.cluuny.grpcdemo.grpcdemoserver.service.grpc;

import dev.cluuny.grpc_demo.UserObject;
import dev.cluuny.grpc_demo.UserServiceRequest;
import dev.cluuny.grpc_demo.userServiceGrpc;
import dev.cluuny.grpcdemo.grpcdemoserver.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoserver.service.IUserService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * This class allows the implementation of the userService service defined within the .proto file of the gRPC-Demo-Interface module.
 */
@GrpcService
@RequiredArgsConstructor
public class GrpcUserServiceImpl extends userServiceGrpc.userServiceImplBase {

    /**
     * Bean of type IUserService.
     */
    private final IUserService service;

    /**
     * implementation of the getUserByCitizenId method defined within the userServiceGrpc.userServiceImplBase class within the gRPC-Demo-Interface module.
     * Within this method, the user data is first obtained with the help of the IUserService type bean and then transpiled to the UserObject type, which is defined as an implementation of the UserObject message defined within the .proto file of the gRPC-Demo-Interface module. , with this transpiled data a response is returned which is defined as the final response for the implementation of this method.
     *
     * @param request          Object of type UserServiceRequest defined as input message inside the file.
     * @param responseObserver Object of type StreamObserver<> that contains an object of type UserObject which is defined according to the UserObject message defined within the .proto file of the gRPC-Demo-Interface module.
     */
    @Override
    public void getUserByCitizenId(UserServiceRequest request, StreamObserver<UserObject> responseObserver) {
        UserDTO user = service.getUserByCitizenId(request.getCitizenId());

        UserObject userObject = UserObject.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .setLastName(user.getLastName())
                .setCitizenId(user.getCitizenId())
                .setBirthDate(String.valueOf(user.getBirthDate()))
                .build();

        responseObserver.onNext(userObject);
        responseObserver.onCompleted();
    }
}
