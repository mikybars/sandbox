package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import javax.xml.ws.soap.SOAPFaultException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Retryable;
import stormpot.Pool;
import stormpot.PoolException;
import stormpot.Timeout;

public class Meta4ClientPoolBase {

  private static final String EXPIRE_SESSION_MESSAGE_LOG = "Session caducada (Pool)";

  private static final String ERROR_MESSAGE_LOG = "Error en la llamada a Meta4 con los parametros {}";

  private static final String EXPIRE_SESSION_MESSAGE_EXCEPTION = "Session caducada (Pool) (Exception)";

  private static final String ERROR_MESSAGE_EXCEPTION = "Error en la llamada a Meta4 (Exception)";

  @Value("${app.envars.meta4.config.pool.claimTimeout}")
  public long claimTimeout;

  @Autowired
  private Logger log;

  @Retryable
  protected Meta4ClientPoolable claim(final Pool<Meta4ClientPoolable> pool) {
    this.log.debug("Inicio :: Meta4ClientPoolBase :: pool.claim()");
    Meta4ClientPoolable poolable = null;
    try {
      final Instant start = Instant.now();
      poolable = pool.claim(new Timeout(this.claimTimeout, TimeUnit.MILLISECONDS));
      final Instant end = Instant.now();
      this.log.debug("Meta4ClientPoolBase :: pool.claim(): {}", Duration.between(start, end));
      if (poolable != null) {
        this.uso(poolable);
        this.logSession(poolable.getSession());
      } else {
        this.log.error("Error :: Meta4ClientPoolBase :: pool.claim() :: null");
        throw new Meta4IcmclcwbException(EXPIRE_SESSION_MESSAGE_LOG);
      }
    } catch (final PoolException e) {
      this.throwMeta4IcmclcwbException(e);
    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
      this.throwMeta4IcmclcwbException(e);
    }
    this.log.debug("Fin :: Meta4ClientPoolBase :: pool.claim()");
    return poolable;
  }

  private void throwMeta4IcmclcwbException(final Exception e) {
    final String msg = "Error :: Meta4ClientPoolBase :: pool.claim()";
    this.log.error(msg);
    throw new Meta4IcmclcwbException(msg, e);
  }

  protected void catchException(final Exception e, final Meta4ClientPoolable client, final List<Object> params) {
    if (e.getClass().equals(SOAPFaultException.class) && e.getLocalizedMessage().contains("RET_ERROR_COMM")) {
      this.log.warn(EXPIRE_SESSION_MESSAGE_LOG, e);
      this.expire(client);
      throw new Meta4IcmclcwbException(EXPIRE_SESSION_MESSAGE_EXCEPTION, e);
    } else {
      this.log.error(ERROR_MESSAGE_LOG, params, e);
      throw new Meta4IcmclcwbException(ERROR_MESSAGE_EXCEPTION, e);
    }
  }

  protected void expire(final Meta4ClientPoolable poolable) {
    this.log.warn("Inicio :: Meta4ClientPoolBase :: expire()");
    if (poolable != null) {
      this.log.warn("Inicio :: Meta4ClientPoolBase :: poolable.expire() :: {}", poolable.getSession());
      poolable.expire();
      this.log.warn("Fin :: Meta4ClientPoolBase :: poolable.expire() :: {}", poolable.getSession());
    }
    this.log.warn("Fin :: Meta4ClientPoolBase :: expire()");
  }

  protected void release(final Meta4ClientPoolable poolable) {
    this.log.debug("Inicio :: Meta4ClientPoolBase :: release()");
    if (poolable != null) {
      this.log.debug("Inicio :: Meta4ClientPoolBase :: poolable.release() :: {}", poolable.getSession());
      poolable.release();
      this.log.debug("Fin :: Meta4ClientPoolBase :: poolable.release() :: {}", poolable.getSession());
    }
    this.log.debug("Fin :: Meta4ClientPoolBase :: release()");
  }

  private void uso(final Meta4ClientPoolable poolable) {
    poolable.getSession().setUso(poolable.getSession().getUso() + 1);
    poolable.getSession().setFechaUso(TimeUtils.nowLocalDateTime());
  }

  private void logSession(final Meta4ClientSession session) {
    this.log.debug("Meta4ClientPoolBase :: logSession() :: {}", session);
  }

}
