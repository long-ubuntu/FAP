package net.FAP.Teacher.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.FAP.Teacher.Entity.Classroom;
import net.FAP.Teacher.Entity.Grade;
import net.FAP.Teacher.Entity.Student;
import net.FAP.Teacher.Repository.ClassroomRepository;
import net.FAP.Teacher.Repository.GradeRepository;
import net.FAP.Teacher.Repository.StudentRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GradeRepository gRepository;

    @Override
    public List<Classroom> getAllClass() {
        return classroomRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsByClassroomId(Long id) {
        return studentRepository.findAllByClassroom_Id(id);
    }

    @Override
    public List<Grade> findByStudentId(Long id) {
        return gRepository.findByStudentId(id);
    }

    @Override
    public Grade getGradeById(Long gradeId) {
        return gRepository.findById(gradeId).orElse(null);
    }

    @Override
    public void updateGrade(Long id, Double activeScore, Double exerciseScore, Double preScore, Double projectScore,
            Double finalScore) {
        Grade grade = gRepository.findById(id).orElse(null);
        if (grade != null) {
            grade.setActive_score(activeScore);
            grade.setExercise_score(exerciseScore);
            grade.setPre_score(preScore);
            grade.setProject_score(projectScore);
            grade.setFinal_score(finalScore);
            gRepository.save(grade);
        }
    }

}
