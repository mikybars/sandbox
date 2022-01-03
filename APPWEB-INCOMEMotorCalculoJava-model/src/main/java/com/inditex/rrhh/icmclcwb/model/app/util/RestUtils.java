package com.inditex.rrhh.icmclcwb.model.app.util;

import com.inditex.aqsw.framework.common.rest.client.RestClient;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestUtils {

  private RestUtils() {
  }

  public static <T, R> T checkResponse(ResponseEntity<T> responseEntity, RestClient restClient, String url,
      Object request) {
    T result = null;
    if (responseEntity != null) {
      if (responseEntity.getStatusCode().value() == HttpStatus.SC_OK) {
        result = responseEntity.getBody();
      } else {
        throw new IcmclcwbException(new StringBuilder("La llamada a '").append(restClient.getBaseUrl())
            .append(url)
            .append("' ha fallado (Código: ")
            .append(responseEntity.getStatusCode().value())
            .append(") con la petición: ")
            .append(request.toString())
            .toString());
      }
    } else {
      throw new IcmclcwbException(new StringBuilder("La llamada a '").append(restClient.getBaseUrl())
          .append(url)
          .append("' ha fallado con la petición: ")
          .append(request.toString())
          .toString());
    }
    return result;
  }

}
