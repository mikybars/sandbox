package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ConfiguracionesRequestDto extends GenericFilterParametersDto
        implements Serializable {

    private static final long serialVersionUID = 6004857776815885351L;

    private String idOrigen;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    // Lista vacia para evitar problemas en la petición, pero realmente no se usa
    private List<ConfiguracionesRequestItemDto> items = new ArrayList<>();

}
