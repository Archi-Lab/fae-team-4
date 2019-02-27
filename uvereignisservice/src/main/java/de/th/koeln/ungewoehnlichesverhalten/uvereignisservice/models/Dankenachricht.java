package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import javax.persistence.Embeddable;

/**
 * Klasse für die Dankenachricht an MAS
 * Wird aktuell nicht verwendet, könnte aber genutzt werden, um hier die generische Dankenachricht zu formulieren
 */
@Embeddable
public class Dankenachricht {

    private String nachricht;

    Dankenachricht(){ }

    public Dankenachricht(String nachricht){
        this.nachricht = nachricht;
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }
}
