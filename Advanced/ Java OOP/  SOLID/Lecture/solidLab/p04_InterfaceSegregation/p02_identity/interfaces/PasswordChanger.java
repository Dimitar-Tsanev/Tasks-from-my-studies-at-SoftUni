package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface PasswordChanger {

    void changePassword (String email, String oldPass, String newPass) throws IllegalAccessException;
}
