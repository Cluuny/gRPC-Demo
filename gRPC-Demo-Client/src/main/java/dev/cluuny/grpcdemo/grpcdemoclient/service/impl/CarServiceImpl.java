package dev.cluuny.grpcdemo.grpcdemoclient.service.impl;

import dev.cluuny.grpcdemo.grpcdemoclient.dto.CarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;
import dev.cluuny.grpcdemo.grpcdemoclient.repository.ICarsRepository;
import dev.cluuny.grpcdemo.grpcdemoclient.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

    private final ICarsRepository repository;

    @Override
    public CarDTO getCarByOwnerId(Long ownerId) {
        return repository.getCarByOwnerId(ownerId).map(this::mapToDTO).orElseThrow();
    }

    @Override
    public List<CarDTO> getAllCars() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Car car = repository.save(this.mapToEntity(carDTO));
        return this.getCarByOwnerId(car.getOwnerId());
    }

    @Override
    public void deleteCarByOwnerId(Long ownerId) {
        repository.deleteCarByOwnerId(ownerId);
    }

    @Override
    public Car mapToEntity(CarDTO carDTO) {
        return Car.builder()
                .ownerId(carDTO.getOwnerId())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .carYear(carDTO.getCarYear())
                .build();
    }

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
