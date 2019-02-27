package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;

public interface DvpService {
	void handleDvpCreatedEvent(DVP dvp);
	void handleDvpUpdatedEvent(DVP dvp);
	void handleDvpDeletedEvent(DVP dvp);
}