package products_shop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.validation.Validation;

import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Configs {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper ();

    }

    @Bean
    public Validator validator (){
        return  Validation.buildDefaultValidatorFactory().getValidator ();
    }

    @Bean
    public Gson gson(){
        return new GsonBuilder ().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    }
}
