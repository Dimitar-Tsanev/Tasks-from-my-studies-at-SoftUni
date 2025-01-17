package smartwallet.wallet.service;

import smartwallet.transaction.model.Transaction;
import smartwallet.user.model.User;

import java.math.BigDecimal;
import java.util.UUID;


public interface WalletService {
    void createNewWallet ( User user );

    Transaction topUp ( UUID walletId, BigDecimal amount );

    Transaction charge (User user, UUID walletId, BigDecimal amount, String chargeDescription );
}
