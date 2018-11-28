package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTipoHoraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionPresenciaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTipoHoraRepository;

@Service
@Validated	
public class TrabajoTipoHoraServiceImpl implements TrabajoTipoHoraService{
	
	@Autowired
	private TrabajoTipoHoraMapper mapper;
	
    @Autowired
    private TrabajoTipoHoraRepository trabajoTipoHoraRepository;
	
	@Override
	public CompletableFuture<Void> save(List<PtrPresenciasMockTiposHorasResponseDto> dto, TrabajoDto trabajoDto) {
		List<TrabajoTipoHoraDto> result = mapper.trabajoTrabajoTipoHoraListTotrabajoTipoHoraDtoList(trabajoTipoHoraRepository.save(mapper.ptrPresenciasMockListTipoHoraResponsesDtoToTrabajoTipoHoraDto(dto, trabajoDto)));
		return CompletableFuture.completedFuture(null);
	}

}
