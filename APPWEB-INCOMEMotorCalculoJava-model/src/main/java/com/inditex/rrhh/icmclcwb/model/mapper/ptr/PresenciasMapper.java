package com.inditex.rrhh.icmclcwb.model.mapper.ptr;

import org.springframework.stereotype.Component;

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
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleComisionableMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaSeccionMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface PresenciasMapper {
	//PRESENCIAS DETALLE COMISIONABLE
    PresenciasDetalleComisionableResponseDTO asPresenciaDetalleComisionableDTO(PresenciaDetalleComisionableMock src);

    PresenciaDetalleComisionableMock asPresenciaDetalleComisionable(PresenciasDetalleComisionableRequestDTO src);

    List<PresenciasDetalleComisionableResponseDTO> asPresenciaDetalleComisionableDTOs(List<PresenciaDetalleComisionableMock> src);
    
    //PRESENCIAS DETALLE
    PresenciasDetalleResponseDTO asPresenciaDetalleDTO(PresenciaDetalleMock src);

    PresenciaDetalleMock asPresenciaDetalle(PresenciasDetalleRequestDTO src);

    List<PresenciasDetalleResponseDTO> asPresenciaDetalleDTOs(List<PresenciaDetalleMock> src);
    
   
  
    //PRESENCIAS TIENDA
    PresenciasTotalTiendaResponseDTO asPresenciasTotalTiendaDTO(PresenciaTotalTiendaMock src);

    PresenciaTotalTiendaMock asPresenciasTotalTienda(PresenciasTotalTiendaRequestDTO src);

    List<PresenciasTotalTiendaResponseDTO> asPresenciasTotalTiendaDTOs(List<PresenciaTotalTiendaMock> src);
    
    //PRESENCIAS TIENDA SECCION
    PresenciasTotalTiendaSeccionResponseDTO asPresenciasTotalTiendaSeccionDTO(PresenciaTotalTiendaSeccionMock src);

    PresenciaTotalTiendaSeccionMock asPresenciasTotalTiendaSeccion(PresenciasTotalTiendaSeccionRequestDTO src);

    List<PresenciasTotalTiendaSeccionResponseDTO> asPresenciasTotalTiendaSeccionDTOs(List<PresenciaTotalTiendaSeccionMock> src);
    
    	
    //TIPOS HORAS
    TiposHorasResponseDTO asTiposHorasDTO(TiposHorasMock src);

    TiposHorasMock asTiposHoras(TiposHorasRequestDTO src);

    List<TiposHorasResponseDTO> asTiposHorasDTOs(List<TiposHorasMock> src);
}






