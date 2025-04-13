package org.example.delete9.service;

import java.math.BigDecimal;

public interface TransferService {
    void transfer(Long recieverId, Long senderId, BigDecimal summ);

    void withdraw(Long senderId, BigDecimal summ);

    void deposit(Long recieverId, BigDecimal summ);
}
