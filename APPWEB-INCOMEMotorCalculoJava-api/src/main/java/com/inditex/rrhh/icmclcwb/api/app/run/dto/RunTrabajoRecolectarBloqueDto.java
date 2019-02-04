package com.inditex.rrhh.icmclcwb.api.app.run.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaEstadoDto;
import lombok.Data;

@Data
public class RunTrabajoRecolectarBloqueDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

    private Set<String> cadenaEmpresa = new HashSet<>();

    private Set<String> tiendaMeta4 = new HashSet<>();

    private Set<String> tiendaMtu = new HashSet<>();

    private Set<Integer> tipoHoraComisionable = new HashSet<>();
    
    private Set<Integer> tipoHoraComisionableDenominador = new HashSet<>();

    private boolean pivot = false;

    private Set<String> empleadoLocal = new HashSet<>();

    private Set<String> empleadoUniversal = new HashSet<>();

    private Set<String> tiendaPresencia = new HashSet<>();

    private Set<TrabajoTiendaEstadoDto> tienda = new HashSet<>();

    private Set<TrabajoEmpleadoEstadoDto> empleado = new HashSet<>();

}
