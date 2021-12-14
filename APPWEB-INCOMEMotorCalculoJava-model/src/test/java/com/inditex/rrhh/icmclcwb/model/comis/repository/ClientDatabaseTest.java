package com.inditex.rrhh.icmclcwb.model.comis.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ClientDatabaseTest {

  @Test
  void getClientTest() {
    assertEquals(ClientDatabase.COMIS720, ClientDatabase.getClient("720"));
    assertEquals(null, ClientDatabase.getClient("99999999"));
  }

}
