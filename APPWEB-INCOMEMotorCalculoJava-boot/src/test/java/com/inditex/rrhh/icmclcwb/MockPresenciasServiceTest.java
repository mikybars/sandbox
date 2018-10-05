package com.inditex.rrhh.icmclcwb;


import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.LocalManagementPort;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.*;

/**
 * Tests del servicio ProductService. NOTE: Se prueban varias características de la implementación del servicio. Se
 * recomienda que se borre esta clase y que se cree otra u otras con las necesidades del proyecto.
 */


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {Application.class})
@ActiveProfiles({"standalone","test"})
@EnableAutoConfiguration
public class MockPresenciasServiceTest {
	
	
	//Cliente TEST
	/**@Autowired
    private TestRestTemplate restClient; **/
	
	//Ciente ptr
	@Autowired
	@Qualifier("ptrClientPresenciaMock")
    private RestClient restClient;
    
   /** @Autowired
    @Qualifier("ptrClientPresencia")
    private RestClient restClient;**/
	


    @Test
    public void presenciasDetalle() {
        //this.restClient = this.restClient.withBasicAuth("username100", "username100p");
        PresenciasDetalleRequestDTO req = new PresenciasDetalleRequestDTO();
        req.setCadena(165);
        ResponseEntity<PresenciasDetalleResponseDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasDetalle/", req, PresenciasDetalleResponseDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(ret.getBody().getCadena().intValue(), 165);
        
    }
    
    @Test
    public void presenciasDetalleComisionable(){
    	//this.restClient = this.restClient.withBasicAuth("username100", "username100p");
    	PresenciasDetalleComisionableRequestDTO req = new PresenciasDetalleComisionableRequestDTO();
        req.setCadena(185); 
        ResponseEntity<PresenciasDetalleComisionableResponseDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasDetalleComisionable/", req, PresenciasDetalleComisionableResponseDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(ret.getBody().getCadena().intValue(), 185);   
    }

    @Test
    public void presenciasTotalTienda(){
    	//this.restClient = this.restClient.withBasicAuth("username100", "username100p");
    	PresenciasTotalTiendaRequestDTO req = new PresenciasTotalTiendaRequestDTO();
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(5);
    	req.setTienda(list);
        ResponseEntity<PresenciasTotalTiendaResponseDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasTotalTienda/", req, PresenciasTotalTiendaResponseDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(ret.getBody().getTienda().get(0).intValue(), 5);   
    }

    @Test
    public void presenciasTotalTiendaSeccion(){
    	//this.restClient = this.restClient.withBasicAuth("username100", "username100p");
    	PresenciasTotalTiendaSeccionRequestDTO req = new PresenciasTotalTiendaSeccionRequestDTO();
    	req.setCadena(5);;
        ResponseEntity<PresenciasTotalTiendaSeccionResponseDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/presenciasTotalTiendaSeccion/", req, PresenciasTotalTiendaSeccionResponseDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(ret.getBody().getFechaDesde(), req.getFechaDesde());   
    }

    @Test
    public void tiposHoras(){
    	//this.restClient = this.restClient.withBasicAuth("username100", "username100p");
    	TiposHorasRequestDTO req = new TiposHorasRequestDTO();
        req.setTipoHora(100);
        ResponseEntity<TiposHorasResponseDTO> ret = this.restClient.postForEntity("/presenciasServiceMock/tiposHoras/", req,TiposHorasResponseDTO.class);
        assertEquals(HttpStatus.SC_OK, ret.getStatusCodeValue());
        assertEquals(ret.getBody().getTipoHora().intValue(),100); 
    }
    
}
