package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import java.util.UUID;

public interface TrackerService {
	void handleTrackerTrackedEvent(UUID trackerId, Aufenthaltsort aufenthaltsort);
}