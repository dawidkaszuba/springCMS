package pl.dawidkaszuba.dao;

import org.springframework.stereotype.Repository;
import pl.dawidkaszuba.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article){
        entityManager.persist(article);
    }
    public void update(Article article){
        entityManager.merge(article);
    }
    public Article findById(long id){
        return entityManager.find(Article.class, id);
    }
    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ? article: entityManager.merge(article));

    }
    public List getLastArticles(int quantity){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        query.setMaxResults(quantity);

        return query.getResultList();
    }

    public List<Article> getArticlesByCategory(long id) {
        Query query = entityManager.createQuery("SELECT a FROM Article a Join a.categories c WHERE c.id= :id");
        query.setParameter("id",id);
        return query.getResultList();
    }

    public List<Article> findAll() {
        Query query = this.entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }

    public List<Article> findAllNotDraft() {
        Query query = this.entityManager.createQuery("SELECT a FROM Article a where a.draft=0");
        return query.getResultList();
    }



    public List<Article> getAllDrafts(){
        Query query = this.entityManager.createQuery("SELECT a FROM Article a where a.draft=1");
        return query.getResultList();
    }
}
