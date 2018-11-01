package de.th.koeln.fae.unusualbehavior.unusualbehavior.UBEvent.models;

import javax.persistence.*;

@Embeddable
public class DementedPerson {

    private long dpid;

    private byte[] image;

    @Embedded
    private Position position;


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) { this.image = image; }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getDpid() {
        return dpid;
    }

    public void setDpid(long dvpid) {
        this.dpid = dvpid;
    }
}
