package com.chawki.filter;

/**
 * Created by Muhammad Fahad on 7/19/2017.
 */

public class Model {
    int image;
    String Title;
    String location;
    String rating;
    String likes;
    String distance;

    public Model(int image, String title, String location, String rating, String likes, String distance) {
        this.image = image;
        Title = title;
        this.location = location;
        this.rating = rating;
        this.likes = likes;
        this.distance = distance;
    }
}
