package xin.shenheng.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import xin.shenheng.domain.Account;

import java.util.List;

public interface IAccountDao {

    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select="xin.shenheng.dao.IUserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();


    @Select("select * from account where uid=#{userId}")
    //@ResultMap(value = {"accountMap"})
    List<Account> findAccountByUid(Integer userId);
}
