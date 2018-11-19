package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionEmpleadoPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionEmpleadoPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionEmpleadoPresencia;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTipoHora;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionEmpleadoPresenciaRepository;

@Service
@Validated
public class TrabajoTiendaSeccionEmpleadoPresenciaServiceImpl implements TrabajoTiendaSeccionEmpleadoPresenciaService {

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaMapper mapper;

    @Autowired
    private TrabajoTiendaSeccionEmpleadoPresenciaRepository trabajoTiendaSeccionEmpleadoPresenciaRepository;

    @Override
    public CompletableFuture<Void> save(@Valid final TrabajoTiendaSeccionEmpleadoPresenciaDto dto) {
        mapper.trabajoTiendaSeccionEmpleadoPresenciaToTrabajoTiendaSeccionEmpleadoPresenciaDto(
                trabajoTiendaSeccionEmpleadoPresenciaRepository.save(
                        mapper.trabajoTiendaSeccionEmpleadoPresenciaDtoToTrabajoTiendaSeccionEmpleadoPresencia(dto)));
        return CompletableFuture.completedFuture(null);
    }

    @Override
    @Transactional(timeout = 120) // TODO: Revisar timeouts en transacciones
    public CompletableFuture<Void> save(List<PresenciasDetalleResponseDto> dtos, TrabajoDto trabajoDto) {
    	List<TrabajoTiendaSeccionEmpleadoPresencia> result = mapper.presenciasDetalleResponsesDtoToTrabajoTiendaSeccionVentas(dtos, trabajoDto);
    	TrabajoTipoHora tipoHora = new TrabajoTipoHora();
    	tipoHora.setId(101L);
    	result.stream().forEach(r -> r.setTipoHora(tipoHora));
        mapper.trabajoTiendaSeccionEmpleadoPresenciasToTrabajoTiendaSeccionEmpleadoPresenciasDto(
                trabajoTiendaSeccionEmpleadoPresenciaRepository
                        .save(result));
        return CompletableFuture.completedFuture(null);
    }

}
