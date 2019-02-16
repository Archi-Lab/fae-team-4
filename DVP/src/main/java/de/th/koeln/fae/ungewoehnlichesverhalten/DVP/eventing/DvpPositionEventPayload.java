package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Position;

import javax.validation.constraints.NotNull;
import java.security.Timestamp;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DvpPositionEventPayload {

    @NotNull
    private Long version;
    private Date timestamp;
    private Position position;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
