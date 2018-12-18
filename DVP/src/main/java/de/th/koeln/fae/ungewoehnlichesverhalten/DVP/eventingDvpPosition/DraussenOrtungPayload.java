package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventingDvpPosition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.EventPayload;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class DraussenOrtungPayload extends EventPayload {

    private String latitude;
    private String longitude;

    @NotNull
    private String timestamp;
}
