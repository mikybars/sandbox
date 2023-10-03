package com.inditex.rrhh.icmclcwb.api.app.proceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TipoProcesoDTO {

    private Integer id;

    private String nombre;

}
