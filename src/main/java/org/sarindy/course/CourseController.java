package org.sarindy.course;

import java.util.List;

import org.sarindy.topic.TopicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/topic/{id}/course", method = RequestMethod.GET)
	public List<CourseModel> getAllCourses(@PathVariable Long id) {
		return courseService.getAllCourseByTopicId(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CourseModel getCourse(@PathVariable Long id) {
		return courseService.getCourse(id);

	}

	@RequestMapping(value = "/addCourse/{topicId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseModel addCourse(@PathVariable Long topicId, @RequestBody CourseModel course) {
		course.setTopicModel(new TopicModel(topicId, "", ""));
		return courseService.addCourse(course);
	}

}
