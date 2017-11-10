package org.endeavourhealth.healthdashboard.endpoints;
import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.endeavourhealth.healthdashboard.logic.TickerLogic;
import org.endeavourhealth.healthdashboard.models.Ticker;
import org.endeavourhealth.healthdashboard.models.TickerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/tickers")
@Metrics(registry = "HealthDashboardMetricRegistry")
@Api(description = "API for all calls relating to tickers")
public class TickerEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(TickerEndpoint.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed(absolute = true, name = "HealthDashboard.TickerEndpoint.Tickers")
    @Path("/")
    @ApiOperation(value = "Returns a list of tickers")
    public Response getTickers(@Context SecurityContext sc) throws Exception {
        LOG.debug("Get Tickers");

        List<Ticker> tickers = new TickerLogic().getTickers();

        return Response
            .ok()
            .entity(tickers)
            .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed(absolute = true, name = "HealthDashboard.TickerEndpoint.TickerData")
    @Path("/data")
    @ApiOperation(value = "Returns chart data for a ticker")
    public Response getTickerData(@Context SecurityContext sc,
                                  @ApiParam(value = "Mandatory ticker id") @QueryParam("tickerId") int tickerId) throws Exception {

        TickerData tickerData = new TickerLogic().getTickerData(tickerId);

        return Response
            .ok()
            .entity(tickerData)
            .build();
    }
}
