package org.endeavourhealth.healthdashboard.models;

import java.util.ArrayList;
import java.util.List;

public class TickerData {
    private List<String> xAxis = new ArrayList<>();
    private List<TickerDataSeries> series = new ArrayList<>();

    public List<String> getxAxis() {
        return xAxis;
    }

    public TickerData setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public List<TickerDataSeries> getSeries() {
        return series;
    }

    public TickerData setSeries(List<TickerDataSeries> series) {
        this.series = series;
        return this;
    }
}
