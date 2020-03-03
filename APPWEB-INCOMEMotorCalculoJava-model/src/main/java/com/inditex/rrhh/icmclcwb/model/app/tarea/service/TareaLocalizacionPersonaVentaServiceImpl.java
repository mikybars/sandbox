package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaVentaService;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class TareaLocalizacionPersonaVentaServiceImpl implements TareaLocalizacionPersonaVentaService {

    @Autowired
    private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPersonaVentaMapper tareaLocalizacionPersonaVentaMapper;


    @Override
    public void savePtrVentaIndividualDetalleResultItem(@NotNull List<PtrVentaIndividualDetalleResultItemDto> operaciones, TareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.save(
            tareaLocalizacionPersonaVentaMapper.ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(operaciones, tarea));
    }

    @Override
    public void savePtrVentaOnlineIpodIndividualDetalleResultItem(@NotNull List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones, TareaDto tarea) {
        tareaLocalizacionPersonaVentaRepositoryCustom.save(
            tareaLocalizacionPersonaVentaMapper.ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(operaciones, tarea));
    }
}
