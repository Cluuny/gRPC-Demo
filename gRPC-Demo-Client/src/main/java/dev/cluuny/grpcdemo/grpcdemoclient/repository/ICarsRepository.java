package dev.cluuny.grpcdemo.grpcdemoclient.repository;

import dev.cluuny.grpcdemo.grpcdemoclient.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines the application repository.
 */
@Repository
public interface ICarsRepository extends JpaRepository<Car, Long> {
    /**
     * This method allows obtaining information about those cars that belong to the registered user with their unique identification number sent as a parameter.
     *
     * @param ownerId Unique identification number of the person.
     * @return Optional<> with a list of cars found under that unique identification number
     */
    Optional<List<Car>> getAllByOwnerId(String ownerId);

    /**
     * This method allows you to delete information from those cars that belong to the registered user with their unique identification number sent as a parameter.
     *
     * @param ownerId Unique identification number of the person.
     */
    void deleteCarByOwnerId(String ownerId);
}
