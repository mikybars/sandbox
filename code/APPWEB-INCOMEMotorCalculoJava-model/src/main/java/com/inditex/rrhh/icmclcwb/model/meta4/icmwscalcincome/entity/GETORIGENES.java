
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
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALSOCIEDAD" type="{http://schemas.meta4.com/}Icm_ParamcalsociedadBlock"/&gt;
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
    "icmparametrospaginacion",
    "icmparamcalsociedad"
})
@XmlRootElement(name = "GETORIGENES")
public class GETORIGENES implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
  protected IcmParametrospaginacionBlock icmparametrospaginacion;

  @XmlElement(name = "ICM_PARAMCALSOCIEDAD", required = true)
  protected IcmParamcalsociedadBlock icmparamcalsociedad;

  /**
   * Gets the value of the icmparametrospaginacion property.
   *
   * @return possible object is {@link IcmParametrospaginacionBlock }
   *
   */
  public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
    return icmparametrospaginacion;
  }

  /**
   * Sets the value of the icmparametrospaginacion property.
   *
   * @param value allowed object is {@link IcmParametrospaginacionBlock }
   *
   */
  public void setICMPARAMETROSPAGINACION(IcmParametrospaginacionBlock value) {
    this.icmparametrospaginacion = value;
  }

  /**
   * Gets the value of the icmparamcalsociedad property.
   *
   * @return possible object is {@link IcmParamcalsociedadBlock }
   *
   */
  public IcmParamcalsociedadBlock getICMPARAMCALSOCIEDAD() {
    return icmparamcalsociedad;
  }

  /**
   * Sets the value of the icmparamcalsociedad property.
   *
   * @param value allowed object is {@link IcmParamcalsociedadBlock }
   *
   */
  public void setICMPARAMCALSOCIEDAD(IcmParamcalsociedadBlock value) {
    this.icmparamcalsociedad = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETORIGENES that = ((GETORIGENES) object);
    {
      IcmParametrospaginacionBlock lhsICMPARAMETROSPAGINACION;
      lhsICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
      IcmParametrospaginacionBlock rhsICMPARAMETROSPAGINACION;
      rhsICMPARAMETROSPAGINACION = that.getICMPARAMETROSPAGINACION();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospaginacion", lhsICMPARAMETROSPAGINACION),
          LocatorUtils.property(thatLocator, "icmparametrospaginacion", rhsICMPARAMETROSPAGINACION), lhsICMPARAMETROSPAGINACION,
          rhsICMPARAMETROSPAGINACION, (this.icmparametrospaginacion != null), (that.icmparametrospaginacion != null))) {
        return false;
      }
    }
    {
      IcmParamcalsociedadBlock lhsICMPARAMCALSOCIEDAD;
      lhsICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
      IcmParamcalsociedadBlock rhsICMPARAMCALSOCIEDAD;
      rhsICMPARAMCALSOCIEDAD = that.getICMPARAMCALSOCIEDAD();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalsociedad", lhsICMPARAMCALSOCIEDAD),
          LocatorUtils.property(thatLocator, "icmparamcalsociedad", rhsICMPARAMCALSOCIEDAD), lhsICMPARAMCALSOCIEDAD, rhsICMPARAMCALSOCIEDAD,
          (this.icmparamcalsociedad != null), (that.icmparamcalsociedad != null))) {
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
      IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
      theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
      strategy.appendField(locator, this, "icmparametrospaginacion", buffer, theICMPARAMETROSPAGINACION,
          (this.icmparametrospaginacion != null));
    }
    {
      IcmParamcalsociedadBlock theICMPARAMCALSOCIEDAD;
      theICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
      strategy.appendField(locator, this, "icmparamcalsociedad", buffer, theICMPARAMCALSOCIEDAD, (this.icmparamcalsociedad != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
      theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION),
          currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion != null));
    }
    {
      IcmParamcalsociedadBlock theICMPARAMCALSOCIEDAD;
      theICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalsociedad", theICMPARAMCALSOCIEDAD), currentHashCode,
          theICMPARAMCALSOCIEDAD, (this.icmparamcalsociedad != null));
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
    if (draftCopy instanceof GETORIGENES) {
      final GETORIGENES copy = ((GETORIGENES) draftCopy);
      {
        Boolean icmparametrospaginacionShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.icmparametrospaginacion != null));
        if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParametrospaginacionBlock sourceICMPARAMETROSPAGINACION;
          sourceICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
          IcmParametrospaginacionBlock copyICMPARAMETROSPAGINACION = ((IcmParametrospaginacionBlock) strategy.copy(
              LocatorUtils.property(locator, "icmparametrospaginacion", sourceICMPARAMETROSPAGINACION), sourceICMPARAMETROSPAGINACION,
              (this.icmparametrospaginacion != null)));
          copy.setICMPARAMETROSPAGINACION(copyICMPARAMETROSPAGINACION);
        } else {
          if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparametrospaginacion = null;
          }
        }
      }
      {
        Boolean icmparamcalsociedadShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalsociedad != null));
        if (icmparamcalsociedadShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParamcalsociedadBlock sourceICMPARAMCALSOCIEDAD;
          sourceICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
          IcmParamcalsociedadBlock copyICMPARAMCALSOCIEDAD =
              ((IcmParamcalsociedadBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalsociedad", sourceICMPARAMCALSOCIEDAD),
                  sourceICMPARAMCALSOCIEDAD, (this.icmparamcalsociedad != null)));
          copy.setICMPARAMCALSOCIEDAD(copyICMPARAMCALSOCIEDAD);
        } else {
          if (icmparamcalsociedadShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparamcalsociedad = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETORIGENES();
  }

}
