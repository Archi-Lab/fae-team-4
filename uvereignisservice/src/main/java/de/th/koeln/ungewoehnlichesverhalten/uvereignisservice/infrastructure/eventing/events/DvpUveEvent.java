package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.internal.DomainEvent;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.DvpUve;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class DvpUveEvent implements DomainEvent {

    public DvpUveEvent(DvpUve dvpUve)
    {
        this.id = UUID.randomUUID();
        this.dvpUve = dvpUve;
        this.instant = Instant.now();
    }

    final UUID id;
    final DvpUve dvpUve;
    final Instant instant;

    public String getId() {
        return id.toString();
    }

    public String getKey() {
        return dvpUve.getId();
    }

    //The tracker Entity doesn't implement any versioning patterns (yet), therefore event versions are always 0
    public Long getVersion() {
        return 0L;
    }

    public ZonedDateTime getTime() {
        return instant.atZone(ZoneId.systemDefault());
    }

    public byte[] getPayload(ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(dvpUve);
    }

    public Class<?> getEntityType() {
        return dvpUve.getClass();
    }

    public String getType()
    {
        return "dvpuve";
    }
}
