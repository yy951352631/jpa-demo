package com.my.jpa;

import com.my.jpa.model.Customer;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Wtq
 * @date 2019/9/10 - 11:25
 */
@RunWith(SpringRunner.class)
public class TestOriginalMethod {
    @org.junit.Test
    public void testSave() {
        //1.加载配置文件工厂（实体管理类工厂）对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过实体管理类工厂获取实体管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //3.获取事物对象，开启事物
        EntityTransaction ts = entityManager.getTransaction();//获取
        ts.begin();//开启
        //4.保存一个客户到数据库中
        Customer customer = new Customer();
        customer.setCustName("Bob1");
        customer.setCustIndustry("航天");
        //保存
        entityManager.persist(customer);
        //5.提交事物
        ts.commit();
        //6.释放资源
        entityManager.close();
        entityManagerFactory.close();
    }
}
