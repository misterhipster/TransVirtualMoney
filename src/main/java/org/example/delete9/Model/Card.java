package org.example.delete9.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private BankAccount bankAccount;

    private String cvvNumber;
    private Date date;
    private String CardNumber;
    private short pinCode;

    @OneToMany(mappedBy = "senderCard")
    private Set<OperationHistory> sentOperations;
    @OneToMany(mappedBy = "receiverCard")
    private Set<OperationHistory> receiveOperations;
}
