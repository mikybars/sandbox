package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import com.inditex.rrhh.icmclcwb.api.dto.SolrQueueDTO;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.SolrQueue;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface SolrQueueMapper {

	SolrQueueDTO asSolrQueueDTO(SolrQueue src);

	SolrQueue asSolrQueue(SolrQueueDTO src);

	List<SolrQueueDTO> asSolrQueueDTOs(List<SolrQueue> src);

}