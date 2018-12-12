package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import stormpot.Pool;
import stormpot.Timeout;

public class Meta4ClientPoolBase {

    @Autowired
    private Logger log;

    protected Meta4ClientPoolable claim(final Pool<Meta4ClientPoolable> pool)
            throws InterruptedException {
        Meta4ClientPoolable client = pool.claim(new Timeout(1, TimeUnit.SECONDS));
        uso(client);
        logSession(client.getSession());
        return client;
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
