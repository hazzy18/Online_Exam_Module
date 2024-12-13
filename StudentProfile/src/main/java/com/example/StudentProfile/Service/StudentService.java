package com.example.StudentProfile.Service;

import com.example.StudentProfile.Entity.Student;
import com.example.StudentProfile.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student updateStudent(Long id,Student updatedStudent){
        Student existingStudent=studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException(("Student not found with id :"+id)));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("Student not found with id:"+id);
        }
        studentRepository.deleteById(id);
    }

}
