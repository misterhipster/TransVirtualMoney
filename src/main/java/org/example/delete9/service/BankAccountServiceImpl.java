package org.example.delete9.service;

import lombok.AllArgsConstructor;
import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;
import org.example.delete9.model.Enums.BankAccountStatus;
import org.example.delete9.repository.BankAccountRepository;
import org.example.delete9.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletionService;

@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    BankAccountRepository bankAccountRepository;
    UserRepository userRepository;

    @Override
    public BankAccount getBankAccountByid(Long bankAccountId) {
        return bankAccountRepository.findById(bankAccountId).get();
    }

    public BankAccount getBankAccountByUserId(Long userId) {

        Set<BankAccount> bankAccounts = userRepository.findById(userId).get().getBankAccounts();
        return bankAccounts.stream().findFirst().orElseThrow(
                () -> new RuntimeException("BankAccountServiceImpl getBankAccountByUser")
        );
    }

    @Override
    public BigDecimal getBalanceById(Long bankAccountId) {
        return bankAccountRepository.findById(bankAccountId).get().getBalance();
    }

    @Override
    public void depositById(Long bankAccountId, BigDecimal summ) {
        BankAccount tmpBankAccount = bankAccountRepository.findById(bankAccountId).get();
        if (tmpBankAccount.getStatus().equals(BankAccountStatus.Working)) {
            tmpBankAccount.setBalance(tmpBankAccount.getBalance().add(summ));
        } else {
            throw new RuntimeException("This bankAccount not working");
        }
    }

    @Override
    public void closeAccountById(Long bankAccountId) {
        bankAccountRepository.findById(bankAccountId).get().setStatus(BankAccountStatus.Closed);
    }

    @Override
    public void blockAccountById(Long bankAccountId) {
        bankAccountRepository.findById(bankAccountId).get().setStatus(BankAccountStatus.Blocked);
    }

    public Set<Card> getCardsForAccount(Long bankAccountId) {
        return bankAccountRepository.findById(bankAccountId).get().getCards();
    }

    @Override
    public void addCard(Long bankAccountId, Card card) {
        bankAccountRepository.findById(bankAccountId).get().getCards().add(card);
    }
}
