package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage;


import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.models.NotlageEventMessage;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.service.NotlageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NotlageEventConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotlageEventConsumer.class);

    private final NotlageService notlageService;

    public NotlageEventConsumer(NotlageService notlageService){
        this.notlageService = notlageService;
    }

    @KafkaListener(topics = "${topics.notlage}", containerFactory = "dvpConsumerContainerFactory")
    public void receive(@Payload NotlageEventMessage notlageEventMessage) {

        switch (notlageEventMessage.payload.status) {
            case "ERSTELLT":
                notlageService.handleNotlageCreatedEvent(notlageEventMessage.payload);
                break;

            case "IN_BEAREITUNG":
                notlageService.handleNotlageInBearbeitungEvent(notlageEventMessage.payload);
                break;

            case "BEHOBEN":
                notlageService.handleNotlageGeloestEvent(notlageEventMessage.payload);
                break;

            default:
                LOGGER.info("Status " + notlageEventMessage.payload.status + " nicht erkannt");
                break;
        }
    }
}
