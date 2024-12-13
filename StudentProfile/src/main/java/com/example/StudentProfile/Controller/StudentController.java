package com.example.StudentProfile.Controller;

import com.example.StudentProfile.Dto.StudentDto;
import com.example.StudentProfile.Entity.Student;
import com.example.StudentProfile.Mapper.StudentMapper;
import com.example.StudentProfile.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
        Optional<Student> student= studentService.getStudentById(id);
        return StudentMapper.toDto(student.orElse(null));
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable Long id,@RequestBody Student updatedStudent){
//        return studentService.updateStudent(id,updatedStudent);
//    }


    @PutMapping("/{id}")//using Mapper Class
    public StudentDto updateStudent(@PathVariable Long id,@RequestBody StudentDto studentDto){
        Student student =studentService.updateStudent(id,studentDto);
        
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student deleted succesfully with id : " +id;
    }


}