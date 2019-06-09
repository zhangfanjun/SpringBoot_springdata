package com.qf.springdata_test.service.impl;

import com.qf.springdata_test.dao.UserDao;
import com.qf.springdata_test.entity.User;
import com.qf.springdata_test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;

    @Override
    public Page getPage(int currentPage) {
        currentPage-=1;
        Sort s=new Sort(Sort.Direction.DESC,"date");
        Pageable page=PageRequest.of(currentPage,5,s);
        Page<User> p = dao.findAll(page);
        return p;
    }

    @Override
    public void del(int id) {
        dao.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return dao.findById(id).get();
    }

    @Override
    public void update(User user) {
        dao.save(user);
    }

    @Override
    public void add(User user) {
        dao.save(user);
    }
}
