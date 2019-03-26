package pl.dawidkaszuba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.dawidkaszuba.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a where a.draft=1")
    List<Article> findAllDrafts();

    @Query("SELECT a FROM Article a where a.draft=0")
    List<Article> findAllNotDrafts();

    @Query("SELECT a FROM Article a Join a.categories c WHERE c.id= ?1")
    List<Article> findByCategory(Long id);
}
