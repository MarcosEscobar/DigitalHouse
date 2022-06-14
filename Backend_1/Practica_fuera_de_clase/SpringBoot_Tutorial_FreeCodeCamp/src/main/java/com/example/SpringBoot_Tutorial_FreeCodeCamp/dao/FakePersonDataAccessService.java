package com.example.SpringBoot_Tutorial_FreeCodeCamp.dao;

import com.example.SpringBoot_Tutorial_FreeCodeCamp.model.Person;
import org.springframework.stereotype.Repository;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static final List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
}
