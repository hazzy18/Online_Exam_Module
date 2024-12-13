package com.example.StudentProfile.Mapper;

import com.example.StudentProfile.Dto.StudentDto;
import com.example.StudentProfile.Entity.Student;

public class StudentMapper {

    public static StudentDto toDto(Student student){
        StudentDto studentDto=new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }
    public static Student toEntity(StudentDto studentDto){
        Student student=new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        return student;
    }

}
