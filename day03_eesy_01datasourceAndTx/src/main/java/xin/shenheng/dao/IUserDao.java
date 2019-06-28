package xin.shenheng.dao;

import xin.shenheng.domain.QueryVo;
import xin.shenheng.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    User findById(Integer userId);

    List<User> findByName(String username);


    List<User> findUserByCondition(User user);

    List<User> findUserInIds(QueryVo vo);

}


