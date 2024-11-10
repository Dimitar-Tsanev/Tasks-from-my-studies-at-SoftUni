package users.service;

import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.data.entities.User;
import users.data.repositories.UserRepository;

import users.service.interfaces.UserService;
import users.util.interfacces.ValidatorUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;


    @Autowired
    public UserServiceImp(UserRepository userRepository, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
    }


    @Override
    public void createUser ( String userName, String password, String firstName, String lastName, String email ) {
        if ( userRepository.findByEmail(email).isPresent () ){
            throw new IllegalArgumentException ( String.format("User with email %s already exists", email) );
        }

        User user = new User(userName, password, firstName, lastName, email);
        user.setAge ( 18 );
        user.setRegisteredOn ( LocalDate.now () );
        user.setLasTimeLoggedIn ( LocalDateTime.now () );
        user.setDeleted ( false );

        if (!validatorUtil.isValid ( user)){
            System.out.println ( validatorUtil.validate (user).stream ().map ( ConstraintViolation::getMessage ).collect( Collectors.joining("\n")));
        }
        userRepository.save(user);
    }

    @Override
    public List<User> getByEmailProvider ( String emailProvider ) {
        List<User> users = userRepository.findByEmailEndingWith ( emailProvider );
        if ( users.isEmpty () ){
            throw new IllegalArgumentException ( String.format ("No users found with email domain %s",emailProvider ));
        }
        return users;
    }

    @Override
    public List<User> getInactiveUsers () {
        return userRepository.findByLasTimeLoggedInBefore ( LocalDateTime.now ( ).minusMinutes ( 10 ) );
    }

    @Override
    public void removeInactiveUsers () {
        List<User> users = getInactiveUsers ();
        if (users.isEmpty ()){
            return;
        }
        users.forEach ( u -> {
            System.out.printf ( "%s was deleted%n", u.getUsername () );
            u.setDeleted ( true );
            userRepository.save ( u );
        });
    }
}
