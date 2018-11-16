package com.inditex.rrhh.icmclcwb.model.ptr.presenciasmock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasServiceMock;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PresenciasMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.PtrPresenciasMockRepository;

@Service
@Validated
public class PtrPresenciasMockServiceImpl implements PtrPresenciasServiceMock {

    @Autowired
    private PtrPresenciasMockRepository presenciasRepository;

    @Autowired
    private PresenciasMapper presenciasMapper;

    @Override
    public List<PresenciasDetalleResponseDto> presenciasDetalle(PresenciasDetalleRequestDto presencias) {
        return this.presenciasMapper.asPresenciaDetalleDTOs(this.presenciasRepository.findPresencias(presencias));
    }

	@Override
	public List<PresenciasDetalleComisionableResponseDto> presenciasDetalleComisionable(
			PresenciasDetalleComisionableRequestDto presencias) {
		return this.presenciasMapper.asPresenciaDetalleComisionableDTOs(this.presenciasRepository
				.findPresencias(presenciasMapper.asPresenciaComisionableToDetalle(presencias)));
	}

    @Override
    public List<PresenciasTotalTiendaResponseDto> presenciasTotalTienda(PresenciasTotalTiendaRequestDto presencias) {
        return this.presenciasMapper
                .asPresenciasTotalTiendaDTOs(this.presenciasRepository.findPresenciasTotalTienda(presencias));
    }

    @Override
    public List<PresenciasTotalTiendaSeccionResponseDto> presenciasTotalTiendaSeccion(
            PresenciasTotalTiendaSeccionRequestDto presencias) {
        return this.presenciasMapper.asPresenciasTotalTiendaSeccionDTOs(
                this.presenciasRepository.findPresenciasTotalTiendaSeccion(presencias));
    }

    @Override
    public List<TiposHorasResponseDto> tiposHoras(TiposHorasRequestDto tiposHoras) {
        return this.presenciasMapper.asTiposHorasDTOs(this.presenciasRepository.findTiposHoras(tiposHoras));
    }

}