package de.th.koeln.fae.unusualbehavior.unusualbehavior.UBEvent.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UBEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private DementedPerson dp;

    private Date timestamp;

    // In eigene Klasse auslagern?
    private byte[] message;

    // In eigene Klasse auslagern?
    private String answer;

    // private MAS mas;


    public long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public DementedPerson getDp() {
        return dp;
    }

    public void setDvp(DementedPerson dp) {
        this.dp = dp;
    }
}
