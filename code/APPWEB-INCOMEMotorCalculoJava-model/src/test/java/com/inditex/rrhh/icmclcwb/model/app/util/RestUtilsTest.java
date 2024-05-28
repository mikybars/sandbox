package com.inditex.rrhh.icmclcwb.model.app.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RestUtilsTest {

  private RestClient restClient;

  @BeforeEach
  public void setup() {
    this.restClient = mock(RestClient.class);
    when(this.restClient.getBaseUrl()).thenReturn("http://localhost:8080");
  }

  @Test
  public void checkResponseShouldReturnResponseBodyWhenStatusIsOk() {
    final ResponseEntity<String> responseEntity = new ResponseEntity<>("Success", HttpStatus.OK);
    final String result = RestUtils.checkResponse(responseEntity, this.restClient, "/test", "request");
    assertEquals("Success", result);
  }

  @Test
  public void checkResponseShouldThrowExceptionWhenStatusIsNotOk() {
    final ResponseEntity<String> responseEntity = new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
    assertThrows(IcmclcwbException.class, () -> RestUtils.checkResponse(responseEntity, this.restClient, "/test", "request"));
  }

  @Test
  public void checkResponseShouldThrowExceptionWhenResponseEntityIsNull() {
    assertThrows(IcmclcwbException.class, () -> RestUtils.checkResponse(null, this.restClient, "/test", "request"));
  }
}
