package flex.dev.SpringWebApp.repositories;

import flex.dev.SpringWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
