package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SAMOCHOD")
@Getter
@Setter
@NoArgsConstructor// <- konstruktor bezargumentowy
//@AllArgsConstructor // <- kontruktor ze wszystkimi polami
//@RequiredArgsConstructor // <- konstruktor tylko dla pol final
@ToString(exclude = {"ownerrrrrrrr", "stickers"})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    @Column(name = "MAX_SPEED")
    private Integer maxSpeed;
    @OneToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner ownerrrrrrrr;
    @ManyToMany(mappedBy = "cars")
    private Set<Sticker> stickers;
}