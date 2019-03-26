package pl.dawidkaszuba.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.dawidkaszuba.validator.ListSize;
import pl.dawidkaszuba.validator.ValidationArticle;
import pl.dawidkaszuba.validator.ValidationDraft;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(groups = {ValidationArticle.class,ValidationDraft.class},message = "title can not be empty")
    @Size(groups = {ValidationArticle.class,ValidationDraft.class},max=200,message = "title should has max 200 signs")
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany(fetch = FetchType.EAGER)
    @ListSize(groups = ValidationArticle.class)
    private List<Category> categories;
    @Column(columnDefinition = "TEXT")
    @NotEmpty(groups = {ValidationArticle.class,ValidationDraft.class},message = "Content can not be empty")
    @Size(groups = {ValidationArticle.class,ValidationDraft.class},min=100,message = "Content should has min 100 signs")
    private String content;
    private LocalDate created;
    private LocalDate updated;
    private boolean draft;

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }
}
