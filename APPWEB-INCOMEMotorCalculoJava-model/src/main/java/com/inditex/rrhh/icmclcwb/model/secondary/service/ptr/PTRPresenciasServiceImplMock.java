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
		Object[] param = new Object[]{presencias.getOrigen().toString(),presencias.getTienda().toString(),fecha1,fecha2};
		Log.info("------------------Find Presencias Detalle JDBC: Inicio");
		Long startTime = System.currentTimeMillis();
		List<PresenciaDetalleMock> p= this.presenciasRepository.findPresencias(param);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Presencias Detalle JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		
		return this.presenciasMapper.asPresenciaDetalleDTOs(p);
	}

	@Override
	public PresenciasDetalleComisionableResponseDTO PresenciasDetalleComisionable(PresenciasDetalleComisionableRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciaDetalleComisionableDTO(this.presenciasRepositoryJPA.findPresenciasComisionable(this.presenciasMapper.asPresenciaDetalleComisionable(presencias)));
		return null;
	}

	@Override
	public List<PresenciasTotalTiendaResponseDTO> PresenciasTotalTienda(PresenciasTotalTiendaRequestDTO presencias) {
		String fecha1= formatter.format(presencias.getFechaDesde());
		String fecha2= formatter.format(presencias.getFechaHasta());
		
		Object[] param = new Object[]{presencias.getOrigen(),fecha1,fecha2,presencias.getTiendas()};
		Log.info("------------------Find Total Tienda JDBC: Inicio");
		Long startTime = System.currentTimeMillis();
		List<PresenciaTotalTiendaMock> p= this.presenciasRepository.findPresenciasTotalTienda(param);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Total Tienda JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		Log.info("***********************************"+p.get(0)+"**************************************");
		return this.presenciasMapper.asPresenciasTotalTiendaDTOs(p);
	}

	@Override
	public PresenciasTotalTiendaSeccionResponseDTO PresenciasTotalTiendaSeccion(
			PresenciasTotalTiendaSeccionRequestDTO presencias) {
		//return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTO(this.presenciasRepositoryJPA.findPresenciasTotalTiendaSeccion(this.presenciasMapper.asPresenciasTotalTiendaSeccion(presencias)));
		return null;
	}

	@Override
	public List<TiposHorasResponseDTO> TiposHoras(TiposHorasRequestDTO tiposHoras) {
		Object[] param = new Object[]{tiposHoras.getTipoHora().toString()};
		Log.info("------------------Find Tipos Horas JDBC: Inicio");
		Long startTime = System.currentTimeMillis();
		List<TiposHorasMock> p= this.presenciasRepository.findTiposHoras(param);
		Long estimatedTime = System.currentTimeMillis() - startTime;
		Log.info("------------------ Find Presencias Detalle JDBC: Fin........... Tiempo de Ejecucion: "+ estimatedTime.toString()+" ms");
		return this.presenciasMapper.asTiposHorasDTOs(p);
	}

}
