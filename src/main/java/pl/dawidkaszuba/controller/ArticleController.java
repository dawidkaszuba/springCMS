package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.dao.ArticleDao;
import pl.dawidkaszuba.entity.Article;

import java.util.List;

@Controller
@RequestMapping(path="/articles", produces = "text/html; charset=UTF-8")
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping("/list")
    public String getLastArticles(Model model){
        List<Article> lastArticles = articleDao.getLastArticles(5);
        model.addAttribute("lastArticles", lastArticles);
        return "article/list";
    }

    @GetMapping("/{id}")
    public String getArtilcesByCategory(@PathVariable long id, Model model){
        List<Article> articlesByCategory = articleDao.getArticlesByCategory(id);
        model.addAttribute("articlesByCategory", articlesByCategory);
        return "article/byCategory";
    }
}
