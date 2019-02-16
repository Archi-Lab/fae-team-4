package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.AufenthaltsorteRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;

public class DvpPositionEventProcessor {

    @Autowired
    private AufenthaltsorteRepository repository;

    protected void processEvent(final DvpPositionEvent positionEvent) {
        switch (positionEvent.getType()) {
            case "tracker-tracked":
                repository.save(toAufenthaltsort(positionEvent));
                System.out.println("save");
                break;
            default:
                /* LOG.warn("Unexpected type: '{}' of message with key '{}'", productEvent.getType(),
                        productEvent.getKey()); */
        }
    }

    private Aufenthaltsort toAufenthaltsort(final DvpPositionEvent positionEvent) {
        return new Aufenthaltsort(positionEvent.getPayload().getTimestamp(),
                positionEvent.getPayload().getPosition());
    }
}
