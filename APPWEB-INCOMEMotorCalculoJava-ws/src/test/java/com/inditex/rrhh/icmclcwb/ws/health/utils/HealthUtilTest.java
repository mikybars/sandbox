package com.inditex.rrhh.icmclcwb.ws.health.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;
import java.util.Arrays;
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
    Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");

    Health health = HealthUtil.callEndpoint(false, dataProject, null,
        null, null, null);

    assertNotNull(health);
    assertEquals(health, Health.unknown().withDetail("project", "ICMCLCWB").build());
  }

  @Test
  void callEndpointTest2() {
    Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "BASIC");

    List<String> urls = Arrays.asList("url");

    Health health = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    assertNotNull(health);
  }

  @Test
  void callEndpointTest3() {
    Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "NONE");

    List<String> urls = Arrays
        .asList("https://des-openshift.axdesocp1.central.inditex.grp/icmclcws-develop/validationCheck");

    Health health = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.AMIGA_HEALTH_STATUS_UP, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    Health health2 = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    assertNotNull(health);
    assertNotNull(health2);

  }

  @Test
  void callEndpointTest4() {
    Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "BASIC");

    List<String> urls = Arrays.asList();

    Health health = HealthUtil.callEndpoint(true, dataProject, urls,
        TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK, Duration.ofHours(Long.valueOf(0)),
        Duration.ofHours(Long.valueOf(0)));

    assertNotNull(health);
  }

  @Test
  void callEndpointThrowTest() {
    Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "user");
    dataProject.put("passwordService", "pass");
    dataProject.put("authMethodService", "NONE");

    List<String> urls = Arrays
        .asList("url");

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
