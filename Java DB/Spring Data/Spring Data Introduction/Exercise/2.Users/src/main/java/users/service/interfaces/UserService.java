package users.service.interfaces;

import users.data.entities.User;

import java.util.List;

public interface UserService {
     void createUser( String userName, String password, String firstName, String lastName, String email);

     List<User> getByEmailProvider( String emailProvider);
     List<User> getInactiveUsers();
     void removeInactiveUsers ();
}
