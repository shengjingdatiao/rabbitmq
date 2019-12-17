package cn.itcast.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @PackageName: cn.itcast.consumer
 * @ClassName: Consumer
 * @Author: dongxiyaohui
 * @Date: 2019/12/17 21:24
 * @Description: //TODO
 */
@Component
public class Consumer {
    @RabbitListener(queues = "item_queue")
    public void topicConsumer(Message message){
        String mes = null;
        try {
            mes = new String(message.getBody(), "UTF-8");
            System.out.println(mes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
