package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokemonTypeController   {


    @Autowired
    PokemonTypeService pokemonTypeService;

    @GetMapping({"/pokedex"})
    public ModelAndView pokedex(){
        var pokedex = new ModelAndView("pokedex");
        var l_pokemon = this.pokemonTypeService.listPokemonsTypes();
        pokedex.getModel().putIfAbsent("pokemonTypes", l_pokemon);
        return pokedex;
    }

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService){
        this.pokemonTypeService = pokemonTypeService;
    }

}
