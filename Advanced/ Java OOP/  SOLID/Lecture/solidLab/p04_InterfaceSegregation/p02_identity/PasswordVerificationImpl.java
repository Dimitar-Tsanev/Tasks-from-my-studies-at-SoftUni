package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.PasswordVerification;

public class PasswordVerificationImpl implements PasswordVerification {
    private static final int MINIMUM_REQUIRED_PASSWORD_LENGTH = 8;
    private static final int MAXIMUM_REQUIRED_PASSWORD_LENGTH = 15;

    @Override
    public int getMinRequiredPasswordLength () {
        return MINIMUM_REQUIRED_PASSWORD_LENGTH;
    }

    @Override
    public int getMaxRequiredPasswordLength () {
        return MAXIMUM_REQUIRED_PASSWORD_LENGTH;
    }

    @Override
    public boolean isValidPassword ( String password ) {
        return password.length () >= MINIMUM_REQUIRED_PASSWORD_LENGTH && password.length () <= MAXIMUM_REQUIRED_PASSWORD_LENGTH;
    }
}
