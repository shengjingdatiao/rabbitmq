package cn.itcast.produce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @PackageName: cn.itcast.produce
 * @ClassName: ProduceDemo
 * @Author: dongxiyaohui
 * @Date: 2019/12/17 18:28
 * @Description: //TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduceDemo {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void test() {
        rabbitTemplate.convertAndSend("item_topic_exchange", "item.query", "商品查询，路由key为item.query");
        rabbitTemplate.convertAndSend("item_topic_exchange", "item.update", "商品更新，路由key为item.update");
        rabbitTemplate.convertAndSend("item_topic_exchange", "item.delete", "商品删除，路由key为item.delete");
    }
}
