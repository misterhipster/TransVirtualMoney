package org.example.delete9.controller;

import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;
import org.example.delete9.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
    BankAccountService bankAccountService;

    @GetMapping("/getAcc/{id}")
    BankAccount getBankAccountById(@PathVariable Long bankAccountId) {
        return bankAccountService.getBankAccountByid(bankAccountId);
    }

    @RequestMapping("/block/{id}")
    void blockAccountById(@PathVariable Long bankAccountId) {
        bankAccountService.blockAccountById(bankAccountId);
    }

    @RequestMapping("/close/{id}")
    void closeAccountById(@PathVariable Long bankAccountId) {
        bankAccountService.closeAccountById(bankAccountId);
    }

    @PutMapping("/deposit/{id}")
    void depositById(@PathVariable Long bankAccountId, @RequestBody BigDecimal money) {
        bankAccountService.depositById(bankAccountId, money);
    }

    @PutMapping("/cards/{id}")
    Set<Card> getCards(@PathVariable Long bankAccountId) {
        return bankAccountService.getCardsForAccount(bankAccountId);
    }

}
