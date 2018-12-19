package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.services;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.events.DvpUveEvent;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.internal.KafkaGateway;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.DvpUve;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.Status;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.UVEreignis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DvpUvePublisher {

    private static final Logger log = LoggerFactory.getLogger(DvpUvePublisher.class);
    private final KafkaGateway eventPublisher;


    @Autowired
    public DvpUvePublisher(final KafkaGateway eventPublisher)
    {
        this.eventPublisher = eventPublisher;
    }

    public void sendeUVEreignis(UVEreignis uvEreignis) {
        for (DvpUve dvpUve : uvEreignis.getDvpuves()) {
            publishDVPUVEEvent(dvpUve);
            dvpUve.setStatus(Status.ABGESCHICKT);
        }
        uvEreignis.berechneStatus();
    }

    private void publishDVPUVEEvent(DvpUve dvpUve)
    {
        DvpUveEvent dvpUveEvent = new DvpUveEvent(dvpUve);
        try {
            SendResult<String, String> sendResult = eventPublisher.publish(dvpUveEvent)
                    .get(1, TimeUnit.SECONDS);

            log.info(sendResult.toString());
        } catch (final Exception ex) {
            log.info("An " + ex.getClass() + "occured!");
        }
    }

}
