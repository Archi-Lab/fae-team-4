package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.KafkaConfig;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker.models.TrackerTrackedEventMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;


@Configuration
@EnableKafka
public class TrackerConsumerConfig extends KafkaConsumerConfig {

    @Bean
    @ConditionalOnMissingBean(name = "trackerConsumerContainerFactory")
    public ConsumerFactory<String, TrackerTrackedEventMessage> trackerConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                getConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(TrackerTrackedEventMessage.class)
        );
    }

    @Bean(name = "trackerConsumerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, TrackerTrackedEventMessage> trackerListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TrackerTrackedEventMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(trackerConsumerFactory());
        return factory;
    }

}