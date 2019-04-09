package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaTiendaVentaSeccionRespositoryProcesarCustomImpl implements TareaTiendaVentaSeccionRespositoryProcesarCustom {
    
    @Autowired
    @Qualifier("pscfTareaTiendaVentaSeccionRepositoryProcesar")
    private PreparedStatementCreatorFactory pscfSave;
    
    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
    public void procesar(@NotNull final TareaDto tareaDto, @NotNull final List<Long> tipoImportes) {
        Map<String, Object> params = new HashMap<>();
        params.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_SECCION, TipoImporteVentaEnum.IMPORTE_VENTA_LOCALIZACION_SECCION.getId());
        params.put(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA, tipoImportes);
        params.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        namedParameterJdbcTemplate.update(pscfSave.getSql(), params);
    }
}
