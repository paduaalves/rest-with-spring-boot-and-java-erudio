package br.com.erudio.service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import br.com.erudio.vo.v1.PersonVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonVO findById(Long id) {
        var person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
        return DozerMapper.parseObject(person, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        var persons = personRepository.findAll();
        return DozerMapper.parseListObjects(persons, PersonVO.class);

    }

    public PersonVO create(PersonVO person) {
        logger.info("Create person");
        var personEntity = DozerMapper.parseObject(person, Person.class);
        var personSaved = personRepository.save(personEntity);
        return DozerMapper.parseObject(personSaved, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Update person");
        var personToUpdate = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(personToUpdate), PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("remove person");
        var personToDelete = this.findById(id);
        personRepository.deleteById(personToDelete.getId());
    }
}
