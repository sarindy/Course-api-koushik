package org.sarindy.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", method = RequestMethod.GET)
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/getAllCourses")
	public ResponseEntity<List<CourseModel>> getAllTopics() {

		return new ResponseEntity<List<CourseModel>>(courseService.getAllCourses(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseModel> addTopic(@RequestBody CourseModel course) {

		return new ResponseEntity<CourseModel>(courseService.addCourse(course), HttpStatus.OK);

	}

	@RequestMapping(value = "/updateCourse", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseModel> updateTopic(@RequestBody CourseModel course) {

		return new ResponseEntity<CourseModel>(courseService.updateCourse(null, course), HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteCourse", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseModel> deleteTopic(@RequestBody CourseModel course) {

		return new ResponseEntity<CourseModel>(courseService.deleteCourse(null, course), HttpStatus.NO_CONTENT);

	}

}
