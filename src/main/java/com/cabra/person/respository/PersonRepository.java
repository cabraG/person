package com.cabra.person.respository;

import com.cabra.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer>{
    public List<Person> findByAge(int age);
}

