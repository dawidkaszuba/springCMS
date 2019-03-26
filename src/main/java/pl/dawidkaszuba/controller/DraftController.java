package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.dao.ArticleDao;
import pl.dawidkaszuba.dao.AuthorDao;
import pl.dawidkaszuba.dao.CategoriesDao;
import pl.dawidkaszuba.entity.Article;
import pl.dawidkaszuba.entity.Author;
import pl.dawidkaszuba.entity.Category;
import pl.dawidkaszuba.validator.ValidationDraft;

import javax.validation.groups.Default;
import java.util.List;


@Controller
@RequestMapping("/drafts")
public class DraftController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private CategoriesDao categoriesDao;



    @GetMapping("/add")
    public String addDraft(Model model){
        model.addAttribute("article", new Article());
        return "article/add";
    }

    @PostMapping("/add")
    public String saveDraft(@Validated(ValidationDraft.class) Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "article/add";
        }
        else{
            this.articleDao.save(article);
            return "redirect:/drafts/list";
        }
    }

    @GetMapping("/list")
    public String getAllDrafts(Model model){
        model.addAttribute("drafts", this.articleDao.getAllDrafts());
        return "draft/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDraft(@PathVariable Long id){
        this.articleDao.delete(this.articleDao.findById(id));
        return "redirect:/drafts/list";
    }

    @GetMapping("/edit/{id}")
    public String editDraft(@PathVariable Long id, Model model){
        model.addAttribute("article",this.articleDao.findById(id));
        return "article/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedDraft(@Validated({Default.class}) Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/edit/"+article.getId();
        }else if(article.isDraft()){  //to nie działa....dlaczego
            return "draft/list";
        }else {
            return "articles/list";
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

