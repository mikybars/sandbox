
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
 * <p>Java class for Icm_ParamcalprocesoBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalprocesoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idambito" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idorigen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idperiodo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idtrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idusuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idorganization" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idtpejeccalculo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParamcalprocesoRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalprocesoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalprocesoBlock", propOrder = {
    "idambito",
    "idorigen",
    "idperiodo",
    "idtrabajo",
    "idusuario",
    "idorganization",
    "idtpejeccalculo",
    "icmParamcalprocesoRecordSet"
})
public class IcmParamcalprocesoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String idambito;

  @XmlElement(required = true, nillable = true)
  protected String idorigen;

  @XmlElement(required = true, nillable = true)
  protected String idperiodo;

  @XmlElement(required = true, nillable = true)
  protected String idtrabajo;

  @XmlElement(required = true, nillable = true)
  protected String idusuario;

  @XmlElement(required = true, nillable = true)
  protected String idorganization;

  @XmlElement(required = true, nillable = true)
  protected String idtpejeccalculo;

  @XmlElement(name = "Icm_ParamcalprocesoRecordSet", nillable = true)
  protected List<IcmParamcalprocesoRecord> icmParamcalprocesoRecordSet;

  /**
   * Gets the value of the idambito property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdambito() {
    return idambito;
  }

  /**
   * Sets the value of the idambito property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdambito(String value) {
    this.idambito = value;
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
   * Gets the value of the idperiodo property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdperiodo() {
    return idperiodo;
  }

  /**
   * Sets the value of the idperiodo property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdperiodo(String value) {
    this.idperiodo = value;
  }

  /**
   * Gets the value of the idtrabajo property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdtrabajo() {
    return idtrabajo;
  }

  /**
   * Sets the value of the idtrabajo property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdtrabajo(String value) {
    this.idtrabajo = value;
  }

  /**
   * Gets the value of the idusuario property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdusuario() {
    return idusuario;
  }

  /**
   * Sets the value of the idusuario property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdusuario(String value) {
    this.idusuario = value;
  }

  /**
   * Gets the value of the idorganization property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdorganization() {
    return idorganization;
  }

  /**
   * Sets the value of the idorganization property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdorganization(String value) {
    this.idorganization = value;
  }

  /**
   * Gets the value of the idtpejeccalculo property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdtpejeccalculo() {
    return idtpejeccalculo;
  }

  /**
   * Sets the value of the idtpejeccalculo property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdtpejeccalculo(String value) {
    this.idtpejeccalculo = value;
  }

  /**
   * Gets the value of the icmParamcalprocesoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParamcalprocesoRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getIcmParamcalprocesoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalprocesoRecord }
   *
   *
   */
  public List<IcmParamcalprocesoRecord> getIcmParamcalprocesoRecordSet() {
    if (icmParamcalprocesoRecordSet == null) {
      icmParamcalprocesoRecordSet = new ArrayList<IcmParamcalprocesoRecord>();
    }
    return this.icmParamcalprocesoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalprocesoBlock that = ((IcmParamcalprocesoBlock) object);
    {
      String lhsIdambito;
      lhsIdambito = this.getIdambito();
      String rhsIdambito;
      rhsIdambito = that.getIdambito();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idambito", lhsIdambito),
          LocatorUtils.property(thatLocator, "idambito", rhsIdambito), lhsIdambito, rhsIdambito, (this.idambito != null),
          (that.idambito != null))) {
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
      String lhsIdperiodo;
      lhsIdperiodo = this.getIdperiodo();
      String rhsIdperiodo;
      rhsIdperiodo = that.getIdperiodo();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idperiodo", lhsIdperiodo),
          LocatorUtils.property(thatLocator, "idperiodo", rhsIdperiodo), lhsIdperiodo, rhsIdperiodo, (this.idperiodo != null),
          (that.idperiodo != null))) {
        return false;
      }
    }
    {
      String lhsIdtrabajo;
      lhsIdtrabajo = this.getIdtrabajo();
      String rhsIdtrabajo;
      rhsIdtrabajo = that.getIdtrabajo();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idtrabajo", lhsIdtrabajo),
          LocatorUtils.property(thatLocator, "idtrabajo", rhsIdtrabajo), lhsIdtrabajo, rhsIdtrabajo, (this.idtrabajo != null),
          (that.idtrabajo != null))) {
        return false;
      }
    }
    {
      String lhsIdusuario;
      lhsIdusuario = this.getIdusuario();
      String rhsIdusuario;
      rhsIdusuario = that.getIdusuario();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idusuario", lhsIdusuario),
          LocatorUtils.property(thatLocator, "idusuario", rhsIdusuario), lhsIdusuario, rhsIdusuario, (this.idusuario != null),
          (that.idusuario != null))) {
        return false;
      }
    }
    {
      String lhsIdorganization;
      lhsIdorganization = this.getIdorganization();
      String rhsIdorganization;
      rhsIdorganization = that.getIdorganization();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idorganization", lhsIdorganization),
          LocatorUtils.property(thatLocator, "idorganization", rhsIdorganization), lhsIdorganization, rhsIdorganization,
          (this.idorganization != null), (that.idorganization != null))) {
        return false;
      }
    }
    {
      String lhsIdtpejeccalculo;
      lhsIdtpejeccalculo = this.getIdtpejeccalculo();
      String rhsIdtpejeccalculo;
      rhsIdtpejeccalculo = that.getIdtpejeccalculo();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idtpejeccalculo", lhsIdtpejeccalculo),
          LocatorUtils.property(thatLocator, "idtpejeccalculo", rhsIdtpejeccalculo), lhsIdtpejeccalculo, rhsIdtpejeccalculo,
          (this.idtpejeccalculo != null), (that.idtpejeccalculo != null))) {
        return false;
      }
    }
    {
      List<IcmParamcalprocesoRecord> lhsIcmParamcalprocesoRecordSet;
      lhsIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty()))
          ? this.getIcmParamcalprocesoRecordSet()
          : null);
      List<IcmParamcalprocesoRecord> rhsIcmParamcalprocesoRecordSet;
      rhsIcmParamcalprocesoRecordSet = (((that.icmParamcalprocesoRecordSet != null) && (!that.icmParamcalprocesoRecordSet.isEmpty()))
          ? that.getIcmParamcalprocesoRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalprocesoRecordSet", lhsIcmParamcalprocesoRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalprocesoRecordSet", rhsIcmParamcalprocesoRecordSet), lhsIcmParamcalprocesoRecordSet,
          rhsIcmParamcalprocesoRecordSet, ((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty())),
          ((that.icmParamcalprocesoRecordSet != null) && (!that.icmParamcalprocesoRecordSet.isEmpty())))) {
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
      String theIdambito;
      theIdambito = this.getIdambito();
      strategy.appendField(locator, this, "idambito", buffer, theIdambito, (this.idambito != null));
    }
    {
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      strategy.appendField(locator, this, "idorigen", buffer, theIdorigen, (this.idorigen != null));
    }
    {
      String theIdperiodo;
      theIdperiodo = this.getIdperiodo();
      strategy.appendField(locator, this, "idperiodo", buffer, theIdperiodo, (this.idperiodo != null));
    }
    {
      String theIdtrabajo;
      theIdtrabajo = this.getIdtrabajo();
      strategy.appendField(locator, this, "idtrabajo", buffer, theIdtrabajo, (this.idtrabajo != null));
    }
    {
      String theIdusuario;
      theIdusuario = this.getIdusuario();
      strategy.appendField(locator, this, "idusuario", buffer, theIdusuario, (this.idusuario != null));
    }
    {
      String theIdorganization;
      theIdorganization = this.getIdorganization();
      strategy.appendField(locator, this, "idorganization", buffer, theIdorganization, (this.idorganization != null));
    }
    {
      String theIdtpejeccalculo;
      theIdtpejeccalculo = this.getIdtpejeccalculo();
      strategy.appendField(locator, this, "idtpejeccalculo", buffer, theIdtpejeccalculo, (this.idtpejeccalculo != null));
    }
    {
      List<IcmParamcalprocesoRecord> theIcmParamcalprocesoRecordSet;
      theIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty()))
          ? this.getIcmParamcalprocesoRecordSet()
          : null);
      strategy.appendField(locator, this, "icmParamcalprocesoRecordSet", buffer, theIcmParamcalprocesoRecordSet,
          ((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theIdambito;
      theIdambito = this.getIdambito();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "idambito", theIdambito), currentHashCode, theIdambito, (this.idambito != null));
    }
    {
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "idorigen", theIdorigen), currentHashCode, theIdorigen, (this.idorigen != null));
    }
    {
      String theIdperiodo;
      theIdperiodo = this.getIdperiodo();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idperiodo", theIdperiodo), currentHashCode, theIdperiodo,
          (this.idperiodo != null));
    }
    {
      String theIdtrabajo;
      theIdtrabajo = this.getIdtrabajo();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idtrabajo", theIdtrabajo), currentHashCode, theIdtrabajo,
          (this.idtrabajo != null));
    }
    {
      String theIdusuario;
      theIdusuario = this.getIdusuario();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idusuario", theIdusuario), currentHashCode, theIdusuario,
          (this.idusuario != null));
    }
    {
      String theIdorganization;
      theIdorganization = this.getIdorganization();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idorganization", theIdorganization), currentHashCode,
          theIdorganization, (this.idorganization != null));
    }
    {
      String theIdtpejeccalculo;
      theIdtpejeccalculo = this.getIdtpejeccalculo();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idtpejeccalculo", theIdtpejeccalculo), currentHashCode,
          theIdtpejeccalculo, (this.idtpejeccalculo != null));
    }
    {
      List<IcmParamcalprocesoRecord> theIcmParamcalprocesoRecordSet;
      theIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty()))
          ? this.getIcmParamcalprocesoRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalprocesoRecordSet", theIcmParamcalprocesoRecordSet),
          currentHashCode, theIcmParamcalprocesoRecordSet,
          ((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalprocesoBlock) {
      final IcmParamcalprocesoBlock copy = ((IcmParamcalprocesoBlock) draftCopy);
      {
        Boolean idambitoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idambito != null));
        if (idambitoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdambito;
          sourceIdambito = this.getIdambito();
          String copyIdambito =
              ((String) strategy.copy(LocatorUtils.property(locator, "idambito", sourceIdambito), sourceIdambito, (this.idambito != null)));
          copy.setIdambito(copyIdambito);
        } else {
          if (idambitoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idambito = null;
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
        Boolean idperiodoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idperiodo != null));
        if (idperiodoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdperiodo;
          sourceIdperiodo = this.getIdperiodo();
          String copyIdperiodo = ((String) strategy.copy(LocatorUtils.property(locator, "idperiodo", sourceIdperiodo), sourceIdperiodo,
              (this.idperiodo != null)));
          copy.setIdperiodo(copyIdperiodo);
        } else {
          if (idperiodoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idperiodo = null;
          }
        }
      }
      {
        Boolean idtrabajoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idtrabajo != null));
        if (idtrabajoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdtrabajo;
          sourceIdtrabajo = this.getIdtrabajo();
          String copyIdtrabajo = ((String) strategy.copy(LocatorUtils.property(locator, "idtrabajo", sourceIdtrabajo), sourceIdtrabajo,
              (this.idtrabajo != null)));
          copy.setIdtrabajo(copyIdtrabajo);
        } else {
          if (idtrabajoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idtrabajo = null;
          }
        }
      }
      {
        Boolean idusuarioShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idusuario != null));
        if (idusuarioShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdusuario;
          sourceIdusuario = this.getIdusuario();
          String copyIdusuario = ((String) strategy.copy(LocatorUtils.property(locator, "idusuario", sourceIdusuario), sourceIdusuario,
              (this.idusuario != null)));
          copy.setIdusuario(copyIdusuario);
        } else {
          if (idusuarioShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idusuario = null;
          }
        }
      }
      {
        Boolean idorganizationShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idorganization != null));
        if (idorganizationShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdorganization;
          sourceIdorganization = this.getIdorganization();
          String copyIdorganization = ((String) strategy.copy(LocatorUtils.property(locator, "idorganization", sourceIdorganization),
              sourceIdorganization, (this.idorganization != null)));
          copy.setIdorganization(copyIdorganization);
        } else {
          if (idorganizationShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idorganization = null;
          }
        }
      }
      {
        Boolean idtpejeccalculoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idtpejeccalculo != null));
        if (idtpejeccalculoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdtpejeccalculo;
          sourceIdtpejeccalculo = this.getIdtpejeccalculo();
          String copyIdtpejeccalculo = ((String) strategy.copy(LocatorUtils.property(locator, "idtpejeccalculo", sourceIdtpejeccalculo),
              sourceIdtpejeccalculo, (this.idtpejeccalculo != null)));
          copy.setIdtpejeccalculo(copyIdtpejeccalculo);
        } else {
          if (idtpejeccalculoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idtpejeccalculo = null;
          }
        }
      }
      {
        Boolean icmParamcalprocesoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty())));
        if (icmParamcalprocesoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalprocesoRecord> sourceIcmParamcalprocesoRecordSet;
          sourceIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty()))
              ? this.getIcmParamcalprocesoRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalprocesoRecord> copyIcmParamcalprocesoRecordSet = ((List<IcmParamcalprocesoRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParamcalprocesoRecordSet", sourceIcmParamcalprocesoRecordSet),
              sourceIcmParamcalprocesoRecordSet,
              ((this.icmParamcalprocesoRecordSet != null) && (!this.icmParamcalprocesoRecordSet.isEmpty()))));
          copy.icmParamcalprocesoRecordSet = null;
          if (copyIcmParamcalprocesoRecordSet != null) {
            List<IcmParamcalprocesoRecord> uniqueIcmParamcalprocesoRecordSetl = copy.getIcmParamcalprocesoRecordSet();
            uniqueIcmParamcalprocesoRecordSetl.addAll(copyIcmParamcalprocesoRecordSet);
          }
        } else {
          if (icmParamcalprocesoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalprocesoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalprocesoBlock();
  }

}
