package dev.cluuny.grpcdemo.grpcdemoclient.service;

import dev.cluuny.grpcdemo.grpcdemoclient.dto.CarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.CompleteCarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;

import java.util.List;

/**
 * This interface defines the services that the application will offer.
 */
public interface ICarService {
    /**
     * This method allows obtaining information about those cars that belong to the registered user with their unique identification number sent as a parameter.
     *
     * @param ownerId Unique identification number of the person.
     * @return List of CompleteCarDTO objects.
     */
    List<CompleteCarDTO> getCarByOwnerId(String ownerId);

    /**
     * This method allows you to obtain information on all registered cars.
     *
     * @return List of objects of type CarDTO.
     */
    List<CarDTO> getAllCars();

    /**
     * This method allows the registration of car data.
     *
     * @param carDTO CarDTO with the data to be registered.
     * @return List with an object of type CompleteCarDTO that contains the information of the newly registered car.
     */
    List<CompleteCarDTO> createCar(CarDTO carDTO);

    /**
     * This method allows you to delete information from those cars that belong to the registered user with their unique identification number sent as a parameter.
     *
     * @param ownerId Unique identification number of the person.
     */
    void deleteCarByOwnerId(String ownerId);

    /**
     * This method allows transpiling the car data built on the CarDTO class to the Car class.
     *
     * @param carDTO Car Data built on top of the CarDTO class.
     * @return Car Data built on top of the Car class.
     */
    Car mapToEntity(CarDTO carDTO);

    /**
     * This method allows transpiling the car data built on the Car class to the CarDTO class.
     *
     * @param car Car Data built on top of the Car class.
     * @return Car Data built on top of the CarDTO class.
     */
    CarDTO mapToDTO(Car car);

}
