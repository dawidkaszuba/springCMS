package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.dao.ArticleDao;
import pl.dawidkaszuba.dao.AuthorDao;
import pl.dawidkaszuba.dao.CategoriesDao;
import pl.dawidkaszuba.entity.Article;
import pl.dawidkaszuba.entity.Author;
import pl.dawidkaszuba.entity.Category;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path="/articles", produces = "text/html; charset=UTF-8")
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private CategoriesDao categoriesDao;



    @GetMapping("/list")
    public String getAllArticles(Model model){
        model.addAttribute("articles", this.articleDao.findAllNotDraft());
        return "article/list";
    }

    @GetMapping("/{id}")
    public String getArtilcesByCategory(@PathVariable Long id, Model model){
        model.addAttribute("articlesByCategory", articleDao.getArticlesByCategory(id));
        return "article/byCategory";
    }

    @GetMapping("/add")
    public String addArticle(Model model){
        model.addAttribute("article", new Article());
        return "article/add";
    }
    @PostMapping("/add")
    public String saveArticle(@Valid Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "article/add";
        }
        else{
            LocalDate now = LocalDate.now();
            article.setCreated(now);
            this.articleDao.save(article);
            return "redirect:/articles/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        this.articleDao.delete(this.articleDao.findById(id));
        return "redirect:/articles/list";
    }

    @GetMapping("/edit/{id}")
    public String editArticle(@PathVariable Long id, Model model){
        model.addAttribute("article", this.articleDao.findById(id));
        return "article/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedArticle(@ModelAttribute Article article){
        LocalDate now = LocalDate.now();
        article.setUpdated(now);
        this.articleDao.update(article);
        return "redirect:/articles/list";
    }




    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return this.authorDao.findAll();
    }
    @ModelAttribute("categories")
    public List<Category> getAllCategories(){
        return this.categoriesDao.findAll();
    }
}
