package org.endeavourhealth.healthdashboard.framework;

import com.codahale.metrics.jvm.*;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.models.auth.OAuth2Definition;
import org.endeavourhealth.coreui.framework.config.ConfigService;
import org.endeavourhealth.healthdashboard.metrics.HealthDashboardInstrumentedFilterContextListener;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.management.ManagementFactory;

public class SwaggerBootstrap extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        Info info = new Info()
                .title("Patient Location API")
                .description("Patient Location API");

        System.out.println("API is running!!!");

        String baseAuthUrl = ConfigService.instance().getAuthConfig().getAuthServerUrl() +
                "/realms/" + ConfigService.instance().getAuthConfig().getRealm() + "/protocol/openid-connect";

        Swagger swagger = new Swagger().info(info);
        swagger.basePath("/api");
        swagger.securityDefinition("oauth",
                new OAuth2Definition()
                        .accessCode(baseAuthUrl + "/auth", baseAuthUrl + "/token")
                );
        new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);

        HealthDashboardInstrumentedFilterContextListener.REGISTRY.register("Garbage Collection", new GarbageCollectorMetricSet());
        HealthDashboardInstrumentedFilterContextListener.REGISTRY.register("Buffers", new BufferPoolMetricSet(ManagementFactory.getPlatformMBeanServer()));
        HealthDashboardInstrumentedFilterContextListener.REGISTRY.register("Memory", new MemoryUsageGaugeSet());
        HealthDashboardInstrumentedFilterContextListener.REGISTRY.register("Threads", new ThreadStatesGaugeSet());
        HealthDashboardInstrumentedFilterContextListener.REGISTRY.register("File Descriptor", new FileDescriptorRatioGauge());
    }
}
