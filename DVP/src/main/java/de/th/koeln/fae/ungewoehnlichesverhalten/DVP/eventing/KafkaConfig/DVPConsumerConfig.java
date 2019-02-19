package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.KafkaConfig;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Dvp.models.DvpEventMessage;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker.models.TrackerTrackedEventMessage;
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
public class DVPConsumerConfig extends KafkaConsumerConfig {

    @Bean
    @ConditionalOnMissingBean(name = "dvpConsumerContainerFactory")
    public ConsumerFactory<String, DvpEventMessage> dvpConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                getConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(DvpEventMessage.class)
        );
    }

    @Bean(name = "dvpConsumerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, DvpEventMessage> dvpConsumerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, DvpEventMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(dvpConsumerFactory());
        return factory;
    }

}