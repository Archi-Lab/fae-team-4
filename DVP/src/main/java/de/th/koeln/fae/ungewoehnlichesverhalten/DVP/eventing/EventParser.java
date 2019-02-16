package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EventParser {

    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventParser.class);

    @Autowired
    public EventParser(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected DvpPositionEvent parseMessage(final String message){

        try {
            LOGGER.info("Parsing received event.");
            final DvpPositionEvent kafkaMessage = objectMapper.readValue(message, DvpPositionEvent.class);
            return kafkaMessage;
        }
        catch(Exception e){
            LOGGER.error("Error when parsing event: {}", e.getMessage());
            return null;
        }

    }
}
