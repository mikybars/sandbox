package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public class CollectionUtils {

  private CollectionUtils() {
  }

  public static boolean isEmpty(final Collection<? extends Object> coll) {
    return ((coll == null) || coll.isEmpty());
  }

  public static boolean isNotEmpty(final Collection<? extends Object> coll) {
    return !CollectionUtils.isEmpty(coll);
  }

}
