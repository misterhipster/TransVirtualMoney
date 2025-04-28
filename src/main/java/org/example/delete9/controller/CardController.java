package org.example.delete9.controller;

import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;
import org.example.delete9.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/card")
public class CardController {

    BankAccountService bankAccountService;

    @PostMapping("/create/{id}")
    public void createCard(@PathVariable Long id, @RequestBody short pinCode) {
        Card card = Card.builder()
                .bankAccount(bankAccountService.getBankAccountByid(id))
                .date(new Date())
                .pinCode(pinCode)
                .build();

        card.generateAndSetCardNumber();
        card.generateCVV();

        bankAccountService.addCard(id, card);
    }

    @GetMapping("card/{id}")
    public Set<Card> getCardsByBankAccountId(@PathVariable Long id) {
        return bankAccountService.getCardsForAccount(id);
    }
}
