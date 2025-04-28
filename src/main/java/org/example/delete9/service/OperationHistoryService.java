package org.example.delete9.service;

import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;
import org.example.delete9.model.Enums.IdentificatorType;
import org.example.delete9.model.Enums.TransactionTool;

import java.math.BigDecimal;

public interface OperationHistoryService {
    void saveOperation(BankAccount reciever, BankAccount sender, IdentificatorType identificatorType, BigDecimal summ, TransactionTool transactionTool);
}
