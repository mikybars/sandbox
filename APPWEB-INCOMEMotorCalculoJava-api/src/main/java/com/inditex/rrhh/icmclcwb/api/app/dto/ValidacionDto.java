/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ValidacionDto implements Serializable {

    private Boolean result;

    private Long idTareaFaseAccion;

}
