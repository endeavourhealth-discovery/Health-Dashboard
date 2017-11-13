package org.endeavourhealth.healthdashboard.logic;

import org.endeavourhealth.healthdashboard.dal.ChartDal;
import org.endeavourhealth.healthdashboard.models.Chart;
import org.endeavourhealth.healthdashboard.models.ChartData;
import org.endeavourhealth.healthdashboard.models.ChartDataSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChartLogic {
    static ChartDal chartDal;

    public ChartLogic() {
        if (chartDal == null)
            chartDal = new ChartDal();
    }

    public List<Chart> getCharts() {
        return chartDal.getCharts();
    }

    public ChartData getChartData(int chartId) {
        Random rand = new Random();

        return new ChartData()
            .setxAxis(Arrays.asList("2010", "2011", "2012", "2013", "2014"))
            .setSeries(Arrays.asList(
                new ChartDataSeries()
                    .setType("column")
                    .setName("Legend 1")
                    .setData(Arrays.asList(rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500))),
                new ChartDataSeries()
                    .setType("line")
                    .setName("Legend 2")
                    .setData(Arrays.asList(rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500))),
                new ChartDataSeries()
                    .setType("spline")
                    .setName("Legend 3")
                    .setData(Arrays.asList(rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500)))
            ));
    }
}
