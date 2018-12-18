package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.internal;

public interface EventSource {
    
    String getId();
    Long getVersion();
    String getAggregateName();

}
