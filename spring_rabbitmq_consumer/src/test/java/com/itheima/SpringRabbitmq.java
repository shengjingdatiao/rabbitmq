package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: spring_rabbitmq
 * @Author: dongxiyaohui
 * @Date: 2019/12/16 20:08
 * @Description: //TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:spring-rabbitmq-consumer.xml")
public class SpringRabbitmq {
 @Test
    public void test(){
     while (true){}
 }
}
