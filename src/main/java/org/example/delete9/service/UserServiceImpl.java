package org.example.delete9.service;

import lombok.AllArgsConstructor;
import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Enums.BankAccountStatus;
import org.example.delete9.model.OperationHistory;
import org.example.delete9.model.User;
import org.example.delete9.repository.BankAccountRepository;
import org.example.delete9.repository.CardRepository;
import org.example.delete9.repository.OperationHistoryRepository;
import org.example.delete9.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private BankAccountRepository bankAccountRepository;
    private CardRepository cardRepository;
    private OperationHistoryRepository operationHistoryRepository;
    private UserRepository userRepository;


    @Override
    public void createUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found in UPDATE operation"));

        if (user.getLogin() != null) {
            existingUser.setLogin(user.getLogin());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPhoneNumber() != null) {
            existingUser.setPhoneNumber(user.getPhoneNumber());
        }
        // если объект новый, то создается запись в бд (INSERT). Если объект уже есть, то прооисходит UPDATE
        userRepository.save(existingUser);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));

    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        return user;
    }

    @Override
    public void createBankAccount(Long userId) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setStatus(BankAccountStatus.Working);
        userRepository.findById(userId).get().getBankAccounts().add(bankAccount);

    }

}
