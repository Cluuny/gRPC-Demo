package dev.cluuny.grpcdemo.grpcdemoclient.service.impl;

import dev.cluuny.grpcdemo.grpcdemoclient.dto.CarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.CompleteCarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;
import dev.cluuny.grpcdemo.grpcdemoclient.repository.ICarsRepository;
import dev.cluuny.grpcdemo.grpcdemoclient.service.ICarService;
import dev.cluuny.grpcdemo.grpcdemoclient.service.grpc.GrpcUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class defines an implementation of the ICarService interface.
 */
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

    /**
     * Bean of type ICarsRepository.
     */
    private final ICarsRepository repository;
    /**
     * Bean of tye GrpcUserClient that allows the gRPC calls.
     */
    private final GrpcUserClient grpcClient;

    /**
     * Implementation of the getCarByOwnerId method defined in the ICarService interface.
     * This method will use the gRPC client service to make the call to the gRPC-Demo-Server service and thus be able to obtain the user data to later build the CompleteCarDTO type objects.
     *
     * @param ownerId Unique identification number of the person
     * @return List of CompleteCarDTO objects.
     */
    @Override
    public List<CompleteCarDTO> getCarByOwnerId(String ownerId) {
        return grpcClient.getCarByOwnerId(ownerId);
    }

    /**
     * Implementation of the getAllCars method defined in the ICarService interface.
     *
     * @return List of objects of type CarDTO.
     */
    @Override
    public List<CarDTO> getAllCars() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    /**
     * Implementation of the createCar method defined in the ICarService interface.
     *
     * @param carDTO CarDTO with the data to be registered.
     * @return List with an object of type CompleteCarDTO that contains the information of the newly registered car.
     */
    @Override
    public List<CompleteCarDTO> createCar(CarDTO carDTO) {
        Car car = repository.save(this.mapToEntity(carDTO));
        return this.getCarByOwnerId(car.getOwnerId());
    }

    /**
     * Implementation of the deleteCarByOwnerId method defined in the ICarService interface.
     *
     * @param ownerId Unique identification number of the person.
     */
    @Override
    public void deleteCarByOwnerId(String ownerId) {
        repository.deleteCarByOwnerId(ownerId);
    }

    /**
     * Implementation of the mapToEntity method defined in the ICarService interface.
     *
     * @param carDTO Car Data built on top of the CarDTO class.
     * @return Car Data built on top of the Car class.
     */
    @Override
    public Car mapToEntity(CarDTO carDTO) {
        return Car.builder()
                .ownerId(carDTO.getOwnerId())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .carYear(carDTO.getCarYear())
                .build();
    }

    /**
     * Implementation of the mapToDTO method defined in the ICarService interface.
     *
     * @param car Car Data built on top of the Car class.
     * @return Car Data built on top of the CarDTO class.
     */
    @Override
    public CarDTO mapToDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .ownerId(car.getOwnerId())
                .brand(car.getBrand())
                .model(car.getModel())
                .carYear(car.getCarYear())
                .build();
    }
}
