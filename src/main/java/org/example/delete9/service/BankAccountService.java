package org.example.delete9.service;

import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface BankAccountService {
    BankAccount getBankAccountByid(Long bankAccountId);
    BankAccount getBankAccountByUserId(Long userId);
    BigDecimal getBalanceById(Long bankAccountId);
    void depositById(Long bankAccountId, BigDecimal summ);
    void closeAccountById(Long bankAccountId);
    void blockAccountById(Long bankAccountId);

    void addCard(Long bankAccountId, Card card);
    Set<Card> getCardsForAccount(Long bankAccountId);
}
