package dev.cluuny.grpcdemo.grpcdemoclient.service;

import dev.cluuny.grpcdemo.grpcdemoclient.dto.CarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;

import java.util.List;

public interface ICarService {
    CarDTO getCarByOwnerId(Long ownerId);

    List<CarDTO> getAllCars();

    CarDTO createCar(CarDTO carDTO);

    void deleteCarByOwnerId(Long ownerId);

    Car mapToEntity(CarDTO carDTO);

    CarDTO mapToDTO(Car car);

}
