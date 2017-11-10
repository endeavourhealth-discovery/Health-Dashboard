package org.endeavourhealth.healthdashboard.models;

public class Ticker {
    int id;
    String title;
    int refresh;

    public int getId() {
        return id;
    }

    public Ticker setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Ticker setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRefresh() {
        return refresh;
    }

    public Ticker setRefresh(int refresh) {
        this.refresh = refresh;
        return this;
    }
}
