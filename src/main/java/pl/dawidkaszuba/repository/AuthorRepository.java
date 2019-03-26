package pl.dawidkaszuba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
