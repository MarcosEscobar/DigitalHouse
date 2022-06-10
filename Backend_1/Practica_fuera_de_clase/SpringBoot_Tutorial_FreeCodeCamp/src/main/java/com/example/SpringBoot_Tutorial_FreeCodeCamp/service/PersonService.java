package com.example.SpringBoot_Tutorial_FreeCodeCamp.service;

import com.example.SpringBoot_Tutorial_FreeCodeCamp.dao.PersonDao;
import com.example.SpringBoot_Tutorial_FreeCodeCamp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
