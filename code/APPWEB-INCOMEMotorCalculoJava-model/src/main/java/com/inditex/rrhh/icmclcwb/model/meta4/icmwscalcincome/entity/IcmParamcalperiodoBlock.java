
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
 * <p>Java class for Icm_ParamcalperiodoBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalperiodoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalperiodoRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalperiodoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalperiodoBlock", propOrder = {
    "icmParamcalperiodoRecordSet"
})
public class IcmParamcalperiodoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ParamcalperiodoRecordSet", nillable = true)
  protected List<IcmParamcalperiodoRecord> icmParamcalperiodoRecordSet;

  /**
   * Gets the value of the icmParamcalperiodoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParamcalperiodoRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   *
   * <pre>
   * getIcmParamcalperiodoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalperiodoRecord }
   *
   *
   */
  public List<IcmParamcalperiodoRecord> getIcmParamcalperiodoRecordSet() {
    if (icmParamcalperiodoRecordSet == null) {
      icmParamcalperiodoRecordSet = new ArrayList<IcmParamcalperiodoRecord>();
    }
    return this.icmParamcalperiodoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalperiodoBlock that = ((IcmParamcalperiodoBlock) object);
    {
      List<IcmParamcalperiodoRecord> lhsIcmParamcalperiodoRecordSet;
      lhsIcmParamcalperiodoRecordSet = (((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty()))
          ? this.getIcmParamcalperiodoRecordSet()
          : null);
      List<IcmParamcalperiodoRecord> rhsIcmParamcalperiodoRecordSet;
      rhsIcmParamcalperiodoRecordSet = (((that.icmParamcalperiodoRecordSet != null) && (!that.icmParamcalperiodoRecordSet.isEmpty()))
          ? that.getIcmParamcalperiodoRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalperiodoRecordSet", lhsIcmParamcalperiodoRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalperiodoRecordSet", rhsIcmParamcalperiodoRecordSet), lhsIcmParamcalperiodoRecordSet,
          rhsIcmParamcalperiodoRecordSet, ((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty())),
          ((that.icmParamcalperiodoRecordSet != null) && (!that.icmParamcalperiodoRecordSet.isEmpty())))) {
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
      List<IcmParamcalperiodoRecord> theIcmParamcalperiodoRecordSet;
      theIcmParamcalperiodoRecordSet = (((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty()))
          ? this.getIcmParamcalperiodoRecordSet()
          : null);
      strategy.appendField(locator, this, "icmParamcalperiodoRecordSet", buffer, theIcmParamcalperiodoRecordSet,
          ((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmParamcalperiodoRecord> theIcmParamcalperiodoRecordSet;
      theIcmParamcalperiodoRecordSet = (((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty()))
          ? this.getIcmParamcalperiodoRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalperiodoRecordSet", theIcmParamcalperiodoRecordSet),
          currentHashCode, theIcmParamcalperiodoRecordSet,
          ((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalperiodoBlock) {
      final IcmParamcalperiodoBlock copy = ((IcmParamcalperiodoBlock) draftCopy);
      {
        Boolean icmParamcalperiodoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty())));
        if (icmParamcalperiodoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalperiodoRecord> sourceIcmParamcalperiodoRecordSet;
          sourceIcmParamcalperiodoRecordSet = (((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty()))
              ? this.getIcmParamcalperiodoRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalperiodoRecord> copyIcmParamcalperiodoRecordSet = ((List<IcmParamcalperiodoRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParamcalperiodoRecordSet", sourceIcmParamcalperiodoRecordSet),
              sourceIcmParamcalperiodoRecordSet,
              ((this.icmParamcalperiodoRecordSet != null) && (!this.icmParamcalperiodoRecordSet.isEmpty()))));
          copy.icmParamcalperiodoRecordSet = null;
          if (copyIcmParamcalperiodoRecordSet != null) {
            List<IcmParamcalperiodoRecord> uniqueIcmParamcalperiodoRecordSetl = copy.getIcmParamcalperiodoRecordSet();
            uniqueIcmParamcalperiodoRecordSetl.addAll(copyIcmParamcalperiodoRecordSet);
          }
        } else {
          if (icmParamcalperiodoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalperiodoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalperiodoBlock();
  }

}
