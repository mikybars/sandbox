package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;

import stormpot.Pool;
import stormpot.PoolException;
import stormpot.Timeout;

public class Meta4ClientPoolBase {

	@Auditoria
	protected Meta4ClientPoolable claim(final Pool<Meta4ClientPoolable> pool)
			throws PoolException, InterruptedException {
		Meta4ClientPoolable client = pool.claim(new Timeout(1, TimeUnit.SECONDS));
		uso(client);
		logSession(client.getSession());
		return client;
	}

	@Auditoria
	private void uso(Meta4ClientPoolable client) {
		client.getSession().setUso(client.getSession().getUso() + 1);
		client.getSession().setFechaUso(LocalDateTime.now());
	}

	@Auditoria
	private void logSession(Meta4ClientSession session) {
		System.out.println(session);
	}

}
