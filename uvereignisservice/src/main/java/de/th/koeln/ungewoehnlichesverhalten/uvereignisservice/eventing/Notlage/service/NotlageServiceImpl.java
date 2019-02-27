package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.service;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.models.NotlagePayload;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotlageServiceImpl implements NotlageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotlageService.class);


    @Override
    public void handleNotlageCreatedEvent(NotlagePayload notlagePayload) {
        LOGGER.info("Handle handleNotlageCreatedEvent");

        // TODO
    }

    @Override
    public void handleNotlageGeloestEvent(NotlagePayload notlagePayload) {
        LOGGER.info("Handle handleNotlageGeloestEvent");

        // TODO
    }

    @Override
    public void handleNotlageInBearbeitungEvent(NotlagePayload notlagePayload) {
        LOGGER.info("Handle handleNotlageInBearbeitungEvent");

        // TODO
    }
}
