package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.exception.ReflectionIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaValidarRepositoryCustom;

@Service
@Validated
public class TareaValidarServiceImpl implements TareaValidarService {

    @Autowired
    private TareaValidarRepositoryCustom tareaValidarRepositoryCustom;

    @Autowired
    private TareaService tareaService;

    @Override
    public List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.checkDuplicatedTiendasHistorico(idTarea);
    }

    @Override
    public List<String> checkDuplicatedTiposHora(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.checkDuplicatedTiposHora(idTarea);
    }

    @Override
    public Integer countEmpleadosHistorico(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countEmpleadosHistorico(idTarea);
    }

    @Override
    public Integer countTiendasHistorico(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendasHistorico(idTarea);
    }

    @Override
    public Integer countEstructuras(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countEstructuras(idTarea);
    }

    @Override
    public Integer countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendaPresenciaSeccion(idTarea);
    }

    @Override
    public Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendaEmpleadoPresenciaSeccion(idTarea);
    }

    @Override
    public Integer countTiendaVentaSeccion(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendaVentaSeccion(idTarea);
    }

    @Override
    public List<String> validateAmbito(@NotNull @Positive Long idTarea) {
        TareaDto tareaDto = tareaService.find(idTarea);
        if (CollectionUtils.isNotEmpty(tareaDto.getLocalizacion())) {
            return tareaValidarRepositoryCustom.validateAmbitoLocalizacion(idTarea);
        } else if (CollectionUtils.isNotEmpty(tareaDto.getPersona())) {
            return tareaValidarRepositoryCustom.validateAmbitoPersona(idTarea);
        }
        return tareaValidarRepositoryCustom.validateAmbitoEmpresa(idTarea);
    }

    @Override
    public List<Map<String, Object>> validateByIdTrabajo(@NotNull @Positive Long idTrabajo) {
        List<TareaDto> tareaDto = tareaService.findByTrabajoId(idTrabajo);
        return tareaDto.stream().map(TareaDto::getId).map(this::validateByIdTarea).collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> validateByIdTarea(@NotNull @Positive Long idTarea) {
        try {
            Map<String, Object> objects = new HashMap<String, Object>();
            Method[] methods = TareaValidarRepositoryCustom.class.getMethods();
            for (Method method : methods) {
                objects.put(method.getName(), method.invoke(tareaValidarRepositoryCustom, idTarea));
            }
            return objects;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new ReflectionIcmclcwbException(e.getMessage(), e);
        } catch (Exception e) {
            throw e;
        }
    }

}
