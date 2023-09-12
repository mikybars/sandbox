package com.inditex.rrhh.icmclcwb.ws.health;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.utils.TypeHealthEnum;
import com.inditex.rrhh.icmclcwb.ws.health.utils.HealthUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(SpringExtension.class)
class LivelinkHealthIndicatorTest {

  @InjectMocks
  Meta4HealthIndicator healthIndicator;

  @Test
  void healthDown() {
    final Map<String, String> dataProject = new HashMap<>();
    dataProject.put("projectService", "ICMCLCWB");
    dataProject.put("usernameService", "usernameAuthenticator");
    dataProject.put("passwordService", "PASSWORD");
    dataProject.put("authMethodService", "NONE");
    final TypeHealthEnum typeHealthEnum = TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK;
    final Duration duration = Duration.ofSeconds(10);

    ReflectionTestUtils.setField(this.healthIndicator, "enabled",
        Boolean.TRUE);
    ReflectionTestUtils.setField(this.healthIndicator, "project",
        "ICMCLCWB");

    final List<String> urls = List.of("https://not.exist.url.test");
    ReflectionTestUtils.setField(this.healthIndicator, "urls", urls);

    ReflectionTestUtils.setField(this.healthIndicator, "authMethod",
        "NONE");
    ReflectionTestUtils.setField(this.healthIndicator, "username",
        "usernameAuthenticator");
    ReflectionTestUtils.setField(this.healthIndicator, "password",
        "PASSWORD");

    ReflectionTestUtils.setField(this.healthIndicator, "type",
        2);

    ReflectionTestUtils.setField(this.healthIndicator, "connectTimeout",
        duration);

    ReflectionTestUtils.setField(this.healthIndicator, "readTimeout",
        duration);

    final Health healthUp = Health.up().build();

    try (final MockedStatic<HealthUtil> healthUtilMockedStatic = Mockito.mockStatic(HealthUtil.class)) {
      healthUtilMockedStatic.when(() -> HealthUtil.callEndpoint(
          Boolean.TRUE,
          dataProject,
          urls, typeHealthEnum, duration, duration))
          .thenReturn(healthUp);

      final var result = this.healthIndicator.health();
      Assertions.assertNotNull(result);
      Assertions.assertEquals(Status.UP, result.getStatus());
    }

  }

}
