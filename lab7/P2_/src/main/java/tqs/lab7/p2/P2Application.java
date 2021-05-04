package tqs.lab7.p2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@RestController
public class P2Application {

    @Autowired
    StudentRepository repository;

    private static final Logger log = LoggerFactory.getLogger(P2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(P2Application.class, args);
    }

    @GetMapping("/")
    public String index(@RequestParam(value="name", defaultValue = "World") String name){
        repository.save(new Student("Jack", "Bauer"));
        repository.save(new Student("Chloe", "O'Brian"));
        repository.save(new Student("Kim", "Bauer"));
        repository.save(new Student("David", "Palmer"));
        repository.save(new Student("Michelle", "Dessler"));

        // fetch all Students
        log.info("Students found with findAll():");
        log.info("-------------------------------");
        for (Student student : repository.findAll()) {
            log.info(student.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        Optional<Student> student = repository.findById(1L);
        log.info("Student found with findById(1L):");
        log.info("--------------------------------");
        log.info(student.toString());
        log.info("");

        // fetch student by last name
        log.info("Student found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        repository.findByLastName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });

        log.info("");
        return String.format("Hello %s!", name);


    }
}
