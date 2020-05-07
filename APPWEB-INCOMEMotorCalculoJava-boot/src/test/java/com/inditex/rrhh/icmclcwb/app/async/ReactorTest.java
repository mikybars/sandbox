package com.inditex.rrhh.icmclcwb.app.async;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class ReactorTest {

    @Autowired
    private Logger log;

    private final static List<String> algoritmos = new ArrayList<>();

    private final static List<String> personas = new ArrayList<>();

    private final static String prefijoAlgoritmo = "algoritmo-";

    private final static String prefijoPersona = "persona-";

    private void run(String... args) {
        List<String> items = Arrays.asList(args);
        log.info("Inicio :: run() :: {}", items);
        TestUtils.threadSleep();
        if (items.contains("persona-4") || items.contains("persona-7")) {
            log.error("Ha fallado el bloque: {}", items);
            new ReactorIcmclcwbException("Ha fallado el bloque:");
        }
        log.info("Fin :: run() :: {}", items);
    }

    @Before
    public void setUp() {
        for (int x = 0; x < 20; x++) {
            algoritmos.add(prefijoAlgoritmo + x);
        }
        for (int x = 0; x < 1000; x++) {
            personas.add(prefijoPersona + x);
        }
    }

    @Ignore
    @Test
    public void reactorSequentialBlockLastTest() {
        log.info("Inicio :: ReactorSequentialBlockLastTest");
        final Instant start = Instant.now();
        Flux.fromIterable(personas).log().parallel().runOn(Schedulers.parallel()).doOnNext(item -> {
            log.info("ReactorSequentialBlockLastTest :: doOnNext() :: {}", item);
        }).map(item -> {
            log.info("ReactorSequentialBlockLastTest :: Inicio :: map() :: {}", item);
            run(item);
            log.info("ReactorSequentialBlockLastTest :: Fin :: map() :: {}", item);
            return Flux.empty();
        }).sequential().blockLast();
        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        log.info("Fin :: ReactorSequentialBlockLastTest :: {}", duration);
    }

    @Ignore
    @Test
    public void reactorSequentialCollectListBlockTest() {
        log.info("Inicio :: reactorSequentialCollectListBlockTest");
        final Instant start = Instant.now();
        Flux.fromIterable(personas).log().parallel().runOn(Schedulers.parallel()).doOnNext(item -> {
            log.info("reactorSequentialCollectListBlockTest :: doOnNext() :: {}", item);
        }).map(item -> {
            log.info("reactorSequentialCollectListBlockTest :: Inicio :: map() :: {}", item);
            run(item);
            log.info("reactorSequentialCollectListBlockTest :: Fin :: map() :: {}", item);
            return Flux.empty();
        }).sequential().collectList().block();
        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        log.info("Fin :: reactorSequentialCollectListBlockTest :: {}", duration);
    }

    @Ignore
    @Test
    public void reactorSequentialCollectListBlockTestWithChild() {
        log.info("Inicio :: reactorSequentialCollectListBlockTestWithChild");
        final Instant start = Instant.now();

        Flux.fromIterable(algoritmos).log().parallel().runOn(ItxSchedulers.elastic()).doOnNext(item -> {
            log.info("reactorSequentialCollectListBlockTest :: algoritmos :: doOnNext() :: {}", item);
        }).map(algoritmo -> {
            log.info("reactorSequentialCollectListBlockTest :: algoritmos :: Inicio :: map() :: {}", algoritmo);

            Flux.fromIterable(StreamUtils.partition(personas, 100))
                .log()
                .parallel()
                .runOn(ItxSchedulers.elastic())
                .doOnNext(partitionPersonas -> {
                    log.info(
                            "reactorSequentialCollectListBlockTestWithChild :: partitionPersonas :: doOnNext() :: {}",
                            partitionPersonas);
                })
                .map(partitionPersonas -> {
                    log.info(
                            "reactorSequentialCollectListBlockTestWithChild :: partitionPersonas :: Inicio :: map() :: {}",
                            partitionPersonas);
                    run(partitionPersonas.toArray(new String[partitionPersonas.size()]));
                    log.info(
                            "reactorSequentialCollectListBlockTestWithChild :: partitionPersonas :: Fin :: map() :: {}",
                            partitionPersonas);
                    return Flux.empty();
                })
                .sequential()
                .collectList()
                .block();

            log.info("reactorSequentialCollectListBlockTest :: algoritmos :: Fin :: map() :: {}", algoritmo);
            return Flux.empty();
        }).sequential().collectList().block();

        final Instant end = Instant.now();
        final Duration duration = Duration.between(start, end);
        log.info("Fin :: reactorSequentialCollectListBlockTestWithChild :: {}", duration);
    }

}
