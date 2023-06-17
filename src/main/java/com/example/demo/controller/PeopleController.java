package com.example.demo.controller;


import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class PeopleController {

    private PersonService personService;
    @Autowired
    public PeopleController(PersonServiceImp personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String getAllUsers(ModelMap model){
        model.addAttribute("people", personService.getAllUsers());
        return "index";
    }
    @GetMapping("{id}")
    public String getUserById(@PathVariable ("id") Long id, ModelMap model) {
        model.addAttribute("person", personService.getUserById(id));
        return "show";
    }

    @GetMapping ("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new";
    }

    @PostMapping()
    public  String create(@ModelAttribute ("person") Person person){
        personService.saveUser(person);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit (ModelMap model, @PathVariable ("id") Long id){
        model.addAttribute("person", personService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute ("person") Person person, @PathVariable ("id") Long id) {
        personService.updateUser(person);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable ("id") Long id){
        personService.removeUser(id);
        return "redirect:/";
    }


}
