package cn.itcast.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName: cn.itcast.config
 * @ClassName: RabbitMqConfig
 * @Author: dongxiyaohui
 * @Date: 2019/12/17 18:06
 * @Description: //TODO
 */
@Configuration
public class RabbitMqConfig {
    //定义交换机名称
    public static final String ITEM_TOPIC_EXCHANGE = "item_topic_exchange";
    //定义队列名称
    public static final String ITEM_QUEUE = "item_queue";
    //定义交换机
    @Bean("itemExchange")
    public Exchange itemExchange(){
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE).durable(true).build();
    }
    //定义队列
    @Bean("itemQueue")
    public Queue itemQueue(){
        return QueueBuilder.durable(ITEM_QUEUE).build();
    }
   //交换机绑定队列
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemExchange")Exchange exchange,@Qualifier("itemQueue")Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("item.#").noargs();
    }
}
