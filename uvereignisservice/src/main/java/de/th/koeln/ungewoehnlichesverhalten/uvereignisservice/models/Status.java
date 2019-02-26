package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

public enum Status {
    /** UVE und DvpUve erstellt.
     * Abgeschickt, wenn MAS auf senden drückt und DvpUves valide sind.
     * Behoben, wenn BP informiert wurde bzw. wenn alle DvpUves eines UVEs status == behoben haben. **/
    ERSTELLT, ABGESCHICKT, BEHOBEN;
    //evtl hier noch "teilweise behoben" oder so, wenn nur ein Teil der DVP-UVEs behoben sind?
}
