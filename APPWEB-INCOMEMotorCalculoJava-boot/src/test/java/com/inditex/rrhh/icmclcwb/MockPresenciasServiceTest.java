package com.inditex.rrhh.icmclcwb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.*;

/**
 * Tests del servicio ProductService. NOTE: Se prueban varias características de la implementación del servicio. Se
 * recomienda que se borre esta clase y que se cree otra u otras con las necesidades del proyecto.
 */


//@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
@ActiveProfiles({"standalone", "test"})
@EnableAutoConfiguration
public class MockPresenciasServiceTest {

    @Autowired
    private TestRestTemplate testRestTemplate; 
    
    @Test
    public void presenciasDetalle() {
        this.testRestTemplate = this.testRestTemplate.withBasicAuth("username100", "username100p");
        ResponseEntity<PresenciasDetalleResponseDTO> ret = this.testRestTemplate.getForEntity("/presenciasServiceMock/presenciasDetalle/1", PresenciasDetalleResponseDTO.class);
        System.out.println("");
        System.out.println("");
        System.out.println(ret.getBody().getMinutos());
        System.out.println("");
        System.out.println("");
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
    }
}
