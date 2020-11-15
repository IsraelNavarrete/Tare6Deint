package com.example.tarea6deint.data.model;

import android.media.Image;

public class News {
    private String title;
    private String description;
    private Image image;

    public News(String title, String description, Image image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        return title.equals(news.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
