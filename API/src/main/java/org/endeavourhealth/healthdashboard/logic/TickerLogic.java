package org.endeavourhealth.healthdashboard.logic;

import org.endeavourhealth.healthdashboard.models.Ticker;
import org.endeavourhealth.healthdashboard.models.TickerData;
import org.endeavourhealth.healthdashboard.models.TickerDataSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TickerLogic {
    public List<Ticker> getTickers() {
        List<Ticker> result = new ArrayList<>();

        result.add(new Ticker()
            .setId(1)
            .setTitle("A&E Attendance - Homerton")
            .setRefresh(5)
        );

        result.add(new Ticker()
            .setId(2)
            .setTitle("A&E Attendance - Barts")
            .setRefresh(10)
        );

        result.add(new Ticker()
            .setId(3)
            .setTitle("A&E Attendance - Royal London")
            .setRefresh(15)
        );

        return result;
    }

    public TickerData getTickerData(int tickerId) {
        return new TickerData()
            .setxAxis(Arrays.asList("2010", "2011", "2012", "2013", "2014"))
            .setSeries(Arrays.asList(
                new TickerDataSeries()
                    .setChartType("line")
                    .setName("Legend 1")
                    .setData(Arrays.asList(1, 2, 3, 4, 5)),
                new TickerDataSeries()
                    .setChartType("line")
                    .setName("Legend 2")
                    .setData(Arrays.asList(10, 9, 8, 7, 6))

            ));
    }
}
