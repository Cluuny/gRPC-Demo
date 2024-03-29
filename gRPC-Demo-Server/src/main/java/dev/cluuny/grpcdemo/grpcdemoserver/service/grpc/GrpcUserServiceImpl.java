package dev.cluuny.grpcdemo.grpcdemoserver.service.grpc;

import dev.cluuny.grpc_demo.UserObject;
import dev.cluuny.grpc_demo.UserServiceRequest;
import dev.cluuny.grpc_demo.userServiceGrpc;
import dev.cluuny.grpcdemo.grpcdemoserver.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoserver.service.IUserService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class GrpcUserServiceImpl extends userServiceGrpc.userServiceImplBase {

    private final IUserService service;

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
