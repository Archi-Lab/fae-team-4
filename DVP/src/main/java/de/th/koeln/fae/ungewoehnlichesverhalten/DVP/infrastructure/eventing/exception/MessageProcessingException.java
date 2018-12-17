package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.exception;


import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.EventProcessingState;

public class MessageProcessingException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private final EventProcessingState state;

    public MessageProcessingException(final EventProcessingState state, final String message,
                                      final Exception e) {
        super(message, e);
        this.state = state;
    }

    public MessageProcessingException(final EventProcessingState state, final String message) {
        super(message);
        this.state = state;
    }

    public EventProcessingState getState() {
        return state;
    }
}
