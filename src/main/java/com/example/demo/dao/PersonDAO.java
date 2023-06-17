package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO {
     void saveUser(Person person);
     void updateUser(Person person);
     void removeUser(Long id);
     Person getUserById(Long id);
     List<Person> getAllUsers();

}
