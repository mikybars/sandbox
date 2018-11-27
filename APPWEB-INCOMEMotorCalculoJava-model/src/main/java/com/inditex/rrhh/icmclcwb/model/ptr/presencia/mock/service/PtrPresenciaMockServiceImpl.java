package com.inditex.rrhh.icmclcwb.model.ptr.presencia.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResultItemDto;
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
    public List<PtrPresenciasDetalleResultItemDto> presenciasDetalle(PtrPresenciasDetalleRequestDto presencias) {
        return this.presenciasMapper.asPresenciaDetalleDtos(this.presenciasRepository.findPresencias(presencias));
    }

	@Override
	public List<PtrPresenciasDetalleComisionableResultItemDto> presenciasDetalleComisionable(
			PtrPresenciasDetalleComisionableRequestDto presencias) {
		return this.presenciasMapper.asPresenciaDetalleComisionableDtos(this.presenciasRepository
				.findPresencias(PtrPresenciasMockMapperComisionable.asPresenciaComisionableToDetalle(presencias)));
	}

    @Override
    public List<PtrPresenciasTotalTiendaResultItemDto> presenciasTotalTienda(PtrPresenciasTotalTiendaRequestDto presencias) {
        return this.presenciasMapper
                .asPresenciasTotalTiendaDtos(this.presenciasRepository.findPresenciasTotalTienda(presencias));
    }

    @Override
    public List<PtrPresenciasTotalTiendaSeccionResultItemDto> presenciasTotalTiendaSeccion(
            PtrPresenciasTotalTiendaSeccionRequestDto presencias) {
        return this.presenciasMapper.asPresenciasTotalTiendaSeccionDtos(
                this.presenciasRepository.findPresenciasTotalTiendaSeccion(presencias));
    }

    @Override
    public List<PtrPresenciasTiposHorasResultItemDto> tiposHoras(PtrPresenciasTiposHorasRequestDto tiposHoras) {
        return this.presenciasMapper.asTiposHorasDtos(this.presenciasRepository.findTiposHoras(tiposHoras));
    }

}