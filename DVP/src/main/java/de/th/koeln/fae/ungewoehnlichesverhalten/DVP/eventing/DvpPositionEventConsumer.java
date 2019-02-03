package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class DvpPositionEventConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DvpPositionEvent.class);

    private final DvpPositionEventProcessor dvpPositionEventProcessor;
    private final EventParser eventParser;

    @Autowired
    protected DvpPositionEventConsumer(final DvpPositionEventProcessor _dvpPositionEventProcessor, final EventParser _eventParser) {

        this.dvpPositionEventProcessor = _dvpPositionEventProcessor;
        this.eventParser = _eventParser;
    }


    @KafkaListener(topics = "tracker")
    public void listen(ConsumerRecord<String, String> consumerRecord) throws Exception {
        LOGGER.info("LISTEN: Received Kafka DVP Event: {}", consumerRecord.toString());
        DvpPositionEvent event = eventParser.parseMessage(consumerRecord.value());
        dvpPositionEventProcessor.processEvent(event);
    }
}
