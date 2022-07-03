package org.example.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @NotEmpty(message = "Pole maraka nie moze byc puste")
    private String brand;
    @Column(name = "MAX_SPEED")
    @Min(value = 40)
    @Max(value = 210, message = "Tak szybkich samochodow nie obslugujemy")
    private Integer maxSpeed;
    @OneToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner ownerrrrrrrr;
    @ManyToMany(mappedBy = "cars")
    private Set<Sticker> stickers;
}