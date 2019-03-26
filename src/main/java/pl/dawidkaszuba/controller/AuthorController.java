package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dawidkaszuba.entity.Author;
import pl.dawidkaszuba.repository.AuthorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/author", produces = "text/html; charset=UTF-8")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

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
            this.authorRepository.save(author);
            return "redirect:/author/list";
        }
    }

    @GetMapping("/list")
    public String getAllAuthors(Model model){
        model.addAttribute("authors",this.authorRepository.findAll());
        return "author/list";
    }
    @GetMapping("/edit/{id}")
    public String editAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author", this.authorRepository.findOne(id));
        return "author/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedAuthor(@Valid Author author,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "author/add";
        }else{
        this.authorRepository.save(author);
        return "redirect:/author/list";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        this.authorRepository.delete(this.authorRepository.findOne(id));
        return "redirect:/author/list";
    }

}
