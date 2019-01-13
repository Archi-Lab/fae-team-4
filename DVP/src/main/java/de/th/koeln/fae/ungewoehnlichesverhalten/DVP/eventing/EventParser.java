package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Objects;

public class EventParser {

    private final ObjectMapper objectMapper;

    @Autowired
    public EventParser(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected DvpPositionEvent parseMessage(final String message){

        try {
            System.out.println("parse");
            final DvpPositionEvent kafkaMessage = objectMapper.readValue(message, DvpPositionEvent.class);
            return kafkaMessage;
        }
        catch(Exception e){
            System.out.println("parsing Error:" + e.getMessage());
            return null;
            // todo Log
        }

    }
}
