package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;
import org.apache.cxf.transport.http.Cookie;

@Data
public class Meta4ClientSession implements Serializable {

  private static final long serialVersionUID = -3473147313502370674L;

  private String id;

  private Map<String, Cookie> cookies;

  private LocalDateTime fechaCreacion;

  private LocalDateTime fechaUso;

  private long uso;

  private boolean login;

}
