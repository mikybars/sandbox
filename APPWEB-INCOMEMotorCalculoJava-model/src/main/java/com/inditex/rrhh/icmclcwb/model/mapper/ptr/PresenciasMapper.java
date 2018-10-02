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
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.Presencia;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface PresenciasMapper {
	//PRESENCIAS DETALLE COMISIONABLE
    PresenciasDetalleComisionableResponseDTO asPresenciaDetalleComisionableDTO(Presencia src);

    Presencia asPresenciaDetalleComisionable(PresenciasDetalleComisionableRequestDTO src);

    List<PresenciasDetalleComisionableResponseDTO> asPresenciaDetalleComisionableDTOs(List<Presencia> src);
    
    //PRESENCIAS DETALLE
    PresenciasDetalleResponseDTO asPresenciaDetalleDTO(Presencia src);

    Presencia asPresenciaComisionable(PresenciasDetalleRequestDTO src);

    List<PresenciasDetalleResponseDTO> asPresenciaDetalleDTOs(List<Presencia> src);
    
    
    //PRESENCIAS TIENDA
    PresenciasTotalTiendaResponseDTO asPresenciasTotalTiendaDTO(Presencia src);

    Presencia asPresenciasTotalTienda(PresenciasTotalTiendaRequestDTO src);

    List<PresenciasTotalTiendaResponseDTO> asPresenciasTotalTiendaDTOs(List<Presencia> src);
    
    //PRESENCIAS TIENDA SECCION
    PresenciasTotalTiendaSeccionResponseDTO asPresenciasTotalTiendaSeccionDTO(Presencia src);

    Presencia asPresenciasTotalTiendaSeccion(PresenciasTotalTiendaSeccionRequestDTO src);

    List<PresenciasTotalTiendaSeccionResponseDTO> asPresenciasTotalTiendaSeccionDTOs(List<Presencia> src);
    
    
    //TIPOS HORAS
    TiposHorasResponseDTO asTiposHorasDTO(Presencia src);

    Presencia asTiposHoras(TiposHorasRequestDTO src);

    List<TiposHorasResponseDTO> asTiposHorasDTOs(List<Presencia> src);
}






