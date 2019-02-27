package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.config;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.models.NotlageEventMessage;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class NotlageConsumerConfig extends KafkaConsumerConfig {

    @Bean
    @ConditionalOnMissingBean(name = "notlageConsumerContainerFactory")
    public ConsumerFactory<String, NotlageEventMessage> notlageConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                getConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(NotlageEventMessage.class)
        );
    }

    @Bean(name = "NotlageConsumerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, NotlageEventMessage> notlageConsumerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NotlageEventMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(notlageConsumerFactory());
        return factory;
    }

}