package com.inditex.rrhh.icmclcwb.model.mapper.ptr.jpa;

import java.util.List;

import org.mapstruct.Mapper;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.jpa.PresenciasDetalleEspanaJPA;

@Mapper
public interface PresenciasMapperJPA {

	PresenciasDetalleResponseDTO asSolrQueueDTO(PresenciasDetalleEspanaJPA src);

	 PresenciasDetalleEspanaJPA asSolrQueue(PresenciasDetalleResponseDTO src);

	List<PresenciasDetalleResponseDTO> asSolrQueueDTOs(List<PresenciasDetalleEspanaJPA> src);
}
