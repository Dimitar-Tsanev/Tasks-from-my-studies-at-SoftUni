package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface AccessController {

    void register (String email, String password);

    void login (String email, String password) throws IllegalAccessException;

}
