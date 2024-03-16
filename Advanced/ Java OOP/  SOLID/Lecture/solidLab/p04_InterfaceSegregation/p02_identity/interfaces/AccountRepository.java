package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

import solidLab.p04_InterfaceSegregation.p02_identity.Status;

import java.util.NoSuchElementException;

public interface AccountRepository {
    void addUser(User user);
    void setStatus(User user, Status status);
    Iterable<User> getAllUsersOnline()throws UnsupportedOperationException;

    Iterable<User> getAllUsers() throws UnsupportedOperationException ;

    User getUserByName (String email) throws NoSuchElementException;
}
