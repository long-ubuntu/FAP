package net.FAP.Teacher.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.FAP.Teacher.Entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudentId(Long id);

}
