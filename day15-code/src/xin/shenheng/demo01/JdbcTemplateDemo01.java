package xin.shenheng.demo01;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import xin.shenheng.utils.DruidUtils;

import javax.sql.DataSource;

public class JdbcTemplateDemo01 {
    public static void main(String[] args) {

        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

        //String sql = "update account set balance = 5000 where id =?";
        String sql = " select count(id) from account";
        Long total = template.queryForObject(sql, Long.class);
        //int count = template.update(sql, 1);
        System.out.println(total);

    }
    @Test
    public void test1(){
        System.out.println(111);
    }
}
