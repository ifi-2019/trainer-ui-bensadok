package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    RestTemplate restTemplate;

    String trainerServiceUrl;


    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Trainer> listTrainer() {
        var toto = this.restTemplate.getForObject(this.trainerServiceUrl+"/trainers/",Trainer[].class);
        List l_trainer = new ArrayList();

        for(Trainer p : toto){
            l_trainer.add(p);
        }
        return l_trainer;
    }



    public Trainer getTrainer(String name) {
        var url = trainerServiceUrl + "/trainers/"+name;
        var trainer = restTemplate.getForObject(url, Trainer.class);
        return trainer;
    }


    @Value("${trainer.service.url}")
    public void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }


}
