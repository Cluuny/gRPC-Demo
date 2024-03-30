package dev.cluuny.grpcdemo.grpcdemoclient.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * This DTO allows the construction of the data obtained through the gRPC call to the gRPC-Demo-Server.
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
