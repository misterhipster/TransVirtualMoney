package org.example.delete9.controller;

import lombok.AllArgsConstructor;
import org.example.delete9.model.BankAccount;
import org.example.delete9.model.Enums.BankAccountStatus;
import org.example.delete9.model.User;
import org.example.delete9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping("get/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create/user")
    public void createUser(@RequestBody User user) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(new BigDecimal(0));
        bankAccount.setUser(user);
        bankAccount.setStatus(BankAccountStatus.Working);

        user.getBankAccounts().add(bankAccount);
        userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        // HTTP 204 - успешное обновление
//        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/create/bankacc/{id}")
    public void createBankAccount(@PathVariable Long id){
        userService.createBankAccount(id);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
