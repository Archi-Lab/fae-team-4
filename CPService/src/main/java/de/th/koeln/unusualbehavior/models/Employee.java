package de.th.koeln.unusualbehavior.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class Employee {

    @ManyToOne
    @JoinColumn(name="contactpoint_id", nullable=false)
    private ContactPoint contactPoint;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String surname;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }



}
