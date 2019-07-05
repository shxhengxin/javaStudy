package xin.shenheng.dao;


import xin.shenheng.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    User findById(Integer userId);



}


