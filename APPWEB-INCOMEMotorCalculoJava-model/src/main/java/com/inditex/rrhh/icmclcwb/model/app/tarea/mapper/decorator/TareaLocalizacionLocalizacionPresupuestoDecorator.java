package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionLocalizacionPresupuestoDecorator extends TareaLocalizacionPresupuestoMapper {

  @Autowired
  private TareaLocalizacionPresupuestoMapper delegate;

  @Autowired
  private TipoPresupuestoService tipoPresupuestoService;

  @Override
  public List<TareaLocalizacionPresupuesto> presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(
      final List<PresupuestosWlocResultItemDto> src, final TareaDto tarea) {
    final ArrayList<TareaLocalizacionPresupuesto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(
          item -> result.add(this.presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(item, tarea)));
    }
    return result;
  }

  @Override
  public TareaLocalizacionPresupuesto presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(
      final PresupuestosWlocResultItemDto src, final TareaDto tarea) {
    final TareaLocalizacionPresupuesto result = this.delegate
        .presupuestosWlocResultItemDtoToTareaLocalizacionPresupuesto(src,
            tarea);
    result.setExcepcion(Meta4Constants.TRUE.equalsIgnoreCase(src.getExcepcion().trim()));

    final TipoPresupuestoDto presupuesto = this.tipoPresupuestoService
        .findByIcmIdTpPresupuesto(src.getIdTpPresupuesto());
    result.setTipoPresupuesto(new TipoPresupuesto());
    result.getTipoPresupuesto().setId(presupuesto.getId());
    return result;
  }

}
