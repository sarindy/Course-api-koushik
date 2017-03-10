package org.sarindy.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<TopicModel> getAllTopics() {
		List<TopicModel> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;

	}

	public TopicModel getTopic(Long id) {
		return topicRepository.findOne(id);

	}

	public TopicModel addTopic(TopicModel topic) {
		topicRepository.save(topic);
		return topic;// we can set it to void
	}

	public TopicModel updateTopic(Long id, TopicModel topic) {
		topicRepository.save(topic);
		return topic;

	}

	public TopicModel deleteTopic(Long id, TopicModel topic) {
		topicRepository.delete(topic);
		return topic;
	}

}
