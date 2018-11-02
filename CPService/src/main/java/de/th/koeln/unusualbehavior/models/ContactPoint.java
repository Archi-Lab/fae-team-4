package de.th.koeln.unusualbehavior.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
public class ContactPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Embedded
    private Position position;

    @OneToMany(mappedBy="contactPoint")
    private List<Employer> employer;


    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    Position getPosition() {
        return position;
    }

    void setPosition(Position position) {
        this.position = position;
    }

    List<Employer> getEmployer() {
        return employer;
    }

    void setEmployer(List<Employer> employer) {
        this.employer = employer;
    }
}
