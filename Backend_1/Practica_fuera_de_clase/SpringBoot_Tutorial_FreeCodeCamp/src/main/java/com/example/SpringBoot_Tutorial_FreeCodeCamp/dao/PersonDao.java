package com.example.SpringBoot_Tutorial_FreeCodeCamp.dao;

import com.example.SpringBoot_Tutorial_FreeCodeCamp.model.Person;

import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson (Person person){
        UUID id = UUID.randomUUID();
        return  insertPerson(id,person);
    }

}
