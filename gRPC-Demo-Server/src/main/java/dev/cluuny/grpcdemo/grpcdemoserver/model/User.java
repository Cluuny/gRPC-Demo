package dev.cluuny.grpcdemo.grpcdemoserver.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * This class defines the entity model on which user data will be recorded and obtained.
 */
@Getter
@Entity
@Setter
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "citizenId")
    private String citizenId;
    @Column(name = "birthDate")
    private LocalDate birthDate;
}
