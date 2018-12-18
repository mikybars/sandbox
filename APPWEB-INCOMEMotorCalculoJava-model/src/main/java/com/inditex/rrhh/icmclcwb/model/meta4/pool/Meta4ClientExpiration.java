package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import stormpot.Expiration;
import stormpot.SlotInfo;

public class Meta4ClientExpiration implements Expiration<Meta4ClientPoolable> {

    private static final Logger log = LoggerFactory.getLogger(Meta4ClientExpiration.class);
    
	@Override
	public boolean hasExpired(SlotInfo<? extends Meta4ClientPoolable> info) throws Exception {
		boolean expired = true;
		String session = StringUtils.EMPTY;
		try {
			// TODO Podriamos verificar solo cada cierto tiempo
			Meta4ClientPoolable meta4ClientPoolable = info.getPoolable();
			session = meta4ClientPoolable.getSession().getId();
			int result = meta4ClientPoolable.getLoginService().retrieveM4Session(session);
			if(result == 0) {
				expired = false;
			}
		} catch (Exception e) {
		    log.error("Error no controlado :: hasExpired(): ", e);
		}
		if (expired) {
		    log.warn("La session {} ha caducado", session);
		} else {
		    log.info("La session {} sigue activa", session);
		}
		return expired;
	}

}
