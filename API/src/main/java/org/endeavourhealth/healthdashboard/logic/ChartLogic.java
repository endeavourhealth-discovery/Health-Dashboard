package org.endeavourhealth.healthdashboard.logic;

import com.fasterxml.jackson.databind.JsonNode;
import org.endeavourhealth.common.cache.ObjectMapperPool;
import org.endeavourhealth.healthdashboard.dal.ChartDal;
import org.endeavourhealth.healthdashboard.models.Chart;
import org.endeavourhealth.healthdashboard.models.ChartData;
import org.endeavourhealth.healthdashboard.models.ChartDataSeries;
import org.endeavourhealth.healthdashboard.models.ChartDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

public class ChartLogic {
    private static final Logger LOG = LoggerFactory.getLogger(ChartLogic.class);

    static ChartDal chartDal;

    public ChartLogic() {
        if (chartDal == null) chartDal = new ChartDal();
    }

    public List<Chart> getCharts() {
        return chartDal.getCharts();
    }

    public ChartData getChartData(int chartId) {
        ChartDefinition definition = chartDal.getDefinition(chartId);

        try (Connection connection = createConnection(definition.getConnection())) {
            PreparedStatement statement = connection.prepareStatement(definition.getQuery());
            try (ResultSet rs = statement.executeQuery()) {

                ChartData chartData = new ChartData();
                ChartDataSeries chartDataSeries = null;
                HashSet<String> categories = new HashSet<>();

                while (rs.next()) {
                    String type = rs.getString("type");
                    String series = rs.getString("series");
                    String category = rs.getString("category");
                    int value = rs.getInt("value");

                    if (chartDataSeries == null || !chartDataSeries.getName().equals(series)) {
                        chartDataSeries = new ChartDataSeries()
                            .setName(series)
                            .setType(type);
                        chartData.getSeries().add(chartDataSeries);
                    }

                    if (!categories.contains(category))
                        categories.add(category);

                    chartDataSeries.getData().add(value);
                }
                chartData.setxAxis(new ArrayList<>(categories));
                return chartData;

            } catch (Exception e) {
                LOG.error("Error reading definition data " + chartId, e);
            }
        } catch (SQLException e) {
            LOG.error("Error connecting to database " + chartId, e);
        }

        return null;
    }


    private Connection createConnection(String connection) {
        try {
            JsonNode json = ObjectMapperPool.getInstance().readTree(connection);
            String url = json.get("url").asText();
            String user = json.get("username").asText();
            String pass = json.get("password").asText();
            String driver = json.get("class") == null ? null : json.get("class").asText();

            if (driver != null && !driver.isEmpty())
                Class.forName(driver);

            Properties props = new Properties();

            props.setProperty("user", user);
            props.setProperty("password", pass);

            return DriverManager.getConnection(url, props);
        } catch (Exception e) {
            LOG.error("Error getting connection", e);
        }
        return null;
    }
}
