package dev.cluuny.grpcdemo.grpcdemoserver.service.impl;

import dev.cluuny.grpcdemo.grpcdemoserver.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoserver.model.User;
import dev.cluuny.grpcdemo.grpcdemoserver.repository.IUserRepository;
import dev.cluuny.grpcdemo.grpcdemoserver.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;

    @Override
    public UserDTO getUserByCitizenId(String citizenId) {
        User user = repository.getUserByCitizenId(citizenId).orElseThrow();
        return this.mapToDTO(user);
    }

    @Override
    public User mapToEntity(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .citizenId(userDTO.getCitizenId())
                .birthDate(userDTO.getBirthDate())
                .build();
    }

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
