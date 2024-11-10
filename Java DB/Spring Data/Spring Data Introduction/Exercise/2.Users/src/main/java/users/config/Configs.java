package users.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configs {
    @Bean
    public Validator validator (){return  Validation.buildDefaultValidatorFactory().getValidator ();}
}
