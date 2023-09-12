
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
 *         &lt;element name="ICM_PARAMCALCONFORIGEN" type="{http://schemas.meta4.com/}Icm_ParamcalconforigenBlock"/&gt;
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
    "icmparamcalconforigen"
})
@XmlRootElement(name = "GETCONFIGURACION")
public class GETCONFIGURACION implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ICM_PARAMCALCONFORIGEN", required = true)
  protected IcmParamcalconforigenBlock icmparamcalconforigen;

  /**
   * Gets the value of the icmparamcalconforigen property.
   *
   * @return possible object is {@link IcmParamcalconforigenBlock }
   *
   */
  public IcmParamcalconforigenBlock getICMPARAMCALCONFORIGEN() {
    return icmparamcalconforigen;
  }

  /**
   * Sets the value of the icmparamcalconforigen property.
   *
   * @param value allowed object is {@link IcmParamcalconforigenBlock }
   *
   */
  public void setICMPARAMCALCONFORIGEN(IcmParamcalconforigenBlock value) {
    this.icmparamcalconforigen = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETCONFIGURACION that = ((GETCONFIGURACION) object);
    {
      IcmParamcalconforigenBlock lhsICMPARAMCALCONFORIGEN;
      lhsICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
      IcmParamcalconforigenBlock rhsICMPARAMCALCONFORIGEN;
      rhsICMPARAMCALCONFORIGEN = that.getICMPARAMCALCONFORIGEN();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalconforigen", lhsICMPARAMCALCONFORIGEN),
          LocatorUtils.property(thatLocator, "icmparamcalconforigen", rhsICMPARAMCALCONFORIGEN), lhsICMPARAMCALCONFORIGEN,
          rhsICMPARAMCALCONFORIGEN, (this.icmparamcalconforigen != null), (that.icmparamcalconforigen != null))) {
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
      IcmParamcalconforigenBlock theICMPARAMCALCONFORIGEN;
      theICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
      strategy.appendField(locator, this, "icmparamcalconforigen", buffer, theICMPARAMCALCONFORIGEN, (this.icmparamcalconforigen != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      IcmParamcalconforigenBlock theICMPARAMCALCONFORIGEN;
      theICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalconforigen", theICMPARAMCALCONFORIGEN),
          currentHashCode, theICMPARAMCALCONFORIGEN, (this.icmparamcalconforigen != null));
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
    if (draftCopy instanceof GETCONFIGURACION) {
      final GETCONFIGURACION copy = ((GETCONFIGURACION) draftCopy);
      {
        Boolean icmparamcalconforigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalconforigen != null));
        if (icmparamcalconforigenShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParamcalconforigenBlock sourceICMPARAMCALCONFORIGEN;
          sourceICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
          IcmParamcalconforigenBlock copyICMPARAMCALCONFORIGEN = ((IcmParamcalconforigenBlock) strategy.copy(
              LocatorUtils.property(locator, "icmparamcalconforigen", sourceICMPARAMCALCONFORIGEN), sourceICMPARAMCALCONFORIGEN,
              (this.icmparamcalconforigen != null)));
          copy.setICMPARAMCALCONFORIGEN(copyICMPARAMCALCONFORIGEN);
        } else {
          if (icmparamcalconforigenShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparamcalconforigen = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETCONFIGURACION();
  }

}
