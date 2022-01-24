package com.inditex.rrhh.icmclcwb.api.meta4.dto;

import java.io.Serializable;

public interface Pageable<T extends Serializable> {

  T getData();

  PageDto getPage();

}
