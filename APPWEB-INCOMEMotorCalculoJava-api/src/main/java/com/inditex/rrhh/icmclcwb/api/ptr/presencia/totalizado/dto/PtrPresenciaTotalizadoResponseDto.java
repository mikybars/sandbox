package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PtrPresenciaTotalizadoResponseDto {

    private List<PtrPresenciaTotalizadoResultItemDto> presenciasTotalizado;

}
