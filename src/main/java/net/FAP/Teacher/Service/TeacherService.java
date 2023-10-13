package net.FAP.Teacher.Service;

import java.util.List;

import net.FAP.Teacher.Entity.Classroom;
import net.FAP.Teacher.Entity.Grade;
import net.FAP.Teacher.Entity.Student;

public interface TeacherService {

    List<Classroom> getAllClass();

    List<Student> getAllStudentsByClassroomId(Long id);

    List<Grade> findByStudentId(Long id);

    Grade getGradeById(Long gradeId);

    void updateGrade(Long id, Double activeScore, Double exerciseScore, Double preScore, Double projectScore,
            Double finalScore);


    
}
