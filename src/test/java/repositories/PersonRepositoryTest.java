package repositories;

import com.example.demo.Repositories.IPersonRepository;
import com.example.demo.models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepositoryTest;

    @Test
    @DisplayName("Guarda la persona")

    public void testSave() {
       Person person1 = new Person("Pedro", 28);
       Person savedPerson = IPersonRepository.save(person1);


    }

}

