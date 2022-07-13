package com.inditex.rrhh.icmclcwb.model.comis.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClientDatabase {

  COMIS1("1"), COMIS2("2"), COMIS3("3"), COMIS4("4"), COMIS5("5"), COMIS6("6"), COMIS7("7"), COMIS8("8"),
  COMIS9("9"), COMIS10("10"), COMIS11_8("11_8"), COMIS11_20("11_20"), COMIS11_233("11_233"), COMIS11_28("11_28"),
  COMIS11_33("11_33"), COMIS11_101("11_101"), COMIS11_11("11_11"), COMIS11_2("11_2"), COMIS11_30("11_30"),
  COMIS11_25("11_25"), COMIS18("18"), COMIS28("28"), COMIS30("30"), COMIS32("32"), COMIS38("38"), COMIS39("39"),
  COMIS52("52"), COMIS60("60"), COMIS61("61"), COMIS63("63"), COMIS64("64"), COMIS66("66"), COMIS68("68"), COMIS70("70"),
  COMIS72("72"), COMIS73("73"), COMIS75("75"), COMIS79("79"), COMIS91("91"), COMIS92("92"), COMIS93("93"), COMIS95("95"), COMIS96("96"),
  COMIS97("97"),
  COMIS98("98"), COMIS139("139"), COMIS388("388"), COMIS400("400"), COMIS404("404"), COMIS412("412"),
  COMIS508("508"), COMIS512("512"), COMIS524("524"), COMIS528("528"), COMIS664("664"), COMIS720("720"),
  COMIS728("728"), COMIS732("732"), COMIS736("736"), COMIS740("740"), COMIS743("743"), COMIS800("800");

  private final String id;

  public static ClientDatabase getClient(final String value) {
    for (final ClientDatabase e : ClientDatabase.values()) {
      if (e.id.equals(value)) {
        return e;
      }
    }
    return null;
  }

}
