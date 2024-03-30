package dev.cluuny.grpcdemo.grpcdemoclient.dto;

import lombok.*;

/**
 * This class is defined as the DTO of the Car class, it allows clean user of the car data in the application.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String ownerId;
    private String brand;
    private String model;
    private Integer carYear;
}
