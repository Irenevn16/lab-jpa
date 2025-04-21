package com.example.demo.repositories;
import com.example.demo.Repositories.IPersonRepository;
import com.example.demo.models.Person;
import jakarta.persistence.Id;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    public IPersonRepository iPersonRepository;

    @Test
    @DisplayName("Guarda la persona")
    public void testSave() {
        Person person = new Person("John Doe", 30);
        System.out.println("Persona: " + person);
        iPersonRepository.save(person);

        //var newPerson = iPersonRepository.save(person);//
        assertNotNull(person);
        assertNotNull(person.getId());
        assertEquals("John Doe", person.getName());
        assertEquals(30, person.getAge());
    }

    @Test
    @DisplayName("comprueba la lista de personas")
    public void findAll() {
        List<Person> personsList = new ArrayList<>();
        iPersonRepository.saveAll(personsList);
        assertNotNull(personsList);

        List<Person> foundPersons = iPersonRepository.findAll();
        System.out.println("Found persons: " + foundPersons);
        assertNotNull(foundPersons);
        assertEquals("John Doe", foundPersons.get(1).getName());
        assertEquals(30, foundPersons.get(1).getAge());
    }

    @Test
    @DisplayName("borra personas")
    public void testDelete() {
        Person person = new Person("Clara", 15);
        Person savedPerson = iPersonRepository.save(person);
        Optional<Person> foundPerson = iPersonRepository.findById(savedPerson.getId());
        assertTrue(foundPerson.isPresent());

        //optional es obligatorio pq esta definido asi en JPARepository
        iPersonRepository.delete(savedPerson);
        Optional<Person> deletedPerson = iPersonRepository.findById(savedPerson.getId());
        System.out.println("Deleted person: " + deletedPerson);

        assertTrue(deletedPerson.isEmpty());
    }
}