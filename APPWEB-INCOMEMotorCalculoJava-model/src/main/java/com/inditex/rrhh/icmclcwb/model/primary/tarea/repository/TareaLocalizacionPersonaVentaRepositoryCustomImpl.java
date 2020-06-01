package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

@Repository
public class TareaLocalizacionPersonaVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaVenta>
        implements TareaLocalizacionPersonaVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-venta:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaPersonaSeccion']}")
    private String sqlTotalizarVentaPersonaSeccion;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public List<TareaLocalizacionPersonaVenta> save(final List<TareaLocalizacionPersonaVenta> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public void totalizarVentaPersonaSeccion(final TareaDto tarea) {

        final List<IdTipoDatoDto> tiposDato = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.OPERACIONES_VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId());
        this.totalizarVentaPersonaSeccion(tarea, tiposDato, TipoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION_SECCION);

    }

    @Override
    public void totalizarVentaSinDevolucionPersonaSeccion(final TareaDto tarea) {

        final List<IdTipoDatoDto> tiposDato = this.tipoDatoService.findTipoDatoByTipoGrupoDato(
                TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
        this.totalizarVentaPersonaSeccion(tarea, tiposDato,
                TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION);

    }

    @Override
    public void totalizarDevolucionPersonaSeccion(final TareaDto tarea) {

        final List<IdTipoDatoDto> tiposDato = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
        this.totalizarVentaPersonaSeccion(tarea, tiposDato, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION);

    }

    @Override
    public void totalizarVentaFisicaSinDevolucionPersonaSeccion(final TareaDto tarea) {

        this.totalizarVentaPersonaSeccion(tarea,
                TipoDatoEnum.VENTA_FISICA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION,
                Collections.singletonList(TipoDatoEnum.OPERACION_VENTA_FISICA_LOCALIZACION_SECCION.getId()));

    }

    @Override
    public void totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(final TareaDto tarea) {

        this.totalizarVentaPersonaSeccion(tarea,
                TipoDatoEnum.VENTA_ONLINE_IPOD_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION,
                Collections.singletonList(TipoDatoEnum.OPERACION_VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId()));

    }

    @Override
    public void totalizarDevolucionFisicaPersonaSeccion(final TareaDto tarea) {

        this.totalizarVentaPersonaSeccion(tarea, TipoDatoEnum.DEVOLUCION_FISICA_INDIVIDUAL_LOCALIZACION_SECCION,
                Collections.singletonList(TipoDatoEnum.OPERACION_DEVOLUCION_FISICA_LOCALIZACION_SECCION.getId()));

    }

    @Override
    public void totalizarDevolucionOnlineIpodPersonaSeccion(final TareaDto tarea) {

        this.totalizarVentaPersonaSeccion(tarea, TipoDatoEnum.DEVOLUCION_ONLINE_IPOD_INDIVIDUAL_LOCALIZACION_SECCION,
                Collections.singletonList(TipoDatoEnum.OPERACION_DEVOLUCION_ONLINE_IPOD_LOCALIZACION_SECCION.getId()));

    }

    private void totalizarVentaPersonaSeccion(final TareaDto tarea, final TipoDatoEnum nuevoTipoDato,
            final List<Integer> tiposDato) {

        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        // Parámetros filtro
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, tiposDato);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        // Parámetros que establecen valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, nuevoTipoDato.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        this.update(this.sqlTotalizarVentaPersonaSeccion, parameters);

    }

    private void totalizarVentaPersonaSeccion(final TareaDto tarea, final List<IdTipoDatoDto> tiposDato,
            final TipoDatoEnum nuevoTipoDato) {

        this.totalizarVentaPersonaSeccion(tarea, nuevoTipoDato,
                tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));

    }

}
