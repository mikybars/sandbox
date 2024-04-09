
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
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
 *         &lt;element name="ICM_PARAMCALCONFCHVENTA" type="{http://schemas.meta4.com/}Icm_ParamcalconfchventaBlock"/&gt;
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
    "icmparamcalconfchventa"
})
@XmlRootElement(name = "GETCONFCHTPVENTA")
public class GETCONFCHTPVENTA implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ICM_PARAMCALCONFCHVENTA", required = true)
  protected IcmParamcalconfchventaBlock icmparamcalconfchventa;

  /**
   * Gets the value of the icmparamcalconfchventa property.
   *
   * @return possible object is {@link IcmParamcalconfchventaBlock }
   *
   */
  public IcmParamcalconfchventaBlock getICMPARAMCALCONFCHVENTA() {
    return icmparamcalconfchventa;
  }

  /**
   * Sets the value of the icmparamcalconfchventa property.
   *
   * @param value allowed object is {@link IcmParamcalconfchventaBlock }
   *
   */
  public void setICMPARAMCALCONFCHVENTA(IcmParamcalconfchventaBlock value) {
    this.icmparamcalconfchventa = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETCONFCHTPVENTA that = ((GETCONFCHTPVENTA) object);
    {
      IcmParamcalconfchventaBlock lhsICMPARAMCALCONFCHVENTA;
      lhsICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
      IcmParamcalconfchventaBlock rhsICMPARAMCALCONFCHVENTA;
      rhsICMPARAMCALCONFCHVENTA = that.getICMPARAMCALCONFCHVENTA();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalconfchventa", lhsICMPARAMCALCONFCHVENTA),
          LocatorUtils.property(thatLocator, "icmparamcalconfchventa", rhsICMPARAMCALCONFCHVENTA), lhsICMPARAMCALCONFCHVENTA,
          rhsICMPARAMCALCONFCHVENTA, (this.icmparamcalconfchventa != null), (that.icmparamcalconfchventa != null))) {
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
      IcmParamcalconfchventaBlock theICMPARAMCALCONFCHVENTA;
      theICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
      strategy.appendField(locator, this, "icmparamcalconfchventa", buffer, theICMPARAMCALCONFCHVENTA,
          (this.icmparamcalconfchventa != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      IcmParamcalconfchventaBlock theICMPARAMCALCONFCHVENTA;
      theICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalconfchventa", theICMPARAMCALCONFCHVENTA),
          currentHashCode, theICMPARAMCALCONFCHVENTA, (this.icmparamcalconfchventa != null));
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
    if (draftCopy instanceof GETCONFCHTPVENTA) {
      final GETCONFCHTPVENTA copy = ((GETCONFCHTPVENTA) draftCopy);
      {
        Boolean icmparamcalconfchventaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalconfchventa != null));
        if (icmparamcalconfchventaShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParamcalconfchventaBlock sourceICMPARAMCALCONFCHVENTA;
          sourceICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
          IcmParamcalconfchventaBlock copyICMPARAMCALCONFCHVENTA = ((IcmParamcalconfchventaBlock) strategy.copy(
              LocatorUtils.property(locator, "icmparamcalconfchventa", sourceICMPARAMCALCONFCHVENTA), sourceICMPARAMCALCONFCHVENTA,
              (this.icmparamcalconfchventa != null)));
          copy.setICMPARAMCALCONFCHVENTA(copyICMPARAMCALCONFCHVENTA);
        } else {
          if (icmparamcalconfchventaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparamcalconfchventa = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETCONFCHTPVENTA();
  }

}
