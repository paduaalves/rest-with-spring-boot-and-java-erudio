package br.com.erudio.mapper.custom;

import br.com.erudio.model.Person;
import br.com.erudio.vo.v2.PersonVOV2;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class PersonMapper {
    public PersonVOV2 convertEntitytoVO(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        try {
            BeanUtils.copyProperties(vo, person);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return vo;
    }

    public Person convertVOtoEntity(PersonVOV2 vo) {
        Person person = new Person();
        try {
            BeanUtils.copyProperties(person, vo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
