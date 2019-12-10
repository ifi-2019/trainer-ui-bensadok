package com.ifi.trainer_ui.config;

import com.ifi.trainer_ui.trainers.bo.Trainer;
import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private TrainerService trainerService;

    public TrainerService getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService(trainerService);
    }

    public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

        @Autowired
        private TrainerService trainerservice;

        public UserDetailsService(TrainerService trainerService) {
            this.trainerservice = trainerService;
        }


        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
          Trainer t = trainerservice.getTrainer(s);
          if(t !=null){
              var new_auth = new GrantedAuthority() {
                  @Override
                  public String getAuthority() {
                      return "ROLE_USER";
                  }
              };
              UserDetails u = User.withUsername(t.getName()).password(t.getPassword()).authorities(new_auth).build();
              return u;
          }
          else {
              throw new BadCredentialsException("No such user");
          }
        }
    }


}

