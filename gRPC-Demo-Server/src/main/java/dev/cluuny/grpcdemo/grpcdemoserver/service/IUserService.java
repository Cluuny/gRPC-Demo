package dev.cluuny.grpcdemo.grpcdemoserver.service;

import dev.cluuny.grpcdemo.grpcdemoserver.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoserver.model.User;

/**
 * This interface defines the services that the application will offer.
 */
public interface IUserService {
    /**
     * This method allows you to find a user based on their unique identification number.
     *
     * @param citizenId Unique identification number of the user to obtain.
     * @return User data built on top of the UserDTO class.
     */
    UserDTO getUserByCitizenId(String citizenId);

    /**
     * This method allows transpiling the user data built on the User class to the UserDTO class.
     *
     * @param user User data built on top of the User class.
     * @return User data built on top of the UserDTO class.
     */
    UserDTO mapToDTO(User user);
}
