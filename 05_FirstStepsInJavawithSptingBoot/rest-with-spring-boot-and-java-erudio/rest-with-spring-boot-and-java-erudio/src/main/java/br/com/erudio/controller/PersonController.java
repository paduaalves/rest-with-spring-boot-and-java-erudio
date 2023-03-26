package br.com.erudio.controller;

import br.com.erudio.model.Person;
import br.com.erudio.record.PersonRecord;
import br.com.erudio.service.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonRecord findById(@PathVariable Long id) {
        Person person = personServices.findById(id);
        return new PersonRecord(person.getId(), person.getFirstName(), person.getLastName(),
                person.getAddress(), person.getGender());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonRecord> findByAll() {
        List<PersonRecord> records = new ArrayList<>();
        List<Person> person = personServices.findAll();
        for (Person p : person) {
            records.add(new PersonRecord(p.getId(), p.getFirstName(), p.getLastName(),
                    p.getAddress(), p.getGender()));
        }
        return records;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody PersonRecord record) {

        return personServices.create(Person.recordToPerson(record, new Person()));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody PersonRecord record) {

        return personServices.update(Person.recordToPerson(record, new Person()));
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
