package org.endeavourhealth.healthdashboard.models;

import java.util.ArrayList;
import java.util.List;

public class ChartDataSeries {
    private String name;
    private String type;
    private List<DataPoint> data = new ArrayList<>();

    public String getName() {
        return name;
    }

    public ChartDataSeries setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public ChartDataSeries setType(String type) {
        this.type = type;
        return this;
    }

    public List<DataPoint> getData() {
        return data;
    }

    public ChartDataSeries setData(List<DataPoint> data) {
        this.data = data;
        return this;
    }
}
