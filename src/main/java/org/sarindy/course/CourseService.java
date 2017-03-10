package org.sarindy.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	/*
	 * public List<CourseModel> getAllCourse() { List<CourseModel> course = new
	 * ArrayList<>(); courseRepository.findAll().forEach(course::add); return
	 * course;
	 * 
	 * }
	 */

	public List<CourseModel> getAllCourseByTopicId(Long topicId) {
		List<CourseModel> courses = new ArrayList<>();
		courseRepository.findByTopicModelId(topicId).forEach(courses::add);
		return courses;

	}
	
	public List<CourseModel> getAllCourseService(){
		List<CourseModel> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	public CourseModel getCourse(Long id) {
		return courseRepository.findOne(id);

	}

	public CourseModel addCourse(CourseModel course) {
		courseRepository.save(course);
		return course;// we can set it to void
	}

	public CourseModel updateCourse(Long id, CourseModel course) {
		courseRepository.save(course);
		return course;

	}

	public CourseModel deleteCourse(Long id, CourseModel course) {
		courseRepository.delete(course);
		return course;
	}

}
