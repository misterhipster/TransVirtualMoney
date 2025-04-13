package org.example.delete9.service;

import org.example.delete9.model.BankAccount;
import org.example.delete9.model.User;

/*
Итак, что нужно реализовать в UserService?
1. Возможность авторизации
    при авторизации, пользователь вводит:
     email,
     пароль


2. Возможность регистрации
    При регистрации, пользователь должен ввести свои:
        логин (в будущем, возможно, опустим это поле),
        пароль,
        email,
        номер телефона
*/
public interface UserService {
    void createUser(User user);

    void deleteUserById(Long id);

    void updateUser(Long id, User user);

    User getUserById(Long userId);
    void createBankAccount(Long userId);
}
