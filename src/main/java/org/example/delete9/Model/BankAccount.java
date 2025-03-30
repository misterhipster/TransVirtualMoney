package org.example.delete9.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.delete9.Model.Enums.BankAccoutStatus;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "bankAccount")
    private Set<Card> cards;
    private Long balance;
    private BankAccoutStatus status;
}
