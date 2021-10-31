package cn.lw.controller;

import cn.lw.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author linwei
 * @Date 2021/10/31 16:48
 * @Description TODO
 */
@RestController
public class SendMessageController {
    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();

    }
}