package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;

@ApiModel(description = "Modelo TrabajoDto")
@Data
public class TrabajoDto implements Serializable {

    private static final long serialVersionUID = 6263836371385557891L;

    @ApiModelProperty(value = "Identificador del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Programación asociada", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idProgramacion;
    
    @ApiModelProperty(value = "Id del usuario que solicito el trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true, example = "IAGOML")
    private String idUsuario;

    @ApiModelProperty(value = "Fecha en la que se creo el trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaCreacion;

    @NotBlank
    @ApiModelProperty(value = "Id del periodo a procesar", required = true, example = "ICM_201703")
    private String idPeriodo;
    
    @NotNull
    @ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = true, example = "2017-03-01T00:00:00.000Z")
    private LocalDateTime fechaInicioPeriodo;

    @NotNull
    @ApiModelProperty(value = "Fecha fin del periodo a procesar", required = true, example = "2017-03-31T00:00:00.000Z")
    private LocalDateTime fechaFinPeriodo;
    
    @NotBlank
    @ApiModelProperty(value = "Id de la sociedad", required = true, example = "0001")
    private String idSociedad;
    
    @NotNull
    @ApiModelProperty(value = "Tipo Ambito", required = true, example = "1")
    private /* BigInteger */ TipoAmbitoDto tipoAmbito;
    
    @ApiModelProperty(value = "Ambito origen del trabajo", required = false)
    private List<TrabajoAmbitoOrigenDto> origen;

    @ApiModelProperty(value = "Ambito empresa del trabajo", required = false)
    private List<TrabajoAmbitoEmpresaDto> empresa;

    @ApiModelProperty(value = "Ambito persona del trabajo", required = false)
    private List<TrabajoAmbitoPersonaDto> persona;
    
    @ApiModelProperty(value = "Ambito localizacion del trabajo", required = false)
    private List<TrabajoAmbitoLocalizacionDto> localizacion;

}
