package org.example.delete9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
import java.util.Random;

@Entity
@Data
@Builder
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private BankAccount bankAccount;

    @Size(min = 3, max = 3)
    private String cvvNumber;
    private Date date;
    private String cardNumber;
    private Short pinCode;

    @OneToMany(mappedBy = "senderCard")
    private Set<OperationHistory> sentOperations;
    @OneToMany(mappedBy = "receiverCard")
    private Set<OperationHistory> receiveOperations;

    public void generateAndSetCardNumber() {
        CardNumberGenerator cardNumberGenerator = CardNumberGenerator.generateVisaCard();
        cardNumber = cardNumberGenerator.getCardNumber();
    }

    public void generateCVV() {
        Random random = new Random();
        int cvv = random.nextInt(1000); // Генерация числа от 0 до 999
        cvvNumber = String.format("%03d", cvv); // Форматирование до 3 цифр
    }
}
