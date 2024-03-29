package dev.cluuny.grpcdemo.grpcdemoclient.dto;

import lombok.*;

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
