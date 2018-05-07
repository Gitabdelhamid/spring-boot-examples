package com.in28minutes.springboot.rest.example.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.rest.example.entity.Course;
import com.in28minutes.springboot.rest.example.repository.CourseRepository;

@RestController
public class CourseResource {

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/courses")
	public List<Course> retrieveAllStudents() {
		return courseRepository.findAll();
	}
//
//	@GetMapping("/courses/{id}")
//	public Student retrieveStudent(@PathVariable long id) {
//		Optional<Student> student = studentRepository.findById(id);
//
//		if (!student.isPresent())
//			throw new StudentNotFoundException("id-" + id);
//
//		return student.get();
//	}
}
