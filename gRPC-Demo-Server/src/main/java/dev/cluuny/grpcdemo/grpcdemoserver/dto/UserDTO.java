package dev.cluuny.grpcdemo.grpcdemoserver.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * This class is defined as the DTO of the User class, it allows clean entry and exit of the user.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String citizenId;
    private LocalDate birthDate;
}
