package org.example.delete9.service;

public interface BankAccountService {
    // перевод по id, номеру карты, номеру телефона
    void transferBankAccountId(Long bankAccountId);
    void transferCardNumber(String cardNumber);
    void transferPhoneNumber(String phoneNumber);

    // снятие
    void withdraw();

    // внос (положить деньги на счет)
    void deposit();
}
