package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoAmbitoOrigenService trabajoAmbitoOrigenService;

    @Autowired
    private TrabajoAmbitoEmpresaService trabajoAmbitoEmpresaService;

    @Autowired
    private TrabajoAmbitoLocalizacionService trabajoAmbitoLocalizacionService;

    @Autowired
    private TrabajoAmbitoPersonaService trabajoAmbitoPersonaService;

    @Override
    public TrabajoDto create(@Valid final TrabajoDto trabajo) {

//        tarea.setFechaCreacion(LocalDateTime.now());
//        tarea.setEstado(EstadoTareaEnum.PENDIENTE_DATOS.getDto());
//        if (StringUtils.isBlank(tarea.getIdUsuario())) {
//            UserSSO userSSO = SsoUtils.getUserSSO();
//            if (StringUtils.isNotBlank(userSSO.getUsername())) {
//                tarea.setIdUsuario(userSSO.getUsername());
//            }
//        }
//        TareaDto result = tareaMapper
//                .tareaToTareaDto(tareaRepository.save(tareaMapper.tareaDtoToTarea(tarea)));
//        if (CollectionUtils.isNotEmpty(tarea.getTiendas())) {
//            result.setTiendas(tareaTiendaService.createTareaTienda(result, tarea.getTiendas()));
//        } else if (CollectionUtils.isNotEmpty(tarea.getEmpleados())) {
//            result.setEmpleados(tareaEmpleadoService.createTareaEmpleado(result, tarea.getEmpleados()));
//        }
//        senderTarea.send(result);
        return trabajo;
    }

    @Override
    public List<TrabajoDto> create(@Valid @NotNull final ProgramacionDto programacion,
            @Valid @NotNull final PeriodoDto periodo) {
        List<TrabajoDto> result = new ArrayList<>();
        trabajoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(programacion.getAmbito(),
                programacion, periodo).forEach(item -> result.add(create(item)));
        return result;
    }

}