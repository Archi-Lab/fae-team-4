package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class DvpPositionEventConsumer {

    private final DvpPositionEventProcessor dvpPositionEventProcessor;
    private final EventParser eventParser;

    @Autowired
    protected DvpPositionEventConsumer(final DvpPositionEventProcessor _dvpPositionEventProcessor, final EventParser _eventParser) {

        this.dvpPositionEventProcessor = _dvpPositionEventProcessor;
        this.eventParser = _eventParser;
    }


    @KafkaListener(topics = "tracker")
    public void listen(ConsumerRecord<String, String> consumerRecord) throws Exception {

        System.out.println(consumerRecord.toString());
        System.out.println("listen");
        DvpPositionEvent event = eventParser.parseMessage(consumerRecord.value());
        dvpPositionEventProcessor.processEvent(event);
    }


}
