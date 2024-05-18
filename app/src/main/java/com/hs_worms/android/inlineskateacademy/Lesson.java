package com.hs_worms.android.inlineskateacademy;

public class Lesson {

    final String title;
    final String description;
    final int image;
    final int backgroundColor;
    final String webLink;

    public Lesson(String title, String description, int image, int backgroundColor, String webLink) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.backgroundColor = backgroundColor;
        this.webLink = webLink;
    }

    public String getTitle() {
        return title;
    }

    public String getWebLink() {
        return webLink;
    }
}