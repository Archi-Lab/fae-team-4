package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Embeddable
class DVPerson {

    private long dpId;

    private byte[] bild;

    @Embedded
    private Position position;


    byte[] getBild() {
        return bild;
    }

    void setBild(byte[] image) { this.bild = image; }

    Position getPosition() {
        return position;
    }

    void setPosition(Position position) {
        this.position = position;
    }

    long getId() {
        return dpId;
    }

    void setId(long id) {
        this.dpId = id;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
