package com.example.tarea6deint.data.model;

import android.media.Image;

public class Podcasts {
    private String title;
    private String duration;
    private Image image;

    public Podcasts() {
    }

    public Podcasts(String title, String duration, Image image) {
        this.title = title;
        this.duration = duration;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Podcasts podcasts = (Podcasts) o;

        return title.equals(podcasts.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
