package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DvpPositionEvent {


    private final String id;

    private final String key;

    private final String time;

    private final String type;

    private final Long version;

    private final DvpPositionEventPayload payload;

    public DvpPositionEvent(@JsonProperty("id") final String id, @JsonProperty("key") final String key,
                       @JsonProperty("time") final String time, @JsonProperty("type") final String type,
                       @JsonProperty("payload") final DvpPositionEventPayload payload, @JsonProperty("version") final Long version) {
        this.id = id;
        this.key = key;
        this.time = time;
        this.type = type;
        this.payload = payload;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public Long getVersion() {
        return version;
    }

    public DvpPositionEventPayload getPayload() {
        return payload;
    }
}
