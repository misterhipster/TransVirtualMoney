package org.example.delete9.service;

import java.math.BigDecimal;

public interface TransactionService {
    void transferByBankAccId(Long recieverId, Long senderId, BigDecimal summ);

    void transferByUserPhoneNumbers(String senderPhoneNumber, String recieverPhoneNumber, BigDecimal summ);

    void withdraw(Long senderId, BigDecimal summ);

    void deposit(Long recieverId, BigDecimal summ);
}
