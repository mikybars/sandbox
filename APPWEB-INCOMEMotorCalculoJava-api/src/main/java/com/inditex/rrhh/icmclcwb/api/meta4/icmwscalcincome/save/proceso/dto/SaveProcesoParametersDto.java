package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SaveProcesoParametersDto extends GenericFilterParametersDto implements Serializable {

  private static final long serialVersionUID = -8046321991280127076L;

  private String idEmpresa;

}
