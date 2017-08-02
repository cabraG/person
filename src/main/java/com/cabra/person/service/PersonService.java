package com.cabra.person.service;

import com.cabra.person.domain.Person;
import com.cabra.person.domain.Result;
import com.cabra.person.enums.ResultEnum;
import com.cabra.person.exception.PersonException;
import com.cabra.person.respository.PersonRepository;
import com.cabra.person.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

//get by id and order() by age
    public Result getAge(Integer id) throws Exception {
        Person person = personRepository.findOne(id);
        int age = person.getAge();
        if (age < 10) {
            throw new PersonException(ResultEnum.TEN);
        } else if (age > 10 && age < 16) {
            throw new PersonException(ResultEnum.SIXTE);
        } else {
            return ResultUtil.success(person);
        }
    }
//find one by id
    public Person findOne(int id){
        return personRepository.findOne(id);
    }

}
