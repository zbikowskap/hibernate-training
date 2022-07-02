package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Sticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Float width;
    private Float height;
    @ManyToOne
    private Author author;
    @ManyToMany
    @JoinTable(
            name = "STICKER_CAR_RELATION",
            joinColumns = {
                    @JoinColumn(name = "MY_STICKER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "MY_CAR_ID")
            }
    )
    private Set<Car> cars;
}
