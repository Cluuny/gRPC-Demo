package dev.cluuny.grpcdemo.grpcdemoserver.controller;

import dev.cluuny.grpcdemo.grpcdemoserver.dto.UserDTO;
import dev.cluuny.grpcdemo.grpcdemoserver.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserService service;

    @GetMapping("/{citizenId}")
    public ResponseEntity<UserDTO> getUserByCitizenId(@PathVariable String citizenId) {
        UserDTO user = service.getUserByCitizenId(citizenId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    private ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return service.createUser(userDTO);
    }

    @DeleteMapping("/{citizenId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserByCitizenId(@PathVariable String citizenId) {
        service.deleteUserByCitizenId(citizenId);
    }
}

