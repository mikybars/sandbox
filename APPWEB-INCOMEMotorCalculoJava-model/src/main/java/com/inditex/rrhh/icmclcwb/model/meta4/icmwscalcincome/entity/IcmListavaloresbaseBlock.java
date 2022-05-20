
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
 * <p>Clase Java para Icm_ListavaloresbaseBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListavaloresbaseBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idestructurabase" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ListavaloresbaseRecordSet" type="{http://schemas.meta4.com/}Icm_ListavaloresbaseRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListavaloresbaseBlock", propOrder = {
    "idestructurabase",
    "icmListavaloresbaseRecordSet"
})
public class IcmListavaloresbaseBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String idestructurabase;

  @XmlElement(name = "Icm_ListavaloresbaseRecordSet", nillable = true)
  protected List<IcmListavaloresbaseRecord> icmListavaloresbaseRecordSet;

  /**
   * Obtiene el valor de la propiedad idestructurabase.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdestructurabase() {
    return idestructurabase;
  }

  /**
   * Define el valor de la propiedad idestructurabase.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdestructurabase(String value) {
    this.idestructurabase = value;
  }

  /**
   * Gets the value of the icmListavaloresbaseRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListavaloresbaseRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListavaloresbaseRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListavaloresbaseRecord }
   *
   *
   */
  public List<IcmListavaloresbaseRecord> getIcmListavaloresbaseRecordSet() {
    if (icmListavaloresbaseRecordSet == null) {
      icmListavaloresbaseRecordSet = new ArrayList<IcmListavaloresbaseRecord>();
    }
    return this.icmListavaloresbaseRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListavaloresbaseBlock that = ((IcmListavaloresbaseBlock) object);
    {
      String lhsIdestructurabase;
      lhsIdestructurabase = this.getIdestructurabase();
      String rhsIdestructurabase;
      rhsIdestructurabase = that.getIdestructurabase();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idestructurabase", lhsIdestructurabase),
          LocatorUtils.property(thatLocator, "idestructurabase", rhsIdestructurabase), lhsIdestructurabase, rhsIdestructurabase,
          (this.idestructurabase != null), (that.idestructurabase != null))) {
        return false;
      }
    }
    {
      List<IcmListavaloresbaseRecord> lhsIcmListavaloresbaseRecordSet;
      lhsIcmListavaloresbaseRecordSet = (((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty()))
          ? this.getIcmListavaloresbaseRecordSet()
          : null);
      List<IcmListavaloresbaseRecord> rhsIcmListavaloresbaseRecordSet;
      rhsIcmListavaloresbaseRecordSet = (((that.icmListavaloresbaseRecordSet != null) && (!that.icmListavaloresbaseRecordSet.isEmpty()))
          ? that.getIcmListavaloresbaseRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListavaloresbaseRecordSet", lhsIcmListavaloresbaseRecordSet),
          LocatorUtils.property(thatLocator, "icmListavaloresbaseRecordSet", rhsIcmListavaloresbaseRecordSet),
          lhsIcmListavaloresbaseRecordSet, rhsIcmListavaloresbaseRecordSet,
          ((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty())),
          ((that.icmListavaloresbaseRecordSet != null) && (!that.icmListavaloresbaseRecordSet.isEmpty())))) {
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
      String theIdestructurabase;
      theIdestructurabase = this.getIdestructurabase();
      strategy.appendField(locator, this, "idestructurabase", buffer, theIdestructurabase, (this.idestructurabase != null));
    }
    {
      List<IcmListavaloresbaseRecord> theIcmListavaloresbaseRecordSet;
      theIcmListavaloresbaseRecordSet = (((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty()))
          ? this.getIcmListavaloresbaseRecordSet()
          : null);
      strategy.appendField(locator, this, "icmListavaloresbaseRecordSet", buffer, theIcmListavaloresbaseRecordSet,
          ((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theIdestructurabase;
      theIdestructurabase = this.getIdestructurabase();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructurabase", theIdestructurabase), currentHashCode,
          theIdestructurabase, (this.idestructurabase != null));
    }
    {
      List<IcmListavaloresbaseRecord> theIcmListavaloresbaseRecordSet;
      theIcmListavaloresbaseRecordSet = (((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty()))
          ? this.getIcmListavaloresbaseRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListavaloresbaseRecordSet", theIcmListavaloresbaseRecordSet),
          currentHashCode, theIcmListavaloresbaseRecordSet,
          ((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListavaloresbaseBlock) {
      final IcmListavaloresbaseBlock copy = ((IcmListavaloresbaseBlock) draftCopy);
      {
        Boolean idestructurabaseShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestructurabase != null));
        if (idestructurabaseShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdestructurabase;
          sourceIdestructurabase = this.getIdestructurabase();
          String copyIdestructurabase = ((String) strategy.copy(LocatorUtils.property(locator, "idestructurabase", sourceIdestructurabase),
              sourceIdestructurabase, (this.idestructurabase != null)));
          copy.setIdestructurabase(copyIdestructurabase);
        } else {
          if (idestructurabaseShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idestructurabase = null;
          }
        }
      }
      {
        Boolean icmListavaloresbaseRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty())));
        if (icmListavaloresbaseRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListavaloresbaseRecord> sourceIcmListavaloresbaseRecordSet;
          sourceIcmListavaloresbaseRecordSet =
              (((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty()))
                  ? this.getIcmListavaloresbaseRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListavaloresbaseRecord> copyIcmListavaloresbaseRecordSet = ((List<IcmListavaloresbaseRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListavaloresbaseRecordSet", sourceIcmListavaloresbaseRecordSet),
              sourceIcmListavaloresbaseRecordSet,
              ((this.icmListavaloresbaseRecordSet != null) && (!this.icmListavaloresbaseRecordSet.isEmpty()))));
          copy.icmListavaloresbaseRecordSet = null;
          if (copyIcmListavaloresbaseRecordSet != null) {
            List<IcmListavaloresbaseRecord> uniqueIcmListavaloresbaseRecordSetl = copy.getIcmListavaloresbaseRecordSet();
            uniqueIcmListavaloresbaseRecordSetl.addAll(copyIcmListavaloresbaseRecordSet);
          }
        } else {
          if (icmListavaloresbaseRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListavaloresbaseRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListavaloresbaseBlock();
  }

}
