package org.example.delete9.service;

import lombok.AllArgsConstructor;
import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Card;
import org.example.delete9.model.Enums.IdentificatorType;
import org.example.delete9.model.Enums.OperationResult;
import org.example.delete9.model.Enums.TransactionTool;
import org.example.delete9.model.OperationHistory;
import org.example.delete9.repository.OperationHistoryRepository;
import org.springframework.stereotype.Service;

import javax.sound.midi.Receiver;
import java.math.BigDecimal;
import java.util.Date;

@Service
@AllArgsConstructor
public class OperationHistoryServiceImpl implements OperationHistoryService {
    OperationHistoryRepository operationHistoryRepository;

    @Override
    public void saveOperation(BankAccount reciever, BankAccount sender, IdentificatorType identificatorType, BigDecimal summ, TransactionTool transactionTool) {
        OperationHistory operationHistory = OperationHistory.builder()
                .date(new Date())
                .operationResult(OperationResult.Completed)
                .identificatorType(identificatorType)
                .transactionMethod(transactionTool)
                .operationSumm(summ)
                .receiverCard(reciever)
                .senderCard(sender)
                .build();
        operationHistoryRepository.save(operationHistory);
    }

}
