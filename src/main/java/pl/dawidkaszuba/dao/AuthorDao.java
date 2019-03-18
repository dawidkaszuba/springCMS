package pl.dawidkaszuba.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author author){
        this.entityManager.persist(author);
    }
    public void update(Author author){
        this.entityManager.merge(author);
    }
    public void delete(Author author){
        this.entityManager.remove(this.entityManager.contains(author) ? author : this.entityManager.merge(author));
    }
    public List<Author> findAll(){
        Query query = this.entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }
    public Author findById(Long id){
        return this.entityManager.find(Author.class, id);
    }
}
