package flex.dev.SpringWebApp.repositories;

import flex.dev.SpringWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
