package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service.TrackerService;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackerServiceImpl implements TrackerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerService.class);

	@Override
	public void handleTrackerTrackedEvent(UUID trackerId, Aufenthaltsort aufenthaltsort) {
		LOGGER.info("Tracker Event erhalten {}", trackerId);

		// TODO

	}
}