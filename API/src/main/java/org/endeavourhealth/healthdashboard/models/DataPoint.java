package org.endeavourhealth.healthdashboard.models;

public class DataPoint {
    private String name;
    private int y;

    public String getName() {
        return name;
    }

    public DataPoint setName(String name) {
        this.name = name;
        return this;
    }

    public int getY() {
        return y;
    }

    public DataPoint setY(int y) {
        this.y = y;
        return this;
    }
}
