package dev.cluuny.grpcdemo.grpcdemoclient.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * This class defines the entity model on which car data will be recorded and obtained.
 */
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
    private String ownerId;
    private String brand;
    private String model;
    private Integer carYear;
}
