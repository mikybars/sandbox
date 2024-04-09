package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import jakarta.xml.ws.soap.SOAPFaultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static final Logger LOG = LoggerFactory.getLogger(Meta4ClientPoolBase.class);

  @Retryable
  protected Meta4ClientPoolable claim(final Pool<Meta4ClientPoolable> pool) {
    Meta4ClientPoolBase.LOG.debug("Inicio :: Meta4ClientPoolBase :: pool.claim()");
    Meta4ClientPoolable poolable = null;
    try {
      final Instant start = Instant.now();
      poolable = pool.claim(new Timeout(this.claimTimeout, TimeUnit.MILLISECONDS));
      final Instant end = Instant.now();
      Meta4ClientPoolBase.LOG.debug("Meta4ClientPoolBase :: pool.claim(): {}", Duration.between(start, end));
      if (poolable != null) {
        this.uso(poolable);
        this.logSession(poolable.getSession());
      } else {
        Meta4ClientPoolBase.LOG.error("Error :: Meta4ClientPoolBase :: pool.claim() :: null");
        throw new Meta4IcmclcwbException(EXPIRE_SESSION_MESSAGE_LOG);
      }
    } catch (final PoolException e) {
      this.throwMeta4IcmclcwbException(e);
    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
      this.throwMeta4IcmclcwbException(e);
    }
    Meta4ClientPoolBase.LOG.debug("Fin :: Meta4ClientPoolBase :: pool.claim()");
    return poolable;
  }

  private void throwMeta4IcmclcwbException(final Exception e) {
    final String msg = "Error :: Meta4ClientPoolBase :: pool.claim()";
    Meta4ClientPoolBase.LOG.error(msg);
    throw new Meta4IcmclcwbException(msg, e);
  }

  protected void catchException(final Exception e, final Meta4ClientPoolable client, final List<Object> params) {
    if (e.getClass().equals(SOAPFaultException.class) && e.getLocalizedMessage().contains("RET_ERROR_COMM")) {
      Meta4ClientPoolBase.LOG.warn(EXPIRE_SESSION_MESSAGE_LOG, e);
      this.expire(client);
      throw new Meta4IcmclcwbException(EXPIRE_SESSION_MESSAGE_EXCEPTION, e);
    } else {
      Meta4ClientPoolBase.LOG.error(ERROR_MESSAGE_LOG, params, e);
      throw new Meta4IcmclcwbException(ERROR_MESSAGE_EXCEPTION, e);
    }
  }

  protected void expire(final Meta4ClientPoolable poolable) {
    Meta4ClientPoolBase.LOG.warn("Inicio :: Meta4ClientPoolBase :: expire()");
    if (poolable != null) {
      Meta4ClientPoolBase.LOG.warn("Inicio :: Meta4ClientPoolBase :: poolable.expire() :: {}", poolable.getSession());
      poolable.expire();
      Meta4ClientPoolBase.LOG.warn("Fin :: Meta4ClientPoolBase :: poolable.expire() :: {}", poolable.getSession());
    }
    Meta4ClientPoolBase.LOG.warn("Fin :: Meta4ClientPoolBase :: expire()");
  }

  protected void release(final Meta4ClientPoolable poolable) {
    Meta4ClientPoolBase.LOG.debug("Inicio :: Meta4ClientPoolBase :: release()");
    if (poolable != null) {
      Meta4ClientPoolBase.LOG.debug("Inicio :: Meta4ClientPoolBase :: poolable.release() :: {}", poolable.getSession());
      poolable.release();
      Meta4ClientPoolBase.LOG.debug("Fin :: Meta4ClientPoolBase :: poolable.release() :: {}", poolable.getSession());
    }
    Meta4ClientPoolBase.LOG.debug("Fin :: Meta4ClientPoolBase :: release()");
  }

  private void uso(final Meta4ClientPoolable poolable) {
    poolable.getSession().setUso(poolable.getSession().getUso() + 1);
    poolable.getSession().setFechaUso(TimeUtils.nowLocalDateTime());
  }

  private void logSession(final Meta4ClientSession session) {
    Meta4ClientPoolBase.LOG.debug("Meta4ClientPoolBase :: logSession() :: {}", session);
  }

}
