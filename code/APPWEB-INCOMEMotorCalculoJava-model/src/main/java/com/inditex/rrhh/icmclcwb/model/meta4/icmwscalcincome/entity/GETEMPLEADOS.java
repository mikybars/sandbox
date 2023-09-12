
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
 *         &lt;element name="ICM_PARAMCALEMPLEADOS" type="{http://schemas.meta4.com/}Icm_ParamcalempleadosBlock"/&gt;
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
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
    "icmparamcalempleados",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "GETEMPLEADOS")
public class GETEMPLEADOS implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ICM_PARAMCALEMPLEADOS", required = true)
  protected IcmParamcalempleadosBlock icmparamcalempleados;

  @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
  protected IcmParametrospaginacionBlock icmparametrospaginacion;

  /**
   * Gets the value of the icmparamcalempleados property.
   *
   * @return possible object is {@link IcmParamcalempleadosBlock }
   *
   */
  public IcmParamcalempleadosBlock getICMPARAMCALEMPLEADOS() {
    return icmparamcalempleados;
  }

  /**
   * Sets the value of the icmparamcalempleados property.
   *
   * @param value allowed object is {@link IcmParamcalempleadosBlock }
   *
   */
  public void setICMPARAMCALEMPLEADOS(IcmParamcalempleadosBlock value) {
    this.icmparamcalempleados = value;
  }

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

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETEMPLEADOS that = ((GETEMPLEADOS) object);
    {
      IcmParamcalempleadosBlock lhsICMPARAMCALEMPLEADOS;
      lhsICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
      IcmParamcalempleadosBlock rhsICMPARAMCALEMPLEADOS;
      rhsICMPARAMCALEMPLEADOS = that.getICMPARAMCALEMPLEADOS();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalempleados", lhsICMPARAMCALEMPLEADOS),
          LocatorUtils.property(thatLocator, "icmparamcalempleados", rhsICMPARAMCALEMPLEADOS), lhsICMPARAMCALEMPLEADOS,
          rhsICMPARAMCALEMPLEADOS, (this.icmparamcalempleados != null), (that.icmparamcalempleados != null))) {
        return false;
      }
    }
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
      IcmParamcalempleadosBlock theICMPARAMCALEMPLEADOS;
      theICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
      strategy.appendField(locator, this, "icmparamcalempleados", buffer, theICMPARAMCALEMPLEADOS, (this.icmparamcalempleados != null));
    }
    {
      IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
      theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
      strategy.appendField(locator, this, "icmparametrospaginacion", buffer, theICMPARAMETROSPAGINACION,
          (this.icmparametrospaginacion != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      IcmParamcalempleadosBlock theICMPARAMCALEMPLEADOS;
      theICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalempleados", theICMPARAMCALEMPLEADOS), currentHashCode,
          theICMPARAMCALEMPLEADOS, (this.icmparamcalempleados != null));
    }
    {
      IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
      theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION),
          currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion != null));
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
    if (draftCopy instanceof GETEMPLEADOS) {
      final GETEMPLEADOS copy = ((GETEMPLEADOS) draftCopy);
      {
        Boolean icmparamcalempleadosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalempleados != null));
        if (icmparamcalempleadosShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParamcalempleadosBlock sourceICMPARAMCALEMPLEADOS;
          sourceICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
          IcmParamcalempleadosBlock copyICMPARAMCALEMPLEADOS =
              ((IcmParamcalempleadosBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalempleados", sourceICMPARAMCALEMPLEADOS),
                  sourceICMPARAMCALEMPLEADOS, (this.icmparamcalempleados != null)));
          copy.setICMPARAMCALEMPLEADOS(copyICMPARAMCALEMPLEADOS);
        } else {
          if (icmparamcalempleadosShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparamcalempleados = null;
          }
        }
      }
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
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETEMPLEADOS();
  }

}
