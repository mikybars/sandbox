package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetausenciasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcadenaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchdiasminimosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchtpventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfpreciohoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosdesplazOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructurascomOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestosrangoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestoswlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetventacongeladaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SaveprocesoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;

import stormpot.BlazePool;
import stormpot.Config;
import stormpot.Timeout;

public class Meta4ClientPool extends Meta4ClientPoolBase {

    private static final Logger log = LoggerFactory.getLogger(Meta4ClientPool.class);

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
            pool.shutdown()
                .await(new Timeout(meta4ClientFactory.getMeta4ClientProperties().getShutdownTimeout(),
                        TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        }
        log.info("Fin :: Meta4ClientPool :: close()");
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetempleadosdesplazOutput getempleadosdesplaz(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleadosdesplaz(param2, param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetorigenesOutput getorigenes(IcmParamcalsociedadBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getorigenes(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetempresasOutput getempresas(IcmParamcalorigenBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempresas(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }


    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetcadenaOutput getcadena(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getcadena(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetconfprodventaOutput getconfprodventa(IcmParametrosentradaBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfprodventa(param2, param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
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
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetagruponlineOutput getagruponline(IcmParamcalorigenBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getagruponline(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
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
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
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
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
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
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
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
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
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
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetperiodosOutput getperiodos(IcmParamcalperiodoBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getperiodos(param2, param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetempleadosOutput getempleados(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getempleados(param2, param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetestructurascomOutput getestructurascom(IcmParamcalestructuraBlock param1) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getestructurascom(param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetestructuraspolOutput getestructuraspol(IcmParamcalestructuraBlock param1) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getestructuraspol(param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }


    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public SearchtiendasOutput searchtiendas(IcmParametrosentradaBlock param1, IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchtiendas(param2, param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GettiendasincomeOutput gettiendasincome(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasincome(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GettiendasonlineOutput gettiendasonline(IcmParametrospaginacionBlock param1,
            IcmParametrosentradaBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().gettiendasonline(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public SearchempleadosOutput searchempleados(IcmParametrospaginacionBlock param1,
            IcmParamcalempleadoBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().searchempleados(param2, param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public SaveprocesoOutput saveproceso(IcmParamcalprocesoBlock param) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().saveproceso(param);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetausenciasOutput getausencias(IcmParametrospaginacionBlock param1, IcmParamcalempleadoBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getausencias(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetconfiguracionOutput getconfiguracion(IcmParamcalconforigenBlock param) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfiguracion(param);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetconfchdiasminimosOutput getconfchdiasminimos(IcmParamcalconfchdiasBlock param) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfchdiasminimos(param);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetpresupuestoswlocOutput getpresupuestoswloc(IcmParamcalpresupuestoswlocBlock param1,
            IcmParametrospaginacionBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getpresupuestoswloc(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetconfpreciohoraOutput getconfpreciohora(IcmParamcalconfpreciohoraBlock param) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfpreciohora(param);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetconfchtpventaOutput getconfchtpventa(IcmParamcalconfchventaBlock param) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getconfchtpventa(param);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetpresupuestosrangoOutput getpresupuestosrango(IcmParametrospaginacionBlock param1,
            IcmParamcalpresupuestosrangoBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getpresupuestosrango(param2, param1);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

    @Retryable(maxAttemptsExpression = "#{${app.envars.meta4.config.max-attempts}}")
    public GetventacongeladaOutput getventacongelada(IcmParametrospaginacionBlock param1,
            IcmParamcalventacongeladaBlock param2) {
        Meta4ClientPoolable client = claim(pool);
        try {
            return client.getIcmWsCalcIncomeService().getventacongelada(param1, param2);
        } catch (Exception e) {
            catchException(e, client, Arrays.asList(param1, param2));
            throw new Meta4IcmclcwbException(e.getMessage(), e);
        } finally {
            release(client);
        }
    }

}
