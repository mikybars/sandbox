package com.inditex.rrhh.icmclcwb.model.comis.repository;

public class ClientDatabaseContextHolder {

  private static final ThreadLocal<ClientDatabase> CONTEXT = new ThreadLocal<>();

  public static void set(final ClientDatabase clientDatabase) {
    CONTEXT.set(clientDatabase);
  }

  public static ClientDatabase getClientDatabase() {
    return CONTEXT.get();
  }

  public static void clear() {
    CONTEXT.remove();
  }

}
