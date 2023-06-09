package br.com.erudio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -276717165117137620L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date birthDate;

}
