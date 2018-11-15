package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Embeddable
public class DVPerson {

    private long dpId;

    private byte[] bild;

    @Embedded
    private Position position;


    public byte[] getBild() {
        return bild;
    }

    public void setBild(byte[] image) { this.bild = image; }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getId() {
        return dpId;
    }

    public void setId(long id) {
        this.dpId = id;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
