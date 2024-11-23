package game_store.service;

import game_store.data.entities.DTOs.CreateUserDTO;
import game_store.data.entities.Game;
import game_store.data.entities.ShoppingCart;
import game_store.data.entities.User;
import game_store.data.repositories.ShoppingCartRepository;
import game_store.data.repositories.UserRepository;
import game_store.service.interfaces.UserService;
import game_store.util.interfacces.ValidatorUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserServiceImp implements UserService {
    private final ShoppingCartRepository shoppingCartRepository;
    private User logginUser;

    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImp ( UserRepository userRepository,
                            ValidatorUtil validatorUtil,
                            PasswordEncoder passwordEncoder,
                            ModelMapper modelMapper, ShoppingCartRepository shoppingCartRepository ) {

        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.logginUser = null;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public String registerUser ( CreateUserDTO createUserDTO ) {
        if ( userRepository.findByEmail ( createUserDTO.getEmail ( ) ).isPresent ( ) ) {
            return "Username already exists";
        }

        if ( !createUserDTO.getPassword ( ).equals ( createUserDTO.getConfirmPassword ( ) ) ) {
            return "Passwords do not match";
        }

        Set<ConstraintViolation<CreateUserDTO>> violations = validatorUtil.validate ( createUserDTO );

        if ( !violations.isEmpty ( ) ) {
            return violations.stream ( ).map ( ConstraintViolation::getMessage ).collect ( Collectors.joining ( System.lineSeparator ( ) ) );
        }

        createUserDTO.setPassword ( passwordEncoder.encode ( createUserDTO.getPassword ( ) ) );

        createUserDTO.setAdmin ( userRepository.count ( ) == 0 );

        User user = modelMapper.map ( createUserDTO, User.class );

        userRepository.save ( user);

        shoppingCartRepository.saveAndFlush ( new ShoppingCart ( user ) );

        userRepository.save ( user );

        return String.format ( "%s was successfully registered!", createUserDTO.getFullName ( ) );
    }

    @Override
    public String loginUser ( String username, String password ) {
        if ( userRepository.findByEmail ( username ).isEmpty ( ) ) {
            return "Incorrect username ";
        }

        User user = userRepository.findByEmail ( username ).get ( );

        if ( !passwordEncoder.matches ( password, user.getPasswordHash ( ) ) ) {
            return "Incorrect password";
        }

        logginUser = user;

        return String.format ( "Successfully logged in %s", user.getFullName ( ) );
    }

    @Override
    public String logoutUser () {
        if ( this.logginUser == null ) {
            return "Cannot log out. No user was logged in.";
        }

        String userFullName = logginUser.getFullName ( );
        logginUser = null;
        return String.format ( "User %s successfully logged out", userFullName );
    }

    @Override
    public boolean isCurrentUserAdmin () {
        return logginUser.isAdmin ( );
    }

    @Transactional
    @Override
    public Set<String> getOwnedGames () {
        return logginUser.getGames ().stream ( ).map ( Game::getTitle ).collect ( Collectors.toSet ( ) );
    }

    @Override
    public String getUserEmail () {
        return logginUser.getEmail ();
    }

    @Override
    public boolean isUserLoggedIn () {
        return logginUser != null;
    }

    @Override
    public void save () {
        userRepository.save ( logginUser );
    }

    @Override
    public boolean isUserHaveGame ( String itemName ) {
        return logginUser.getGames ( ).stream ( ).map ( Game::getTitle ).collect ( Collectors.toSet ( ) ).contains ( itemName );
    }

}
