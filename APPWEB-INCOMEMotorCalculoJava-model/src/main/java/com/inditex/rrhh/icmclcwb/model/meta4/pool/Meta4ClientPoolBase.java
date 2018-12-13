package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4Exception;

import stormpot.BlazePool;
import stormpot.Timeout;

public class Meta4ClientPoolBase {

	@Autowired
	private Logger log;

	protected Meta4ClientPoolable claim(final BlazePool<Meta4ClientPoolable> pool) throws InterruptedException {
		log.info("Inicio :: Meta4ClientPoolBase :: :: pool.claim()");
		Instant start = Instant.now();
		Meta4ClientPoolable client = pool.claim(new Timeout(30, TimeUnit.SECONDS));
		Instant end = Instant.now();
		log.info("Fin :: Meta4ClientPoolBase :: :: pool.claim(): {}", Duration.between(start, end));
		if (client != null) {
			uso(client);
			logSession(client.getSession());
		} else {
			if (log.isWarnEnabled()) {
				log.warn("Meta4ClientPoolBase :: pool.claim() :: null");
			}
			throw new Meta4Exception("Session caducada (Pool)");
		}
		return client;
	}

	protected void release(final Meta4ClientPoolable poolable) {
		if (poolable != null) {
			poolable.release();
		}
	}

	private void uso(Meta4ClientPoolable client) {
		client.getSession().setUso(client.getSession().getUso() + 1);
		client.getSession().setFechaUso(LocalDateTime.now());
	}

	private void logSession(Meta4ClientSession session) {
		if (log.isInfoEnabled()) {
			log.info("Meta4ClientPoolBase :: {}", session);
		}
	}

}
