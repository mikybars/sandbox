package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanuallocalizacion.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableList;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class VentaManualLocalizacionResponseDto extends PageableListDto<VentaManualLocalizacionResultItemDto>
        implements PageableList<VentaManualLocalizacionResultItemDto>, Serializable {

    private static final long serialVersionUID = -1L;

}
