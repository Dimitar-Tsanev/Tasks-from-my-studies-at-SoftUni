package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.AccountRepository;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.EmailVerification;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;

public class EmailVerificationImpl implements EmailVerification {
    private AccountRepository registeredUsers;

    public EmailVerificationImpl ( AccountRepository registeredUsers ) throws IllegalArgumentException {
        this.setRegisteredUsers ( registeredUsers );

    }
    private void setRegisteredUsers ( AccountRepository registeredUsers ) {
        this.registeredUsers = registeredUsers;
    }

    @Override
    public boolean getRequireUniqueEmail (String email) {
        if(email == null || email.isBlank ()){
            throw new IllegalArgumentException ( "Missing email!" );
        }
        if (!email.matches ( "^[A-Za-z0-9]+([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]+(\\.[A-Za-z]+)+$" ) ){
            throw new IllegalArgumentException ( "Unsupported email!" );

        }
        try {
            for ( User user : this.registeredUsers.getAllUsers ( ) ) {
                if ( user.getEmail ( ).equals ( email ) ) {
                    return false;
                }
            }
            return true;

        }catch(UnsupportedOperationException e){
            return true;

        }
    }
}
