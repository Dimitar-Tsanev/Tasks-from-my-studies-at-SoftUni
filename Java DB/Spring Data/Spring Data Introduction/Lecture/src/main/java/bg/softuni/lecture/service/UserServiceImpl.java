package bg.softuni.lecture.service;

import bg.softuni.lecture.data.entities.User;
import bg.softuni.lecture.data.repositories.UserRepository;
import bg.softuni.lecture.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//4.Services

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser ( User user ) {
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if (userRepository.findByUsername ( user.getUsername() ) != null){
            throw new IllegalArgumentException("Username already exists");
        }
        userRepository.save ( user );
    }

    @Override
    public User findUserByUsername ( String username ) {
        return userRepository.findByUsername (username);
    }


}
