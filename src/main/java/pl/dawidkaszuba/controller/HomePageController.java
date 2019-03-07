package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.dawidkaszuba.dao.ArticleDao;
import pl.dawidkaszuba.dao.CategoriesDao;
import pl.dawidkaszuba.entity.Article;
import pl.dawidkaszuba.entity.Category;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoriesDao categoriesDao;

    @GetMapping("/articles")
    public String getLastArticles(Model model){
        List<Article> lastArticles = articleDao.getLastArticles(5);
        List<Category> categories = categoriesDao.findAll();
        model.addAttribute("lastArticles", lastArticles);
        model.addAttribute("categories",categories);
        return "articles";
    }

    @GetMapping("/categories/{id}")
    public String getArtilcesByCategory(@PathVariable long id, Model model){
        List<Article> articlesByCategory = articleDao.getArticlesByCategory(id);
        model.addAttribute("articlesByCategory", articlesByCategory);
        return "articlesByCategory";
    }
}
