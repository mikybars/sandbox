package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response containing a list of employees with their commission calculation results.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculoComisionesResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<CalculoComisionesResultItemDto> data;

}
