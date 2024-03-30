package dev.cluuny.grpcdemo.grpcdemoserver.service.impl;

import dev.cluuny.grpcdemo.grpcdemoserver.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoserver.model.User;
import dev.cluuny.grpcdemo.grpcdemoserver.repository.IUserRepository;
import dev.cluuny.grpcdemo.grpcdemoserver.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This class defines an implementation of the IUserService interface.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    /**
     * Bean of type IUserRepository.
     */
    private final IUserRepository repository;

    /**
     * Implementation of the getUserByCitizenId method defined in the IUserService interface.
     *
     * @param citizenId Unique identification number of the user to obtain.
     * @return User data built on top of the UserDTO class.
     */
    @Override
    public UserDTO getUserByCitizenId(String citizenId) {
        User user = repository.getUserByCitizenId(citizenId).orElseThrow();
        return this.mapToDTO(user);
    }

    /**
     * Implementation of the mapToDTO method defined in the IUserService interface.
     *
     * @param user User data built on top of the User class.
     * @return User data built on top of the UserDTO class.
     */
    @Override
    public UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .citizenId(user.getCitizenId())
                .birthDate(user.getBirthDate())
                .build();
    }
}
