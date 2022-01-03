package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.app.util.CxfUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.cxf.transport.http.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stormpot.Reallocator;
import stormpot.Slot;

public class Meta4ClientReallocator implements Reallocator<Meta4ClientPoolable> {

  private static final Logger log = LoggerFactory.getLogger(Meta4ClientReallocator.class);

  private static final AtomicLong count = new AtomicLong(0);

  private final Meta4ClientFactory meta4ClientFactory;

  public Meta4ClientReallocator(final Meta4ClientFactory meta4ClientFactory) {
    this.meta4ClientFactory = meta4ClientFactory;
  }

  @Override
  public Meta4ClientPoolable allocate(final Slot slot) throws Exception {
    log.info("Inicio :: Meta4ClientReallocator :: allocate()");
    final Long effectiveCount = this.meta4ClientFactory.getMeta4ClientProperties().isPreLogin()
        ? count.incrementAndGet()
        : count.incrementAndGet() - this.meta4ClientFactory.getMeta4ClientProperties().getSize();
    String id = StringUtils.EMPTY;
    Map<String, Cookie> cookies = new HashMap<>();
    LoginService loginService = null;
    IcmWsCalcIncomeService icmWsCalcIncomeService = null;
    boolean login = false;
    if (effectiveCount.compareTo(NumberUtils.LONG_ZERO) > 0) {
      login = true;
      loginService = this.meta4ClientFactory.getLoginServiceFactory().build(LoginService.class);
      icmWsCalcIncomeService = this.meta4ClientFactory.getIcmWsCalcIncomeServiceFactory()
          .build(IcmWsCalcIncomeService.class);
      try {
        id = loginService.login(this.meta4ClientFactory.getMeta4ClientCredentials().getUser(),
            this.meta4ClientFactory.getMeta4ClientCredentials().getPassword(),
            this.meta4ClientFactory.getMeta4ClientCredentials().getLanguage())
            .getSessionID();
        if (StringUtils.isNotBlank(id)) {
          // TODO [DAVIDTSO] NO BORRAR
          // List<String> setCookie =
          // CxfUtils.getSetCookie(CxfUtils.getResponseHeaders(loginService));
          // String jSessionID = CxfUtils.getJSessionID(setCookie);
          // CxfUtils.putRequestHeaders(icmWsCalcIncomeService,
          // CxfUtils.mapJSessionID(jSessionID));
          // CxfUtils.putRequestHeaders(icmWsCalcIncomeService,
          // CxfUtils.mapCookie(setCookie));
          // CxfUtils.putCookies(icmWsCalcIncomeService,
          // CxfUtils.cookieJSessionID(jSessionID));
          // CxfUtils.putCookie(icmWsCalcIncomeService, jSessionID);
          // CxfUtils.cloneHeaders(loginService, icmWsCalcIncomeService);
          cookies = CxfUtils.getCookies(loginService);
          CxfUtils.setCookies(icmWsCalcIncomeService, cookies);
          icmWsCalcIncomeService.retrieveM4Session(id);
        } else {
          log.error("Error :: Meta4ClientReallocator :: allocate({}) :: No ha sido posible hacer login",
              effectiveCount);
          throw new Meta4IcmclcwbException("No ha sido posible hacer login");
        }
      } catch (final Exception e) {
        log.error("Error :: Meta4ClientReallocator :: allocate({})", effectiveCount, e);
      }
    }
    final Meta4Client client = new Meta4Client();
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId(id);
    session.setCookies(cookies);
    session.setFechaCreacion(TimeUtils.nowLocalDateTime());
    session.setLogin(login);
    client.setSession(session);
    client.setCredentials(this.meta4ClientFactory.getMeta4ClientCredentials());
    final Meta4ClientService service = new Meta4ClientService();
    service.setLoginService(loginService);
    service.setIcmWsCalcIncomeService(icmWsCalcIncomeService);
    client.setService(service);
    log.info("Fin :: Meta4ClientReallocator :: allocate({}) :: {}", effectiveCount, id);
    return new Meta4ClientPoolable(slot, client);
  }

  @Override
  public void deallocate(final Meta4ClientPoolable poolable) throws Exception {
    log.info("Inicio :: Meta4ClientReallocator :: deallocate() :: {}", poolable.getSession().getId());
    try {
      if (StringUtils.isNotBlank(poolable.getSession().getId())) {
        poolable.getLoginService().logout();
      }
    } catch (final Exception e) {
      log.error("Error :: Meta4ClientReallocator :: deallocate()", e);
    }
    log.info("Fin :: Meta4ClientReallocator :: deallocate() :: {}", poolable.getSession().getId());
  }

  @Override
  public Meta4ClientPoolable reallocate(final Slot slot, final Meta4ClientPoolable poolable) throws Exception {
    log.info("Inicio :: Meta4ClientReallocator :: reallocate() :: {}", poolable.getSession().getId());
    final Meta4ClientPoolable result = this.allocate(slot);
    log.info("Fin :: Meta4ClientReallocator :: reallocate() :: {}", poolable.getSession().getId());
    return result;
  }

}
