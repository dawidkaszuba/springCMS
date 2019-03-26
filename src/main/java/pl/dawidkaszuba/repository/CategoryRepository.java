package pl.dawidkaszuba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dawidkaszuba.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
