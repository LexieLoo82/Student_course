package com.codeclan.example.studentrecords;

import com.codeclan.example.studentrecords.models.Course;
import com.codeclan.example.studentrecords.models.Student;
import com.codeclan.example.studentrecords.repositories.CourseRepository;
import com.codeclan.example.studentrecords.repositories.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentrecordsApplicationTests {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createStudent(){
		Student alex = new Student("alex", 19);
		Student robin = new Student("robin", 19);
		Student doug = new Student("doug", 19);
		Student shell = new Student("shell", 19);
		studentRepository.save(alex);
		studentRepository.save(robin);
		studentRepository.save(doug);
		studentRepository.save(shell);
		Course math =  new Course("math");
		Course english = new Course("english");
		Course java = new Course("java");
		courseRepository.save(math);
		courseRepository.save(english);
		courseRepository.save(java);
		math.addStudent(alex);
		courseRepository.save(math);
		math.addStudent(doug);
		courseRepository.save(math);
		math.addStudent(robin);
		courseRepository.save(math);
	}



}

