package dev.cluuny.grpcdemo.grpcdemoserver.repository;

import dev.cluuny.grpcdemo.grpcdemoserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface defines the project repository.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    /**
     * This method allows you to find a user based on their unique identification number.
     *
     * @param citizenId Unique identification number of the user to obtain.
     * @return Optional with user data built on top of the User class.
     */
    Optional<User> getUserByCitizenId(String citizenId);
}
