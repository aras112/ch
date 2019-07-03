package com.comarch.comarch.dao;

import com.comarch.comarch.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferDao extends JpaRepository<Transfer,Long> {
}
