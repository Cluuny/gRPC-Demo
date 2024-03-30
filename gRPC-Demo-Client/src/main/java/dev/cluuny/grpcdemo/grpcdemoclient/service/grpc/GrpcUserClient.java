package dev.cluuny.grpcdemo.grpcdemoclient.service.grpc;

import dev.cluuny.grpc_demo.UserObject;
import dev.cluuny.grpc_demo.UserServiceRequest;
import dev.cluuny.grpc_demo.userServiceGrpc;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.CompleteCarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;
import dev.cluuny.grpcdemo.grpcdemoclient.repository.ICarsRepository;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * This class defines the service capable of making gRPC calls to the gRPC-Demo-Server service with the objective of obtaining user data.
 */
@Service
@RequiredArgsConstructor
public class GrpcUserClient {

    /**
     * Bean of type ICarsRepository.
     */
    private final ICarsRepository repository;
    /**
     * Bean of type userServiceGrpc.userServiceBlockingStub which defines the stub with which to create the connection and make calls to the service provided to the @GrpcClient annotation.
     */
    @GrpcClient(value = "gRPC-Demo-Server")
    private userServiceGrpc.userServiceBlockingStub stub;

    /**
     * This method encompasses the entire process of obtaining and constructing the data for the consequent return of an object of type CompleteCarDTO.
     * It accomplishes this by first obtaining a list of vehicles belonging to the owner based on their unique identification number.
     * After this, it obtains the user information through the stub and the gRPC call.
     * Next, it constructs an object of type UserDTO based on the information collected from the gRPC call.
     * Finally, it returns a list of objects of type CompleteCarDTO coming from the list of cars obtained at the beginning of the operation.
     *
     * @param id Unique identification number of the person.
     * @return List of CompleteCarDTO objects.
     */
    public List<CompleteCarDTO> getCarByOwnerId(String id) {
        List<Car> cars = repository.getAllByOwnerId(id).orElseThrow();

        UserObject userObject = stub.getUserByCitizenId(UserServiceRequest.newBuilder()
                .setCitizenId(String.valueOf(id))
                .build());

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
