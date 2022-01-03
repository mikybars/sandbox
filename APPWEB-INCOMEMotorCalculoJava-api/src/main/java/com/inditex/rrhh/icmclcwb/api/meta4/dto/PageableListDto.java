package com.inditex.rrhh.icmclcwb.api.meta4.dto;

import java.io.Serializable;
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
public class PageableListDto<T extends Serializable> implements PageableList<T>, Serializable {

  private static final long serialVersionUID = -1674424926992562719L;

  private List<T> data;

  private PageDto page;

}
