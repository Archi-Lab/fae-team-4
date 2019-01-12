package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class DvpPositionEventConsumer {

    private final DvpPositionEventProcessor dvpPositionEventProcessor;
    private final EventParser eventParser;
    private final Class<DvpPositionEvent> eventType;

    @Inject
    protected DvpPositionEventConsumer(final DvpPositionEventProcessor _dvpPositionEventProcessor, final EventParser _eventParser, final Class<DvpPositionEvent> _eventType) {

        this.dvpPositionEventProcessor = _dvpPositionEventProcessor;
        this.eventParser = _eventParser;
        this.eventType = _eventType;
    }


    @KafkaListener(topics = "tracker")
    public void listen(ConsumerRecord<String, String> consumerRecord) throws Exception {

        System.out.println("xfgdf");
        DvpPositionEvent event = eventParser.parseMessage(consumerRecord.value(), eventType);
        dvpPositionEventProcessor.processEvent(event);

        System.out.println(consumerRecord.toString());
    }


}
