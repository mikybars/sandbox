
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
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GETEMPLEADOSPRESENCIAReturn" type="{http://schemas.meta4.com/}GetempleadospresenciaOutput"/&gt;
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
    "getempleadospresenciaReturn"
})
@XmlRootElement(name = "GETEMPLEADOSPRESENCIAResponse")
public class GETEMPLEADOSPRESENCIAResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "GETEMPLEADOSPRESENCIAReturn", required = true)
  protected GetempleadospresenciaOutput getempleadospresenciaReturn;

  /**
   * Gets the value of the getempleadospresenciaReturn property.
   *
   * @return possible object is {@link GetempleadospresenciaOutput }
   *
   */
  public GetempleadospresenciaOutput getGETEMPLEADOSPRESENCIAReturn() {
    return getempleadospresenciaReturn;
  }

  /**
   * Sets the value of the getempleadospresenciaReturn property.
   *
   * @param value allowed object is {@link GetempleadospresenciaOutput }
   *
   */
  public void setGETEMPLEADOSPRESENCIAReturn(GetempleadospresenciaOutput value) {
    this.getempleadospresenciaReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETEMPLEADOSPRESENCIAResponse that = ((GETEMPLEADOSPRESENCIAResponse) object);
    {
      GetempleadospresenciaOutput lhsGETEMPLEADOSPRESENCIAReturn;
      lhsGETEMPLEADOSPRESENCIAReturn = this.getGETEMPLEADOSPRESENCIAReturn();
      GetempleadospresenciaOutput rhsGETEMPLEADOSPRESENCIAReturn;
      rhsGETEMPLEADOSPRESENCIAReturn = that.getGETEMPLEADOSPRESENCIAReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "getempleadospresenciaReturn", lhsGETEMPLEADOSPRESENCIAReturn),
          LocatorUtils.property(thatLocator, "getempleadospresenciaReturn", rhsGETEMPLEADOSPRESENCIAReturn), lhsGETEMPLEADOSPRESENCIAReturn,
          rhsGETEMPLEADOSPRESENCIAReturn, (this.getempleadospresenciaReturn != null), (that.getempleadospresenciaReturn != null))) {
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
      GetempleadospresenciaOutput theGETEMPLEADOSPRESENCIAReturn;
      theGETEMPLEADOSPRESENCIAReturn = this.getGETEMPLEADOSPRESENCIAReturn();
      strategy.appendField(locator, this, "getempleadospresenciaReturn", buffer, theGETEMPLEADOSPRESENCIAReturn,
          (this.getempleadospresenciaReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      GetempleadospresenciaOutput theGETEMPLEADOSPRESENCIAReturn;
      theGETEMPLEADOSPRESENCIAReturn = this.getGETEMPLEADOSPRESENCIAReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getempleadospresenciaReturn", theGETEMPLEADOSPRESENCIAReturn),
          currentHashCode, theGETEMPLEADOSPRESENCIAReturn, (this.getempleadospresenciaReturn != null));
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
    if (draftCopy instanceof GETEMPLEADOSPRESENCIAResponse) {
      final GETEMPLEADOSPRESENCIAResponse copy = ((GETEMPLEADOSPRESENCIAResponse) draftCopy);
      {
        Boolean getempleadospresenciaReturnShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.getempleadospresenciaReturn != null));
        if (getempleadospresenciaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          GetempleadospresenciaOutput sourceGETEMPLEADOSPRESENCIAReturn;
          sourceGETEMPLEADOSPRESENCIAReturn = this.getGETEMPLEADOSPRESENCIAReturn();
          GetempleadospresenciaOutput copyGETEMPLEADOSPRESENCIAReturn = ((GetempleadospresenciaOutput) strategy.copy(
              LocatorUtils.property(locator, "getempleadospresenciaReturn", sourceGETEMPLEADOSPRESENCIAReturn),
              sourceGETEMPLEADOSPRESENCIAReturn, (this.getempleadospresenciaReturn != null)));
          copy.setGETEMPLEADOSPRESENCIAReturn(copyGETEMPLEADOSPRESENCIAReturn);
        } else {
          if (getempleadospresenciaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.getempleadospresenciaReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETEMPLEADOSPRESENCIAResponse();
  }

}
