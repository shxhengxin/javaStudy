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

        //IAccountService as = new AccountServiceImpl();
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as1 = (IAccountService) ac.getBean("accountService");

        as1.saveAccount();


        System.out.println("==========下面延迟创建==========");
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        bdr.loadBeanDefinitions(resource);
        IAccountService as2 = (IAccountService) factory.getBean("accountService");


        as2.saveAccount();



    }
}
