package game_store.config;
import game_store.data.entities.DTOs.CreateUserDTO;
import game_store.data.entities.User;
import jakarta.validation.Validation;

import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Configs {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        PropertyMap <CreateUserDTO, User> passwordMao = new PropertyMap<> () {
            protected void configure() {
                map().setPasswordHash (  source.getPassword ());
            }
        };


        modelMapper.addMappings(passwordMao);

        return modelMapper;
    }

    @Bean
    public Validator validator (){
        return  Validation.buildDefaultValidatorFactory().getValidator ();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
