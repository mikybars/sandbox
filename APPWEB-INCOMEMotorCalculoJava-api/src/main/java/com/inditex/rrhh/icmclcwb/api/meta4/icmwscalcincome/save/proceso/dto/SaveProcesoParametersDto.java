package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SaveProcesoParametersDto extends GenericFilterParametersDto implements Serializable {

    private static final long serialVersionUID = -8046321991280127076L;

    private String idEmpresa;
}
