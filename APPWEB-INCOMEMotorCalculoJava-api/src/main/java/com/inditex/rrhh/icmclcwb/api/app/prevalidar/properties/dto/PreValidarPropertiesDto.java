package com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PreValidarPropertiesDto {

    @NotNull
    private PreValidarOnlinePropertiesDto online;
    
    @NotNull
    private PreValidarOfflinePropertiesDto offline;

}
