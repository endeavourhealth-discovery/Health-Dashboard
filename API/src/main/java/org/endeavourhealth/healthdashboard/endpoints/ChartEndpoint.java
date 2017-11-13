package org.endeavourhealth.healthdashboard.endpoints;
import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.endeavourhealth.healthdashboard.logic.ChartLogic;
import org.endeavourhealth.healthdashboard.models.Chart;
import org.endeavourhealth.healthdashboard.models.ChartData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/charts")
@Metrics(registry = "HealthDashboardMetricRegistry")
@Api(description = "API for all calls relating to charts")
public class ChartEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(ChartEndpoint.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed(absolute = true, name = "HealthDashboard.ChartEndpoint.Charts")
    @Path("/")
    @ApiOperation(value = "Returns a list of charts")
    public Response getCharts(@Context SecurityContext sc) throws Exception {
        LOG.debug("Get Charts");

        List<Chart> charts = new ChartLogic().getCharts();

        return Response
            .ok()
            .entity(charts)
            .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed(absolute = true, name = "HealthDashboard.ChartEndpoint.ChartData")
    @Path("/data")
    @ApiOperation(value = "Returns chart data for a chart")
    public Response getChartData(@Context SecurityContext sc,
                                 @ApiParam(value = "Mandatory chart id") @QueryParam("chartId") int chartId) throws Exception {

        ChartData chartData = new ChartLogic().getChartData(chartId);

        return Response
            .ok()
            .entity(chartData)
            .build();
    }
}
