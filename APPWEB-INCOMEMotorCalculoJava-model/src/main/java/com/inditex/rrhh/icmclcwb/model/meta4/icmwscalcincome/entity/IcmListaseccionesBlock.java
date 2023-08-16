
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Java class for Icm_ListaseccionesBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaseccionesBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idempleado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ListaseccionesRecordSet" type="{http://schemas.meta4.com/}Icm_ListaseccionesRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaseccionesBlock", propOrder = {
    "fecha",
    "idempleado",
    "icmListaseccionesRecordSet"
})
public class IcmListaseccionesBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String fecha;

  @XmlElement(required = true, nillable = true)
  protected String idempleado;

  @XmlElement(name = "Icm_ListaseccionesRecordSet", nillable = true)
  protected List<IcmListaseccionesRecord> icmListaseccionesRecordSet;

  /**
   * Gets the value of the fecha property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * Sets the value of the fecha property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setFecha(String value) {
    this.fecha = value;
  }

  /**
   * Gets the value of the idempleado property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdempleado() {
    return idempleado;
  }

  /**
   * Sets the value of the idempleado property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdempleado(String value) {
    this.idempleado = value;
  }

  /**
   * Gets the value of the icmListaseccionesRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListaseccionesRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListaseccionesRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListaseccionesRecord }
   *
   *
   */
  public List<IcmListaseccionesRecord> getIcmListaseccionesRecordSet() {
    if (icmListaseccionesRecordSet == null) {
      icmListaseccionesRecordSet = new ArrayList<IcmListaseccionesRecord>();
    }
    return this.icmListaseccionesRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListaseccionesBlock that = ((IcmListaseccionesBlock) object);
    {
      String lhsFecha;
      lhsFecha = this.getFecha();
      String rhsFecha;
      rhsFecha = that.getFecha();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "fecha", lhsFecha), LocatorUtils.property(thatLocator, "fecha", rhsFecha),
          lhsFecha, rhsFecha, (this.fecha != null), (that.fecha != null))) {
        return false;
      }
    }
    {
      String lhsIdempleado;
      lhsIdempleado = this.getIdempleado();
      String rhsIdempleado;
      rhsIdempleado = that.getIdempleado();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idempleado", lhsIdempleado),
          LocatorUtils.property(thatLocator, "idempleado", rhsIdempleado), lhsIdempleado, rhsIdempleado, (this.idempleado != null),
          (that.idempleado != null))) {
        return false;
      }
    }
    {
      List<IcmListaseccionesRecord> lhsIcmListaseccionesRecordSet;
      lhsIcmListaseccionesRecordSet = (((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty()))
          ? this.getIcmListaseccionesRecordSet()
          : null);
      List<IcmListaseccionesRecord> rhsIcmListaseccionesRecordSet;
      rhsIcmListaseccionesRecordSet = (((that.icmListaseccionesRecordSet != null) && (!that.icmListaseccionesRecordSet.isEmpty()))
          ? that.getIcmListaseccionesRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaseccionesRecordSet", lhsIcmListaseccionesRecordSet),
          LocatorUtils.property(thatLocator, "icmListaseccionesRecordSet", rhsIcmListaseccionesRecordSet), lhsIcmListaseccionesRecordSet,
          rhsIcmListaseccionesRecordSet, ((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty())),
          ((that.icmListaseccionesRecordSet != null) && (!that.icmListaseccionesRecordSet.isEmpty())))) {
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
      String theFecha;
      theFecha = this.getFecha();
      strategy.appendField(locator, this, "fecha", buffer, theFecha, (this.fecha != null));
    }
    {
      String theIdempleado;
      theIdempleado = this.getIdempleado();
      strategy.appendField(locator, this, "idempleado", buffer, theIdempleado, (this.idempleado != null));
    }
    {
      List<IcmListaseccionesRecord> theIcmListaseccionesRecordSet;
      theIcmListaseccionesRecordSet = (((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty()))
          ? this.getIcmListaseccionesRecordSet()
          : null);
      strategy.appendField(locator, this, "icmListaseccionesRecordSet", buffer, theIcmListaseccionesRecordSet,
          ((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theFecha;
      theFecha = this.getFecha();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "fecha", theFecha), currentHashCode, theFecha, (this.fecha != null));
    }
    {
      String theIdempleado;
      theIdempleado = this.getIdempleado();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idempleado", theIdempleado), currentHashCode, theIdempleado,
          (this.idempleado != null));
    }
    {
      List<IcmListaseccionesRecord> theIcmListaseccionesRecordSet;
      theIcmListaseccionesRecordSet = (((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty()))
          ? this.getIcmListaseccionesRecordSet()
          : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListaseccionesRecordSet", theIcmListaseccionesRecordSet), currentHashCode,
              theIcmListaseccionesRecordSet, ((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListaseccionesBlock) {
      final IcmListaseccionesBlock copy = ((IcmListaseccionesBlock) draftCopy);
      {
        Boolean fechaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fecha != null));
        if (fechaShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceFecha;
          sourceFecha = this.getFecha();
          String copyFecha =
              ((String) strategy.copy(LocatorUtils.property(locator, "fecha", sourceFecha), sourceFecha, (this.fecha != null)));
          copy.setFecha(copyFecha);
        } else {
          if (fechaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.fecha = null;
          }
        }
      }
      {
        Boolean idempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idempleado != null));
        if (idempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdempleado;
          sourceIdempleado = this.getIdempleado();
          String copyIdempleado = ((String) strategy.copy(LocatorUtils.property(locator, "idempleado", sourceIdempleado), sourceIdempleado,
              (this.idempleado != null)));
          copy.setIdempleado(copyIdempleado);
        } else {
          if (idempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idempleado = null;
          }
        }
      }
      {
        Boolean icmListaseccionesRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty())));
        if (icmListaseccionesRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListaseccionesRecord> sourceIcmListaseccionesRecordSet;
          sourceIcmListaseccionesRecordSet = (((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty()))
              ? this.getIcmListaseccionesRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmListaseccionesRecord> copyIcmListaseccionesRecordSet = ((List<IcmListaseccionesRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListaseccionesRecordSet", sourceIcmListaseccionesRecordSet),
              sourceIcmListaseccionesRecordSet,
              ((this.icmListaseccionesRecordSet != null) && (!this.icmListaseccionesRecordSet.isEmpty()))));
          copy.icmListaseccionesRecordSet = null;
          if (copyIcmListaseccionesRecordSet != null) {
            List<IcmListaseccionesRecord> uniqueIcmListaseccionesRecordSetl = copy.getIcmListaseccionesRecordSet();
            uniqueIcmListaseccionesRecordSetl.addAll(copyIcmListaseccionesRecordSet);
          }
        } else {
          if (icmListaseccionesRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListaseccionesRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListaseccionesBlock();
  }

}
