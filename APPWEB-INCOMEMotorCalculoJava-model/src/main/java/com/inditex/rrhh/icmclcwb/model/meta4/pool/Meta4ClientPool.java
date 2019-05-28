package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4Exception;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcomisionempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;

import stormpot.BlazePool;
import stormpot.Config;
import stormpot.Timeout;

public class Meta4ClientPool extends Meta4ClientPoolBase {

    private static final Logger log = LoggerFactory.getLogger(Meta4ClientPool.class);

    private static final String ERROR_MESSAGE_LOG = "Error en la llamada a Meta4";

    private static final String ERROR_MESSAGE_EXCEPTION = "Session caducada (Pool) (Exception)";

    private final Meta4ClientFactory meta4ClientFactory;

    private final BlazePool<Meta4ClientPoolable> pool;

    public Meta4ClientPool(Meta4ClientFactory meta4ClientFactory) {
        this.meta4ClientFactory = meta4ClientFactory;
        Meta4ClientReallocator allocator = new Meta4ClientReallocator(meta4ClientFactory);
        Config<Meta4ClientPoolable> config = new Config<>();
        config.setAllocator(allocator);
        config.setSize(meta4ClientFactory.getMeta4ClientProperties().getSize());
        config.setExpiration(new Meta4ClientExpiration());
        this.pool = new BlazePool<>(config);
    }

    public void close() {
        log.info("Inicio :: Meta4ClientPool :: close()");
        try {
            pool.shutdown().await(new Timeout(meta4ClientFactory.getMeta4ClientProperties().getShutdownTimeout(),
                    TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new Meta4Exception(e.getMessage(), e);
        }
        log.info("Fin :: Meta4ClientPool :: close()");
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetconfprodventaOutput getconfprodventa(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfprodventa(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetconfventaonlineOutput getconfventaonline(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfventaonline(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetagruponlineOutput getagruponline(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getagruponline(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetflagcalculaOutput getflagcalcula(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getflagcalcula(param2, param1);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetcoefjornadaOutput getcoefjornada(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getcoefjornada(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetfestivosOutput getfestivos(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getfestivos(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetpresenciamanualOutput getpresenciamanual(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getpresenciamanual(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetempleadospresenciaOutput getempleadospresencia(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleadospresencia(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetperiodosOutput getperiodos(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getperiodos(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetempleadosOutput getempleados(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleados(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetcomisionempleadoOutput getcomisionempleado(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getcomisionempleado(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GettiendasempleadoOutput gettiendasempleado(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasempleado(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public SearchtiendasOutput searchtiendas(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchtiendas(param1, param2);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GettiendasincomeOutput gettiendasincome(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasincome(param2, param1);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public SearchempleadosOutput searchempleados(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchempleados(param2, param1);
        } catch (Exception e) {
            log.warn(ERROR_MESSAGE_LOG, e);
            expire(client);
            throw new Meta4Exception(ERROR_MESSAGE_EXCEPTION, e);
        } finally {
            release(client);
        }
    }

}
