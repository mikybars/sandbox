
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
 * <p>Clase Java para Icm_ParamcalsistdestinoBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalsistdestinoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idorigen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParamcalsistdestinoRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalsistdestinoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalsistdestinoBlock", propOrder = {
    "idorigen",
    "icmParamcalsistdestinoRecordSet"
})
public class IcmParamcalsistdestinoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String idorigen;

  @XmlElement(name = "Icm_ParamcalsistdestinoRecordSet", nillable = true)
  protected List<IcmParamcalsistdestinoRecord> icmParamcalsistdestinoRecordSet;

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
   * Gets the value of the icmParamcalsistdestinoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParamcalsistdestinoRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmParamcalsistdestinoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalsistdestinoRecord }
   *
   *
   */
  public List<IcmParamcalsistdestinoRecord> getIcmParamcalsistdestinoRecordSet() {
    if (icmParamcalsistdestinoRecordSet == null) {
      icmParamcalsistdestinoRecordSet = new ArrayList<IcmParamcalsistdestinoRecord>();
    }
    return this.icmParamcalsistdestinoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalsistdestinoBlock that = ((IcmParamcalsistdestinoBlock) object);
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
      List<IcmParamcalsistdestinoRecord> lhsIcmParamcalsistdestinoRecordSet;
      lhsIcmParamcalsistdestinoRecordSet =
          (((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty()))
              ? this.getIcmParamcalsistdestinoRecordSet()
              : null);
      List<IcmParamcalsistdestinoRecord> rhsIcmParamcalsistdestinoRecordSet;
      rhsIcmParamcalsistdestinoRecordSet =
          (((that.icmParamcalsistdestinoRecordSet != null) && (!that.icmParamcalsistdestinoRecordSet.isEmpty()))
              ? that.getIcmParamcalsistdestinoRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalsistdestinoRecordSet", lhsIcmParamcalsistdestinoRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalsistdestinoRecordSet", rhsIcmParamcalsistdestinoRecordSet),
          lhsIcmParamcalsistdestinoRecordSet, rhsIcmParamcalsistdestinoRecordSet,
          ((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty())),
          ((that.icmParamcalsistdestinoRecordSet != null) && (!that.icmParamcalsistdestinoRecordSet.isEmpty())))) {
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
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      strategy.appendField(locator, this, "idorigen", buffer, theIdorigen, (this.idorigen != null));
    }
    {
      List<IcmParamcalsistdestinoRecord> theIcmParamcalsistdestinoRecordSet;
      theIcmParamcalsistdestinoRecordSet =
          (((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty()))
              ? this.getIcmParamcalsistdestinoRecordSet()
              : null);
      strategy.appendField(locator, this, "icmParamcalsistdestinoRecordSet", buffer, theIcmParamcalsistdestinoRecordSet,
          ((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theIdorigen;
      theIdorigen = this.getIdorigen();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "idorigen", theIdorigen), currentHashCode, theIdorigen, (this.idorigen != null));
    }
    {
      List<IcmParamcalsistdestinoRecord> theIcmParamcalsistdestinoRecordSet;
      theIcmParamcalsistdestinoRecordSet =
          (((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty()))
              ? this.getIcmParamcalsistdestinoRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmParamcalsistdestinoRecordSet", theIcmParamcalsistdestinoRecordSet),
              currentHashCode, theIcmParamcalsistdestinoRecordSet,
              ((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalsistdestinoBlock) {
      final IcmParamcalsistdestinoBlock copy = ((IcmParamcalsistdestinoBlock) draftCopy);
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
        Boolean icmParamcalsistdestinoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty())));
        if (icmParamcalsistdestinoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalsistdestinoRecord> sourceIcmParamcalsistdestinoRecordSet;
          sourceIcmParamcalsistdestinoRecordSet =
              (((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty()))
                  ? this.getIcmParamcalsistdestinoRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalsistdestinoRecord> copyIcmParamcalsistdestinoRecordSet = ((List<IcmParamcalsistdestinoRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParamcalsistdestinoRecordSet", sourceIcmParamcalsistdestinoRecordSet),
              sourceIcmParamcalsistdestinoRecordSet,
              ((this.icmParamcalsistdestinoRecordSet != null) && (!this.icmParamcalsistdestinoRecordSet.isEmpty()))));
          copy.icmParamcalsistdestinoRecordSet = null;
          if (copyIcmParamcalsistdestinoRecordSet != null) {
            List<IcmParamcalsistdestinoRecord> uniqueIcmParamcalsistdestinoRecordSetl = copy.getIcmParamcalsistdestinoRecordSet();
            uniqueIcmParamcalsistdestinoRecordSetl.addAll(copyIcmParamcalsistdestinoRecordSet);
          }
        } else {
          if (icmParamcalsistdestinoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalsistdestinoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalsistdestinoBlock();
  }

}
