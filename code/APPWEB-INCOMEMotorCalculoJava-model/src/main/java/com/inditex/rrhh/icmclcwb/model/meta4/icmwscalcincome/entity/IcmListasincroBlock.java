
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
 * <p>Java class for Icm_ListasincroBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListasincroBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListasincroRecordSet" type="{http://schemas.meta4.com/}Icm_ListasincroRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListasincroBlock", propOrder = {
    "icmListasincroRecordSet"
})
public class IcmListasincroBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListasincroRecordSet", nillable = true)
  protected List<IcmListasincroRecord> icmListasincroRecordSet;

  /**
   * Gets the value of the icmListasincroRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListasincroRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getIcmListasincroRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListasincroRecord }
   *
   *
   */
  public List<IcmListasincroRecord> getIcmListasincroRecordSet() {
    if (icmListasincroRecordSet == null) {
      icmListasincroRecordSet = new ArrayList<IcmListasincroRecord>();
    }
    return this.icmListasincroRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListasincroBlock that = ((IcmListasincroBlock) object);
    {
      List<IcmListasincroRecord> lhsIcmListasincroRecordSet;
      lhsIcmListasincroRecordSet =
          (((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())) ? this.getIcmListasincroRecordSet()
              : null);
      List<IcmListasincroRecord> rhsIcmListasincroRecordSet;
      rhsIcmListasincroRecordSet =
          (((that.icmListasincroRecordSet != null) && (!that.icmListasincroRecordSet.isEmpty())) ? that.getIcmListasincroRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListasincroRecordSet", lhsIcmListasincroRecordSet),
          LocatorUtils.property(thatLocator, "icmListasincroRecordSet", rhsIcmListasincroRecordSet), lhsIcmListasincroRecordSet,
          rhsIcmListasincroRecordSet, ((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())),
          ((that.icmListasincroRecordSet != null) && (!that.icmListasincroRecordSet.isEmpty())))) {
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
      List<IcmListasincroRecord> theIcmListasincroRecordSet;
      theIcmListasincroRecordSet =
          (((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())) ? this.getIcmListasincroRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListasincroRecordSet", buffer, theIcmListasincroRecordSet,
          ((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListasincroRecord> theIcmListasincroRecordSet;
      theIcmListasincroRecordSet =
          (((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())) ? this.getIcmListasincroRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListasincroRecordSet", theIcmListasincroRecordSet), currentHashCode,
              theIcmListasincroRecordSet, ((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListasincroBlock) {
      final IcmListasincroBlock copy = ((IcmListasincroBlock) draftCopy);
      {
        Boolean icmListasincroRecordSetShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, ((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())));
        if (icmListasincroRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListasincroRecord> sourceIcmListasincroRecordSet;
          sourceIcmListasincroRecordSet =
              (((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty())) ? this.getIcmListasincroRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListasincroRecord> copyIcmListasincroRecordSet = ((List<IcmListasincroRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListasincroRecordSet", sourceIcmListasincroRecordSet), sourceIcmListasincroRecordSet,
              ((this.icmListasincroRecordSet != null) && (!this.icmListasincroRecordSet.isEmpty()))));
          copy.icmListasincroRecordSet = null;
          if (copyIcmListasincroRecordSet != null) {
            List<IcmListasincroRecord> uniqueIcmListasincroRecordSetl = copy.getIcmListasincroRecordSet();
            uniqueIcmListasincroRecordSetl.addAll(copyIcmListasincroRecordSet);
          }
        } else {
          if (icmListasincroRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListasincroRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListasincroBlock();
  }

}
