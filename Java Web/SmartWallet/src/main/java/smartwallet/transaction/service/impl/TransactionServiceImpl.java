package smartwallet.transaction.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import smartwallet.transaction.model.Transaction;
import smartwallet.transaction.model.TransactionStatus;
import smartwallet.transaction.model.TransactionType;
import smartwallet.transaction.repository.TransactionRepository;
import smartwallet.transaction.service.TransactionService;
import smartwallet.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction ( User owner, String sender, String receiver,
                                           BigDecimal transactionAmount, BigDecimal balanceLeft,
                                           Currency currency, TransactionType type, TransactionStatus status,
                                           String transactionDescription, String failureReason ) {

        LocalDateTime now = LocalDateTime.now();

        Transaction transaction = Transaction.builder().
                owner( owner ).
                sender( sender ).
                receiver( receiver ).
                amount ( transactionAmount ).
                balanceLeft ( balanceLeft ).
                currency ( currency ).
                type ( type ).
                status ( status ).
                description ( transactionDescription ).
                failureReason ( failureReason ).
                createdOn ( now ).
                build();

        return transactionRepository.save(transaction);
    }

}
