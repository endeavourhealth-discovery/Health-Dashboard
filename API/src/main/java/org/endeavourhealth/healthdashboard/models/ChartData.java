package org.endeavourhealth.healthdashboard.models;

import java.util.ArrayList;
import java.util.List;

public class ChartData {
    private List<String> xAxis = new ArrayList<>();
    private List<ChartDataSeries> series = new ArrayList<>();

    public List<String> getxAxis() {
        return xAxis;
    }

    public ChartData setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public List<ChartDataSeries> getSeries() {
        return series;
    }

    public ChartData setSeries(List<ChartDataSeries> series) {
        this.series = series;
        return this;
    }
}
