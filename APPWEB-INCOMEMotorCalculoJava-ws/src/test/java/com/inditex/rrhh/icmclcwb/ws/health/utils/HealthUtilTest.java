package com.inditex.rrhh.icmclcwb.ws.health.utils;

import com.inditex.rrhh.icmclcwb.api.utils.TypeHealthEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.actuate.health.Health;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class HealthUtilTest {

    @InjectMocks
    HealthUtil healthUtil;

    @Test
    void callEndpointTest1() {
        Map<String, String> dataProject = new HashMap<>();
        dataProject.put("projectService", "ICMCLCWB");

        Health health = this.healthUtil.callEndpoint(false, dataProject, null,
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

        List<String> urls = Arrays.asList("url1");

        Health health = this.healthUtil.callEndpoint(true, dataProject, urls,
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

        List<String> urls = Arrays.asList("url1");

        Health health = this.healthUtil.callEndpoint(true, dataProject, urls,
                TypeHealthEnum.AMIGA_HEALTH_STATUS_UP, Duration.ofHours(Long.valueOf(0)),
                Duration.ofHours(Long.valueOf(0)));

        assertNotNull(health);
    }

}
