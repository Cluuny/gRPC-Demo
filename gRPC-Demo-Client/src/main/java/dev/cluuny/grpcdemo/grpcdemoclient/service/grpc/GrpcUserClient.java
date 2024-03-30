package dev.cluuny.grpcdemo.grpcdemoclient.service.grpc;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import dev.cluuny.grpc_demo.UserObject;
import dev.cluuny.grpc_demo.UserServiceRequest;
import dev.cluuny.grpc_demo.userServiceGrpc;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.CompleteCarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;
import dev.cluuny.grpcdemo.grpcdemoclient.repository.ICarsRepository;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrpcUserClient {

    private final ICarsRepository repository;
    @GrpcClient(value = "gRPC-Demo-Server")
    private userServiceGrpc.userServiceBlockingStub stub;
//    private final EurekaClient eurekaClient;
//    InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("GRPC-DEMO-SERVER", false);
//    ManagedChannel channel = NettyChannelBuilder.forTarget("localhost:9090").usePlaintext().build();

    public List<CompleteCarDTO> getCarByOwnerId(String id) {
        List<Car> cars = repository.getAllByOwnerId(id).orElseThrow();
//        userServiceGrpc.userServiceBlockingStub stub;

        UserObject userObject = stub.getUserByCitizenId(UserServiceRequest.newBuilder()
                .setCitizenId(String.valueOf(id))
                .build());

//        channel.shutdownNow();

        UserDTO retrievedUserDTO = UserDTO.builder()
                .id(userObject.getId())
                .name(userObject.getName())
                .lastName(userObject.getLastName())
                .citizenId(userObject.getCitizenId())
                .birthDate(LocalDate.parse(userObject.getBirthDate()))
                .build();

        return cars.stream().map(car -> CompleteCarDTO.builder()
                .id(car.getId())
                .owner(retrievedUserDTO)
                .brand(car.getBrand())
                .model(car.getModel())
                .carYear(car.getCarYear())
                .build()).toList();
    }
}
