package de.th.koeln.fae.ungewoehnlichesverhalten.DVP;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class DvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvpApplication.class, args);
	}

	@KafkaListener(topics = "tracker")
	public void listen(ConsumerRecord<?, ?> consumerRecord) throws Exception {
		System.out.println(consumerRecord.toString());
	}
}
