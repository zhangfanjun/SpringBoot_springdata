package com.qf.springdata_test.dao;

import com.qf.springdata_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
