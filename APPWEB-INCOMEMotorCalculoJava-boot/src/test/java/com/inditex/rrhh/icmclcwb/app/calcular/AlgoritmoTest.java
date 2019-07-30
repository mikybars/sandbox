package com.inditex.rrhh.icmclcwb.app.calcular;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class AlgoritmoTest {

    @Autowired
    private AlgoritmoService algoritmoService;

    // TODO Dejar de ignorar cuando se regenere el modelo de BBDD
    @Ignore
    @Test
    public void checkDuplicatedActives() {
        assertEquals(Boolean.FALSE, algoritmoService.checkDuplicatedActives());
    }

}
