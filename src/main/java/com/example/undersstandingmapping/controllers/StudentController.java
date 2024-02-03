package com.example.undersstandingmapping.controllers;

import com.example.undersstandingmapping.models.Student;
import com.example.undersstandingmapping.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// to mark this class as a controller.
// and return the output as json directly
@RestController
public class StudentController {

    // not a good idea to use repositories inside controllers

    // automatically wire an instance of repo to this class -> Autowired
    @Autowired
    private StudentRepository studentRepository;

    // actual url to which you're serving the response
    @RequestMapping("/getStudents")
    public List<Student> getStudent(){
        System.out.println("vis");

        return studentRepository.findAll();

    }
    @RequestMapping(method = RequestMethod.PUT, value = "/credit ")
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public void deleteStudent(@RequestParam Long id)
    {
        studentRepository.deleteById(id);
    }



    // Transactions 1 and 2 completely.

}
