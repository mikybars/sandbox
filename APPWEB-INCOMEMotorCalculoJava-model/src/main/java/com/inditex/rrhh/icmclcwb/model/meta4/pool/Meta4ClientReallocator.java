package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.transport.http.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inditex.rrhh.icmclcwb.model.app.util.CxfUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import stormpot.Reallocator;
import stormpot.Slot;

public class Meta4ClientReallocator implements Reallocator<Meta4ClientPoolable> {

    private static final Logger log = LoggerFactory.getLogger(Meta4ClientReallocator.class);

    private final Meta4ClientFactory meta4ClientFactory;

    public Meta4ClientReallocator(Meta4ClientFactory meta4ClientFactory) {
        this.meta4ClientFactory = meta4ClientFactory;
    }

    @Override
    public Meta4ClientPoolable allocate(Slot slot) throws Exception {
        log.info("Inicio :: Meta4ClientReallocator :: allocate()");
        LoginService loginService = meta4ClientFactory.getLoginServiceFactory().build(LoginService.class);
        IcmWsCalcIncomeService icmWsCalcIncomeService = meta4ClientFactory.getIcmWsCalcIncomeServiceFactory()
                .build(IcmWsCalcIncomeService.class);

        String id = StringUtils.EMPTY;
        Map<String, Cookie> cookies = new HashMap<>();
        try {
            id = loginService.login(meta4ClientFactory.getMeta4ClientCredentials().getUser(),
                    meta4ClientFactory.getMeta4ClientCredentials().getPassword(),
                    meta4ClientFactory.getMeta4ClientCredentials().getLanguage()).getSessionID();
            // TODO
//          List<String> setCookie = CxfUtils.getSetCookie(CxfUtils.getResponseHeaders(loginService));
//          String jSessionID = CxfUtils.getJSessionID(setCookie);
//          CxfUtils.putRequestHeaders(icmWsCalcIncomeService, CxfUtils.mapJSessionID(jSessionID));
//          CxfUtils.putRequestHeaders(icmWsCalcIncomeService, CxfUtils.mapCookie(setCookie));
//          CxfUtils.putCookies(icmWsCalcIncomeService, CxfUtils.cookieJSessionID(jSessionID));
//          CxfUtils.putCookie(icmWsCalcIncomeService, jSessionID);
//          CxfUtils.cloneHeaders(loginService, icmWsCalcIncomeService);
            cookies = CxfUtils.getCookies(loginService);
            CxfUtils.setCookies(icmWsCalcIncomeService, cookies);
            icmWsCalcIncomeService.retrieveM4Session(id);
        } catch (Exception e) {
            log.error("Error :: Meta4ClientReallocator :: allocate()", e);
        }

        Meta4Client client = new Meta4Client();

        Meta4ClientSession session = new Meta4ClientSession();
        session.setId(id);
        session.setCookies(cookies);
        session.setFechaCreacion(LocalDateTime.now());
        client.setSession(session);

        client.setCredentials(meta4ClientFactory.getMeta4ClientCredentials());

        Meta4ClientService service = new Meta4ClientService();
        service.setLoginService(loginService);
        service.setIcmWsCalcIncomeService(icmWsCalcIncomeService);
        client.setService(service);
        log.info("Fin :: Meta4ClientReallocator :: allocate() :: {}", id);
        return new Meta4ClientPoolable(slot, client);
    }

    @Override
    public void deallocate(Meta4ClientPoolable poolable) throws Exception {
        log.info("Inicio :: Meta4ClientReallocator :: deallocate() :: {}", poolable.getSession().getId());
        try {
            if (StringUtils.isNotBlank(poolable.getSession().getId())) {
                poolable.getLoginService().logout();
            }
        } catch (Exception e) {
            log.error("Error :: Meta4ClientReallocator :: deallocate()", e);
        }
        log.info("Fin :: Meta4ClientReallocator :: deallocate() :: {}", poolable.getSession().getId());
    }

    @Override
    public Meta4ClientPoolable reallocate(Slot slot, Meta4ClientPoolable poolable) throws Exception {
        log.info("Inicio :: Meta4ClientReallocator :: reallocate() :: {}", poolable.getSession().getId());
        Meta4ClientPoolable result = allocate(slot);
        log.info("Fin :: Meta4ClientReallocator :: reallocate() :: {}", poolable.getSession().getId());
        return result;
    }

}
