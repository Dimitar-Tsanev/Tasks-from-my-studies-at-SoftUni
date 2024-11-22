package employees.config;

import employees.entities.DTOs.EmployeeDTO;
import employees.entities.EmployeeTaskTwo;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap <EmployeeTaskTwo, EmployeeDTO> orderMap = new PropertyMap<> () {
            protected void configure() {
                map().setManagerLastName ( source.getManager ().getLastName ());
            }
        };

        modelMapper.addMappings(orderMap);

        return modelMapper;
    }
}
