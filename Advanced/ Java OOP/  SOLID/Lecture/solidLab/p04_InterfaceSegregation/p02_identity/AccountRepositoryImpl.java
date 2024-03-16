package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.AccountRepository;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class AccountRepositoryImpl implements AccountRepository {

    private Map<User, Status> registeredUsers;

    public AccountRepositoryImpl () {
        this.registeredUsers = new HashMap<> ( );
    }
    @Override
    public void addUser ( User user ) {
        this.registeredUsers.putIfAbsent ( user, Status.OFFLINE );
    }

    @Override
    public Iterable<User> getAllUsersOnline () throws UnsupportedOperationException {
        if(registeredUsers.isEmpty ()){
            throw new UnsupportedOperationException ( "Repository is Empty!" );
        }
        return Collections.unmodifiableCollection ( this.registeredUsers.keySet ( ) );
    }

    @Override
    public Iterable<User> getAllUsers () throws UnsupportedOperationException{
        if(registeredUsers.isEmpty ()){
            throw new UnsupportedOperationException ( "Repository is Empty!" );
        }
        return this.registeredUsers.entrySet ( )
                .stream ( )
                .filter ( e -> e.getValue ( ).equals ( Status.ONLINE ) )
                .map ( Map.Entry::getKey ).toList ( );
    }
    @Override
    public User getUserByName ( String email ) throws NoSuchElementException {
        try {
            return this.registeredUsers.keySet ( ).stream ( ).filter ( u -> u.getEmail ( ).equals ( email ) ).findFirst ( ).orElseThrow ( );

        }catch (NoSuchElementException e){
            throw new  NoSuchElementException ("Email is not registered!",e);
        }
    }
    @Override
    public void setStatus(User user, Status status){
        if (user == null){
            throw new NoSuchElementException ( "Missing user!" );
        }
        this.registeredUsers.put ( user,status );
    }
}
