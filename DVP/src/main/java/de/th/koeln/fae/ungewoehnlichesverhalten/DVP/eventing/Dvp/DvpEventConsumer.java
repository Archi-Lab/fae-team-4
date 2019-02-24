package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Dvp;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Dvp.models.DvpEventMessage;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service.DvpService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DvpEventConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DvpEventConsumer.class);

    private final DvpService dvpService;

    public DvpEventConsumer(DvpService dvpService){
        this.dvpService = dvpService;
    }

    @KafkaListener(topics = "${kafka.topics.dvp}", containerFactory = "dvpConsumerContainerFactory")
    public void receive(@Payload DvpEventMessage dvpDaten) {

        DVP dvp;

        switch (dvpDaten.type) {
            case "dvp-created":
                dvp = new DVP(dvpDaten.payload.id, dvpDaten.payload.tracker.id, dvpDaten.payload.bild.pfad);
                dvpService.handleDvpCreatedEvent(dvp);
                break;

            case "dvp-updated":
                dvp = new DVP(dvpDaten.payload.id, dvpDaten.payload.tracker.id, dvpDaten.payload.bild.pfad);
                dvpService.handleDvpUpdatedEvent(dvp);
                break;

            case "dvp-deleted":
                dvp = new DVP(dvpDaten.payload.id, dvpDaten.payload.tracker.id, dvpDaten.payload.bild.pfad);
                dvpService.handleDvpDeletedEvent(dvp);
                break;

            default:
                LOGGER.info("Event-Typ: nicht erkannt");
                break;
        }
    }
}
