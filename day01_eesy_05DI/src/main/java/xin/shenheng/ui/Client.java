package xin.shenheng.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import xin.shenheng.service.IAccountService;
import xin.shenheng.service.impl.AccountServiceImpl;


/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring 的ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        /*
        构造函数注入
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();*/

        /**
         * set方法名称注入
         */

        /*IAccountService as = (IAccountService) ac.getBean("accountService2");
        as.saveAccount();*/

        /**
         * 复杂类型/集合注入
         */
        IAccountService as = (IAccountService) ac.getBean("accountService3");
        as.saveAccount();
    }
}
