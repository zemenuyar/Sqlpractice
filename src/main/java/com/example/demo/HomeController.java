package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    asbezaRepository asbezaRepository;
    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("asbezas",  asbezaRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String processForm(Model model){
        model.addAttribute("asbeza",new asbeza());
        return "asbezaform";
    }

    @PostMapping("/process")
    public String processForm(@Valid  asbeza asbeza, BindingResult result){
        if (result.hasErrors()){
            return "asbezaform";
        }
        asbezaRepository.save(asbeza);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("asbeza",  asbezaRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id")long id, Model model){
        model.addAttribute("asbeza", asbezaRepository.findById(id).get());
        return "asbezaform";

    }
    @RequestMapping("/delete/{id}")
    public String delasbeza(@PathVariable("id")long id, Model model) {
        asbezaRepository .deleteById(id);
        return "redirect:/";
    }
}
