package de.th.koeln.unusualbehavior.models;

class Address {

    private String mStreet;
    private String mNumber;

    Address(String street, String number){
        mNumber = number;
        mStreet = street;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String mStreet) {
        this.mStreet = mStreet;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String mNumber) {
        this.mNumber = mNumber;
    }
}
