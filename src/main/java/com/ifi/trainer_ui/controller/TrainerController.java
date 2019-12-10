package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {


    @Autowired
    private TrainerService trainerService;

    @GetMapping({"/trainers"})
    public ModelAndView index(){
        var modelAndView = new ModelAndView("trainers");

        modelAndView.addObject("trainers", this.trainerService.listTrainer());

        return modelAndView;
    }

    @Autowired
    public void setPokemonTypeService(TrainerService trainerService){
        this.trainerService = trainerService;
    }


    @GetMapping("/trainers/{name}")
    ModelAndView index(@PathVariable String name){
        var modelAndView = new ModelAndView("trainer");

        modelAndView.addObject("trainer", trainerService.getTrainer(name));

        return modelAndView;
    }

}