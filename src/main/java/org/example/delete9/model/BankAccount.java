package org.example.delete9.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.delete9.model.Enums.BankAccountStatus;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "bankAccount")
    private Set<Card> cards;
    private BigDecimal balance;
    private BankAccountStatus status;
}
