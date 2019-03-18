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
        model.addAttribute("articles", this.articleDao.findAll());
        return "article/list";
    }

    @GetMapping("/{id}")
    public String getArtilcesByCategory(@PathVariable long id, Model model){
//        List<Article> articlesByCategory = articleDao.getArticlesByCategory(id);
//        model.addAttribute("articlesByCategory", articlesByCategory);

        //todo
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
            this.articleDao.save(article);
            return "redirect:/articles/list";
        }
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
