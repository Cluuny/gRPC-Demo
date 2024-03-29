package dev.cluuny.grpcdemo.grpcdemoclient.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Setter
@Builder
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ownerId;
    private String brand;
    private String model;
    private Integer carYear;
}
