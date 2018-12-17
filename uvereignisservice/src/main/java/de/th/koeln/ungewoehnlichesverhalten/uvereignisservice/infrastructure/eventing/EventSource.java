package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing;

public interface EventSource {
    
    String getId();
    Long getVersion();
    String getAggregateName();

}
