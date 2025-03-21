package com.inditex.rrhh.icmclcwb.ws.health.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.utils.TypeHealthEnum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.actuate.health.Health;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class HealthUtilTest {

  @Test
  void callEndpointTest1() {
    final Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");

    final Health health = HealthUtil.callEndpoint(false, dataProject, null,
        null, null, null);

    assertNotNull(health);
    assertEquals(health, Health.unknown().withDetail("project", "ICMCLCWB").build());
  }

  @Test
  void callEndpointTest2() {
    final Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "BASIC");

    final List<String> urls = List.of("url");

    final Health health = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    assertNotNull(health);
  }

  @Test
  void callEndpointTest3() {
    final Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "NONE");

    final List<String> urls = List.of("https://des-openshift.axdesocp1.central.inditex.grp/icmclcws/validationCheck");

    final Health health = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.AMIGA_HEALTH_STATUS_UP, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    final Health health2 = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    assertNotNull(health);
    assertNotNull(health2);

  }

  @Test
  void callEndpointTest4() {
    final Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "BASIC");

    final List<String> urls = List.of();

    final Health health = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    assertNotNull(health);
  }

  @Test
  void callEndpointThrowTest() {
    final Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "NONE");

    final List<String> urls = List.of("url");

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      HealthUtil.callEndpoint(true, dataProject, urls,
          null, null, null);
    });

    Assertions.assertThrows(NullPointerException.class, () -> {
      HealthUtil.callEndpoint(true, null, null,
          null, null, null);
    });

  }

}
