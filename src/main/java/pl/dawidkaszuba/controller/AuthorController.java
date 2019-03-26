package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.dao.AuthorDao;
import pl.dawidkaszuba.entity.Author;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/author", produces = "text/html; charset=UTF-8")
public class AuthorController {


    @Autowired
    private AuthorDao authorDao;

    @GetMapping("/add")
    public String addAuthor(Model model){
        model.addAttribute("author",new Author());
        return "author/add";
    }

    @PostMapping("/add")
    public String saveAuthor(@Valid Author author, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "author/add";
        }else{
            this.authorDao.save(author);
            return "redirect:/author/list";
        }
    }

    @GetMapping("/list")
    public String getAllAuthors(Model model){
        model.addAttribute("authors",this.authorDao.findAll());
        return "author/list";
    }
    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author", this.authorDao.findById(id));
        return "author/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedAuthor(@Valid Author author,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "author/add";
        }else{
        this.authorDao.update(author);
        return "redirect:/author/list";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        this.authorDao.delete(this.authorDao.findById(id));
        return "redirect:/author/list";
    }

}
