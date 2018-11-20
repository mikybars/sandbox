package com.inditex.rrhh.icmclcwb.model.app.service.poc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocEjecucionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.service.poc.PocEjecucionService;
import com.inditex.rrhh.icmclcwb.api.app.util.poc.PocConstants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocEjecucionMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocPeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.poc.PocEjecucionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.poc.PocPeriodoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.poc.PocTiendaRepository;

@Service
@Validated
public class PocEjecucionServiceImpl implements PocEjecucionService {

    @Autowired
    private PocEjecucionRepository pocEjecucionRepository;

    @Autowired
    private PocEjecucionMapper pocEjecucionMapper;

    @Autowired
    private PocPeriodoRepository pocPeriodoRepository;

    @Autowired
    private PocPeriodoMapper pocPeriodoMapper;

    @Autowired
    private PocTiendaRepository pocTiendaRepository;

    @Autowired
    private PocTiendaMapper pocTiendaMapper;

    @Autowired
    private TrabajoService trabajoService;

    @Override
    public List<PocEjecucionDto> findAll() {
        return pocEjecucionMapper.pocEjecucionToPocEjecucionDto(pocEjecucionRepository.findAll());
    }

    @Override
    public PocEjecucionDto createPocEjecucion(@Valid PocEjecucionDto pocEjecucion) {

        // Gestion de periodos
        PocPeriodoDto pocPeriodo = pocPeriodoMapper
                .pocPeriodoToPocPeriodoDto(pocPeriodoRepository.findOne(pocEjecucion.getPeriodo()));
        if (pocPeriodo == null) {
            throw new ApplicationException("No tiene un periodo válido");
        }

        // Gestion de tiendas
        List<PocTiendaDto> pocTiendas;
        if (CollectionUtils.isNotEmpty(pocEjecucion.getTiendas())) {
            pocTiendas = pocTiendaMapper.pocTiendaToPocTiendaDto(
                    pocTiendaRepository.findByIdPaisOrigenAndIdEmpresaAndIdIn(pocEjecucion.getIdPaisOrigen(),
                            pocEjecucion.getIdEmpresa(), pocEjecucion.getTiendas()));
            if (pocEjecucion.getTiendas().size() != pocTiendas.size()) {
                throw new ApplicationException("Todas las tiendas no son validas");
            }
        } else {
            pocTiendas = pocTiendaMapper.pocTiendaToPocTiendaDto(pocTiendaRepository
                    .findByIdPaisOrigenAndIdEmpresa(pocEjecucion.getIdPaisOrigen(), pocEjecucion.getIdEmpresa()));
            if (CollectionUtils.isEmpty(pocTiendas)) {
                throw new ApplicationException("No hay tiendas para el pais/empresa");
            }
        }

        pocEjecucion.setFechaCreacion(LocalDateTime.now());
        if (PocConstants.PocSistemaEnum.JAVA.getSistema().equals(pocEjecucion.getSistema())) {
            TrabajoDto trabajo = new TrabajoDto();
            trabajo.setIdPaisOrigen(pocEjecucion.getIdPaisOrigen());
            trabajo.setIdEmpresa(pocEjecucion.getIdEmpresa());
            trabajo.setFechaInicioPeriodo(pocPeriodo.getFechaInicioPeriodo());
            trabajo.setFechaFinPeriodo(pocPeriodo.getFechaFinPeriodo());
            List<TrabajoTiendaDto> tiendas = new ArrayList<>();
            pocTiendas.forEach(item -> {
                TrabajoTiendaDto tienda = new TrabajoTiendaDto();
                tienda.setIdTienda(item.getId());
                tiendas.add(tienda);
            });
            trabajo.setTiendas(tiendas);
            trabajo = trabajoService.createTrabajo(trabajo);
            pocEjecucion.setIdSistemaEjecucion(trabajo.getId());
        } else if (PocConstants.PocSistemaEnum.META4.getSistema().equals(pocEjecucion.getSistema())) {
            pocEjecucion.setIdSistemaEjecucion(-1L);
        } else {
            throw new ApplicationException("No tiene un sistema valido");
        }
        pocEjecucion = pocEjecucionMapper.pocEjecucionToPocEjecucionDto(
                pocEjecucionRepository.save(pocEjecucionMapper.pocEjecucionDtoToPocEjecucion(pocEjecucion)));
        return pocEjecucion;
    }

}