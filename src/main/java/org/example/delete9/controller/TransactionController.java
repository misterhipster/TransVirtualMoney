package org.example.delete9.controller;

import org.example.delete9.service.TransferService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
TransferService transferService;
    @PutMapping()
    void transfer(Long recieverId, Long senderId, BigDecimal summ) {
        transferService.transfer(recieverId, senderId, summ);
    }

    void withdraw(Long senderId, BigDecimal summ) {
        transferService.withdraw(senderId,summ);
    }

    void deposit(Long recieverId, BigDecimal summ) {
        transferService.deposit(recieverId, summ);
    }
}
