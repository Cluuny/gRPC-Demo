package dev.cluuny.grpcdemo.grpcdemoserver.service;

import dev.cluuny.grpcdemo.grpcdemoserver.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoserver.model.User;

import java.util.List;

public interface IUserService {
    UserDTO getUserByCitizenId(String citizenId);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    void deleteUserByCitizenId(String citizenId);

    User mapToEntity(UserDTO userDTO);

    UserDTO mapToDTO(User user);
}
