package org.sarindy;

import org.sarindy.topic.CourseModel;
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
	CommandLineRunner init(CourseRepository topicRepository) {
		return (args) -> {
			topicRepository.save(new CourseModel("Java","Programming Open Source"));
			topicRepository.save(new CourseModel("VB","Programming Microsoft"));
		};
	}
}
