package org.sarindy;

import java.util.HashSet;

import org.sarindy.onetomanydemo.BookCategory;
import org.sarindy.onetomanydemo.BookCaterogyRepository;
import org.sarindy.onetomanydemo.Books;
import org.sarindy.onetoonedemo.Book;
import org.sarindy.onetoonedemo.BookDetail;
import org.sarindy.onetoonedemo.BookRepository;
import org.sarindy.topic.TopicModel;
import org.sarindy.topic.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class CourseApiKoushikApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CourseApiKoushikApplication.class, args);
	}
	
	@Bean
	@Order(value = 1)
	CommandLineRunner init(TopicRepository topicRepository) {
		return (args) -> {
			topicRepository.save(new TopicModel("Java", "Programming Open Source"));
			topicRepository.save(new TopicModel("VB", "Programming Microsoft"));
		};
	}
	
	@Bean
	@Order(value = 2)
	CommandLineRunner init2(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book("Java", new BookDetail(49)));
			bookRepository.save(new Book("VB", new BookDetail(59)));
			bookRepository.save(new Book("PHP", new BookDetail(69)));
		};
	}
	
	@SuppressWarnings("serial")
	@Bean
	@Order(value = 3)
	CommandLineRunner init3(BookCaterogyRepository booksRepository) {
		return (args) -> {
			
			// save a couple of categories
			BookCategory categoryA = new BookCategory("Category A");
			HashSet<Books> bookAs = new HashSet<Books>();
			bookAs.add(new Books("Book A1", categoryA));
			bookAs.add(new Books("Book A2", categoryA));
			bookAs.add(new Books("Book A3", categoryA));
			
			categoryA.setBooks(bookAs);
			
			BookCategory categoryB = new BookCategory("Category B");
			HashSet<Books> bookBs = new HashSet<Books>();
			
			bookBs.add(new Books("Book B1", categoryB));
			bookBs.add(new Books("Book B2", categoryB));
			bookBs.add(new Books("Book B3", categoryB));
				
			
			categoryB.setBooks(bookBs);
			
			booksRepository.save(new HashSet<BookCategory>() {
				{
					add(categoryA);
					add(categoryB);
				}
			});
			
			/*
			 * booksRepository.save(new Books("Java",new
			 * BookCategory("Programming"))); booksRepository.save(new
			 * Books("PHP",new BookCategory("Programming")));
			 * booksRepository.save(new Books("Iron Man",new
			 * BookCategory("Marvel")));
			 */
		};
	}
	
}
