package br.com.erudio.unittests.mapper;

import br.com.erudio.model.Person;
import br.com.erudio.vo.v1.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonVO mockRecord() {
        return mockRecord(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockRecordList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockRecord(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonVO mockRecord(Integer number) {
        String addres = "Addres Test" + number;
        String firtName = "First Name Test" + number;
        String gender = number % 2 ==0 ? "Male" : "Female";
        Long id = number.longValue();
        String lastName = "Last Name Test" + number;
        return new PersonVO(id, firtName, lastName, addres, gender);
    }
}
