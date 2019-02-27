package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.service;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.models.NotlagePayload;

public interface NotlageService {
    void handleNotlageCreatedEvent(NotlagePayload notlagePayload);
    void handleNotlageGeloestEvent(NotlagePayload notlagePayload);
    void handleNotlageInBearbeitungEvent(NotlagePayload notlagePayload);
}
