package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.exception;


import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.EventProcessingState;

public class TemporaryMessageProcessingException extends MessageProcessingException {

    private static final long serialVersionUID = 1L;

    public TemporaryMessageProcessingException(final String message) {
        super(EventProcessingState.TEMPORARY_ERROR, message);
    }

    public TemporaryMessageProcessingException(final String message, final Exception e) {
        super(EventProcessingState.TEMPORARY_ERROR, message, e);
    }
}
