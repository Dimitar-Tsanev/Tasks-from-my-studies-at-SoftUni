package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;

public class UserImpl implements User {
    private final String email;
    private String password;

    public UserImpl ( String email, String password ) {
        this.email = email;
        this.setPassword ( password );
    }
    @Override
    public String getEmail () {
        return this.email;
    }

    @Override
    public String getPasswordHash () {
        return this.password;
    }

    @Override
    public void setPassword ( String password ) {
        this.password = password;
    }
}
