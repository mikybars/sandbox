package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockDetalle;

public class PtrPresenciaMockDetalleRowMapper implements RowMapper<PtrPresenciaMockDetalle> {

    @Override
    public PtrPresenciaMockDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
        PtrPresenciaMockDetalle pre = new PtrPresenciaMockDetalle();
        pre.setTipo(rs.getInt("ID_TIPO"));
        pre.setTienda(rs.getInt("ID_TIENDA"));
        pre.setFecha(rs.getDate("FECHA"));
        pre.setSeccion(rs.getInt("ID_SECCION"));
        pre.setPersona(rs.getInt("EMPLEADO"));
        pre.setMinutos(rs.getInt("MINUTOS"));
        pre.setModificado_income(rs.getBoolean("MODIFICADO_INCOME"));
        pre.setCadena(rs.getInt("CADENA"));
        pre.setOrigen(rs.getInt("ORIGEN"));
        return pre;
    }

}