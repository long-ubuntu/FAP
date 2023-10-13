package net.FAP.Teacher.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.FAP.Teacher.Entity.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    
}
