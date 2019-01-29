package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Retryable;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4Exception;
import stormpot.BlazePool;
import stormpot.Timeout;

public class Meta4ClientPoolBase {

	@Value("${app.envars.meta4.config.pool.claimTimeout}")
	public long claimTimeout;

	@Autowired
	private Logger log;

	@Retryable
	protected Meta4ClientPoolable claim(final BlazePool<Meta4ClientPoolable> pool) throws InterruptedException {
		log.debug("Inicio :: Meta4ClientPoolBase :: pool.claim()");
		Instant start = Instant.now();
		Meta4ClientPoolable poolable = pool.claim(new Timeout(claimTimeout, TimeUnit.MILLISECONDS));
		Instant end = Instant.now();
		log.debug("Fin :: Meta4ClientPoolBase :: pool.claim(): {}", Duration.between(start, end));
		if (poolable != null) {
			uso(poolable);
			logSession(poolable.getSession());
		} else {
			log.error("Error :: Meta4ClientPoolBase :: pool.claim() :: null");
			throw new Meta4Exception("Session caducada (Pool)");
		}
		return poolable;
	}

	protected void expire(final Meta4ClientPoolable poolable) {
		log.warn("Inicio :: Meta4ClientPoolBase :: expire()");
		if (poolable != null) {
			log.warn("Inicio :: Meta4ClientPoolBase :: poolable.expire() :: {}", poolable.getSession());
			poolable.expire();
			log.warn("Fin :: Meta4ClientPoolBase :: poolable.expire() :: {}", poolable.getSession());
		}
		log.warn("Fin :: Meta4ClientPoolBase :: expire()");
	}

	protected void release(final Meta4ClientPoolable poolable) {
		log.debug("Inicio :: Meta4ClientPoolBase :: release()");
		if (poolable != null) {
			log.debug("Inicio :: Meta4ClientPoolBase :: poolable.release() :: {}", poolable.getSession());
			poolable.release();
			log.debug("Fin :: Meta4ClientPoolBase :: poolable.release() :: {}", poolable.getSession());
		}
		log.debug("Fin :: Meta4ClientPoolBase :: release()");
	}

	private void uso(final Meta4ClientPoolable poolable) {
		poolable.getSession().setUso(poolable.getSession().getUso() + 1);
		poolable.getSession().setFechaUso(LocalDateTime.now());
	}

	private void logSession(final Meta4ClientSession session) {
		log.info("Meta4ClientPoolBase :: logSession() :: {}", session);
	}

}
