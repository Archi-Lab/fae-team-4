package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.service;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.DvpRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DvpServiceImpl implements DvpService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DvpService.class);

	@Autowired
	DvpRepository dvpRepository;

	/**
	 * Erstellen einer DVP
	 * @param eventDvp zu erstellende DVP
	 */
	@Override
	public void handleDvpCreatedEvent(DVP eventDvp) {
		LOGGER.info("Handle dvp-created Event");
		dvpRepository.save(eventDvp);
	}


	/**
	 * Aktualisieren einer DVP
	 * Die passende DVP wird anhand der UUID aus dem Repository gesucht und ersetzt. Aufenthaltsorte werden übernommen.
	 * Wird keine DVP gefunden, wird diese neu angelegt und eine Warnmeldung hinterlegt.
	 * @param eventDvp Zu aktualisierende DVP
	 */
	@Override
	public void handleDvpUpdatedEvent(DVP eventDvp) {
		LOGGER.info("Handle dvp-updated Event");
		Optional<DVP> optionalDVP = dvpRepository.findById(eventDvp.getId());
		if(optionalDVP.isPresent()){
		    LOGGER.info("Updating DVP {}.", eventDvp.getId());
			DVP updateDVP = optionalDVP.get();
			List<Aufenthaltsort> aufenthaltsorte = updateDVP.getAufenthaltsorte();
			updateDVP = eventDvp;
			updateDVP.setAufenthaltsorte(aufenthaltsorte);
			dvpRepository.save(updateDVP);
		}
		else {
			LOGGER.warn("No DVP with id {} found. Saving new DVP.", eventDvp.getId());
			dvpRepository.save(eventDvp);
		}
	}

	/**
	 * Löschen einer DVP
	 * @param eventDvp zu löschende DVP
	 */
	@Override
	public void handleDvpDeletedEvent(DVP eventDvp) {
		LOGGER.info("Handle dvp-deleted Event");
		dvpRepository.deleteById(eventDvp.getId());
	}
}