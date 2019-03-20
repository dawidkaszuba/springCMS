package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.dao.ArticleDao;
import pl.dawidkaszuba.entity.Article;
import pl.dawidkaszuba.validator.DraftValidator;
import pl.dawidkaszuba.validator.ValidationDraft;


@Controller
@RequestMapping("/drafts")
public class DraftController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private DraftValidator draftValidator;



    @GetMapping("/add")
    public String addDraft(Model model){
        model.addAttribute("article", new Article());
        return "article/add";
    }

    @PostMapping("/add")
    public String saveDraft(@Validated({ValidationDraft.class}) Article article, BindingResult bindingResult){
        this.draftValidator.validate(article,bindingResult);
        if(bindingResult.hasErrors()){
            return "article/add";
        }
        else{
            this.articleDao.save(article);
            return "redirect:/articles/list";
        }
    }

    @GetMapping("/list")
    public String getAllDrafts(Model model){
        model.addAttribute("drafts", this.articleDao.getAllDrafts());
        return "draft/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        this.articleDao.delete(this.articleDao.findById(id));
        return "redirect:/drafts/list";
    }
}

