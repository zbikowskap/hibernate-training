package org.example;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "SAMOCHOD")
@Getter
@Setter
@NoArgsConstructor// <- konstruktor bezargumentowy
//@AllArgsConstructor // <- kontruktor ze wszystkimi polami
//@RequiredArgsConstructor // <- konstruktor tylko dla pol final
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    @Column(name = "MAX_SPEED")
    private Integer maxSpeed;
}