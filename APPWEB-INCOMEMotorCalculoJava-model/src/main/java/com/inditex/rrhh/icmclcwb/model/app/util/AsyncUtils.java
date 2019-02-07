package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.AsyncIcmclcwbException;

@Component
public class AsyncUtils {

    private AsyncUtils() {
    }

    public static void checkAsyncAvaliable(final List<CompletableFuture<?>> cfList, Integer maxSize) {
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
        for (CompletableFuture<?> item : cfList) {
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
        CompletableFuture.anyOf(cfWait).join();
        AsyncUtils.isOk(cfList);
    }

    public static void waitAnyOfIsOk(final List<CompletableFuture<?>> cfList, final List<CompletableFuture<?>> cfWait) {
        AsyncUtils.waitAnyOfIsOk(cfList, cfWait.toArray(new CompletableFuture[cfWait.size()]));
        AsyncUtils.isOk(cfWait);
    }

    public static void waitAllOfIsOk(final List<CompletableFuture<?>> cfList, final CompletableFuture<?>... cfWait) {
        CompletableFuture.allOf(cfWait).join();
        AsyncUtils.isOk(cfList);
    }

    public static void waitAllOfIsOk(final List<CompletableFuture<?>> cfList, final List<CompletableFuture<?>> cfWait) {
        AsyncUtils.waitAllOfIsOk(cfList, cfWait.toArray(new CompletableFuture[cfWait.size()]));
        AsyncUtils.isOk(cfWait);
    }

}
