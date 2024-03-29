package dev.cluuny.grpcdemo.grpcdemoclient.service;

import dev.cluuny.grpcdemo.grpcdemoclient.dto.CarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.CompleteCarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;

import java.util.List;

public interface ICarService {
    List<CompleteCarDTO> getCarByOwnerId(String ownerId);

    List<CarDTO> getAllCars();

    List<CompleteCarDTO> createCar(CarDTO carDTO);

    void deleteCarByOwnerId(String ownerId);

    Car mapToEntity(CarDTO carDTO);

    CarDTO mapToDTO(Car car);

}
