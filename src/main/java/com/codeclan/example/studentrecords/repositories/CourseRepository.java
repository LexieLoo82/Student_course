package com.codeclan.example.studentrecords.repositories;

import com.codeclan.example.studentrecords.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
