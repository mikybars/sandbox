
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GETVENTAMANUALWLOCReturn" type="{http://schemas.meta4.com/}GetventamanualwlocOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getventamanualwlocReturn"
})
@XmlRootElement(name = "GETVENTAMANUALWLOCResponse")
public class GETVENTAMANUALWLOCResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "GETVENTAMANUALWLOCReturn", required = true)
  protected GetventamanualwlocOutput getventamanualwlocReturn;

  /**
   * Obtiene el valor de la propiedad getventamanualwlocReturn.
   *
   * @return possible object is {@link GetventamanualwlocOutput }
   *
   */
  public GetventamanualwlocOutput getGETVENTAMANUALWLOCReturn() {
    return getventamanualwlocReturn;
  }

  /**
   * Define el valor de la propiedad getventamanualwlocReturn.
   *
   * @param value allowed object is {@link GetventamanualwlocOutput }
   *
   */
  public void setGETVENTAMANUALWLOCReturn(GetventamanualwlocOutput value) {
    this.getventamanualwlocReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETVENTAMANUALWLOCResponse that = ((GETVENTAMANUALWLOCResponse) object);
    {
      GetventamanualwlocOutput lhsGETVENTAMANUALWLOCReturn;
      lhsGETVENTAMANUALWLOCReturn = this.getGETVENTAMANUALWLOCReturn();
      GetventamanualwlocOutput rhsGETVENTAMANUALWLOCReturn;
      rhsGETVENTAMANUALWLOCReturn = that.getGETVENTAMANUALWLOCReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "getventamanualwlocReturn", lhsGETVENTAMANUALWLOCReturn),
          LocatorUtils.property(thatLocator, "getventamanualwlocReturn", rhsGETVENTAMANUALWLOCReturn), lhsGETVENTAMANUALWLOCReturn,
          rhsGETVENTAMANUALWLOCReturn, (this.getventamanualwlocReturn != null), (that.getventamanualwlocReturn != null))) {
        return false;
      }
    }
    return true;
  }

  public boolean equals(Object object) {
    final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
    return equals(null, null, object, strategy);
  }

  public String toString() {
    final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
    final StringBuilder buffer = new StringBuilder();
    append(null, buffer, strategy);
    return buffer.toString();
  }

  public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
    strategy.appendStart(locator, this, buffer);
    appendFields(locator, buffer, strategy);
    strategy.appendEnd(locator, this, buffer);
    return buffer;
  }

  public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
    {
      GetventamanualwlocOutput theGETVENTAMANUALWLOCReturn;
      theGETVENTAMANUALWLOCReturn = this.getGETVENTAMANUALWLOCReturn();
      strategy.appendField(locator, this, "getventamanualwlocReturn", buffer, theGETVENTAMANUALWLOCReturn,
          (this.getventamanualwlocReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      GetventamanualwlocOutput theGETVENTAMANUALWLOCReturn;
      theGETVENTAMANUALWLOCReturn = this.getGETVENTAMANUALWLOCReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getventamanualwlocReturn", theGETVENTAMANUALWLOCReturn),
          currentHashCode, theGETVENTAMANUALWLOCReturn, (this.getventamanualwlocReturn != null));
    }
    return currentHashCode;
  }

  public int hashCode() {
    final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
    return this.hashCode(null, strategy);
  }

  public Object clone() {
    return copyTo(createNewInstance());
  }

  public Object copyTo(Object target) {
    final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
    return copyTo(null, target, strategy);
  }

  public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
    final Object draftCopy = ((target == null) ? createNewInstance() : target);
    if (draftCopy instanceof GETVENTAMANUALWLOCResponse) {
      final GETVENTAMANUALWLOCResponse copy = ((GETVENTAMANUALWLOCResponse) draftCopy);
      {
        Boolean getventamanualwlocReturnShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.getventamanualwlocReturn != null));
        if (getventamanualwlocReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          GetventamanualwlocOutput sourceGETVENTAMANUALWLOCReturn;
          sourceGETVENTAMANUALWLOCReturn = this.getGETVENTAMANUALWLOCReturn();
          GetventamanualwlocOutput copyGETVENTAMANUALWLOCReturn = ((GetventamanualwlocOutput) strategy.copy(
              LocatorUtils.property(locator, "getventamanualwlocReturn", sourceGETVENTAMANUALWLOCReturn), sourceGETVENTAMANUALWLOCReturn,
              (this.getventamanualwlocReturn != null)));
          copy.setGETVENTAMANUALWLOCReturn(copyGETVENTAMANUALWLOCReturn);
        } else {
          if (getventamanualwlocReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.getventamanualwlocReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETVENTAMANUALWLOCResponse();
  }

}
