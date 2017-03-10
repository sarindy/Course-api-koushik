package org.sarindy.onetomanydemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCaterogyRepository extends CrudRepository<BookCategory, Integer> {
	
}
