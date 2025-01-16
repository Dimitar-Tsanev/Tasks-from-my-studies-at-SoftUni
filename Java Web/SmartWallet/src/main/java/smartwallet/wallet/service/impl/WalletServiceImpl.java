package smartwallet.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smartwallet.user.model.User;
import smartwallet.wallet.model.Wallet;
import smartwallet.wallet.property.WalletProperty;
import smartwallet.wallet.repository.WalletRepository;
import smartwallet.wallet.service.WalletService;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletProperty walletProperty;

    @Override
    public void createNewWallet ( User user ) {
        Wallet wallet = Wallet.builder ( )
                .owner ( user )
                .status ( walletProperty.status ( ) )
                .balance ( walletProperty.balance ( ) )
                .currency ( walletProperty.currency ( ) )
                .createdOn ( walletProperty.createdOn ( ) )
                .updatedOn ( walletProperty.updatedOn ( ) )
                .build ( );

        walletRepository.save ( wallet );
    }
}
