package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface PasswordVerification {
    int getMinRequiredPasswordLength();
    int getMaxRequiredPasswordLength();
    boolean isValidPassword(String password);

}
