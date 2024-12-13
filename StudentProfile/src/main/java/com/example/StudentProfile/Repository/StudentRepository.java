package com.example.StudentProfile.Repository;

import com.example.StudentProfile.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
