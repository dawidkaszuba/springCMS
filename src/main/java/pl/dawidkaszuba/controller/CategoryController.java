package pl.dawidkaszuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.entity.Category;
import pl.dawidkaszuba.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/categories",produces = "text/html; charset=UTF-8")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/add")
    public String addCategories(Model model){
        model.addAttribute("category", new Category());
        return "category/add";
    }
    @PostMapping("/add")
    public String saveCategory(@Valid Category category, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "category/add";
        }else{
            categoryRepository.save(category);
            return "redirect:/categories/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        this.categoryRepository.delete(this.categoryRepository.findOne(id));
        return "redirect:/categories/list";
    }
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        model.addAttribute("category",this.categoryRepository.findOne(id));
        return "category/edit";
    }
    @PostMapping("/saveEdited")
    public String saveEditedCategory(@ModelAttribute Category category){
        this.categoryRepository.save(category);
        return "redirect:/categories/list";
    }

    @GetMapping("/list")
    public String allCategories(Model model){
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);
        return "category/list";
    }
}
