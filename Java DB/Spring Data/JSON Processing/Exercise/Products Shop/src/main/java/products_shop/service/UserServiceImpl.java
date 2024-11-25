package products_shop.service;

import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.data.DTO.ImportUserJsonDto;
import products_shop.data.DTO.SoledProduct;
import products_shop.data.DTO.UsersWithSuccessfullySoldItemsDTO;
import products_shop.data.entity.User;
import products_shop.data.repositorie.UserRepository;
import products_shop.service.interfaces.UserService;
import products_shop.util.interfacces.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final String IMPORT_FILE_PATH = "src/main/resources/imports/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validator;

    @Autowired
    public UserServiceImpl ( UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validator ) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public void importUsers () throws IOException {
        String jsonString = String.join ( "", Files.readAllLines ( Path.of ( IMPORT_FILE_PATH ) ) );

        Arrays.stream ( this.gson.fromJson ( jsonString, ImportUserJsonDto[].class ) )
                .filter ( s -> {
                    if ( !this.validator.isValid ( s ) ) {
                        System.out.println ( this.validator.validate ( s )
                                .stream ( )
                                .map ( ConstraintViolation::getMessage )
                                .collect ( Collectors.joining ( System.lineSeparator ( ) ) ) );
                        return false;
                    }

                    return true;
                } )
                .map ( s -> this.modelMapper.map ( s, User.class ) )
                .forEach ( userRepository::saveAndFlush );
    }

    @Override
    public boolean areImported () {
        return userRepository.count ( ) > 0;
    }

    @Transactional
    @Override
    public String getALlUsersWithSuccessfulSale () {
        Set<UsersWithSuccessfullySoldItemsDTO> sellers = userRepository.findAllBySoldProductsNotNullOrderByLastNameAscFirstNameAsc ( )
                .stream ( )
                .map ( u -> {
                    Set<SoledProduct> soldProducts = u.getSoldProducts ( ).stream ( ).map ( p -> {
                        if(p.getBuyer () != null) {
                            SoledProduct product = modelMapper.map ( p, SoledProduct.class );
                            product.setBuyerFirstName ( p.getBuyer ( ).getFirstName ( ) );
                            product.setBuyerLastName ( p.getBuyer ( ).getLastName ( ) );
                            return product;
                        }
                        return null;
                    } ).filter ( Objects::nonNull ).collect ( Collectors.toSet ( ) );



                    UsersWithSuccessfullySoldItemsDTO user = modelMapper.map ( u, UsersWithSuccessfullySoldItemsDTO.class );
                    user.setSoledProduct ( soldProducts );

                    return user;
                } ).collect ( Collectors.toSet ( ) );

        return this.gson.toJson ( sellers );
    }
}
