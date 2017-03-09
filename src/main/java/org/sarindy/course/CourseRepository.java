package org.sarindy.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CourseModel, Long> {
	
	public List<CourseModel> findByTopicModelId (Long topicId);

}
