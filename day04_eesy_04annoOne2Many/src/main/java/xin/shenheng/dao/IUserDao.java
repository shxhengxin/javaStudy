package xin.shenheng.dao;

import org.apache.ibatis.annotations.*;
import xin.shenheng.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday")
    })
    List<User> findAll();

    //@Select("select * from user where username like '%${value}%' ")
    @Select("select * from user where username like #{username}")
    @ResultMap(value = {"userMap"})
    List<User> findUserByName(String username);


    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer userId);


}
