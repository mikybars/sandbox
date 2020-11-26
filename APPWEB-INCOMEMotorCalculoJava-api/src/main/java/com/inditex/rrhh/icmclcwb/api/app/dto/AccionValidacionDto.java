/**
 * 
 */
package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo AccionEnvioDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AccionValidacionDto implements Serializable{

    @NotNull
    @ApiModelProperty(value = "Identificador de la accion", required = true, example = "1")
    private Integer id;
    
    @ApiModelProperty(value = "Tiempo de delay si aplica", required = false, example = "60")
    private Long delayTime;
}
