package com.fullcreamlowfat.wireless_shory;

/**
 * Created by user on 9/8/2016.
 */
public class tenantItem {

    private int _ID;
    private String shopName;
    private String category;
    private String website;
    private String phoneNo;
    private String floor;
    private String about;

    public tenantItem(String shopName, String category, String phoneNo, String website, String floor, String about) {
        this.shopName = shopName;
        this.category = category;
        this.phoneNo = phoneNo;
        this.website = website;
        this.floor = floor;
        this.about = about;
    }

    public String getShopName() {
        return shopName;
    }

    public String getAbout() {
        return about;
    }

    public String getFloor() {
        return floor;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getWebsite() {
        return website;
    }

    public String getCategory() {
        return category;
    }
}
