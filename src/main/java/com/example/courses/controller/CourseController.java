package com.example.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.bean.Course;
import com.example.courses.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
//		return  Arrays.asList(new Course(1,"Learn Microservices","in28minutes"),
//				new Course(1,"Learn Full Stack with Angular and React","in28minutes"));
	}
	
	@GetMapping("/courses/{id}")
	public Optional<Course> getCourseDetails(@PathVariable long id){
		Optional<Course> course= courseRepository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course not found with Id:"+ id);
		}
		return Optional.of(course.get());
		//return  Arrays.asList(new Course(1,"Learn Microservices","in28minutes"));
	}
	
	@PostMapping("/courses")
	public Course createCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@PutMapping("/courses/{id}")
	public Course updateCourse(@PathVariable long id, @RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		courseRepository.deleteById(id);
	}
}
