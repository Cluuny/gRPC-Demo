package dev.cluuny.grpcdemo.grpcdemoclient.dto;

import lombok.*;

/**
 * This DTO allows the clean output of the data collected from the database of the application itself and from the data obtained through the gRPC call to the gRPC-Demo-Server in order to obtain the data of the user who owns the car.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteCarDTO {
    private Long id;
    private UserDTO owner;
    private String brand;
    private String model;
    private Integer carYear;
}
