package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker.models.TrackerTrackedEventMessage;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Position;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service.TrackerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class TrackerTrackedEventConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerTrackedEventConsumer.class);

    private final TrackerService trackerService;

    @KafkaListener(topics = "${kafka.topics.tracker}", containerFactory = "trackerConsumerContainerFactory")
    public void receive(@Payload TrackerTrackedEventMessage trackerDaten) {

        switch (trackerDaten.type) {
            case "tracker-tracked":

                LOGGER.info("Event-Typ: tracker-tracked");
                Aufenthaltsort aufenthaltsort = new Aufenthaltsort();

                aufenthaltsort.setTimestamp(ZonedDateTime.parse(trackerDaten.time).toInstant());
                aufenthaltsort.setPosition(
                        new Position(
                                trackerDaten.payload.currentPosition.latitude,
                                trackerDaten.payload.currentPosition.longitude
                        )
                );
                trackerService.handleTrackerTrackedEvent(trackerDaten.payload.trackerId, aufenthaltsort);
                break;

            default:
                LOGGER.info("Event-Typ: nicht erkannt");
                break;
        }
    }
}
