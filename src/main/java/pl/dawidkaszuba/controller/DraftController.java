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
import pl.dawidkaszuba.validator.ValidationDraft;

import javax.validation.groups.Default;
import java.util.List;


@Controller
@RequestMapping("/drafts")
public class DraftController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ArticleRepository articleRepository;


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
            this.articleRepository.save(article);
            return "redirect:/drafts/list";
        }
    }

    @GetMapping("/list")
    public String getAllDrafts(Model model){
        model.addAttribute("drafts", this.articleRepository.findAllDrafts());
        return "draft/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDraft(@PathVariable Long id){
        this.articleRepository.delete(this.articleRepository.findOne(id));
        return "redirect:/drafts/list";
    }

    @GetMapping("/edit/{id}")
    public String editDraft(@PathVariable Long id, Model model){
        model.addAttribute("article",this.articleRepository.findOne(id));
        return "draft/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedDraft(@Validated({ValidationDraft.class}) Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/drafts/edit/"+article.getId();
        }else if(article.isDraft()){
            this.articleRepository.save(article);
            return "redirect:/drafts/list";
        }else {
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

