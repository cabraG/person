package com.cabra.person.controller;

import com.cabra.person.domain.Person;
import com.cabra.person.domain.Result;
import com.cabra.person.respository.PersonRepository;
import com.cabra.person.service.PersonService;
import com.cabra.person.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//查询全部
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/person")
    public List<Person> personList() {
        return personRepository.findAll();


    }

    //add
    @PostMapping(value = "/person")
    public Result<Person> personAdd(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        person.setAge(person.getAge());
        person.setCard(person.getCard());
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(person);
        return ResultUtil.success(personRepository.save(person));

    }

    //update
    @PutMapping(value = "/person/{id}")
    public Person personUpdate(@PathVariable("id") int id, @RequestParam("card") String card,
                               @RequestParam("age") String age) {
        Person pup = new Person();
        pup.setId(id);
        try {
            pup.setAge(Integer.valueOf(age).intValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        pup.setCard(card);
        personRepository.save(pup);
        return pup;


    }

    //delete
    @DeleteMapping(value = "/person/{id}")
    public void deletepe(@PathVariable("id") int id) {
        personRepository.delete(id);
    }

    //findbyage
    @GetMapping(value = "/person/age/{age}")
    public List<Person> findbyage(@PathVariable("age") int age) {
        return personRepository.findByAge(age);
    }
@GetMapping(value = "/person/getage/{id}")
    public Result getAge(@PathVariable("id") int id)throws Exception{
     return   personService.getAge(id);
}

}
