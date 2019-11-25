package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    RestTemplate restTemplate;
    String pokemonServiceUrl;


        public List<PokemonType> listPokemonsTypes() {
            var toto = this.restTemplate.getForObject(this.pokemonServiceUrl+"/pokemon-types/",PokemonType[].class);
            List l_pokemon = new ArrayList();

            for(PokemonType p : toto){
                l_pokemon.add(p);
            }
            return l_pokemon;
        }


        @Autowired
        public void setRestTemplate(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @Value("${pokemonType.service.url}")
        public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
            this.pokemonServiceUrl = pokemonServiceUrl;
        }

}
