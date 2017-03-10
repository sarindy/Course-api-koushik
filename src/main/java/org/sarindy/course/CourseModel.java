package org.sarindy.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sarindy.topic.TopicModel;

@Entity
@Table(name = "CourseModel")
public class CourseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	private TopicModel topicModel;

	
	public TopicModel getTopicModel() {
		return topicModel;
	}

	public void setTopicModel(TopicModel topicModel) {
		this.topicModel = topicModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	

	public CourseModel(String name, String description,Long topicId) {

		this.name = name;
		this.description = description;
		this.topicModel = new TopicModel(topicId,"","");
	
	}
	
	public CourseModel() {

	}
	
	

}
