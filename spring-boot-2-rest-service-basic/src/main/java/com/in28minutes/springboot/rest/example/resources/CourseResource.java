package com.in28minutes.springboot.rest.example.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.rest.example.dao.ICourseDao;
import com.in28minutes.springboot.rest.example.entity.Course;
import com.in28minutes.springboot.rest.example.exception.StudentNotFoundException;

@RestController
public class CourseResource {

	@Autowired
	private ICourseDao courseDao;

	@GetMapping("/courses")
	public List<Course> retrieveAllStudents() {
		return courseDao.findAll();
	}

	@GetMapping("/courses/{id}")
	public Course retrieveStudent(@PathVariable long id) {
		Optional<Course> course = courseDao.findById(id);

		if (!course .isPresent())
			throw new StudentNotFoundException("id-" + id);

		return course .get();
	}
}
