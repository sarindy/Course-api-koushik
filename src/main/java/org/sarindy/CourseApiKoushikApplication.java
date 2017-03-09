package org.sarindy;

import org.sarindy.course.TopicModel;
import org.sarindy.course.TopicRepository;
import org.sarindy.topic.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseApiKoushikApplication {
	
	@SuppressWarnings("unused")
	@Autowired
	private CourseRepository topicRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseApiKoushikApplication.class, args);
	}

	@Bean
	CommandLineRunner init(TopicRepository topicRepository) {
		return (args) -> {
			topicRepository.save(new TopicModel("Java","Programming Open Source"));
			topicRepository.save(new TopicModel("VB","Programming Microsoft"));
		};
	}
}
