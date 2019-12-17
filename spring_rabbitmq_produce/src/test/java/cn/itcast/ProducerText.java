package cn.itcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @PackageName: cn.itcast
 * @ClassName: ProducerText
 * @Author: dongxiyaohui
 * @Date: 2019/12/16 18:39
 * @Description: //TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:spring-rabbitmq-producer.xml")
public class ProducerText {
   @Autowired
   private RabbitTemplate rabbitTemplate;
    @Test
    public void direct(){
        rabbitTemplate.convertAndSend("spring_queue","默认交换机类型dircet");
    }
    @Test
    public void fanout(){
        rabbitTemplate.convertAndSend("spring_fanout_exchange","","fanout交换机类型");
    }
    @Test
    public void topic(){
        rabbitTemplate.convertAndSend("spring_topic_exchange","heima.itcast","topic交换机类型");
        rabbitTemplate.convertAndSend("spring_topic_exchange","heima.itcast.1","topic交换机类型heima.itcast.1");
        rabbitTemplate.convertAndSend("spring_topic_exchange","itcast.heima","topic交换机类型itcast.heima");
    }
}
