package com.example.test.message;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RedisMessageListener implements MessageListener {
	@Override
	//onmessage 是得到消息之后的处理
	public void onMessage(Message message, byte[] pattern) {
		String mess = message.getBody().toString();
		System.out.println(mess+"渠道"+pattern.toString());
	}
}
