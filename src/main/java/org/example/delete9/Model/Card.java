package org.example.delete9.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private BankAccount bankAccount;

    @Size(min = 3, max = 3)
    private String cvvNumber;
    private Date date;
    private String CardNumber;
    private Short pinCode;

    @OneToMany(mappedBy = "senderCard")
    private Set<OperationHistory> sentOperations;
    @OneToMany(mappedBy = "receiverCard")
    private Set<OperationHistory> receiveOperations;
}
