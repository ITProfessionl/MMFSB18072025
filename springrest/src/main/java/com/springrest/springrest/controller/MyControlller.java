package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;


@RestController
public class MyControlller {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to course application";
	}
	
	//get the courses
	@GetMapping("/Courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	//single course get
	@GetMapping("/Courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//add course
	@PostMapping ("/Courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	//update course
	@PutMapping ("/Courses/{courseId}")
	public Course updateCourse(@PathVariable Long courseId ,@RequestBody Course updatedCourse)
	{
		return this.courseService.updateCourse(courseId,updatedCourse);
	}
	 
	//delete course
	@DeleteMapping ("/Courses/{courseId}")
	public Course deleteCourse(@PathVariable Long courseId)
	{
		return this.courseService.deleteCourse(courseId);
	}
	
	
}