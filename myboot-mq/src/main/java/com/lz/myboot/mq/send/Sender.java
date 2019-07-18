package com.lz.myboot.mq.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lz.myboot.mq.config2.MsgProducer;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(value = 1)
@Slf4j
public class Sender implements ApplicationRunner {
	
	@Autowired
	private MsgProducer msgProducer;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		int count = 0;
		while(true) {
			count++;
			Thread.sleep(1000);
			msgProducer.sendMsg("发送第 " + count + " 条消息..." );
			log.info("=========== 项目启动后，初始化 Redis =============");
		}
		
	}

}
