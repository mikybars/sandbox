package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    //TODO[JAVIEREV] En el servicio ahora pide un listado de rangos de fechas, cambiarlo a fechas
    // inicio y fin cuando arreglen el servicio
    private List<ConfiguracionesRequestItemDto> items;
}
