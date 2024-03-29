package dev.cluuny.grpcdemo.grpcdemoclient.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private Long ownerId;
    private String brand;
    private String model;
    private Integer carYear;
}
