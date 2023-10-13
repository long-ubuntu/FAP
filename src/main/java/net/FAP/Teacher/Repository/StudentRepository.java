package net.FAP.Teacher.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.FAP.Teacher.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findAllByClassroom_Id(Long id);
    
}
