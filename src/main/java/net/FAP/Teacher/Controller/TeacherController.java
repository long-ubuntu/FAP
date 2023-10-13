package net.FAP.Teacher.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import net.FAP.Teacher.Entity.Classroom;
import net.FAP.Teacher.Entity.Grade;
import net.FAP.Teacher.Entity.Student;
import net.FAP.Teacher.Service.TeacherService;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher/showclassroom")
    public String showClassroom(Model model) {
        List<Classroom> listClassroom = teacherService.getAllClass();
        model.addAttribute("listClass", listClassroom);
        return "showClassroom";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher/showstudent")
    public String showStudentById(@RequestParam(name = "id") Long id, Model model) {
        List<Student> listStudent = teacherService.getAllStudentsByClassroomId(id);
        model.addAttribute("listStudent", listStudent);
        return "showStudent";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher/showgrade")
    public String showGradeById(@RequestParam(name = "id") Long id, Model model) {
        List<Grade> listgGrades = teacherService.findByStudentId(id);
        model.addAttribute("listgGrades", listgGrades);
        return "showgrade";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher/editgrade/{gradeId}")
    public String editGrade(@PathVariable Long gradeId, Model model) {
        Grade grade = teacherService.getGradeById(gradeId);
        model.addAttribute("grade", grade);
        return "editgrade";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher/updategrade")
    public String updateGrade(
            @RequestParam("id") Long id,
            @RequestParam("activeScore") Double activeScore,
            @RequestParam("exerciseScore") Double exerciseScore,
            @RequestParam("preScore") Double preScore,
            @RequestParam("projectScore") Double projectScore,
            @RequestParam("finalScore") Double finalScore) {
        teacherService.updateGrade(id, activeScore, exerciseScore, preScore, projectScore, finalScore);
        return "redirect:/teacher/showgrade";
    }

}
