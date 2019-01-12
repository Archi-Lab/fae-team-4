package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Objects;

public class EventParser {

    private final ObjectMapper objectMapper;

    @Inject
    public EventParser(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected DvpPositionEvent parseMessage(final String message, final Class<DvpPositionEvent> messageType){

        try {
            System.out.println("parse");
            final DvpPositionEvent kafkaMessage = objectMapper.readValue(message, messageType);
            return kafkaMessage;
        }
        catch(Exception e){
            return null;
            // todo Log
        }

    }
}
