package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.AufenthaltsorteRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service.TrackerService;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackerServiceImpl implements TrackerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerService.class);

	@Autowired
    AufenthaltsorteRepository aufenthaltsorteRepository;

	@Override
	public void handleTrackerTrackedEvent(UUID trackerId, Aufenthaltsort aufenthaltsort) {
		LOGGER.info("Service: Tracker Event speichern: {}, {}", trackerId, aufenthaltsort.getPosition().getLongitude());
		aufenthaltsorteRepository.save(aufenthaltsort);
	}
}