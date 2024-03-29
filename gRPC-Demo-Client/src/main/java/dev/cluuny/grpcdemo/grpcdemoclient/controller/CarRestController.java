package dev.cluuny.grpcdemo.grpcdemoclient.controller;

import dev.cluuny.grpcdemo.grpcdemoclient.dto.CarDTO;
import dev.cluuny.grpcdemo.grpcdemoclient.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarRestController {

    private final ICarService service;

    @GetMapping("/{ownerId}")
    public ResponseEntity<CarDTO> getCarByOwnerId(@PathVariable Long ownerId) {
        return ResponseEntity.ok(service.getCarByOwnerId(ownerId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(service.createCar(carDTO));
    }

    @DeleteMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCarByOwnerId(@PathVariable Long ownerId) {
        service.deleteCarByOwnerId(ownerId);
    }
}
