package com.inditex.rrhh.icmclcwb.model.ptr.presencia.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciaMockMapperComisionable;
import com.inditex.rrhh.icmclcwb.model.secondary.mapper.PtrPresenciaMockMapper;
import com.inditex.rrhh.icmclcwb.model.secondary.repository.PtrPresenciaMockRepository;

@Service
@Validated
public class PtrPresenciaMockServiceImpl implements PtrPresenciaMockService {

    @Autowired
    private PtrPresenciaMockRepository presenciasRepository;

    @Autowired
    private PtrPresenciaMockMapper presenciasMapper;

    @Override
    public List<PtrPresenciaDetalleResultItemDto> presenciasDetalle(PtrPresenciaDetalleRequestDto presencias) {
        return this.presenciasMapper.asPresenciaDetalleDtos(this.presenciasRepository.findPresencias(presencias));
    }

	@Override
	public List<PtrPresenciaDetalleComisionableResultItemDto> presenciasDetalleComisionable(
			PtrPresenciaDetalleComisionableRequestDto presencias) {
		return this.presenciasMapper.asPresenciaDetalleComisionableDtos(this.presenciasRepository
				.findPresencias(PtrPresenciaMockMapperComisionable.asPresenciaComisionableToDetalle(presencias)));
	}

    @Override
    public List<PtrPresenciaTotalTiendaResultItemDto> presenciasTotalTienda(PtrPresenciaTotalTiendaRequestDto presencias) {
        return this.presenciasMapper
                .asPresenciasTotalTiendaDtos(this.presenciasRepository.findPresenciasTotalTienda(presencias));
    }

    @Override
    public List<PtrPresenciaTotalTiendaSeccionResultItemDto> presenciasTotalTiendaSeccion(
            PtrPresenciaTotalTiendaSeccionRequestDto presencias) {
        return this.presenciasMapper.asPresenciasTotalTiendaSeccionDtos(
                this.presenciasRepository.findPresenciasTotalTiendaSeccion(presencias));
    }

    @Override
    public List<PtrPresenciaTiposHorasResultItemDto> tiposHoras(PtrPresenciaTiposHorasRequestDto tiposHoras) {
        // TODO Se puede llamar a findTiposHoras() o a findTiposHorasGroupBy()
        return this.presenciasMapper.asTiposHorasDtos(this.presenciasRepository.findTiposHoras(tiposHoras));
    }

}