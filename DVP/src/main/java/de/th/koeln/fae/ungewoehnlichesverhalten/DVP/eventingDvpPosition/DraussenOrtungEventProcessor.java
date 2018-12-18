package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventingDvpPosition;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.AbstractDomainEventProcessor;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.EventParser;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.EventProcessingState;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.configuration.ConsumerTopicConfig;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.processed.ProcessedEventService;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.CustomDvpRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.DvpRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DraussenOrtungEventProcessor extends AbstractDomainEventProcessor<DraussenOrtungPayload, DraussenOrtungEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDomainEventProcessor.class);

    private final CustomDvpRepository repository;;

    @Inject
    public DraussenOrtungEventProcessor(final ConsumerTopicConfig draussenOrtungTopicConfig, final EventParser eventParser, final ProcessedEventService processedEventService, final CustomDvpRepository repository) {
        super(DraussenOrtungEvent.class, draussenOrtungTopicConfig, eventParser, processedEventService);
        this.repository = repository;
    }

    @Override
    protected EventProcessingState processEvent(final DraussenOrtungEvent draussenOrtungEventEvent) {
        switch (draussenOrtungEventEvent.getType()) {
            case "tracker-created":
            case "tracker-tracked":
                repository.saveAufenthaltsort(toAufenthaltsort(draussenOrtungEventEvent));
                break;
            default:
                LOG.warn("Unexpected type: '{}' of message with key '{}'", draussenOrtungEventEvent.getType(),
                        draussenOrtungEventEvent.getKey());
                return EventProcessingState.UNEXPECTED_ERROR;
        }
        return EventProcessingState.SUCCESS;
    }


    private Aufenthaltsort toAufenthaltsort(final DraussenOrtungEvent draussenOrtungEvent) {
        final Aufenthaltsort aufenthaltsort = new Aufenthaltsort();

        try {
            aufenthaltsort.setTimestamp(new SimpleDateFormat().parse(draussenOrtungEvent.getPayload().getTimestamp()));
        }
        catch (ParseException e){
            LOG.warn("Parse-Error: Timestamp eines DraußenOrtung-Events konnte nicht in Date umgewandelt werden. EventKey: " + draussenOrtungEvent.getKey());

            aufenthaltsort.setTimestamp(new Date(System.currentTimeMillis()));
        }

        final Position position = new Position();
        position.setLatitude( Double.parseDouble(draussenOrtungEvent.getPayload().getLatitude()));
        position.setLongitude( Double.parseDouble(draussenOrtungEvent.getPayload().getLongitude()));
        aufenthaltsort.setPosition(position);

        return aufenthaltsort;
    }
}
