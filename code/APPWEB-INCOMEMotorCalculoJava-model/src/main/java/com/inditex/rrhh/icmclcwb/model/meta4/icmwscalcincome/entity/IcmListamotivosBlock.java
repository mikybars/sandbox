
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
 * <p>Java class for Icm_ListamotivosBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListamotivosBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListamotivosRecordSet" type="{http://schemas.meta4.com/}Icm_ListamotivosRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListamotivosBlock", propOrder = {
    "icmListamotivosRecordSet"
})
public class IcmListamotivosBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListamotivosRecordSet", nillable = true)
  protected List<IcmListamotivosRecord> icmListamotivosRecordSet;

  /**
   * Gets the value of the icmListamotivosRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListamotivosRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getIcmListamotivosRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListamotivosRecord }
   *
   *
   */
  public List<IcmListamotivosRecord> getIcmListamotivosRecordSet() {
    if (icmListamotivosRecordSet == null) {
      icmListamotivosRecordSet = new ArrayList<IcmListamotivosRecord>();
    }
    return this.icmListamotivosRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListamotivosBlock that = ((IcmListamotivosBlock) object);
    {
      List<IcmListamotivosRecord> lhsIcmListamotivosRecordSet;
      lhsIcmListamotivosRecordSet =
          (((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())) ? this.getIcmListamotivosRecordSet()
              : null);
      List<IcmListamotivosRecord> rhsIcmListamotivosRecordSet;
      rhsIcmListamotivosRecordSet =
          (((that.icmListamotivosRecordSet != null) && (!that.icmListamotivosRecordSet.isEmpty())) ? that.getIcmListamotivosRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListamotivosRecordSet", lhsIcmListamotivosRecordSet),
          LocatorUtils.property(thatLocator, "icmListamotivosRecordSet", rhsIcmListamotivosRecordSet), lhsIcmListamotivosRecordSet,
          rhsIcmListamotivosRecordSet, ((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())),
          ((that.icmListamotivosRecordSet != null) && (!that.icmListamotivosRecordSet.isEmpty())))) {
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
      List<IcmListamotivosRecord> theIcmListamotivosRecordSet;
      theIcmListamotivosRecordSet =
          (((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())) ? this.getIcmListamotivosRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListamotivosRecordSet", buffer, theIcmListamotivosRecordSet,
          ((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListamotivosRecord> theIcmListamotivosRecordSet;
      theIcmListamotivosRecordSet =
          (((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())) ? this.getIcmListamotivosRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListamotivosRecordSet", theIcmListamotivosRecordSet), currentHashCode,
              theIcmListamotivosRecordSet, ((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListamotivosBlock) {
      final IcmListamotivosBlock copy = ((IcmListamotivosBlock) draftCopy);
      {
        Boolean icmListamotivosRecordSetShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, ((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())));
        if (icmListamotivosRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListamotivosRecord> sourceIcmListamotivosRecordSet;
          sourceIcmListamotivosRecordSet =
              (((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty())) ? this.getIcmListamotivosRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListamotivosRecord> copyIcmListamotivosRecordSet = ((List<IcmListamotivosRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListamotivosRecordSet", sourceIcmListamotivosRecordSet), sourceIcmListamotivosRecordSet,
              ((this.icmListamotivosRecordSet != null) && (!this.icmListamotivosRecordSet.isEmpty()))));
          copy.icmListamotivosRecordSet = null;
          if (copyIcmListamotivosRecordSet != null) {
            List<IcmListamotivosRecord> uniqueIcmListamotivosRecordSetl = copy.getIcmListamotivosRecordSet();
            uniqueIcmListamotivosRecordSetl.addAll(copyIcmListamotivosRecordSet);
          }
        } else {
          if (icmListamotivosRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListamotivosRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListamotivosBlock();
  }

}
