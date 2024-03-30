package dev.cluuny.grpcdemo.grpcdemoclient.controller;

import dev.cluuny.grpcdemo.grpcdemoclient.dto.CarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.dto.CompleteCarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController for application.
 */
@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarRestController {

    /**
     * Bean of type ICarService.
     */
    private final ICarService service;

    /**
     * This method allows the HTTP GET call to obtain information on vehicles assigned to a unique identification number.
     *
     * @param ownerId Unique identification number of the person.
     * @return Object of type ResponseEntity with a list based on objects of type CompleteCarDTO.
     */
    @GetMapping("/{ownerId}")
    public ResponseEntity<List<CompleteCarDTO>> getCarByOwnerId(@PathVariable String ownerId) {
        return ResponseEntity.ok(service.getCarByOwnerId(ownerId));
    }

    /**
     * This method allows the HTTP GET call to obtain the information of all registered cars.
     *
     * @return Object of type ResponseEntity with a list based on objects of type CarDTO.
     */
    @GetMapping("/all")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }

    /**
     * This method allows the HTTP POST call to register the data of a car within the service.
     *
     * @param carDTO CarDTO type object that contains all the information of the vehicle to be registered.
     * @return Object of type ResponseEntity with a list based on objects of type CompleteCarDTO.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<CompleteCarDTO>> createCar(@RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(service.createCar(carDTO));
    }

    /**
     * This method allows the HTTP DELETE call to delete the information regarding a vehicle.
     *
     * @param ownerId Unique identification number of the person.
     */
    @DeleteMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCarByOwnerId(@PathVariable String ownerId) {
        service.deleteCarByOwnerId(ownerId);
    }
}
