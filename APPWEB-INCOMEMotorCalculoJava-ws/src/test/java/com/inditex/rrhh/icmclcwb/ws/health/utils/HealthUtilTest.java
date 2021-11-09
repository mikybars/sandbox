package com.inditex.rrhh.icmclcwb.ws.health.utils;

import com.inditex.rrhh.icmclcwb.api.utils.TypeHealthEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HealthUtilTest {

    @Value("${app.envars.meta4.icmwscalcincome.ping-query-custom.path}")
    private List<String> urls;

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
        dataProject.put("authMethodService", "NONE");

        Health health = HealthUtil.callEndpoint(true, dataProject, this.urls,
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
        dataProject.put("authMethodService", "BASIC");

        Health health = HealthUtil.callEndpoint(true, dataProject, this.urls,
                TypeHealthEnum.AMIGA_HEALTH_STATUS_UP, Duration.ofHours(Long.valueOf(0)),
                Duration.ofHours(Long.valueOf(0)));

        assertNotNull(health);
    }

    @Test
    void callEndpointTest4() {
        Map<String, String> dataProject = new HashMap<>();
        dataProject.put("projectService", "ICMCLCWB");
        dataProject.put("usernameService", "user");
        dataProject.put("passwordService", "pass");
        dataProject.put("authMethodService", "BASIC");

        List<String> url = Arrays.asList("url");

        Health health = HealthUtil.callEndpoint(true, dataProject, url,
                TypeHealthEnum.AMIGA_HEALTH_STATUS_UP, Duration.ofHours(Long.valueOf(0)),
                Duration.ofHours(Long.valueOf(0)));

        assertNotNull(health);
    }

}
