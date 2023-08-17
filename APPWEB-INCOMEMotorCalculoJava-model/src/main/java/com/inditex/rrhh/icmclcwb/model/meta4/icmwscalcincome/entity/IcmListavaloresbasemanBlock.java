
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
 * <p>Java class for Icm_ListavaloresbasemanBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListavaloresbasemanBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idestructurabase" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ListavaloresbasemanRecordSet" type="{http://schemas.meta4.com/}Icm_ListavaloresbasemanRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListavaloresbasemanBlock", propOrder = {
    "idestructurabase",
    "icmListavaloresbasemanRecordSet"
})
public class IcmListavaloresbasemanBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String idestructurabase;

  @XmlElement(name = "Icm_ListavaloresbasemanRecordSet", nillable = true)
  protected List<IcmListavaloresbasemanRecord> icmListavaloresbasemanRecordSet;

  /**
   * Gets the value of the idestructurabase property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdestructurabase() {
    return idestructurabase;
  }

  /**
   * Sets the value of the idestructurabase property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdestructurabase(String value) {
    this.idestructurabase = value;
  }

  /**
   * Gets the value of the icmListavaloresbasemanRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListavaloresbasemanRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListavaloresbasemanRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListavaloresbasemanRecord }
   *
   *
   */
  public List<IcmListavaloresbasemanRecord> getIcmListavaloresbasemanRecordSet() {
    if (icmListavaloresbasemanRecordSet == null) {
      icmListavaloresbasemanRecordSet = new ArrayList<IcmListavaloresbasemanRecord>();
    }
    return this.icmListavaloresbasemanRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListavaloresbasemanBlock that = ((IcmListavaloresbasemanBlock) object);
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
      List<IcmListavaloresbasemanRecord> lhsIcmListavaloresbasemanRecordSet;
      lhsIcmListavaloresbasemanRecordSet =
          (((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty()))
              ? this.getIcmListavaloresbasemanRecordSet()
              : null);
      List<IcmListavaloresbasemanRecord> rhsIcmListavaloresbasemanRecordSet;
      rhsIcmListavaloresbasemanRecordSet =
          (((that.icmListavaloresbasemanRecordSet != null) && (!that.icmListavaloresbasemanRecordSet.isEmpty()))
              ? that.getIcmListavaloresbasemanRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListavaloresbasemanRecordSet", lhsIcmListavaloresbasemanRecordSet),
          LocatorUtils.property(thatLocator, "icmListavaloresbasemanRecordSet", rhsIcmListavaloresbasemanRecordSet),
          lhsIcmListavaloresbasemanRecordSet, rhsIcmListavaloresbasemanRecordSet,
          ((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty())),
          ((that.icmListavaloresbasemanRecordSet != null) && (!that.icmListavaloresbasemanRecordSet.isEmpty())))) {
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
      List<IcmListavaloresbasemanRecord> theIcmListavaloresbasemanRecordSet;
      theIcmListavaloresbasemanRecordSet =
          (((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty()))
              ? this.getIcmListavaloresbasemanRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListavaloresbasemanRecordSet", buffer, theIcmListavaloresbasemanRecordSet,
          ((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty())));
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
      List<IcmListavaloresbasemanRecord> theIcmListavaloresbasemanRecordSet;
      theIcmListavaloresbasemanRecordSet =
          (((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty()))
              ? this.getIcmListavaloresbasemanRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListavaloresbasemanRecordSet", theIcmListavaloresbasemanRecordSet),
              currentHashCode, theIcmListavaloresbasemanRecordSet,
              ((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListavaloresbasemanBlock) {
      final IcmListavaloresbasemanBlock copy = ((IcmListavaloresbasemanBlock) draftCopy);
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
        Boolean icmListavaloresbasemanRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty())));
        if (icmListavaloresbasemanRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListavaloresbasemanRecord> sourceIcmListavaloresbasemanRecordSet;
          sourceIcmListavaloresbasemanRecordSet =
              (((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty()))
                  ? this.getIcmListavaloresbasemanRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListavaloresbasemanRecord> copyIcmListavaloresbasemanRecordSet = ((List<IcmListavaloresbasemanRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListavaloresbasemanRecordSet", sourceIcmListavaloresbasemanRecordSet),
              sourceIcmListavaloresbasemanRecordSet,
              ((this.icmListavaloresbasemanRecordSet != null) && (!this.icmListavaloresbasemanRecordSet.isEmpty()))));
          copy.icmListavaloresbasemanRecordSet = null;
          if (copyIcmListavaloresbasemanRecordSet != null) {
            List<IcmListavaloresbasemanRecord> uniqueIcmListavaloresbasemanRecordSetl = copy.getIcmListavaloresbasemanRecordSet();
            uniqueIcmListavaloresbasemanRecordSetl.addAll(copyIcmListavaloresbasemanRecordSet);
          }
        } else {
          if (icmListavaloresbasemanRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListavaloresbasemanRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListavaloresbasemanBlock();
  }

}
