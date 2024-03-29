package dev.cluuny.grpcdemo.grpcdemoclient.dto;

import lombok.*;

import java.time.LocalDate;

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
