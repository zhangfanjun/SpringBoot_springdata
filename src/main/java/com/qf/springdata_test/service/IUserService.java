package com.qf.springdata_test.service;

import com.qf.springdata_test.entity.User;
import org.springframework.data.domain.Page;

public interface IUserService {
    Page getPage(int currentPage);

    void add(User user);

    void del(int id);

    User getById(int id);

    void update(User user);
}
