package cn.lw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author linwei
 * @Date 2021/10/31 18:05
 * @Description TODO
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverport;

    @StreamListener(Sink.INPUT)
    public void input(Message<String>message){
        System.out.println("消息消费者1号***接收到的消息"+message.getPayload()+"\t port:"+serverport);
    }
}