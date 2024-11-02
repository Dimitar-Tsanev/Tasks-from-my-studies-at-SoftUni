package bg.softuni.lecture.service.interfaces;

import bg.softuni.lecture.data.entities.User;

public interface UserService {
    void registerUser( User user);
    User findUserByUsername(String username);
}
