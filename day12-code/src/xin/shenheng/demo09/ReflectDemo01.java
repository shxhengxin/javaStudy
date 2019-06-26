package xin.shenheng.demo09;

import xin.shenheng.demo07.Person;

import java.lang.reflect.Field;

public class ReflectDemo01 {

    public static void main(String[] args) {
        Class person = Person.class;
        Field[] fields = person.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }



}
