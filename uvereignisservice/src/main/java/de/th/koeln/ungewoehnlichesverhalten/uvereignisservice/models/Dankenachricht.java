package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import javax.persistence.Embeddable;

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
