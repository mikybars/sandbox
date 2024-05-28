package com.inditex.rrhh.icmclcwb.model.app.util;

import com.inditex.amigafwk.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestUtils {

  private RestUtils() {
  }

  public static <T, R> T checkResponse(final ResponseEntity<T> responseEntity, final RestClient restClient, final String url,
      final Object request) {
    T result = null;
    if (responseEntity != null) {
      if (responseEntity.getStatusCode().value() == HttpStatus.SC_OK) {
        result = responseEntity.getBody();
      } else {
        throw new IcmclcwbException("La llamada a '"
            + restClient.getBaseUrl()
            + url
            + "' ha fallado (Código: "
            + responseEntity.getStatusCode().value()
            + ") con la petición: "
            + request.toString());
      }
    } else {
      throw new IcmclcwbException("La llamada a '"
          + restClient.getBaseUrl()
          + url
          + "' ha fallado con la petición: "
          + request.toString());
    }
    return result;
  }

}
