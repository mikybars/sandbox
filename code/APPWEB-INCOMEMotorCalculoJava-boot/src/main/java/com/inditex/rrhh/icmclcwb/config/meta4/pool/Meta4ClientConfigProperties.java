package com.inditex.rrhh.icmclcwb.config.meta4.pool;

import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientCredentials;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientProperties;

import lombok.Data;

@Data
public class Meta4ClientConfigProperties {

  private Meta4ClientCredentials credentials;

  private Meta4ClientProperties pool;

}
