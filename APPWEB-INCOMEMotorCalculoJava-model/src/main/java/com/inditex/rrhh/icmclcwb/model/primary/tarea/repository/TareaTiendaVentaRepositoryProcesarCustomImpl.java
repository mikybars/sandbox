package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoImporteVentaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;

@Repository
public class TareaTiendaVentaRepositoryProcesarCustomImpl implements TareaTiendaVentaRepositoryProcesarCustom{
    
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    @Value("#{primaryQuery['RunTareaProcesarService.procesarVentaTienda']}")
    private String sqlSave;
    
    @Autowired
    @Qualifier("ventaGeneralProperties")
    protected Map<String, PtrPropertiesDto> ventaGeneralProperties;

    @Override
    public void procesar(@NotNull TareaDto tareaDto, @NotNull List<Long> tipoImportes) {
        // la query incluye una sentencia IN, pero DB2 no soporta pasarle valores con setArray de PreparedStatement,
        // por lo que hay que sustituir un placeholder por el número correcto de interrogantes (?) para poner los valores
        // uno a uno.
        List<String> interrogantes = tipoImportes.stream().map(x -> "?").collect(Collectors.toList());
        String sql = String.format(sqlSave, String.join(",", interrogantes));
        jdbcTemplate.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                setParameters(ps, tareaDto, tipoImportes);
            }
            
        });
    }
    
    private void setParameters(PreparedStatement pstmt, TareaDto entity, List<Long> tipoImportes) throws SQLException {
        // parametros: tipo de importe destino, id tarea y los 5 tipos 
        // de importe origen (fisico, ipod, entreta tienda, entrega domicilio, picking)
        pstmt.setLong(1, TipoImporteVentaEnum.IMPORTE_VENTA_LOCALIZACION.getId());
        pstmt.setLong(2, entity.getId());
        for (int i = 0; i<tipoImportes.size(); i++) {
            pstmt.setLong(3+i, tipoImportes.get(i));
        }
    }

}
