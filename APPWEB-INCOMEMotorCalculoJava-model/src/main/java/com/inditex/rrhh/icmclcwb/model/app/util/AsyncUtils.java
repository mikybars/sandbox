package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;

@Component
public class AsyncUtils {

    private AsyncUtils() {
    }

    public static void checkAsyncAvaliable(final List<CompletableFuture<Void>> cfList) {
        CompletableFuture.anyOf(cfList.toArray(new CompletableFuture[cfList.size()]));
        Map<Boolean, List<CompletableFuture<Void>>> resultPersistence = cfList.stream()
                .collect(Collectors.partitioningBy(CompletableFuture::isDone));
        List<CompletableFuture<Void>> cfDone = resultPersistence.values().stream().flatMap(List::stream)
                .collect(Collectors.toList());
        cfList.removeAll(cfDone);
    }

    public static void exceptionally(final CompletableFuture<?> cf,
            final List<CompletableFuture<?>> cfList) {
        cfList.add(cf);
        cf.exceptionally(e -> {
            cfList.stream().forEach(item -> {
                if (!item.isDone()) {
                    item.cancel(true);
                }
            });
            return null;
        });
    }

    public static boolean isOk(final List<CompletableFuture<?>> cfList) {
        boolean result = true;
        for (CompletableFuture<?> item : cfList) {
            if (item.isCompletedExceptionally()) {
                throw new ApplicationException("AsyncUtils.isOk() == false");
            }
            // TODO Si ha finalizado OK, se elimina de la lista para no verificarlo siempre.
        }
        return result;
    }

}