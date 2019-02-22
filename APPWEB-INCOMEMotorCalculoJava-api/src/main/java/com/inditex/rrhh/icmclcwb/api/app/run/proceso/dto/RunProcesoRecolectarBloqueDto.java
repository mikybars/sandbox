package com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaEstadoDto;
import lombok.Data;

@Data
public class RunProcesoRecolectarBloqueDto implements Serializable {

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

    private Set<ProcesoTiendaEstadoDto> tienda = new HashSet<>();

    private Set<ProcesoEmpleadoEstadoDto> empleado = new HashSet<>();

}
