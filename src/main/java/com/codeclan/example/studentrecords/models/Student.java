package com.codeclan.example.studentrecords.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="students")


public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @JsonIgnoreProperties("students")
    @ManyToMany
    @JoinTable(
            name="courses_students",
            joinColumns = {
                    @JoinColumn(
                            name="student_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="course_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Course> courses;


    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Student(){}

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }


}
