package com.inditex.rrhh.icmclcwb.ws.health.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.aqsw.framework.common.rest.client.authentication.AuthMethod;
import com.inditex.rrhh.icmclcwb.api.utils.TypeHealthEnum;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

@Slf4j
@UtilityClass
public class HealthUtil {

  public static final String PROJECT = "project";

  public static Health callEndpoint(final Boolean enabled, final Map<String, String> dataService,
      final List<String> urls,
      final TypeHealthEnum typeHealth,
      final Duration connectTimeout, final Duration readTimeout) {

    final String project = dataService.get("projectService");

    if (Boolean.FALSE.equals(enabled) || CollectionUtils.isEmpty(urls)) {
      return getHealth(Health.unknown(), project);
    }

    if (typeHealth != null) {
      return checkHealth(typeHealth, urls, dataService, connectTimeout, readTimeout);
    } else {
      throw new IllegalArgumentException();
    }

  }

  private static Health checkHealth(final TypeHealthEnum typeHealth, final List<String> urls,
      final Map<String, String> dataService,
      final Duration connectTimeout, final Duration readTimeout) {
    final String project = dataService.get("projectService");
    final String username = dataService.get("usernameService");
    final String password = dataService.get("passwordService");
    final AuthMethod authMethod = AuthMethod.valueOf(dataService.get("authMethodService"));
    final Map<String, Object> details = new HashMap<>();
    details.put(PROJECT, project);
    try {
      final RestTemplate restTemplate = getRestTemplate(connectTimeout,
          readTimeout, authMethod, username, password);
      boolean result = true;
      final Map<String, String> urlsDetails = new HashMap<>();
      for (final String url : urls) {
        boolean conditionFailCheck = false;
        switch (typeHealth) {
          case AMIGA_HEALTH_STATUS_UP:
            final JsonNode resp = restTemplate.getForObject(
                url, JsonNode.class);
            conditionFailCheck = (resp == null || !"UP".equalsIgnoreCase(resp.get("status").asText()));
            break;
          case VALIDATE_RESPONSE_STATUS_CODE_OK:
            final ResponseEntity<Void> response = restTemplate.getForEntity(url, Void.class);
            conditionFailCheck = !response.getStatusCode().equals(HttpStatus.OK);
            break;
          default:
        }

        if (conditionFailCheck) {
          result = false;
          urlsDetails.put(url, "KO");
        } else {
          urlsDetails.put(url, "OK");
        }
      }
      details.put("urls", urlsDetails);
      final Health.Builder healthBuilder = result ? Health.up() : Health.down();
      return getHealth(healthBuilder, details);
    } catch (final Exception ex) {
      log.error("HealthUtil.checkHealth: KO", ex);
      return getHealth(Health.down(ex), details);
    }

  }

  private static Health getHealth(final Health.Builder builder, final String project) {
    return builder.withDetail(PROJECT, project).build();
  }

  private static Health getHealth(final Health.Builder builder, final Map<String, Object> details) {
    return builder.withDetails(details).build();
  }

  private static RestTemplate getRestTemplate(final Duration connectTimeout,
      final Duration readTimeout, final AuthMethod authMethod, final String username, final String password) {
    final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    if (AuthMethod.BASIC.equals(authMethod)) {
      return restTemplateBuilder.setConnectTimeout(connectTimeout)
          .setReadTimeout(readTimeout)
          .basicAuthentication(username, password)
          .build();
    } else {
      return restTemplateBuilder.setConnectTimeout(connectTimeout)
          .setReadTimeout(readTimeout)
          .build();
    }
  }

}
