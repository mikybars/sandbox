package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MigrationDispatcher {

  private final MigrationMode mode;

  private final Executor migrationExecutor;

  public MigrationDispatcher(
      @Value("${app.envars.meta4.icmwscalcincome.migration-mode:shadow}") String migrationValue,
      @Qualifier("meta4MigrationExecutor") Executor migrationExecutor) {
    this.mode = MigrationMode.from(migrationValue);
    this.migrationExecutor = migrationExecutor;
  }

  public <T> T dispatch(String operationName, Supplier<T> restCall, Supplier<T> soapCall) {
    return switch (mode) {
      case SHADOW -> {
        log.debug("Shadowing endpoint {}", operationName);

        T soapResult = soapCall.get();

        CompletableFuture.supplyAsync(restCall, migrationExecutor)
            .thenAccept(restResult -> {
              // TODO: compare restResult with soapResult and log discrepancies
              log.debug("Shadow REST call completed for {}", operationName);
            })
            .exceptionally(error -> {
              log.warn("Shadow REST call failed for {}: {}", operationName, error.getMessage());
              return null;
            });

        yield soapResult;
      }
      case REST -> restCall.get();
    };
  }

}
