package com.springrest.springrest.services;

import java.util.List;
import com.springrest.springrest.entities.Course;

public interface CourseService {
	
	 public List<Course> getCourses();
	 
	 public Course getCourse(Long courseId);
	 
	 public Course addCourse(Course course);
	 
	 public Course updateCourse(Long courseId, Course updatedCourse);
	 
	 public Course deleteCourse(Long courseId);

}
