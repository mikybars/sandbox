
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
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
 * <p>Java class for Icm_ParametrosentradaBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParametrosentradaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ambito" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idcadena" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idorigen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idempresa" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechainicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrosentradaRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrosentradaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrosentradaBlock", propOrder = {
    "ambito",
    "fechafin",
    "idcadena",
    "idorigen",
    "idempresa",
    "fechainicio",
    "icmParametrosentradaRecordSet"
})
public class IcmParametrosentradaBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String ambito;

  @XmlElement(required = true, nillable = true)
  protected String fechafin;

  @XmlElement(required = true, nillable = true)
  protected String idcadena;

  @XmlElement(required = true, nillable = true)
  protected String idorigen;

  @XmlElement(required = true, nillable = true)
  protected String idempresa;

  @XmlElement(required = true, nillable = true)
  protected String fechainicio;

  @XmlElement(name = "Icm_ParametrosentradaRecordSet", nillable = true)
  protected List<IcmParametrosentradaRecord> icmParametrosentradaRecordSet;

  /**
   * Gets the value of the ambito property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAmbito() {
    return ambito;
  }

  /**
   * Sets the value of the ambito property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAmbito(String value) {
    this.ambito = value;
  }

  /**
   * Gets the value of the fechafin property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getFechafin() {
    return fechafin;
  }

  /**
   * Sets the value of the fechafin property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setFechafin(String value) {
    this.fechafin = value;
  }

  /**
   * Gets the value of the idcadena property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdcadena() {
    return idcadena;
  }

  /**
   * Sets the value of the idcadena property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdcadena(String value) {
    this.idcadena = value;
  }

  /**
   * Gets the value of the idorigen property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdorigen() {
    return idorigen;
  }

  /**
   * Sets the value of the idorigen property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdorigen(String value) {
    this.idorigen = value;
  }

  /**
   * Gets the value of the idempresa property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdempresa() {
    return idempresa;
  }

  /**
   * Sets the value of the idempresa property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdempresa(String value) {
    this.idempresa = value;
  }

  /**
   * Gets the value of the fechainicio property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getFechainicio() {
    return fechainicio;
  }

  /**
   * Sets the value of the fechainicio property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setFechainicio(String value) {
    this.fechainicio = value;
  }

  /**
   * Gets the value of the icmParametrosentradaRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParametrosentradaRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getIcmParametrosentradaRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParametrosentradaRecord }
   *
   *
   */
  public List<IcmParametrosentradaRecord> getIcmParametrosentradaRecordSet() {
    if (icmParametrosentradaRecordSet == null) {
      icmParametrosentradaRecordSet = new ArrayList<IcmParametrosentradaRecord>();
    }
    return this.icmParametrosentradaRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParametrosentradaBlock that = ((IcmParametrosentradaBlock) object);
    {
      String lhsAmbito;
      lhsAmbito = this.getAmbito();
      String rhsAmbito;
      rhsAmbito = that.getAmbito();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "ambito", lhsAmbito), LocatorUtils.property(thatLocator, "ambito", rhsAmbito),
          lhsAmbito, rhsAmbito, (this.ambito != null), (that.ambito != null))) {
        return false;
      }
    }
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
      String lhsIdcadena;
      lhsIdcadena = this.getIdcadena();
      String rhsIdcadena;
      rhsIdcadena = that.getIdcadena();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idcadena", lhsIdcadena),
          LocatorUtils.property(thatLocator, "idcadena", rhsIdcadena), lhsIdcadena, rhsIdcadena, (this.idcadena != null),
          (that.idcadena != null))) {
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
      String lhsIdempresa;
      lhsIdempresa = this.getIdempresa();
      String rhsIdempresa;
      rhsIdempresa = that.getIdempresa();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idempresa", lhsIdempresa),
          LocatorUtils.property(thatLocator, "idempresa", rhsIdempresa), lhsIdempresa, rhsIdempresa, (this.idempresa != null),
          (that.idempresa != null))) {
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
      List<IcmParametrosentradaRecord> lhsIcmParametrosentradaRecordSet;
      lhsIcmParametrosentradaRecordSet = (((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty()))
          ? this.getIcmParametrosentradaRecordSet()
          : null);
      List<IcmParametrosentradaRecord> rhsIcmParametrosentradaRecordSet;
      rhsIcmParametrosentradaRecordSet = (((that.icmParametrosentradaRecordSet != null) && (!that.icmParametrosentradaRecordSet.isEmpty()))
          ? that.getIcmParametrosentradaRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosentradaRecordSet", lhsIcmParametrosentradaRecordSet),
          LocatorUtils.property(thatLocator, "icmParametrosentradaRecordSet", rhsIcmParametrosentradaRecordSet),
          lhsIcmParametrosentradaRecordSet, rhsIcmParametrosentradaRecordSet,
          ((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty())),
          ((that.icmParametrosentradaRecordSet != null) && (!that.icmParametrosentradaRecordSet.isEmpty())))) {
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
      String theAmbito;
      theAmbito = this.getAmbito();
      strategy.appendField(locator, this, "ambito", buffer, theAmbito, (this.ambito != null));
    }
    {
      String theFechafin;
      theFechafin = this.getFechafin();
      strategy.appendField(locator, this, "fechafin", buffer, theFechafin, (this.fechafin != null));
    }
    {
      String theIdcadena;
      theIdcadena = this.getIdcadena();
      strategy.appendField(locator, this, "idcadena", buffer, theIdcadena, (this.idcadena != null));
    }
    {
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      strategy.appendField(locator, this, "idorigen", buffer, theIdorigen, (this.idorigen != null));
    }
    {
      String theIdempresa;
      theIdempresa = this.getIdempresa();
      strategy.appendField(locator, this, "idempresa", buffer, theIdempresa, (this.idempresa != null));
    }
    {
      String theFechainicio;
      theFechainicio = this.getFechainicio();
      strategy.appendField(locator, this, "fechainicio", buffer, theFechainicio, (this.fechainicio != null));
    }
    {
      List<IcmParametrosentradaRecord> theIcmParametrosentradaRecordSet;
      theIcmParametrosentradaRecordSet = (((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty()))
          ? this.getIcmParametrosentradaRecordSet()
          : null);
      strategy.appendField(locator, this, "icmParametrosentradaRecordSet", buffer, theIcmParametrosentradaRecordSet,
          ((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theAmbito;
      theAmbito = this.getAmbito();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "ambito", theAmbito), currentHashCode, theAmbito, (this.ambito != null));
    }
    {
      String theFechafin;
      theFechafin = this.getFechafin();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "fechafin", theFechafin), currentHashCode, theFechafin, (this.fechafin != null));
    }
    {
      String theIdcadena;
      theIdcadena = this.getIdcadena();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "idcadena", theIdcadena), currentHashCode, theIdcadena, (this.idcadena != null));
    }
    {
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "idorigen", theIdorigen), currentHashCode, theIdorigen, (this.idorigen != null));
    }
    {
      String theIdempresa;
      theIdempresa = this.getIdempresa();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idempresa", theIdempresa), currentHashCode, theIdempresa,
          (this.idempresa != null));
    }
    {
      String theFechainicio;
      theFechainicio = this.getFechainicio();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechainicio", theFechainicio), currentHashCode, theFechainicio,
          (this.fechainicio != null));
    }
    {
      List<IcmParametrosentradaRecord> theIcmParametrosentradaRecordSet;
      theIcmParametrosentradaRecordSet = (((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty()))
          ? this.getIcmParametrosentradaRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosentradaRecordSet", theIcmParametrosentradaRecordSet),
          currentHashCode, theIcmParametrosentradaRecordSet,
          ((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParametrosentradaBlock) {
      final IcmParametrosentradaBlock copy = ((IcmParametrosentradaBlock) draftCopy);
      {
        Boolean ambitoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.ambito != null));
        if (ambitoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceAmbito;
          sourceAmbito = this.getAmbito();
          String copyAmbito =
              ((String) strategy.copy(LocatorUtils.property(locator, "ambito", sourceAmbito), sourceAmbito, (this.ambito != null)));
          copy.setAmbito(copyAmbito);
        } else {
          if (ambitoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.ambito = null;
          }
        }
      }
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
        Boolean idcadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idcadena != null));
        if (idcadenaShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdcadena;
          sourceIdcadena = this.getIdcadena();
          String copyIdcadena =
              ((String) strategy.copy(LocatorUtils.property(locator, "idcadena", sourceIdcadena), sourceIdcadena, (this.idcadena != null)));
          copy.setIdcadena(copyIdcadena);
        } else {
          if (idcadenaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idcadena = null;
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
        Boolean idempresaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idempresa != null));
        if (idempresaShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdempresa;
          sourceIdempresa = this.getIdempresa();
          String copyIdempresa = ((String) strategy.copy(LocatorUtils.property(locator, "idempresa", sourceIdempresa), sourceIdempresa,
              (this.idempresa != null)));
          copy.setIdempresa(copyIdempresa);
        } else {
          if (idempresaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idempresa = null;
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
        Boolean icmParametrosentradaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty())));
        if (icmParametrosentradaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParametrosentradaRecord> sourceIcmParametrosentradaRecordSet;
          sourceIcmParametrosentradaRecordSet =
              (((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty()))
                  ? this.getIcmParametrosentradaRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParametrosentradaRecord> copyIcmParametrosentradaRecordSet = ((List<IcmParametrosentradaRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParametrosentradaRecordSet", sourceIcmParametrosentradaRecordSet),
              sourceIcmParametrosentradaRecordSet,
              ((this.icmParametrosentradaRecordSet != null) && (!this.icmParametrosentradaRecordSet.isEmpty()))));
          copy.icmParametrosentradaRecordSet = null;
          if (copyIcmParametrosentradaRecordSet != null) {
            List<IcmParametrosentradaRecord> uniqueIcmParametrosentradaRecordSetl = copy.getIcmParametrosentradaRecordSet();
            uniqueIcmParametrosentradaRecordSetl.addAll(copyIcmParametrosentradaRecordSet);
          }
        } else {
          if (icmParametrosentradaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParametrosentradaRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParametrosentradaBlock();
  }

}
