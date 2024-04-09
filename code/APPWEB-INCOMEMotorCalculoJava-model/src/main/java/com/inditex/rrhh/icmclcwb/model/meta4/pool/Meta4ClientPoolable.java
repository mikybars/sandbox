package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stormpot.Poolable;
import stormpot.Slot;

public class Meta4ClientPoolable implements Poolable {

  private static final Logger LOG = LoggerFactory.getLogger(Meta4ClientPoolable.class);

  private final Slot slot;

  private final Meta4Client session;

  public Meta4ClientPoolable(final Slot slot, final Meta4Client session) {
    this.slot = slot;
    this.session = session;
  }

  public void expire() {
    this.slot.expire(this);
  }

  @Override
  public void release() {
    LOG.debug("Meta4ClientPoolable :: release()");
    this.slot.release(this);
  }

  public Meta4ClientSession getSession() {
    return this.session.getSession();
  }

  public LoginService getLoginService() {
    // TODO [DAVIDTSO] NO BORRAR
    // CxfUtils.putRequestHeaders(session.getService().getLoginService(),
    // CxfUtils.mapJSessionID(session.getSession().getJSessionID()));
    // CxfUtils.putRequestHeaders(session.getService().getLoginService(),
    // CxfUtils.mapCookie(session.getSession().getSetCookie()));
    // CxfUtils.putCookies(session.getService().getLoginService(),
    // CxfUtils.cookieJSessionID(session.getSession().getJSessionID()));
    return this.session.getService().getLoginService();
  }

  public IcmWsCalcIncomeService getIcmWsCalcIncomeService() {
    // TODO [DAVIDTSO] NO BORRAR
    // CxfUtils.putRequestHeaders(session.getService().getIcmWsCalcIncomeService(),
    // CxfUtils.mapJSessionID(session.getSession().getJSessionID()));
    // CxfUtils.putRequestHeaders(session.getService().getIcmWsCalcIncomeService(),
    // CxfUtils.mapCookie(session.getSession().getSetCookie()));
    // CxfUtils.putCookies(session.getService().getIcmWsCalcIncomeService(),
    // CxfUtils.cookieJSessionID(session.getSession().getJSessionID()));
    // CxfUtils.setCookies(session.getService().getIcmWsCalcIncomeService(),
    // session.getSession().getCookies());
    return this.session.getService().getIcmWsCalcIncomeService();
  }

}
