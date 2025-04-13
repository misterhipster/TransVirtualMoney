package org.example.delete9.controller;

import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;
import org.example.delete9.service.BankAccountService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
    BankAccountService bankAccountService;

    @GetMapping("/getAcc/{id}")
    BankAccount getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getBankAccountByid(id);
    }

    @RequestMapping("/block/{id}")
    void blockAccountById(@PathVariable Long id) {
        bankAccountService.blockAccountById(id);
    }

    @RequestMapping("/close/{id}")
    void closeAccountById(@PathVariable Long id) {
        bankAccountService.closeAccountById(id);
    }

    @PutMapping("/deposit/{id}")
    void depositById(@PathVariable Long id, @RequestBody BigDecimal money) {
        bankAccountService.depositById(id, money);
    }

    @PutMapping("/cards/{id}")
    Set<Card> getCards(@PathVariable Long id) {
        return bankAccountService.getCardsForAccount(id);
    }
}
