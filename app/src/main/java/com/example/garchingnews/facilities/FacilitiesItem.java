package com.example.garchingnews.facilities;

public class FacilitiesItem {

    String name;
    String openingHours;
    String webLink;
    String phoneNumber;
    String address;

    int imgID;

    public FacilitiesItem(String name, String openingHours, String webLink, String phoneNumber, String address, int imgID) {
        this.name = name;
        this.openingHours = openingHours;
        this.webLink = webLink;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getWebLink() {
        return webLink;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getImgID() {
        return imgID;
    }
}
