package br.com.erudio.service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    private final PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        logger.info("Create person");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update person");
        var personToUpdate = this.findById(person.getId());
        BeanUtils.copyProperties(person, personToUpdate);
        return personRepository.save(personToUpdate);
    }

    public void delete(Long id) {
        logger.info("remove person");
        var personToDelete = this.findById(id);
        personRepository.deleteById(personToDelete.getId());
    }
}
