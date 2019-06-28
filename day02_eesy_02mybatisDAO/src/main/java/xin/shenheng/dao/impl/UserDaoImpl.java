package xin.shenheng.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xin.shenheng.dao.IUserDao;
import xin.shenheng.domain.User;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    private SqlSession session;


    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
        this.session = this.factory.openSession();
    }

    public List<User> findAll() {
        //根据factory获取对象
        SqlSession session = factory.openSession();
        //调用方法
        List<User> users = session.selectList("xin.shenheng.dao.IUserDao.findAll");



        session.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findById(Integer userId) {
        return null;
    }

    public List<User> findByName(String username) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
