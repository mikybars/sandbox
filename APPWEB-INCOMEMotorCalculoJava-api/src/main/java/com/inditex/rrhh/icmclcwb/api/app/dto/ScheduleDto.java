package com.inditex.rrhh.icmclcwb.api.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "Modelo ScheduleDto")
@Data
public class ScheduleDto implements Serializable {

	private static final long serialVersionUID = 3665361916795418905L;

	@ApiModelProperty(value = "Identifier Schedule", required = true)
	private Integer id;

	@Size(max = 20)
	@NotBlank
    @ApiModelProperty(value = "Name Product", required = true)
	private String name;

}