package org.endeavourhealth.healthdashboard.dal;

import com.fasterxml.jackson.databind.JsonNode;
import org.endeavourhealth.common.config.ConfigManager;
import org.endeavourhealth.coreui.framework.ContextShutdownHook;
import org.endeavourhealth.coreui.framework.StartupConfig;
import org.endeavourhealth.healthdashboard.models.Chart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ChartDal implements ContextShutdownHook {
    private static final Logger LOG = LoggerFactory.getLogger(ChartDal.class);
    private Connection _connection = null;

    public ChartDal() {
        StartupConfig.registerShutdownHook("PersonPatientDAL_Jdbc", this);
    }

    public List<Chart> getCharts() {
        List<Chart> result = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, refresh FROM charts");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.add(
                    new Chart()
                    .setId(rs.getInt("id"))
                    .setTitle(rs.getString("title"))
                    .setRefresh(rs.getInt("refresh"))
                );
            }
        } catch (Exception e) {
            LOG.error("Error fetching charts", e);
        }

        return result;
    }

    private Connection getConnection() {
        try {
            return (_connection != null  && !_connection.isClosed()) ? _connection : (_connection = createConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection createConnection() {
        try {
            JsonNode json = ConfigManager.getConfigurationAsJson("database");
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

    @Override
    public void contextShutdown() {
        try{
            if (_connection != null && !_connection.isClosed())
                _connection.close();
        } catch (Exception e) {
            LOG.error("Error disconnecting", e);
        }
    }
}
