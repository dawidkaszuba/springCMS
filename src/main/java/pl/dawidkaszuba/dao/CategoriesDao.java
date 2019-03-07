package pl.dawidkaszuba.dao;

import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoriesDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Category category){
        entityManager.persist(category);
    }
    public void update(Category category){
        entityManager.merge(category);
    }
    public Category findBuId(long id){
        return  entityManager.find(Category.class,id);
    }

    public List findAll(){
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }
}
