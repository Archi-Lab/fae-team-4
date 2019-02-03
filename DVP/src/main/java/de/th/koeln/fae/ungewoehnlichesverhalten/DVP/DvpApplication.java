package de.th.koeln.fae.ungewoehnlichesverhalten.DVP;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.DvpPositionEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class DvpApplication {

	public static void main(String[] args) {

        System.setProperty("spring.profiles.default", "prod");
		SpringApplication.run(DvpApplication.class, args);

	}

}
