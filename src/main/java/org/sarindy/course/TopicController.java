package org.sarindy.course;

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
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/getAllTopics")
	public ResponseEntity<List<TopicModel>> getAllTopics() {

		return new ResponseEntity<List<TopicModel>>(topicService.getAllTopics(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addTopic", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TopicModel> addTopic(@RequestBody TopicModel topic) {

		return new ResponseEntity<TopicModel>(topicService.addTopic(topic), HttpStatus.OK);

	}

	@RequestMapping(value = "/updateTopic", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TopicModel> updateTopic(@RequestBody TopicModel topic) {

		return new ResponseEntity<TopicModel>(topicService.updateTopic(null, topic), HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteTopic", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TopicModel> deleteTopic(@RequestBody TopicModel topic) {

		return new ResponseEntity<TopicModel>(topicService.deleteTopic(null, topic), HttpStatus.NO_CONTENT);

	}

}
