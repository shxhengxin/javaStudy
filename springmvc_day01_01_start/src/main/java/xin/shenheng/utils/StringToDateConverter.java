package xin.shenheng.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转换日期
 */
public class StringToDateConverter implements Converter<String, Date>{
    @Override
    public Date convert(String source) {

        if(source == null) {
            throw  new RuntimeException("请您传入参数");
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {

            return (Date) df.parseObject(source);
            //return df.parse(source);

        } catch (ParseException e) {
            throw  new RuntimeException("数据类型转换出现错误");
        }
        //return null;
    }
}
