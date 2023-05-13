package com.example.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.courses.bean.Course;
	
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
