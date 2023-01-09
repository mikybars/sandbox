
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
 *         &lt;element name="ICM_PARAMCALPRESUPUESTOSWLOC" type="{http://schemas.meta4.com/}Icm_ParamcalpresupuestoswlocBlock"/&gt;
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
    "icmparamcalpresupuestoswloc"
})
@XmlRootElement(name = "GETPRESUPUESTOSWLOC")
public class GETPRESUPUESTOSWLOC implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
  protected IcmParametrospaginacionBlock icmparametrospaginacion;

  @XmlElement(name = "ICM_PARAMCALPRESUPUESTOSWLOC", required = true)
  protected IcmParamcalpresupuestoswlocBlock icmparamcalpresupuestoswloc;

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
   * Obtiene el valor de la propiedad icmparamcalpresupuestoswloc.
   *
   * @return possible object is {@link IcmParamcalpresupuestoswlocBlock }
   *
   */
  public IcmParamcalpresupuestoswlocBlock getICMPARAMCALPRESUPUESTOSWLOC() {
    return icmparamcalpresupuestoswloc;
  }

  /**
   * Define el valor de la propiedad icmparamcalpresupuestoswloc.
   *
   * @param value allowed object is {@link IcmParamcalpresupuestoswlocBlock }
   *
   */
  public void setICMPARAMCALPRESUPUESTOSWLOC(IcmParamcalpresupuestoswlocBlock value) {
    this.icmparamcalpresupuestoswloc = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final GETPRESUPUESTOSWLOC that = ((GETPRESUPUESTOSWLOC) object);
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
      IcmParamcalpresupuestoswlocBlock lhsICMPARAMCALPRESUPUESTOSWLOC;
      lhsICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
      IcmParamcalpresupuestoswlocBlock rhsICMPARAMCALPRESUPUESTOSWLOC;
      rhsICMPARAMCALPRESUPUESTOSWLOC = that.getICMPARAMCALPRESUPUESTOSWLOC();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalpresupuestoswloc", lhsICMPARAMCALPRESUPUESTOSWLOC),
          LocatorUtils.property(thatLocator, "icmparamcalpresupuestoswloc", rhsICMPARAMCALPRESUPUESTOSWLOC), lhsICMPARAMCALPRESUPUESTOSWLOC,
          rhsICMPARAMCALPRESUPUESTOSWLOC, (this.icmparamcalpresupuestoswloc != null), (that.icmparamcalpresupuestoswloc != null))) {
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
      IcmParamcalpresupuestoswlocBlock theICMPARAMCALPRESUPUESTOSWLOC;
      theICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
      strategy.appendField(locator, this, "icmparamcalpresupuestoswloc", buffer, theICMPARAMCALPRESUPUESTOSWLOC,
          (this.icmparamcalpresupuestoswloc != null));
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
      IcmParamcalpresupuestoswlocBlock theICMPARAMCALPRESUPUESTOSWLOC;
      theICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalpresupuestoswloc", theICMPARAMCALPRESUPUESTOSWLOC),
          currentHashCode, theICMPARAMCALPRESUPUESTOSWLOC, (this.icmparamcalpresupuestoswloc != null));
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
    if (draftCopy instanceof GETPRESUPUESTOSWLOC) {
      final GETPRESUPUESTOSWLOC copy = ((GETPRESUPUESTOSWLOC) draftCopy);
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
        Boolean icmparamcalpresupuestoswlocShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalpresupuestoswloc != null));
        if (icmparamcalpresupuestoswlocShouldBeCopiedAndSet == Boolean.TRUE) {
          IcmParamcalpresupuestoswlocBlock sourceICMPARAMCALPRESUPUESTOSWLOC;
          sourceICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
          IcmParamcalpresupuestoswlocBlock copyICMPARAMCALPRESUPUESTOSWLOC = ((IcmParamcalpresupuestoswlocBlock) strategy.copy(
              LocatorUtils.property(locator, "icmparamcalpresupuestoswloc", sourceICMPARAMCALPRESUPUESTOSWLOC),
              sourceICMPARAMCALPRESUPUESTOSWLOC, (this.icmparamcalpresupuestoswloc != null)));
          copy.setICMPARAMCALPRESUPUESTOSWLOC(copyICMPARAMCALPRESUPUESTOSWLOC);
        } else {
          if (icmparamcalpresupuestoswlocShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmparamcalpresupuestoswloc = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new GETPRESUPUESTOSWLOC();
  }

}
