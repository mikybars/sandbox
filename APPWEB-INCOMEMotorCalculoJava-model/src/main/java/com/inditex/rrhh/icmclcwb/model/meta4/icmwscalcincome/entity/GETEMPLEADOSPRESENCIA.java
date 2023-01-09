
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
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALEMPLEADOSPRESENCIA" type="{http://schemas.meta4.com/}Icm_ParamcalempleadospresenciaBlock"/&gt;
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
    "icmparamcalempleadospresencia"
})
@XmlRootElement(name = "GETEMPLEADOSPRESENCIA")
public class GETEMPLEADOSPRESENCIA implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
  protected IcmParametrospaginacionBlock icmparametrospaginacion;

  @XmlElement(name = "ICM_PARAMCALEMPLEADOSPRESENCIA", required = true)
  protected IcmParamcalempleadospresenciaBlock icmparamcalempleadospresencia;

  /**
   * Obtiene el valor de la propiedad icmparametrospaginacion.
   *
   * @return possible object is {@link IcmParametrospaginacionBlock }
   *
   */
  public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
    return icmparametrospaginacion;
  }

  /**
   * Define el valor de la propiedad icmparametrospaginacion.
   *
   * @param value allowed object is {@link IcmParametrospaginacionBlock }
   *
   */
  public void setICMPARAMETROSPAGINACION(IcmParametrospaginacionBlock value) {
    this.icmparametrospaginacion = value;
  }

  /**
   * Obtiene el valor de la propiedad icmparamcalempleadospresencia.
   *
   * @return possible object is {@link IcmParamcalempleadospresenciaBlock }
   *
   */
  public IcmParamcalempleadospresenciaBlock getICMPARAMCALEMPLEADOSPRESENCIA() {
    return icmparamcalempleadospresencia;
  }

  /**
   * Define el valor de la propiedad icmparamcalempleadospresencia.
   *
   * @param value allowed object is {@link IcmParamcalempleadospresenciaBlock }
   *
   */
  public void setICMPARAMCALEMPLEADOSPRESENCIA(IcmParamcalempleadospresenciaBlock value) {
    this.icmparamcalempleadospresencia = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETEMPLEADOSPRESENCIA that = ((GETEMPLEADOSPRESENCIA) object);
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
      IcmParamcalempleadospresenciaBlock lhsICMPARAMCALEMPLEADOSPRESENCIA;
      lhsICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
      IcmParamcalempleadospresenciaBlock rhsICMPARAMCALEMPLEADOSPRESENCIA;
      rhsICMPARAMCALEMPLEADOSPRESENCIA = that.getICMPARAMCALEMPLEADOSPRESENCIA();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalempleadospresencia", lhsICMPARAMCALEMPLEADOSPRESENCIA),
          LocatorUtils.property(thatLocator, "icmparamcalempleadospresencia", rhsICMPARAMCALEMPLEADOSPRESENCIA),
          lhsICMPARAMCALEMPLEADOSPRESENCIA, rhsICMPARAMCALEMPLEADOSPRESENCIA, (this.icmparamcalempleadospresencia != null),
          (that.icmparamcalempleadospresencia != null))) {
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
      IcmParamcalempleadospresenciaBlock theICMPARAMCALEMPLEADOSPRESENCIA;
      theICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
      strategy.appendField(locator, this, "icmparamcalempleadospresencia", buffer, theICMPARAMCALEMPLEADOSPRESENCIA,
          (this.icmparamcalempleadospresencia != null));
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
      IcmParamcalempleadospresenciaBlock theICMPARAMCALEMPLEADOSPRESENCIA;
      theICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalempleadospresencia", theICMPARAMCALEMPLEADOSPRESENCIA),
          currentHashCode, theICMPARAMCALEMPLEADOSPRESENCIA, (this.icmparamcalempleadospresencia != null));
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
    if (draftCopy instanceof GETEMPLEADOSPRESENCIA) {
      final GETEMPLEADOSPRESENCIA copy = ((GETEMPLEADOSPRESENCIA) draftCopy);
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
        Boolean icmparamcalempleadospresenciaShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalempleadospresencia != null));
        if (icmparamcalempleadospresenciaShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParamcalempleadospresenciaBlock sourceICMPARAMCALEMPLEADOSPRESENCIA;
          sourceICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
          IcmParamcalempleadospresenciaBlock copyICMPARAMCALEMPLEADOSPRESENCIA = ((IcmParamcalempleadospresenciaBlock) strategy.copy(
              LocatorUtils.property(locator, "icmparamcalempleadospresencia", sourceICMPARAMCALEMPLEADOSPRESENCIA),
              sourceICMPARAMCALEMPLEADOSPRESENCIA, (this.icmparamcalempleadospresencia != null)));
          copy.setICMPARAMCALEMPLEADOSPRESENCIA(copyICMPARAMCALEMPLEADOSPRESENCIA);
        } else {
          if (icmparamcalempleadospresenciaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparamcalempleadospresencia = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETEMPLEADOSPRESENCIA();
  }

}
