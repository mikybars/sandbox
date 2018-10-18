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
import com.inditex.rrhh.icmclcwb.model.secondary.repository.ptr.PTRPresenciasRepositoryJPA;
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
	
	
	//REPOSITORIO JPA
	@Autowired
	PTRPresenciasRepositoryJPA presenciasRepositoryJPA;
	
    @Autowired
    private PresenciasMapper presenciasMapper;
    
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    
    //Traduce el objecto, lo envia a la función y la salida la vuelve a traducir
	@Override
	public PresenciasDetalleResponseDTO PresenciasDetalle(PresenciasDetalleRequestDTO presencias) {
		String fecha1= formatter.format(presencias.getFechaDesde());
		String fecha2= formatter.format(presencias.getFechaHasta());
		
		//MEDICION TIEMPO Y EJECUCION EN JPA
		Log.info("------------------Find Presencias Detalle JPA: Inicio");
		Long startTime = System.currentTimeMillis();
		List<PresenciaDetalleMock> listpresencias =this.presenciasRepositoryJPA.findPresencias(presencias.getTienda().toString(),fecha1,fecha2);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Presencias Detalle JPA: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		
		
		//MEDICION TIEMPO Y EJECUCION EN JDBC
		Object[] param = new Object[]{presencias.getTienda().toString(),fecha1,fecha2};
		Log.info("------------------Find Presencias Detalle JDBC: Inicio");
		startTime = System.currentTimeMillis();
		List<PresenciaDetalleMock> p= this.presenciasRepository.findPresencias(param);
		estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Presencias Detalle JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		
		return this.presenciasMapper.asPresenciaDetalleDTO(listpresencias.get(0));
		//return this.presenciasMapper.asPresenciaDetalleDTO(p.get(0));
	}

	@Override
	public PresenciasDetalleComisionableResponseDTO PresenciasDetalleComisionable(PresenciasDetalleComisionableRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciaDetalleComisionableDTO(this.presenciasRepositoryJPA.findPresenciasComisionable(this.presenciasMapper.asPresenciaDetalleComisionable(presencias)));
		return null;
	}

	@Override
	public PresenciasTotalTiendaResponseDTO PresenciasTotalTienda(PresenciasTotalTiendaRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciasTotalTiendaDTO(this.presenciasRepositoryJPA.findPresenciasTotalTienda(this.presenciasMapper.asPresenciasTotalTienda(presencias)));
		return null;
	}

	@Override
	public PresenciasTotalTiendaSeccionResponseDTO PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTO(this.presenciasRepositoryJPA.findPresenciasTotalTiendaSeccion(this.presenciasMapper.asPresenciasTotalTiendaSeccion(presencias)));
		return null;
	}

	@Override
	public TiposHorasResponseDTO TiposHoras(TiposHorasRequestDTO tiposHoras) {
		//return this.presenciasMapper.asTiposHorasDTO(this.presenciasRepositoryJPA.findTiposHoras(this.presenciasMapper.asTiposHoras(tiposHoras)));
		return null;
	}

}
