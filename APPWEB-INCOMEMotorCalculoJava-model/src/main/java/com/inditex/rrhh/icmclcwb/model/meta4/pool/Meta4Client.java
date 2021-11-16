package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.io.Serializable;

import lombok.Data;

@Data
public class Meta4Client implements Serializable {

  private static final long serialVersionUID = -3473147313502370674L;

  private Meta4ClientSession session;

  private Meta4ClientCredentials credentials;

  private Meta4ClientService service;

}
