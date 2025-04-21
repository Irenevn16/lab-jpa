package com.example.demo.repositories;
import com.example.demo.Repositories.IPersonRepository;
import com.example.demo.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    public IPersonRepository iPersonRepository;

    @Test
    @DisplayName("Guarda la persona")
    public void testSave() {
       Person person = new Person("Pedro", 28);
       System.out.println("Persona: " + person);
       iPersonRepository.save(person);

       var newPerson = iPersonRepository.save(person);
       assertNotNull(newPerson);
    }

}

