package br.com.erudio.model;

import br.com.erudio.record.PersonRecord;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;

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

    public static Person recordToPerson(PersonRecord record, Person person) {
        BeanUtils.copyProperties(record, person);
        return person;
    }
}
