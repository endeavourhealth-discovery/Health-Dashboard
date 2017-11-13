package org.endeavourhealth.healthdashboard.models;

public class ChartDefinition {
    private int id;
    private String connection;
    private String query;

    public int getId() {
        return id;
    }

    public ChartDefinition setId(int id) {
        this.id = id;
        return this;
    }

    public String getConnection() {
        return connection;
    }

    public ChartDefinition setConnection(String connection) {
        this.connection = connection;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public ChartDefinition setQuery(String query) {
        this.query = query;
        return this;
    }
}
