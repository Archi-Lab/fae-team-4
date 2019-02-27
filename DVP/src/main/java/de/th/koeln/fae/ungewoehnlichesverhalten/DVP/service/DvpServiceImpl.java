package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DvpServiceImpl implements DvpService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DvpService.class);

	@Override
	public void handleDvpCreatedEvent(DVP dvp) {
		LOGGER.info("Handle Dvp-created Event");

		// TODO

	}


	@Override
	public void handleDvpUpdatedEvent(DVP dvp) {
		LOGGER.info("Handle Dvp-updated Event");

		// TODO

	}

	@Override
	public void handleDvpDeletedEvent(DVP dvp) {
		LOGGER.info("Handle Dvp-deleted Event");

		// TODO

	}
}