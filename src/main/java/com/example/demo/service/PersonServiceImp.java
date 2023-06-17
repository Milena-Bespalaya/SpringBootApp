package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {
    private PersonDAO personDAO;

    @Autowired
    public PersonServiceImp(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    @Transactional
    public void saveUser(Person person) {
        personDAO.saveUser(person);
    }

    @Override
    @Transactional
    public void updateUser(Person person) {
        personDAO.updateUser(person);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        personDAO.removeUser(id);
    }

    @Override
    public Person getUserById(Long id) {
        return personDAO.getUserById(id);
    }

    @Override
    public List<Person> getAllUsers() {
        return personDAO.getAllUsers();
    }
}

