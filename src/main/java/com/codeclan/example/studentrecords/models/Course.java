package com.codeclan.example.studentrecords.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="topic")
    private String topic;

    @JsonIgnoreProperties("courses")
    @ManyToMany
    @JoinTable(
            name="courses_students",
            joinColumns = {
                    @JoinColumn(
                            name="course_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="student_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Student> students;


    public Course(String topic){
        this.topic = topic;
        this.students = new ArrayList<>();
    }

    public Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}


