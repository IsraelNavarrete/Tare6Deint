package com.example.tarea6deint.data.model;

import android.media.Image;

public class Forum {
    private String user;
    private String title;
    private String content;
    private Image image;

    public Forum(String user, String title, String content, Image image) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forum forum = (Forum) o;

        if (!user.equals(forum.user)) return false;
        return title.equals(forum.title);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    public Forum() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
