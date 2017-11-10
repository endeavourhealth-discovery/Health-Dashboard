package org.endeavourhealth.healthdashboard.models;

import java.util.ArrayList;
import java.util.List;

public class TickerDataSeries {
    private String name;
    private String type;
    private List<Integer> data = new ArrayList<>();

    public String getName() {
        return name;
    }

    public TickerDataSeries setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public TickerDataSeries setType(String type) {
        this.type = type;
        return this;
    }

    public List<Integer> getData() {
        return data;
    }

    public TickerDataSeries setData(List<Integer> data) {
        this.data = data;
        return this;
    }
}
