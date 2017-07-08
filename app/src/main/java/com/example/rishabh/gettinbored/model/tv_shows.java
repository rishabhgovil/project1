package com.example.rishabh.gettinbored.model;

/**
 * Created by RISHABH on 07-07-2017.
 */

public class tv_shows {
    Integer id;
    String name;
    String permalink;
    String country;
    String network;
    String status;
    String image_thumbnail_path;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getCountry() {
        return country;
    }

    public String getNetwork() {
        return network;
    }

    public String getStatus() {
        return status;
    }

    public String getImage_thumbnail_path() {
        return image_thumbnail_path;
    }

    public tv_shows(Integer id, String name, String permalink, String country, String network, String status, String image_thumbnail_path) {

        this.id = id;
        this.name = name;
        this.permalink = permalink;
        this.country = country;
        this.network = network;
        this.status = status;
        this.image_thumbnail_path = image_thumbnail_path;
    }
}
