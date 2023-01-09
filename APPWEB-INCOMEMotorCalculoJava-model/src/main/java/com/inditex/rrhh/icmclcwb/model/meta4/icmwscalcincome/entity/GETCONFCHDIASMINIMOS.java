
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
 *         &lt;element name="ICM_PARAMCALCONFCHDIAS" type="{http://schemas.meta4.com/}Icm_ParamcalconfchdiasBlock"/&gt;
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
    "icmparamcalconfchdias"
})
@XmlRootElement(name = "GETCONFCHDIASMINIMOS")
public class GETCONFCHDIASMINIMOS implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ICM_PARAMCALCONFCHDIAS", required = true)
  protected IcmParamcalconfchdiasBlock icmparamcalconfchdias;

  /**
   * Obtiene el valor de la propiedad icmparamcalconfchdias.
   *
   * @return possible object is {@link IcmParamcalconfchdiasBlock }
   *
   */
  public IcmParamcalconfchdiasBlock getICMPARAMCALCONFCHDIAS() {
    return icmparamcalconfchdias;
  }

  /**
   * Define el valor de la propiedad icmparamcalconfchdias.
   *
   * @param value allowed object is {@link IcmParamcalconfchdiasBlock }
   *
   */
  public void setICMPARAMCALCONFCHDIAS(IcmParamcalconfchdiasBlock value) {
    this.icmparamcalconfchdias = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETCONFCHDIASMINIMOS that = ((GETCONFCHDIASMINIMOS) object);
    {
      IcmParamcalconfchdiasBlock lhsICMPARAMCALCONFCHDIAS;
      lhsICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
      IcmParamcalconfchdiasBlock rhsICMPARAMCALCONFCHDIAS;
      rhsICMPARAMCALCONFCHDIAS = that.getICMPARAMCALCONFCHDIAS();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalconfchdias", lhsICMPARAMCALCONFCHDIAS),
          LocatorUtils.property(thatLocator, "icmparamcalconfchdias", rhsICMPARAMCALCONFCHDIAS), lhsICMPARAMCALCONFCHDIAS,
          rhsICMPARAMCALCONFCHDIAS, (this.icmparamcalconfchdias != null), (that.icmparamcalconfchdias != null))) {
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
      IcmParamcalconfchdiasBlock theICMPARAMCALCONFCHDIAS;
      theICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
      strategy.appendField(locator, this, "icmparamcalconfchdias", buffer, theICMPARAMCALCONFCHDIAS, (this.icmparamcalconfchdias != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      IcmParamcalconfchdiasBlock theICMPARAMCALCONFCHDIAS;
      theICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalconfchdias", theICMPARAMCALCONFCHDIAS),
          currentHashCode, theICMPARAMCALCONFCHDIAS, (this.icmparamcalconfchdias != null));
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
    if (draftCopy instanceof GETCONFCHDIASMINIMOS) {
      final GETCONFCHDIASMINIMOS copy = ((GETCONFCHDIASMINIMOS) draftCopy);
      {
        Boolean icmparamcalconfchdiasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalconfchdias != null));
        if (icmparamcalconfchdiasShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParamcalconfchdiasBlock sourceICMPARAMCALCONFCHDIAS;
          sourceICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
          IcmParamcalconfchdiasBlock copyICMPARAMCALCONFCHDIAS = ((IcmParamcalconfchdiasBlock) strategy.copy(
              LocatorUtils.property(locator, "icmparamcalconfchdias", sourceICMPARAMCALCONFCHDIAS), sourceICMPARAMCALCONFCHDIAS,
              (this.icmparamcalconfchdias != null)));
          copy.setICMPARAMCALCONFCHDIAS(copyICMPARAMCALCONFCHDIAS);
        } else {
          if (icmparamcalconfchdiasShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparamcalconfchdias = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETCONFCHDIASMINIMOS();
  }

}
