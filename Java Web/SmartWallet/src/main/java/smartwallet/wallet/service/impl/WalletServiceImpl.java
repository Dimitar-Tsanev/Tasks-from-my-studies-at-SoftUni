package smartwallet.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartwallet.shared.exception.DomainException;
import smartwallet.transaction.model.Transaction;
import smartwallet.transaction.model.TransactionStatus;
import smartwallet.transaction.model.TransactionType;
import smartwallet.transaction.service.TransactionService;
import smartwallet.user.model.User;
import smartwallet.wallet.model.Wallet;
import smartwallet.wallet.model.WalletStatus;
import smartwallet.wallet.property.WalletProperty;
import smartwallet.wallet.repository.WalletRepository;
import smartwallet.wallet.service.WalletService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletProperty walletProperty;
    private final TransactionService transactionService;

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

    @Override
    @Transactional
    public Transaction topUp ( UUID walletId, BigDecimal amount ) {
        Wallet wallet = getWalletById ( walletId );

        String transactionDescription = "Top up %.2f".formatted ( amount.doubleValue ( ) );

        TransactionStatus status = TransactionStatus.FAILED;
        String failureReason = "{failure.reason.inactive.wallet}";

        if ( WalletStatus.ACTIVE.equals ( wallet.getStatus ( ) ) ) {
            status = TransactionStatus.SUCCEEDED;
            failureReason = null;

            wallet.setBalance ( wallet.getBalance ( ).add ( amount ) );
            wallet.setUpdatedOn ( LocalDateTime.now ( ) );

            walletRepository.save ( wallet );
        }

        return generateTransaction ( wallet, amount, TransactionType.DEPOSIT,
                status, transactionDescription, failureReason );
    }

    @Override
    @Transactional
    public Transaction charge ( User user, UUID walletId, BigDecimal amount, String chargeDescription ) {
        Wallet wallet = getWalletById ( walletId );

        TransactionStatus status = TransactionStatus.FAILED;
        String failureReason = "{failure.reason.inactive.wallet}";

        boolean isBalanceEnoughForTransaction = wallet.getBalance ().compareTo ( amount ) >= 0;

        if ( !isBalanceEnoughForTransaction) {
            failureReason = "Insufficient funds, top up your account";

        }

        if ( WalletStatus.ACTIVE.equals ( wallet.getStatus ( ) ) && isBalanceEnoughForTransaction) {
            status = TransactionStatus.SUCCEEDED;
            failureReason = null;

            BigDecimal newBalance = wallet.getBalance().subtract(amount);
            wallet.setBalance(newBalance);
            wallet.setUpdatedOn(LocalDateTime.now());

            walletRepository.save(wallet);
        }

        return generateTransaction ( wallet,amount, TransactionType.WITHDRAWAL,status,chargeDescription,failureReason );
    }

    private Wallet getWalletById ( UUID walletID ) {
        return walletRepository.findById ( walletID )
                .orElseThrow ( () -> new DomainException ( "{wallet.not.found.exception}" ) );
    }

    private Transaction generateTransaction ( Wallet wallet,
                                              BigDecimal amount,
                                              TransactionType type,
                                              TransactionStatus status,
                                              String transactionDescription,
                                              String failureReason ) {

        return transactionService.createTransaction ( wallet.getOwner ( ),
                "{smart.wallet.ltd}",
                wallet.getId ( ).toString ( ),
                amount,
                wallet.getBalance ( ),
                wallet.getCurrency ( ),
                type,
                status,
                transactionDescription,
                failureReason );
    }
}
