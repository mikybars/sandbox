package com.inditex.rrhh.icmclcwb.model.ptr.presencia.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciasMockMapperComisionable;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciasMockMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.PtrPresenciasMockRepository;

@Service
@Validated
public class PtrPresenciaMockServiceImpl implements PtrPresenciaMockService {

    @Autowired
    private PtrPresenciasMockRepository presenciasRepository;

    @Autowired
    private PtrPresenciasMockMapper presenciasMapper;

    @Override
    public List<PtrPresenciasMockDetalleResponseDto> presenciasDetalle(PtrPresenciasMockDetalleRequestDto presencias) {
        return this.presenciasMapper.asPresenciaDetalleDTOs(this.presenciasRepository.findPresencias(presencias));
    }

	@Override
	public List<PtrPresenciasMockDetalleComisionableResponseDto> presenciasDetalleComisionable(
			PtrPresenciasMockDetalleComisionableRequestDto presencias) {
		return this.presenciasMapper.asPresenciaDetalleComisionableDTOs(this.presenciasRepository
				.findPresencias(PtrPresenciasMockMapperComisionable.asPresenciaComisionableToDetalle(presencias)));
	}

    @Override
    public List<PtrPresenciasMockTotalTiendaResponseDto> presenciasTotalTienda(PtrPresenciasMockTotalTiendaRequestDto presencias) {
        return this.presenciasMapper
                .asPresenciasTotalTiendaDTOs(this.presenciasRepository.findPresenciasTotalTienda(presencias));
    }

    @Override
    public List<PtrPresenciasMockTotalTiendaSeccionResponseDto> presenciasTotalTiendaSeccion(
            PtrPresenciasMockTotalTiendaSeccionRequestDto presencias) {
        return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTOs(
                this.presenciasRepository.findPresenciasTotalTiendaSeccion(presencias));
    }

    @Override
    public List<PtrPresenciasMockTiposHorasResponseDto> tiposHoras(PtrPresenciasMockTiposHorasRequestDto tiposHoras) {
        return this.presenciasMapper.asTiposHorasDTOs(this.presenciasRepository.findTiposHoras(tiposHoras));
    }

}