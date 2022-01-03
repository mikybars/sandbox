package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stormpot.Expiration;
import stormpot.SlotInfo;

public class Meta4ClientExpiration implements Expiration<Meta4ClientPoolable> {

  private static final Logger log = LoggerFactory.getLogger(Meta4ClientExpiration.class);

  @Override
  public boolean hasExpired(SlotInfo<? extends Meta4ClientPoolable> info) {
    boolean expired = true;
    boolean login = false;
    String session = StringUtils.EMPTY;
    try {
      Meta4ClientPoolable poolable = info.getPoolable();
      session = poolable.getSession().getId();
      login = poolable.getSession().isLogin();
      LoginService loginService = poolable.getLoginService();
      IcmWsCalcIncomeService icmWsCalcIncomeService = poolable.getIcmWsCalcIncomeService();
      if (login && StringUtils.isNotBlank(session) && loginService != null && icmWsCalcIncomeService != null) {
        int retrieveM4SessionLogin = loginService.retrieveM4Session(session);
        int retrieveM4SessionIcmWsCalcIncome = icmWsCalcIncomeService.retrieveM4Session(session);
        if (retrieveM4SessionLogin == 0 && retrieveM4SessionIcmWsCalcIncome == 0) {
          expired = false;
        }
      }
    } catch (final Exception e) {
      log.error("Meta4ClientExpiration :: Error no controlado :: hasExpired(): ", e);
    }
    if (login) {
      if (expired) {
        log.warn("Meta4ClientExpiration :: La session '{}' ha caducado", session);
      } else {
        log.debug("Meta4ClientExpiration :: La session '{}' sigue activa", session);
      }
    }
    return expired;
  }

}
