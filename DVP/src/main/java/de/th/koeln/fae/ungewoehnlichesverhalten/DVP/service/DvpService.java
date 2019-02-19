package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;

import java.util.UUID;

public interface DvpService {
	void handleDvpCreatedEvent(DVP dvp);
	void handleDvpUpdatedEvent(DVP dvp);
	void handleDvpDeletedEvent(DVP dvp);
}