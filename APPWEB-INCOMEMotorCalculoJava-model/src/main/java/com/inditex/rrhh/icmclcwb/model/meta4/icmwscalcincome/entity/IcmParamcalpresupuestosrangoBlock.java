
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
 * <p>Clase Java para Icm_ParamcalpresupuestosrangoBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalpresupuestosrangoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idorigen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechainicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParamcalpresupuestosrangoRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalpresupuestosrangoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalpresupuestosrangoBlock", propOrder = {
    "fechafin",
    "idorigen",
    "fechainicio",
    "icmParamcalpresupuestosrangoRecordSet"
})
public class IcmParamcalpresupuestosrangoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String fechafin;

  @XmlElement(required = true, nillable = true)
  protected String idorigen;

  @XmlElement(required = true, nillable = true)
  protected String fechainicio;

  @XmlElement(name = "Icm_ParamcalpresupuestosrangoRecordSet", nillable = true)
  protected List<IcmParamcalpresupuestosrangoRecord> icmParamcalpresupuestosrangoRecordSet;

  /**
   * Obtiene el valor de la propiedad fechafin.
   *
   * @return possible object is {@link String }
   *
   */
  public String getFechafin() {
    return fechafin;
  }

  /**
   * Define el valor de la propiedad fechafin.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setFechafin(String value) {
    this.fechafin = value;
  }

  /**
   * Obtiene el valor de la propiedad idorigen.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdorigen() {
    return idorigen;
  }

  /**
   * Define el valor de la propiedad idorigen.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdorigen(String value) {
    this.idorigen = value;
  }

  /**
   * Obtiene el valor de la propiedad fechainicio.
   *
   * @return possible object is {@link String }
   *
   */
  public String getFechainicio() {
    return fechainicio;
  }

  /**
   * Define el valor de la propiedad fechainicio.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setFechainicio(String value) {
    this.fechainicio = value;
  }

  /**
   * Gets the value of the icmParamcalpresupuestosrangoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
   * icmParamcalpresupuestosrangoRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmParamcalpresupuestosrangoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalpresupuestosrangoRecord }
   *
   *
   */
  public List<IcmParamcalpresupuestosrangoRecord> getIcmParamcalpresupuestosrangoRecordSet() {
    if (icmParamcalpresupuestosrangoRecordSet == null) {
      icmParamcalpresupuestosrangoRecordSet = new ArrayList<IcmParamcalpresupuestosrangoRecord>();
    }
    return this.icmParamcalpresupuestosrangoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalpresupuestosrangoBlock that = ((IcmParamcalpresupuestosrangoBlock) object);
    {
      String lhsFechafin;
      lhsFechafin = this.getFechafin();
      String rhsFechafin;
      rhsFechafin = that.getFechafin();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "fechafin", lhsFechafin),
          LocatorUtils.property(thatLocator, "fechafin", rhsFechafin), lhsFechafin, rhsFechafin, (this.fechafin != null),
          (that.fechafin != null))) {
        return false;
      }
    }
    {
      String lhsIdorigen;
      lhsIdorigen = this.getIdorigen();
      String rhsIdorigen;
      rhsIdorigen = that.getIdorigen();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idorigen", lhsIdorigen),
          LocatorUtils.property(thatLocator, "idorigen", rhsIdorigen), lhsIdorigen, rhsIdorigen, (this.idorigen != null),
          (that.idorigen != null))) {
        return false;
      }
    }
    {
      String lhsFechainicio;
      lhsFechainicio = this.getFechainicio();
      String rhsFechainicio;
      rhsFechainicio = that.getFechainicio();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "fechainicio", lhsFechainicio),
          LocatorUtils.property(thatLocator, "fechainicio", rhsFechainicio), lhsFechainicio, rhsFechainicio, (this.fechainicio != null),
          (that.fechainicio != null))) {
        return false;
      }
    }
    {
      List<IcmParamcalpresupuestosrangoRecord> lhsIcmParamcalpresupuestosrangoRecordSet;
      lhsIcmParamcalpresupuestosrangoRecordSet =
          (((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty()))
              ? this.getIcmParamcalpresupuestosrangoRecordSet()
              : null);
      List<IcmParamcalpresupuestosrangoRecord> rhsIcmParamcalpresupuestosrangoRecordSet;
      rhsIcmParamcalpresupuestosrangoRecordSet =
          (((that.icmParamcalpresupuestosrangoRecordSet != null) && (!that.icmParamcalpresupuestosrangoRecordSet.isEmpty()))
              ? that.getIcmParamcalpresupuestosrangoRecordSet()
              : null);
      if (!strategy.equals(
          LocatorUtils.property(thisLocator, "icmParamcalpresupuestosrangoRecordSet", lhsIcmParamcalpresupuestosrangoRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalpresupuestosrangoRecordSet", rhsIcmParamcalpresupuestosrangoRecordSet),
          lhsIcmParamcalpresupuestosrangoRecordSet, rhsIcmParamcalpresupuestosrangoRecordSet,
          ((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty())),
          ((that.icmParamcalpresupuestosrangoRecordSet != null) && (!that.icmParamcalpresupuestosrangoRecordSet.isEmpty())))) {
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
      String theFechafin;
      theFechafin = this.getFechafin();
      strategy.appendField(locator, this, "fechafin", buffer, theFechafin, (this.fechafin != null));
    }
    {
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      strategy.appendField(locator, this, "idorigen", buffer, theIdorigen, (this.idorigen != null));
    }
    {
      String theFechainicio;
      theFechainicio = this.getFechainicio();
      strategy.appendField(locator, this, "fechainicio", buffer, theFechainicio, (this.fechainicio != null));
    }
    {
      List<IcmParamcalpresupuestosrangoRecord> theIcmParamcalpresupuestosrangoRecordSet;
      theIcmParamcalpresupuestosrangoRecordSet =
          (((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty()))
              ? this.getIcmParamcalpresupuestosrangoRecordSet()
              : null);
      strategy.appendField(locator, this, "icmParamcalpresupuestosrangoRecordSet", buffer, theIcmParamcalpresupuestosrangoRecordSet,
          ((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theFechafin;
      theFechafin = this.getFechafin();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "fechafin", theFechafin), currentHashCode, theFechafin, (this.fechafin != null));
    }
    {
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "idorigen", theIdorigen), currentHashCode, theIdorigen, (this.idorigen != null));
    }
    {
      String theFechainicio;
      theFechainicio = this.getFechainicio();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechainicio", theFechainicio), currentHashCode, theFechainicio,
          (this.fechainicio != null));
    }
    {
      List<IcmParamcalpresupuestosrangoRecord> theIcmParamcalpresupuestosrangoRecordSet;
      theIcmParamcalpresupuestosrangoRecordSet =
          (((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty()))
              ? this.getIcmParamcalpresupuestosrangoRecordSet()
              : null);
      currentHashCode = strategy.hashCode(
          LocatorUtils.property(locator, "icmParamcalpresupuestosrangoRecordSet", theIcmParamcalpresupuestosrangoRecordSet),
          currentHashCode, theIcmParamcalpresupuestosrangoRecordSet,
          ((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalpresupuestosrangoBlock) {
      final IcmParamcalpresupuestosrangoBlock copy = ((IcmParamcalpresupuestosrangoBlock) draftCopy);
      {
        Boolean fechafinShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechafin != null));
        if (fechafinShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceFechafin;
          sourceFechafin = this.getFechafin();
          String copyFechafin =
              ((String) strategy.copy(LocatorUtils.property(locator, "fechafin", sourceFechafin), sourceFechafin, (this.fechafin != null)));
          copy.setFechafin(copyFechafin);
        } else {
          if (fechafinShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.fechafin = null;
          }
        }
      }
      {
        Boolean idorigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idorigen != null));
        if (idorigenShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdorigen;
          sourceIdorigen = this.getIdorigen();
          String copyIdorigen =
              ((String) strategy.copy(LocatorUtils.property(locator, "idorigen", sourceIdorigen), sourceIdorigen, (this.idorigen != null)));
          copy.setIdorigen(copyIdorigen);
        } else {
          if (idorigenShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idorigen = null;
          }
        }
      }
      {
        Boolean fechainicioShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechainicio != null));
        if (fechainicioShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceFechainicio;
          sourceFechainicio = this.getFechainicio();
          String copyFechainicio = ((String) strategy.copy(LocatorUtils.property(locator, "fechainicio", sourceFechainicio),
              sourceFechainicio, (this.fechainicio != null)));
          copy.setFechainicio(copyFechainicio);
        } else {
          if (fechainicioShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.fechainicio = null;
          }
        }
      }
      {
        Boolean icmParamcalpresupuestosrangoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty())));
        if (icmParamcalpresupuestosrangoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalpresupuestosrangoRecord> sourceIcmParamcalpresupuestosrangoRecordSet;
          sourceIcmParamcalpresupuestosrangoRecordSet =
              (((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty()))
                  ? this.getIcmParamcalpresupuestosrangoRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalpresupuestosrangoRecord> copyIcmParamcalpresupuestosrangoRecordSet =
              ((List<IcmParamcalpresupuestosrangoRecord>) strategy.copy(
                  LocatorUtils.property(locator, "icmParamcalpresupuestosrangoRecordSet", sourceIcmParamcalpresupuestosrangoRecordSet),
                  sourceIcmParamcalpresupuestosrangoRecordSet,
                  ((this.icmParamcalpresupuestosrangoRecordSet != null) && (!this.icmParamcalpresupuestosrangoRecordSet.isEmpty()))));
          copy.icmParamcalpresupuestosrangoRecordSet = null;
          if (copyIcmParamcalpresupuestosrangoRecordSet != null) {
            List<IcmParamcalpresupuestosrangoRecord> uniqueIcmParamcalpresupuestosrangoRecordSetl =
                copy.getIcmParamcalpresupuestosrangoRecordSet();
            uniqueIcmParamcalpresupuestosrangoRecordSetl.addAll(copyIcmParamcalpresupuestosrangoRecordSet);
          }
        } else {
          if (icmParamcalpresupuestosrangoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalpresupuestosrangoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalpresupuestosrangoBlock();
  }

}
