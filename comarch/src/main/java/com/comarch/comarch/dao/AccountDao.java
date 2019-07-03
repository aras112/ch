package com.comarch.comarch.dao;

import com.comarch.comarch.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account,Long> {
}
