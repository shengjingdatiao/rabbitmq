package com.itheima.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * @PackageName: com.itheima.rabbitmq.listener
 * @ClassName: FanoutListener1
 * @Author: dongxiyaohui
 * @Date: 2019/12/16 20:21
 * @Description: //TODO
 */
public class FanoutListener1 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String msg = new String(message.getBody(), "UTF-8");
            System.out.println(msg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
