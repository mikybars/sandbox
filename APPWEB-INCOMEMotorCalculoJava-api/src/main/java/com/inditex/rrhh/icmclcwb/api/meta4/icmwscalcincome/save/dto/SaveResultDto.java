package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SaveResultDto implements Serializable {

  private static final long serialVersionUID = 1973154739591645146L;

  private Boolean resultadoOk;

  private Boolean resultadoError;

  private List<SaveResultErrorDto> data;

}
