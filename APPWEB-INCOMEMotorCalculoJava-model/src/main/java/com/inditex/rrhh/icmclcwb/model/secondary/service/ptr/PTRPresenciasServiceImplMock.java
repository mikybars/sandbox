package com.inditex.rrhh.icmclcwb.model.secondary.service.ptr;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.esotericsoftware.minlog.Log;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleComisionableRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.PresenciasTotalTiendaSeccionRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleComisionableResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaSeccionResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.TiposHorasResponseDTO;
import com.inditex.rrhh.icmclcwb.api.service.ptr.PTRPresenciasServiceMock;
import com.inditex.rrhh.icmclcwb.model.mapper.ptr.PresenciasMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr.PTRPresenciasRepositoryMock;
import org.slf4j.Logger;
/**
 * Implementación del servicio de producto
 */
@Service
@Validated
public class PTRPresenciasServiceImplMock implements PTRPresenciasServiceMock {
	
	@Autowired
    private Logger logger;
    
	
	//REPOSITORIO QUE USA JDBCTEMPLATE
    @Autowired
    private PTRPresenciasRepositoryMock presenciasRepository;
	
	
    @Autowired
    private PresenciasMapper presenciasMapper;
    
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    
    
    
    
    //Traduce el objecto, lo envia a la función y la salida la vuelve a traducir
	@Override
	public List<PresenciasDetalleResponseDTO> PresenciasDetalle(PresenciasDetalleRequestDTO presencias) {
		String fecha1= formatter.format(presencias.getFechaDesde());
		String fecha2= formatter.format(presencias.getFechaHasta());
		
		//MEDICION TIEMPO Y EJECUCION EN JDBC
		//Object[] param = new Object[]{presencias.getOrigen().toString(),presencias.getTienda().toString(),fecha1,fecha2,presencias.getCadena(),presencias.getTipo(),presencias.getSeccion(),presencias.getPersonas()};
		Object[] param = new Object[]{presencias.getOrigen().toString(),fecha1,fecha2,presencias.getTienda().toString(),presencias.getSeccion(),presencias.getTipo(),presencias.getCadena(),presencias.getPersonas()};
		Log.info("------------------Find Presencias Detalle JDBC: Inicio");
		Long startTime = System.currentTimeMillis();
		List<PresenciaDetalleMock> p= this.presenciasRepository.findPresencias(param);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Presencias Detalle JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		
		return this.presenciasMapper.asPresenciaDetalleDTOs(p);
	}

	
	
	
	
	
	
	
	
	@Override
	public List<PresenciasDetalleComisionableResponseDTO> PresenciasDetalleComisionable(PresenciasDetalleComisionableRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciaDetalleComisionableDTO(this.presenciasRepositoryJPA.findPresenciasComisionable(this.presenciasMapper.asPresenciaDetalleComisionable(presencias)));
		return null;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public List<PresenciasTotalTiendaResponseDTO> PresenciasTotalTienda(PresenciasTotalTiendaRequestDTO presencias) {
		String fecha1= formatter.format(presencias.getFechaDesde());
		String fecha2= formatter.format(presencias.getFechaHasta());
		
		Object[] param = new Object[]{presencias.getOrigen(),fecha1,fecha2,presencias.getTipo(),presencias.getCadena(),presencias.getTiendas()};
		Log.info("------------------Find Total Tienda JDBC: Inicio");
		Long startTime = System.currentTimeMillis();
		List<PresenciaTotalTiendaMock> p= this.presenciasRepository.findPresenciasTotalTienda(param);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Total Tienda JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		return this.presenciasMapper.asPresenciasTotalTiendaDTOs(p);
	}

	
	
	

	@Override
	public List<PresenciasTotalTiendaSeccionResponseDTO> PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDTO presencias) {
		String fecha1= formatter.format(presencias.getFechaDesde());
		String fecha2= formatter.format(presencias.getFechaHasta());
		Object[] param = new Object[]{presencias.getOrigen(),fecha1,fecha2,presencias.getTipo(),presencias.getCadena(),presencias.getTiendaSeccion()};
				
		Log.info("------------------Find Total Tienda Seccion JDBC: Inicio");
		Long startTime = System.currentTimeMillis();
		List<PresenciaTotalTiendaSeccionMock> p= this.presenciasRepository.findPresenciasTotalTiendaSeccion(param);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Total Tienda Seccion JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		Log.info("Tiene un tamaño de:  "+ p.size());
		return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTOs(p);
	}

	
	
	
	
	
	
	
	
	@Override
	public List<TiposHorasResponseDTO> TiposHoras(TiposHorasRequestDTO tiposHoras) {
		Log.info("------------------Find Tipos Horas JDBC: Inicio");
		Long startTime = System.currentTimeMillis();
		List<TiposHorasMock> p= this.presenciasRepository.findTiposHoras(tiposHoras);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Presencias Detalle JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		return this.presenciasMapper.asTiposHorasDTOs(p);
	}

}
