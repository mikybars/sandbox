package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionAbiertaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionAbiertaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionAbiertaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionAbiertaServiceImpl implements TareaLocalizacionAbiertaService {

    @Autowired
    private TareaLocalizacionAbiertaRepositoryCustom tareaLocalizacionAbiertaRepositoryCustom;

    @Autowired
    private TareaLocalizacionAbiertaMapper tareaLocalizacionAbiertaMapper;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public void saveAbierto(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto) {
        tareaLocalizacionAbiertaRepositoryCustom.saveAbierto(tareaDto, trabajoDto);
    }

    @Override
    public void saveCerrado(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto) {
        List<IdTipoDatoDto> ids = tipoDatoService
                .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_LOCALIZACION.getId());
        tareaLocalizacionAbiertaRepositoryCustom.saveCerrado(tareaDto, trabajoDto,
                ids.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    }

}
