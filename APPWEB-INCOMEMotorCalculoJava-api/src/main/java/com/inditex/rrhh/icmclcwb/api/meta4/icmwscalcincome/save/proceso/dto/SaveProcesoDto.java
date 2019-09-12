package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SaveProcesoDto implements Serializable {

    private static final long serialVersionUID = -5223418179902973150L;

    private String idAmbito;

    private String nombreUsuario;

    //TODO [JESTEVEZ] eliminar este campo si al final no se usa en el servicio SAVEPROCESO
    private String idEstadoEjecucion;

    private String idOrganization;

    private List<SaveProcesoParametersDto> item;

}
