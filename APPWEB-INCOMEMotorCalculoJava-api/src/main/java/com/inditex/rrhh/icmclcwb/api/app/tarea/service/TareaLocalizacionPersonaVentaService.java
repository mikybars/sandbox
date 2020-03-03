package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TareaLocalizacionPersonaVentaService {

    void savePtrVentaIndividualDetalleResultItem(
        @NotNull List<PtrVentaIndividualDetalleResultItemDto> operaciones, TareaDto tarea);

    void savePtrVentaOnlineIpodIndividualDetalleResultItem(
        @NotNull List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones, TareaDto tarea);

}
