package com.example.Events.Repository;

import com.example.Events.Model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Accounts findByUsernameAndPassword(String username, String password);
}
