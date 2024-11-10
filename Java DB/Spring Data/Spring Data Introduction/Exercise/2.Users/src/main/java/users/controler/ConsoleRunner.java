package users.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import users.service.interfaces.*;
import users.data.entities.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final AlbumService albumService;
    private final CountryService countryService;
    private final PictureService pictureService;
    private final TownService townService;
    private final UserService userService;

    @Autowired
    public ConsoleRunner(AlbumService albumService, CountryService countryService, PictureService pictureService, TownService townService, UserService userService) {
        this.albumService = albumService;
        this.countryService = countryService;
        this.pictureService = pictureService;
        this.townService = townService;
        this.userService = userService;
    }

    @Override
    public void run ( String... args ) throws Exception {
        try {
            userService.createUser("username", "rAnd0m>", "firstName", "lastName", "email1@gmail.com");
            userService.createUser("userName", "rAnd0m!", "firstName", "lastName", "email2@yahoo.co.uk");
            userService.createUser("usernAme", "rAnd0m<", "firstName", "lastName", "email3@yahoo.co.uk");
            userService.createUser("Username", "rAnd0m@", "firstName", "lastName", "email4@gmail.com");

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        List<String> emailProviders = List.of ( "gmail.com", "yahoo.co.uk","abv.bg");
        emailProviders.forEach ( p -> {
            List<User> users = getByEmailProvider ( p );

            if(!users.isEmpty ()){
                printUsers ( users );
                System.out.println (System.lineSeparator () );
            }
        });

        userService.removeInactiveUsers ();

    }
    private void printUsers(List<User> users){
        users.stream( ).map ( User::getUsername ).forEach( System.out::println );
    }

    private List<User> getByEmailProvider (String email){
        try {
            return userService.getByEmailProvider(email);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<> ();
    }

}
