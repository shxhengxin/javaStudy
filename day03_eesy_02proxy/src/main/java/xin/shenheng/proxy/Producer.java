package xin.shenheng.proxy;

public class Producer implements IProducer{
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱:" + money);
    }
    public void  afterService(float money) {
        System.out.println("提供售后服务并拿到钱: " + money);
    }
}
