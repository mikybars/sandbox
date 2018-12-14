package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import stormpot.Expiration;
import stormpot.SlotInfo;

public class Meta4ClientExpiration implements Expiration<Meta4ClientPoolable> {

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
			System.out.println("Error no controlado :: hasExpired(): " + e.getMessage());
		}
		if (expired) {
			System.out.println("La session " + session + " ha caducado");
		} else {
			System.out.println("La session " + session + " sigue activa");
		}
		return expired;
	}

}
