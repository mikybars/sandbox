package com.inditex.rrhh.icmclcwb.ws.health;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.utils.TypeHealthEnum;
import com.inditex.rrhh.icmclcwb.ws.health.utils.HealthUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class Meta4HealthIndicator implements HealthIndicator {

  @Value("${spring.application.name:ICMCLCWB}")
  private String project;

  @Value("${app.envars.meta4.ping-query-custom.enabled:false}")
  private boolean enabled;

  @Value("${app.envars.meta4.ping-query-custom.path}")
  private List<String> urls;

  @Value("${app.envars.meta4.ping-query-custom.type}")
  private int type;

  @Value("${app.envars.meta4.ping-query-custom.connect-timeout}")
  private Duration connectTimeout;

  @Value("${app.envars.meta4.ping-query-custom.read-timeout}")
  private Duration readTimeout;

  @Value("${app.envars.meta4.config.credentials.auth-method:NONE}")
  private String authMethod;

  @Value("${app.envars.meta4.config.credentials.user:#{null}}")
  private String username;

  @Value("${app.envars.meta4.config.credentials.password:#{null}}")
  private String password;

  @Override
  public Health health() {

    Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", this.project);
    dataProject.put("usernameService", this.username);
    dataProject.put("passwordService", this.password);
    dataProject.put("authMethodService", this.authMethod);

    return HealthUtil.callEndpoint(this.enabled, dataProject, this.urls, TypeHealthEnum.getById(this.type),
        this.connectTimeout, this.readTimeout);

  }

}
