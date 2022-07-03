package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 40)
    private String firstName;
    private String lastName;
    private String address;
    @OneToMany(mappedBy = "author")
    private Set<Sticker> stickers;
    @Embedded
    private Address fullAddress;
    @PESEL
    private String pesel;
}
