package com.inditex.rrhh.icmclcwb.api.meta4.dto;

import java.io.Serializable;
import java.util.List;

public interface PageableList<T extends Serializable> {

  public List<T> getData();

  public PageDto getPage();

}
