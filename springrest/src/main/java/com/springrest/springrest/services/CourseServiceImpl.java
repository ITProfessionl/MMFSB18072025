package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl()
	{
		list=new ArrayList<>();
		list.add(new Course(145,"Java Course","This course conatins basic of Java"));
		list.add(new Course(4343,"Spring Boot Course","Creating rest API using Spring Boot"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(Long courseId) {
		Course c=null;
		
		for(Course course :list) 
		{
			if(course.getId()==courseId) 
			{
				c=course;
				break;
			}
			
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Long courseId, Course updatedCourse) {
		for (Course course : list) {
	        if (course.getId() == courseId) {
	            course.setTitle(updatedCourse.getTitle());
	            course.setDiscription(updatedCourse.getDiscription());
	            // update other fields as needed
	            return course;
	        }
	    }
		throw new RuntimeException("Course not found with ID: " + courseId);
	}

	@Override
	public Course deleteCourse(Long courseId) {
		Iterator<Course> iterator = list.iterator();
		while(iterator.hasNext())
		{
			Course course=iterator.next();
			if(course.getId()==courseId) 
			{
				iterator.remove();
				return course;
			}
		}
		return null;
	}

}
