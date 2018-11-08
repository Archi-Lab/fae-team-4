package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import javax.persistence.Embeddable;

@Embeddable
public class Dankenachricht {

    private String nachricht;

    Dankenachricht(){ }

    Dankenachricht(String nachricht){
        this.nachricht = nachricht;
    }

    String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }
}
