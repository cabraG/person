package com.cabra.person;

import com.cabra.person.domain.Person;
import com.cabra.person.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Test
    public void findonetest(){
        Person person= personService.findOne(27);
        Assert.assertEquals(9,person.getAge());

    }

}
