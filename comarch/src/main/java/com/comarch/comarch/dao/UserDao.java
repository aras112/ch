package com.comarch.comarch.dao;

import com.comarch.comarch.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
