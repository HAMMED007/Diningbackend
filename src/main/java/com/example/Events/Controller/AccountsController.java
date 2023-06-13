package com.example.Events.Controller;

import com.example.Events.Model.Accounts;
import com.example.Events.Model.Login;
import com.example.Events.Repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class AccountsController {

    private final AccountsRepository accountsRepository;

    @Autowired
    public AccountsController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }
    //Add New Product

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Accounts> createNewUser(@RequestBody Accounts user) {
        System.out.println("Requst Comming........");
        Accounts createdUser = accountsRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    @CrossOrigin
    public Long doLogin(@RequestBody Login login)
    {
        System.out.println(login.getUsername()+"----------"+login.getPassword());
        Accounts accounts=this.accountsRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if(accounts !=null)
        {
            return accounts.getId();
        }
        else
        {
            return Long.valueOf(0);
        }
    }



}
