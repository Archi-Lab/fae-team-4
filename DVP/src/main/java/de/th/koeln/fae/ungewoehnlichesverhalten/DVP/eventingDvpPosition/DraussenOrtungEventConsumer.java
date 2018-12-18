package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventingDvpPosition;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.AbstractKafkaConsumer;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.unprocessable.UnprocessableEventService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;
import com.google.common.collect.ImmutableSet;

import javax.inject.Inject;

@Component
public class DraussenOrtungEventConsumer extends AbstractKafkaConsumer {

    @Inject
    protected DraussenOrtungEventConsumer(DraussenOrtungEventProcessor messageProcessor, UnprocessableEventService unprocessableEventService) {
        super(messageProcessor, unprocessableEventService, ImmutableSet.of(UncategorizedDataAccessException.class, TransientDataAccessException.class, CannotCreateTransactionException.class));
    }

    @KafkaListener(topics = "${eventing.topic_name}")
    public void listen(final ConsumerRecord<String, String> consumerRecord, final Acknowledgment ack) {
        super.handleConsumerRecord(consumerRecord, ack);
    }
}
