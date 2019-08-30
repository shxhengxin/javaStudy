package xin.shenheng.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xin.shenheng.domain.Account;

import java.util.List;
@Repository
public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money)  values (#{name},#{money})")
    public void  saveAccount(Account account);
}
