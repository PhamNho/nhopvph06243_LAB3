package com.nho_pc.nhopvph06243_lab3.model;

public class MyBookmark {
    public String title;
    public String url;

    public MyBookmark(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public MyBookmark() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
