package smartwallet.transaction.service;

import smartwallet.transaction.model.Transaction;
import smartwallet.transaction.model.TransactionStatus;
import smartwallet.transaction.model.TransactionType;
import smartwallet.user.model.User;

import java.math.BigDecimal;
import java.util.Currency;

public interface TransactionService {

    Transaction createTransaction( User owner, String sender, String receiver,
                                   BigDecimal transactionAmount, BigDecimal balanceLeft,
                                   Currency currency, TransactionType type,
                                   TransactionStatus status, String transactionDescription,
                                   String failureReason);
}
