package dev.cluuny.grpcdemo.grpcdemoserver.repository;

import dev.cluuny.grpcdemo.grpcdemoserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByCitizenId(String citizenId);
    void deleteAllByCitizenId(String citizenId);
}
