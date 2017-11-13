package org.endeavourhealth.healthdashboard.models;

public class Chart {
    int id;
    String title;
    int refresh;

    public int getId() {
        return id;
    }

    public Chart setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Chart setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRefresh() {
        return refresh;
    }

    public Chart setRefresh(int refresh) {
        this.refresh = refresh;
        return this;
    }
}
