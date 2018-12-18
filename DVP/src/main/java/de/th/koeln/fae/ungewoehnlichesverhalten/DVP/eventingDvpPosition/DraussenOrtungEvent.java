package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventingDvpPosition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.DomainEvent;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class DraussenOrtungEvent extends DomainEvent<DraussenOrtungPayload> {

    private final String aggregateName;

    public DraussenOrtungEvent(@JsonProperty("id") final String id, @JsonProperty("key") final String key,
                               @JsonProperty("time") final String time, @JsonProperty("type") final String type,
                               @JsonProperty("payload") final DraussenOrtungPayload payload, @JsonProperty("version") final Long version,
                               @JsonProperty("aggregateName") final String aggregateName) {

        super(id, key, time, type, payload, version);
        this.aggregateName = aggregateName;
    }
}
