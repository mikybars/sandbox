
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
 * <p>Java class for Icm_ListacadenasBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListacadenasBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListacadenasRecordSet" type="{http://schemas.meta4.com/}Icm_ListacadenasRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListacadenasBlock", propOrder = {
    "icmListacadenasRecordSet"
})
public class IcmListacadenasBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListacadenasRecordSet", nillable = true)
  protected List<IcmListacadenasRecord> icmListacadenasRecordSet;

  /**
   * Gets the value of the icmListacadenasRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListacadenasRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getIcmListacadenasRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListacadenasRecord }
   *
   *
   */
  public List<IcmListacadenasRecord> getIcmListacadenasRecordSet() {
    if (icmListacadenasRecordSet == null) {
      icmListacadenasRecordSet = new ArrayList<IcmListacadenasRecord>();
    }
    return this.icmListacadenasRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListacadenasBlock that = ((IcmListacadenasBlock) object);
    {
      List<IcmListacadenasRecord> lhsIcmListacadenasRecordSet;
      lhsIcmListacadenasRecordSet =
          (((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())) ? this.getIcmListacadenasRecordSet()
              : null);
      List<IcmListacadenasRecord> rhsIcmListacadenasRecordSet;
      rhsIcmListacadenasRecordSet =
          (((that.icmListacadenasRecordSet != null) && (!that.icmListacadenasRecordSet.isEmpty())) ? that.getIcmListacadenasRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListacadenasRecordSet", lhsIcmListacadenasRecordSet),
          LocatorUtils.property(thatLocator, "icmListacadenasRecordSet", rhsIcmListacadenasRecordSet), lhsIcmListacadenasRecordSet,
          rhsIcmListacadenasRecordSet, ((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())),
          ((that.icmListacadenasRecordSet != null) && (!that.icmListacadenasRecordSet.isEmpty())))) {
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
      List<IcmListacadenasRecord> theIcmListacadenasRecordSet;
      theIcmListacadenasRecordSet =
          (((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())) ? this.getIcmListacadenasRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListacadenasRecordSet", buffer, theIcmListacadenasRecordSet,
          ((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListacadenasRecord> theIcmListacadenasRecordSet;
      theIcmListacadenasRecordSet =
          (((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())) ? this.getIcmListacadenasRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListacadenasRecordSet", theIcmListacadenasRecordSet), currentHashCode,
              theIcmListacadenasRecordSet, ((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListacadenasBlock) {
      final IcmListacadenasBlock copy = ((IcmListacadenasBlock) draftCopy);
      {
        Boolean icmListacadenasRecordSetShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, ((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())));
        if (icmListacadenasRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListacadenasRecord> sourceIcmListacadenasRecordSet;
          sourceIcmListacadenasRecordSet =
              (((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty())) ? this.getIcmListacadenasRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListacadenasRecord> copyIcmListacadenasRecordSet = ((List<IcmListacadenasRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListacadenasRecordSet", sourceIcmListacadenasRecordSet), sourceIcmListacadenasRecordSet,
              ((this.icmListacadenasRecordSet != null) && (!this.icmListacadenasRecordSet.isEmpty()))));
          copy.icmListacadenasRecordSet = null;
          if (copyIcmListacadenasRecordSet != null) {
            List<IcmListacadenasRecord> uniqueIcmListacadenasRecordSetl = copy.getIcmListacadenasRecordSet();
            uniqueIcmListacadenasRecordSetl.addAll(copyIcmListacadenasRecordSet);
          }
        } else {
          if (icmListacadenasRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListacadenasRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListacadenasBlock();
  }

}
