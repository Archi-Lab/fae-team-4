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
    private String address;
    private int zipCode;
    private String cityName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

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
