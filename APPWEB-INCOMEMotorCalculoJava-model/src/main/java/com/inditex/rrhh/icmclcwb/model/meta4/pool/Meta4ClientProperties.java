package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.io.Serializable;

import lombok.Data;

@Data
public class Meta4ClientProperties implements Serializable {

  private static final long serialVersionUID = -3473147313502370674L;

  private boolean preLogin;

  private int size;

  private long claimTimeout;

  private long shutdownTimeout;

}
