package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class IdTipoDatoDto implements Serializable {

    private static final long serialVersionUID = 3630643129878733468L;

    public Integer id;

}
