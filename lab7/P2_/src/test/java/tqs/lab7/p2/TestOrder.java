package tqs.lab7.p2;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

@Testcontainers
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOrder {

    @Autowired
    private StudentRepository studentRepository;



    @Test
    @Order(1)
    public void testCreateUser() {
        Student student = new Student("Andre", "Morais");
        System.out.println(student);
        studentRepository.save(student);
    }

    @Test
    @Order(2)
    public void testUpdateUser() {
        for(Student student : studentRepository.findAll()){
            if(student.getId()==1L){ student.setLastName("Moniz"); studentRepository.save(student);}
        }
    }

    @Test
    @Order(2)
    public void testDeleteUser() {
        for(Student student : studentRepository.findAll()){
            if(student.getId()==1L){ studentRepository.deleteById(student.getId());}
        }
    }
}