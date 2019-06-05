package com.inditex.rrhh.icmclcwb.ptr.venta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrTestConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto.PtrObtenerVentaAcumuladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto.PtrObtenerVentaAcumuladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto.PtrObtenerVentaAcumuladaDiaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto.PtrObtenerVentaAcumuladaDiaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrAcumuladoVentaImporteService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class PtrVentaAcumuladoServiceTest {

    
    @Autowired
    @Qualifier("ptrVentaClient")
    private RestClient ptrVentaClient;
    
    @Autowired
    private PtrAcumuladoVentaImporteService ptrAcumuladoVentaImporteService;

    @Autowired
    @Qualifier("acumuladoVentaImporteProperties")
    protected Map<String, PtrPropertiesDto> acumuladoVentaImporteProperties;
       
    @Autowired
    @Qualifier("ventaVersion")
    private String version;
    
    
    @Ignore("Devuelve un 500, el formato de fechas no es el correcto")
    @Test
    public void ventaAcumulada() {
        PtrObtenerVentaAcumuladaRequestDto request = new PtrObtenerVentaAcumuladaRequestDto();
//        request.setFechaHoraInicio(PtrTestConstants.FECHA_HORA_DESDE_FORMAT_DD_MM_YYYY);
//        request.setFechaHoraFin(PtrTestConstants.FECHA_HORA_HASTA_FORMAT_DD_MM_YYYY);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        request.setVentaComercial(0);
        request.setOnline(0);
        
        PtrObtenerVentaAcumuladaResponseDto response = ptrAcumuladoVentaImporteService.ventaAcumulada(request);
        assertNotNull(response.getDatoVentaTienda());
    }
    
    @Ignore("El formato de fechas no es el correcto")
    @Test
    public void ventaAcumuladaDia() {
        PtrObtenerVentaAcumuladaDiaRequestDto request = new PtrObtenerVentaAcumuladaDiaRequestDto();
//        request.setFecha(PtrTestConstants.FECHA_FORMAT_DD_MM_YYYY);
        request.setCadena(PtrTestConstants.CADENA_LIST);
        request.setPais(PtrTestConstants.PAIS_LIST);
        request.setVentaComercial(0);
        request.setOnline(0);

        PtrObtenerVentaAcumuladaDiaResponseDto response = ptrAcumuladoVentaImporteService.ventaAcumuladaDia(request);
        assertNotNull(response.getDatoVentaTienda());
    }
    
    @Ignore("No existe en los servicios publicados en Openshift, está pendiente que miren si los agregan")
    @Test
    public void test() { 
        assertTrue(Boolean.valueOf(ptrAcumuladoVentaImporteService.test()));
    }
    
    @Ignore("No existe en los servicios publicados en Openshift, está pendiente que miren si los agregan")
    @Test
    public void version() {
        assertEquals(version, ptrAcumuladoVentaImporteService.version());
    }
    
}
