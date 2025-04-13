package org.example.delete9.service;

import lombok.AllArgsConstructor;
import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;
import org.example.delete9.model.Enums.BankAccountStatus;
import org.example.delete9.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletionService;

@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount getBankAccountByid(Long bankAccountId) {
        return  bankAccountRepository.findById(bankAccountId).get();
    }

    @Override
    public BigDecimal getBalanceById(Long bankAccountId) {
        return bankAccountRepository.findById(bankAccountId).get().getBalance();
    }

    @Override
    public void depositById(Long bankAccountId, BigDecimal summ) {
        BankAccount tmpBankAccount = bankAccountRepository.findById(bankAccountId).get();
        if (tmpBankAccount.getStatus().equals(BankAccountStatus.Working)){
        tmpBankAccount.setBalance(tmpBankAccount.getBalance().add(summ));
        }
        else {
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
}
