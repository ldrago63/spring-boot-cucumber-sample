package com.ldrago.sample.cucumbersample.controllers.view;

import com.ldrago.sample.cucumbersample.documents.Persons;
import com.ldrago.sample.cucumbersample.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewPersonsController {

    @Autowired
    private PersonsRepository personsRepository;

    @GetMapping("/persons/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        model.addAttribute("person", this.personsRepository.findById(id).orElse(null));
        return "view";
    }

}
