package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLimpiezaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.OptionalUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;
import org.apache.commons.lang3.StringUtils;

import com.inditex.aqsw.framework.service.aaa.userdetails.sso.model.UserSSO;
import com.inditex.aqsw.framework.service.aaa.userdetails.sso.util.SsoUtils;

@Service
@Validated
public class TareaLimpiezaServiceImpl implements TareaLimpiezaService {

    @Autowired
    private TareaLimpiezaRepositoryCustom tareaLimpiezaRepositoryCustom;

    @Autowired
    private TareaLimpiezaRepository tareaLimpiezaRepository;

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private TareaLimpiezaMapper tareaLimpiezaMapper;

    @Override
    public TareaLimpiezaDto save(final TareaLimpiezaDto tareaLimpieza) {
        if (StringUtils.isBlank(tareaLimpieza.getNombreUsuario())) {
            final UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUser())) {
                tareaLimpieza.setNombreUsuario(userSSO.getUser());
            }
        }
        tareaLimpieza.setEstado(EstadoTareaLimpiezaEnum.PENDIENTE.getDto());
        // TODO [javierev] cuando se implemente la limpieza parcial esta línea se debe retirar
        tareaLimpieza.setTipo(TipoLimpiezaEnum.COMPLETA.getDto());
        this.tareaLimpiezaRepositoryCustom
            .save(tareaLimpieza);

        // Reobtención de la limpieza con su id
        final TareaLimpieza limpieza = this.tareaLimpiezaRepository.findByTareaId(tareaLimpieza.getIdTarea());
        return this.tareaLimpiezaMapper.tareaLimpiezaToTareaLimpiezaDto(limpieza);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public List<TareaLimpiezaDto> save(
            final List<IdTareaDto> idTareas) {
        final List<TareaLimpiezaDto> result = new ArrayList<>();
        this.tareaLimpiezaMapper.idTareaDtoToTareaLimpiezaDto(idTareas).forEach(item -> result.add(this.save(item)));
        return result;
    }

    @Override
    public TareaLimpiezaDto find(final Long id) {
        return this.tareaLimpiezaMapper
            .tareaLimpiezaToTareaLimpiezaDto(OptionalUtils.get(this.tareaLimpiezaRepository.findById(id)));
    }

}
