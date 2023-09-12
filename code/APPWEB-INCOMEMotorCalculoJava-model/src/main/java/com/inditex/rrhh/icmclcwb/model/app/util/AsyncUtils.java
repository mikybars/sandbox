package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.exception.AsyncIcmclcwbException;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

@Component
public class AsyncUtils {

  private AsyncUtils() {
  }

  public static void checkAsyncAvaliable(final List<CompletableFuture<?>> cfList, final Integer maxSize) {
    if (cfList.size() >= maxSize.intValue()) {
      AsyncUtils.waitAnyOfIsOk(cfList, cfList);
    }
  }

  public static void exceptionally(final CompletableFuture<?> cf, final List<CompletableFuture<?>> cfList,
      final List<CompletableFuture<?>> cfListOptional) {
    cfListOptional.add(cf);
    AsyncUtils.exceptionally(cf, cfList);
  }

  public static void exceptionally(final CompletableFuture<?> cf, final List<CompletableFuture<?>> cfList) {
    cfList.add(cf);
    cf.exceptionally(e -> {
      AsyncUtils.cancel(cfList);
      return null;
    });
  }

  public static void cancel(final List<CompletableFuture<?>> cfList) {
    cfList.stream().forEach(item -> {
      if (!item.isDone()) {
        item.cancel(true);
      }
    });
  }

  public static void isOk(final List<CompletableFuture<?>> cfList) {
    final List<CompletableFuture<?>> cfListRemove = new ArrayList<>();
    for (final CompletableFuture<?> item : cfList) {
      if (item.isCompletedExceptionally()) {
        throw new AsyncIcmclcwbException("AsyncUtils.isOk() == false");
      } else if (item.isDone()) {
        cfListRemove.add(item);
      }
    }
    if (CollectionUtils.isNotEmpty(cfListRemove)) {
      cfList.removeAll(cfListRemove);
    }
  }

  public static void waitAnyOfIsOk(final List<CompletableFuture<?>> cfList, final CompletableFuture<?>... cfWait) {
    if (CollectionUtils.isNotEmpty(cfList) && ArrayUtils.isEmpty(cfWait)) {
      throw new AsyncIcmclcwbException("Error al esperar por llamadas asincronas");
    }
    CompletableFuture.anyOf(cfWait).join();
    AsyncUtils.isOk(cfList);
  }

  public static void waitAnyOfIsOk(final List<CompletableFuture<?>> cfList, final List<CompletableFuture<?>> cfWait) {
    if (CollectionUtils.isNotEmpty(cfList) && CollectionUtils.isEmpty(cfWait)) {
      throw new AsyncIcmclcwbException("Error al esperar por llamadas asincronas");
    }
    AsyncUtils.waitAnyOfIsOk(cfList, cfWait.toArray(new CompletableFuture[cfWait.size()]));
    AsyncUtils.isOk(cfWait);
  }

  public static void waitAllOfIsOk(final List<CompletableFuture<?>> cfList, final CompletableFuture<?>... cfWait) {
    if (CollectionUtils.isNotEmpty(cfList) && ArrayUtils.isEmpty(cfWait)) {
      throw new AsyncIcmclcwbException("Error al esperar por llamadas asincronas");
    }
    CompletableFuture.allOf(cfWait).join();
    AsyncUtils.isOk(cfList);
  }

  public static void waitAllOfIsOk(final List<CompletableFuture<?>> cfList, final List<CompletableFuture<?>> cfWait) {
    if (CollectionUtils.isNotEmpty(cfList) && CollectionUtils.isEmpty(cfWait)) {
      throw new AsyncIcmclcwbException("Error al esperar por llamadas asincronas");
    }
    AsyncUtils.waitAllOfIsOk(cfList, cfWait.toArray(new CompletableFuture[cfWait.size()]));
    AsyncUtils.isOk(cfWait);
  }

  public static <T> T get(final CompletableFuture<T> cf) {
    try {
      return cf.get();
    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new AsyncIcmclcwbException("Error al recuperar los datos asincronamente", e);
    } catch (final ExecutionException e) {
      throw new AsyncIcmclcwbException("Error al recuperar los datos asincronamente", e);
    }
  }

}
