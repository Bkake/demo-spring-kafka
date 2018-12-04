package com.bkake.demospringkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoSpringKafkaApplication implements CommandLineRunner {

	public static Logger logger = LoggerFactory.getLogger(DemoSpringKafkaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringKafkaApplication.class, args);
	}


	@Autowired
	KafkaTemplate<String, String> template;

	private final CountDownLatch latch = new CountDownLatch(3);

	@Override
	public void run(String... args) throws Exception {
		this.template.send("demo", "foo1");
		this.template.send("demo", "foo2");
		this.template.send("demo", "foo3");
		this.template.send("demo", "foo4");
		latch.await(60, TimeUnit.SECONDS);
	}

	@KafkaListener(topics = "demo", groupId = "demogroup")
	public void listen(ConsumerRecord<?,?> consumerRecord) throws Exception{
		logger.info("Received Messasge in group demogroup: "+ consumerRecord.toString());
		latch.countDown();
	}
}