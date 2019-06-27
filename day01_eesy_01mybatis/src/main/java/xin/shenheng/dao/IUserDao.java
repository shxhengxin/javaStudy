package xin.shenheng.dao;

import xin.shenheng.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有数据
     * @return
     */
    List<User> findAll();
}
