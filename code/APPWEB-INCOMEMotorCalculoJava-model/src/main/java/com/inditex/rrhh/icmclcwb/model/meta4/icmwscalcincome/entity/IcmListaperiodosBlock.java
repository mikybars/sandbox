
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
 * <p>Java class for Icm_ListaperiodosBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaperiodosBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaperiodosRecordSet" type="{http://schemas.meta4.com/}Icm_ListaperiodosRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaperiodosBlock", propOrder = {
    "icmListaperiodosRecordSet"
})
public class IcmListaperiodosBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListaperiodosRecordSet", nillable = true)
  protected List<IcmListaperiodosRecord> icmListaperiodosRecordSet;

  /**
   * Gets the value of the icmListaperiodosRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListaperiodosRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getIcmListaperiodosRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListaperiodosRecord }
   *
   *
   */
  public List<IcmListaperiodosRecord> getIcmListaperiodosRecordSet() {
    if (icmListaperiodosRecordSet == null) {
      icmListaperiodosRecordSet = new ArrayList<IcmListaperiodosRecord>();
    }
    return this.icmListaperiodosRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListaperiodosBlock that = ((IcmListaperiodosBlock) object);
    {
      List<IcmListaperiodosRecord> lhsIcmListaperiodosRecordSet;
      lhsIcmListaperiodosRecordSet =
          (((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty())) ? this.getIcmListaperiodosRecordSet()
              : null);
      List<IcmListaperiodosRecord> rhsIcmListaperiodosRecordSet;
      rhsIcmListaperiodosRecordSet =
          (((that.icmListaperiodosRecordSet != null) && (!that.icmListaperiodosRecordSet.isEmpty())) ? that.getIcmListaperiodosRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaperiodosRecordSet", lhsIcmListaperiodosRecordSet),
          LocatorUtils.property(thatLocator, "icmListaperiodosRecordSet", rhsIcmListaperiodosRecordSet), lhsIcmListaperiodosRecordSet,
          rhsIcmListaperiodosRecordSet, ((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty())),
          ((that.icmListaperiodosRecordSet != null) && (!that.icmListaperiodosRecordSet.isEmpty())))) {
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
      List<IcmListaperiodosRecord> theIcmListaperiodosRecordSet;
      theIcmListaperiodosRecordSet =
          (((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty())) ? this.getIcmListaperiodosRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListaperiodosRecordSet", buffer, theIcmListaperiodosRecordSet,
          ((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListaperiodosRecord> theIcmListaperiodosRecordSet;
      theIcmListaperiodosRecordSet =
          (((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty())) ? this.getIcmListaperiodosRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListaperiodosRecordSet", theIcmListaperiodosRecordSet), currentHashCode,
              theIcmListaperiodosRecordSet, ((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListaperiodosBlock) {
      final IcmListaperiodosBlock copy = ((IcmListaperiodosBlock) draftCopy);
      {
        Boolean icmListaperiodosRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty())));
        if (icmListaperiodosRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListaperiodosRecord> sourceIcmListaperiodosRecordSet;
          sourceIcmListaperiodosRecordSet = (((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty()))
              ? this.getIcmListaperiodosRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmListaperiodosRecord> copyIcmListaperiodosRecordSet = ((List<IcmListaperiodosRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListaperiodosRecordSet", sourceIcmListaperiodosRecordSet), sourceIcmListaperiodosRecordSet,
              ((this.icmListaperiodosRecordSet != null) && (!this.icmListaperiodosRecordSet.isEmpty()))));
          copy.icmListaperiodosRecordSet = null;
          if (copyIcmListaperiodosRecordSet != null) {
            List<IcmListaperiodosRecord> uniqueIcmListaperiodosRecordSetl = copy.getIcmListaperiodosRecordSet();
            uniqueIcmListaperiodosRecordSetl.addAll(copyIcmListaperiodosRecordSet);
          }
        } else {
          if (icmListaperiodosRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListaperiodosRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListaperiodosBlock();
  }

}
