package net.FAP.Teacher.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double active_score;
    private double exercise_score;
    private double pre_score;
    private double project_score;
    private double final_score;

    @ManyToOne
    @JoinColumn(name = "student_id")

    private Student student;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getActive_score() {
        return this.active_score;
    }

    public void setActive_score(double active_score) {
        this.active_score = active_score;
    }

    public double getExercise_score() {
        return this.exercise_score;
    }

    public void setExercise_score(double exercise_score) {
        this.exercise_score = exercise_score;
    }

    public double getPre_score() {
        return this.pre_score;
    }

    public void setPre_score(double pre_score) {
        this.pre_score = pre_score;
    }

    public double getProject_score() {
        return this.project_score;
    }

    public void setProject_score(double project_score) {
        this.project_score = project_score;
    }

    public double getFinal_score() {
        return this.final_score;
    }

    public void setFinal_score(double final_score) {
        this.final_score = final_score;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
