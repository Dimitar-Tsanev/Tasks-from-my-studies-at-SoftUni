package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.*;

public class AccessControllerImpl implements AccessController, PasswordChanger {
    private final AccountRepository repository;
    private final EmailVerification emailVerification;
    private final PasswordVerification passwordVerification;

    public AccessControllerImpl ( AccountRepository repository ) {
        this.repository = repository;
        this.emailVerification = new EmailVerificationImpl ( repository );
        this.passwordVerification = new PasswordVerificationImpl ( );

    }

    @Override
    public void register ( String email, String password ) {
        if ( emailVerification.getRequireUniqueEmail ( email ) ) {
            if ( passwordVerification.isValidPassword ( password ) ) {
                User user = new UserImpl ( email, password );
                repository.addUser ( user );
                System.out.println ( "Successfully registered you can login!" );
            }
        }

    }

    @Override
    public void login ( String email, String password ) throws IllegalAccessException {
        User user = repository.getUserByName ( email );
        if ( !user.getPasswordHash ( ).equals ( password ) ) {
            throw new IllegalAccessException ( "Wrong password" );

        }
        repository.setStatus ( user, Status.ONLINE );
        System.out.println ( "Greetings!" );
    }

    @Override
    public void changePassword ( String email, String oldPass, String newPass ) throws IllegalAccessException {
        User user = repository.getUserByName ( email );
        String password = user.getPasswordHash ( );

        if ( oldPass == null ) {
            throw new IllegalArgumentException ( "Please enter old password" );

        }
        if ( !password.equals ( oldPass ) ) {
            throw new IllegalAccessException ( "Incorrect password!" );

        }
        if ( newPass == null ) {
            throw new IllegalArgumentException ( "Please enter new password" );

        }
        if ( !passwordVerification.isValidPassword ( newPass ) ) {
            throw new IllegalArgumentException ( String.format (
                    "Password length must be between %d and %d characters!"
                    , passwordVerification.getMinRequiredPasswordLength ( ),
                    passwordVerification.getMaxRequiredPasswordLength ( ) ) );

        }
        user.setPassword ( newPass );
    }
}
