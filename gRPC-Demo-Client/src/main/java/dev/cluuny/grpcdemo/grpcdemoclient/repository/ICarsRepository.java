package dev.cluuny.grpcdemo.grpcdemoclient.repository;

import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICarsRepository extends JpaRepository<Car, Long> {
    Optional<List<Car>> getAllByOwnerId(String ownerId);

    void deleteCarByOwnerId(String ownerId);
}
