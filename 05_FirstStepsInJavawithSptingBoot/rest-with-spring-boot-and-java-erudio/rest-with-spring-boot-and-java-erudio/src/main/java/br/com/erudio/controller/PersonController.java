package br.com.erudio.controller;

import br.com.erudio.service.PersonService;
import br.com.erudio.vo.v1.PersonVO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personServices;

    public PersonController(PersonService personServices) {
        this.personServices = personServices;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable Long id) {

        return personServices.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findByAll() {

        return personServices.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO record) {

        return personServices.create(record);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO record) {

        return personServices.update(record);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personServices.delete(id);

        return ResponseEntity.noContent().build();
    }

}
