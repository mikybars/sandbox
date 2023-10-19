
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
 * <p>Java class for Icm_ListadesplazrealBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListadesplazrealBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListadesplazrealRecordSet" type="{http://schemas.meta4.com/}Icm_ListadesplazrealRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListadesplazrealBlock", propOrder = {
    "icmListadesplazrealRecordSet"
})
public class IcmListadesplazrealBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListadesplazrealRecordSet", nillable = true)
  protected List<IcmListadesplazrealRecord> icmListadesplazrealRecordSet;

  /**
   * Gets the value of the icmListadesplazrealRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListadesplazrealRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListadesplazrealRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListadesplazrealRecord }
   *
   *
   */
  public List<IcmListadesplazrealRecord> getIcmListadesplazrealRecordSet() {
    if (icmListadesplazrealRecordSet == null) {
      icmListadesplazrealRecordSet = new ArrayList<IcmListadesplazrealRecord>();
    }
    return this.icmListadesplazrealRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListadesplazrealBlock that = ((IcmListadesplazrealBlock) object);
    {
      List<IcmListadesplazrealRecord> lhsIcmListadesplazrealRecordSet;
      lhsIcmListadesplazrealRecordSet = (((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty()))
          ? this.getIcmListadesplazrealRecordSet()
          : null);
      List<IcmListadesplazrealRecord> rhsIcmListadesplazrealRecordSet;
      rhsIcmListadesplazrealRecordSet = (((that.icmListadesplazrealRecordSet != null) && (!that.icmListadesplazrealRecordSet.isEmpty()))
          ? that.getIcmListadesplazrealRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListadesplazrealRecordSet", lhsIcmListadesplazrealRecordSet),
          LocatorUtils.property(thatLocator, "icmListadesplazrealRecordSet", rhsIcmListadesplazrealRecordSet),
          lhsIcmListadesplazrealRecordSet, rhsIcmListadesplazrealRecordSet,
          ((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty())),
          ((that.icmListadesplazrealRecordSet != null) && (!that.icmListadesplazrealRecordSet.isEmpty())))) {
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
      List<IcmListadesplazrealRecord> theIcmListadesplazrealRecordSet;
      theIcmListadesplazrealRecordSet = (((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty()))
          ? this.getIcmListadesplazrealRecordSet()
          : null);
      strategy.appendField(locator, this, "icmListadesplazrealRecordSet", buffer, theIcmListadesplazrealRecordSet,
          ((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListadesplazrealRecord> theIcmListadesplazrealRecordSet;
      theIcmListadesplazrealRecordSet = (((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty()))
          ? this.getIcmListadesplazrealRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListadesplazrealRecordSet", theIcmListadesplazrealRecordSet),
          currentHashCode, theIcmListadesplazrealRecordSet,
          ((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListadesplazrealBlock) {
      final IcmListadesplazrealBlock copy = ((IcmListadesplazrealBlock) draftCopy);
      {
        Boolean icmListadesplazrealRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty())));
        if (icmListadesplazrealRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListadesplazrealRecord> sourceIcmListadesplazrealRecordSet;
          sourceIcmListadesplazrealRecordSet =
              (((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty()))
                  ? this.getIcmListadesplazrealRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListadesplazrealRecord> copyIcmListadesplazrealRecordSet = ((List<IcmListadesplazrealRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListadesplazrealRecordSet", sourceIcmListadesplazrealRecordSet),
              sourceIcmListadesplazrealRecordSet,
              ((this.icmListadesplazrealRecordSet != null) && (!this.icmListadesplazrealRecordSet.isEmpty()))));
          copy.icmListadesplazrealRecordSet = null;
          if (copyIcmListadesplazrealRecordSet != null) {
            List<IcmListadesplazrealRecord> uniqueIcmListadesplazrealRecordSetl = copy.getIcmListadesplazrealRecordSet();
            uniqueIcmListadesplazrealRecordSetl.addAll(copyIcmListadesplazrealRecordSet);
          }
        } else {
          if (icmListadesplazrealRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListadesplazrealRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListadesplazrealBlock();
  }

}
