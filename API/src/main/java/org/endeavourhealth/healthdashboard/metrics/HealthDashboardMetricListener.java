package org.endeavourhealth.healthdashboard.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;


public class HealthDashboardMetricListener extends MetricsServlet.ContextListener {
    public static final MetricRegistry patientLocationMetricRegistry = HealthDashboardInstrumentedFilterContextListener.REGISTRY;

    @Override
    protected MetricRegistry getMetricRegistry() {
        return patientLocationMetricRegistry;
    }
}
