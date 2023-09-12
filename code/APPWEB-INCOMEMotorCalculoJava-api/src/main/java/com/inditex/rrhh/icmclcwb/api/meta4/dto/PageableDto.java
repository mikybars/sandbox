package com.inditex.rrhh.icmclcwb.api.meta4.dto;

import java.io.Serializable;

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
public class PageableDto<T extends Serializable> implements Pageable<T>, Serializable {

  private static final long serialVersionUID = -1674424926992562719L;

  T data;

  PageDto page;

  public boolean nextPage() {
    if (this.getPage().hasNext()) {
      this.getPage().next();
      return true;
    }
    return false;
  }

}
