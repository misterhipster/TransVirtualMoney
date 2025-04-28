package org.example.delete9.controller;

import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Enums.IdentificatorType;
import org.example.delete9.model.Enums.TransactionTool;
import org.example.delete9.model.User;
import org.example.delete9.service.BankAccountService;
import org.example.delete9.service.OperationHistoryServiceImpl;
import org.example.delete9.service.TransactionService;
import org.example.delete9.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    TransactionService transactionService;
    OperationHistoryServiceImpl operationHistoryService;
    BankAccountService bankAccountService;
    UserService userService;

    @PostMapping("/transferByBankAccId/{recieverId}")
    public void transferByBankAccId(@PathVariable Long recieverId,
                                    @RequestBody Long senderId,
                                    @RequestBody BigDecimal summ) {
        transactionService.transferByBankAccId(recieverId, senderId, summ);
        BankAccount sender = bankAccountService.getBankAccountByid(recieverId);
        BankAccount reciever = bankAccountService.getBankAccountByid(recieverId);

        operationHistoryService.saveOperation(reciever,
                sender,
                IdentificatorType.BankAccountID,
                summ,
                TransactionTool.Site);
    }

    @PostMapping("/transferByPhoneNumber")
    public void transferByUserPhoneNumbers(@RequestBody String senderPhoneNumber,
                                           @RequestBody String recieverPhoneNumber,
                                           @RequestBody BigDecimal summ) {
        transactionService.transferByUserPhoneNumbers(senderPhoneNumber, recieverPhoneNumber, summ);

        User userReciever = userService.getUserByPhoneNumber(recieverPhoneNumber);
        User userSender = userService.getUserByPhoneNumber(senderPhoneNumber);

        BankAccount reciever = bankAccountService.getBankAccountByUserId(userReciever.getId());
        BankAccount sender = bankAccountService.getBankAccountByUserId(userSender.getId());

        operationHistoryService.saveOperation(reciever,
                sender,
                IdentificatorType.PhoneNumber,
                summ,
                TransactionTool.Site);
    }

    @PostMapping("/withdraw/{senderId}")
    public void withdraw(@PathVariable Long senderId, BigDecimal summ) {
        transactionService.withdraw(senderId, summ);
        BankAccount sender = bankAccountService.getBankAccountByid(senderId);
        operationHistoryService.saveOperation(null,
                sender,
                IdentificatorType.BankAccountID,
                summ,
                TransactionTool.Site);
    }

    @PostMapping("/deposit/{recieverId}")
    public void deposit(@PathVariable Long recieverId, BigDecimal summ) {
        transactionService.deposit(recieverId, summ);

        BankAccount reciever = bankAccountService.getBankAccountByid(recieverId);
        operationHistoryService.saveOperation(reciever,
                null,
                IdentificatorType.BankAccountID,
                summ,
                TransactionTool.Site);
    }
}

