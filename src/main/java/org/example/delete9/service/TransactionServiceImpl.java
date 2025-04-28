package org.example.delete9.service;

import lombok.Builder;
import org.example.delete9.model.BankAccount;
import org.example.delete9.model.OperationHistory;
import org.example.delete9.model.User;
import org.example.delete9.repository.BankAccountRepository;
import org.example.delete9.repository.OperationHistoryRepository;
import org.example.delete9.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionServiceImpl implements TransactionService {
    BankAccountRepository bankAccountRepository;
UserRepository userRepository;
    @Transactional
    @Override
    public void transferByBankAccId(Long recieverId, Long senderId, BigDecimal summ) {
        BankAccount sender = bankAccountRepository.findById(recieverId).orElseThrow(
                () -> new RuntimeException("TransferServiceImpl bank account not found for sender / transfer operation")
        );
        BankAccount reciever = bankAccountRepository.findById(senderId).orElseThrow(
                () -> new RuntimeException("TransferServiceImpl bank account not found for reciever / transfer operation")
        );

        int result = summ.compareTo(sender.getBalance());

        if (result <= 0) {
            sender.setBalance(sender.getBalance().subtract(summ));
            reciever.setBalance(reciever.getBalance().add(summ));
//            OperationHistory operationHistory = OperationHistory.builder()
//                    .operationSumm(summ)
//                    .senderCard();dd
//            operationHistoryRepository.save();
        } else {
            throw new RuntimeException("Not enough money");
        }
    }

    @Transactional
    @Override
    public void transferByUserPhoneNumbers(String senderPhoneNumber, String recieverPhoneNumber, BigDecimal summ) {
        User sender = userRepository.findByPhoneNumber(senderPhoneNumber);
        User reciever = userRepository.findByPhoneNumber(recieverPhoneNumber);
        if (sender == null || reciever== null){
            throw new RuntimeException("TransferServiceImpl userSender or userReciever not found/ transfer operation");
        }

    }

    @Transactional
    @Override
    public void withdraw(Long senderId, BigDecimal summ) {
        BankAccount sender = bankAccountRepository.findById(senderId).orElseThrow(
                () -> new RuntimeException("TransferServiceImpl bank account not found for sender / withdraw operation")
        );
        int result = sender.getBalance().compareTo(summ);
        if (result <= 0){
        sender.setBalance(sender.getBalance().subtract(summ));
        }else {
            throw new RuntimeException("Not enough money");
        }
    }

    @Transactional
    @Override
    public void deposit(Long recieverId, BigDecimal summ) {
        BankAccount reciever = bankAccountRepository.findById(recieverId).orElseThrow(
                ()->new RuntimeException("TransferServiceImpl bank account not found for sender / deposit operation")
        );
        reciever.setBalance(reciever.getBalance().add(summ));
    }
}
