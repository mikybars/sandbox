
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="retrieveM4SessionReturn" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "retrieveM4SessionReturn"
})
@XmlRootElement(name = "retrieveM4SessionResponse")
public class RetrieveM4SessionResponse implements Serializable, Cloneable {

  // TODO: Revisar esto

  private final static long serialVersionUID = 1L;

  /**
   * -- GETTER -- Gets the value of the retrieveM4SessionReturn property.
   */
  protected int retrieveM4SessionReturn;

  /**
   * Sets the value of the retrieveM4SessionReturn property.
   *
   */
  public void setRetrieveM4SessionReturn(final int value) {
    this.retrieveM4SessionReturn = value;
  }

}
