package com.example.demo.dao;

import com.example.demo.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOImp implements PersonDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(Person person) {
        entityManager.persist(person);
    }

    @Override
    public void updateUser(Person person) {
        entityManager.merge(person);
    }

    @Override
    public void removeUser(Long id) {
        Person person = entityManager.find(Person.class, id);
        if(person != null)
        entityManager.remove(person);
    }

    @Override
    public Person getUserById(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    @Override
    public List<Person> getAllUsers() {
        List<Person> personList = entityManager.createQuery("from Person", Person.class).getResultList();
        return personList;
    }
}
