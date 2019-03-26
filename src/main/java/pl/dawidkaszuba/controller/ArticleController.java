package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.entity.Article;
import pl.dawidkaszuba.entity.Author;
import pl.dawidkaszuba.entity.Category;
import pl.dawidkaszuba.repository.ArticleRepository;
import pl.dawidkaszuba.repository.AuthorRepository;
import pl.dawidkaszuba.repository.CategoryRepository;
import pl.dawidkaszuba.validator.ValidationArticle;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path="/articles", produces = "text/html; charset=UTF-8")
public class ArticleController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ArticleRepository articleRepository;



    @GetMapping("/list")
    public String getAllArticles(Model model){
        model.addAttribute("articles", this.articleRepository.findAllNotDrafts());
        return "article/list";
    }

    @GetMapping("/{id}")
    public String getArtilcesByCategory(@PathVariable Long id, Model model){
        model.addAttribute("articlesByCategory", articleRepository.findByCategory(id));
        return "article/byCategory";
    }

    @GetMapping("/add")
    public String addArticle(Model model){
        model.addAttribute("article", new Article());
        return "article/add";
    }
    @PostMapping("/add")
    public String saveArticle(@Validated({ValidationArticle.class}) Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "article/add";
        }
        else{
            LocalDate now = LocalDate.now();
            article.setCreated(now);
            this.articleRepository.save(article);
            return "redirect:/articles/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        this.articleRepository.delete(this.articleRepository.findOne(id));
        return "redirect:/articles/list";
    }

    @GetMapping("/edit/{id}")
    public String editArticle(@PathVariable Long id, Model model){
        model.addAttribute("article", this.articleRepository.findOne(id));
        return "article/edit";
    }

    @PostMapping("/saveEdited")
    public String saveEditedArticle(@Validated({ValidationArticle.class}) Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/articles/edit/"+article.getId();
        }
        else{

        LocalDate now = LocalDate.now();
        article.setUpdated(now);
        this.articleRepository.save(article);
        return "redirect:/articles/list";
        }
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }
    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }
}
