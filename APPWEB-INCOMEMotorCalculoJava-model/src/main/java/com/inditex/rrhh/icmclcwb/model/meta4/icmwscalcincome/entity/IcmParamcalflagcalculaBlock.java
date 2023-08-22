
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
 * <p>Java class for Icm_ParamcalflagcalculaBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalflagcalculaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalflagcalculaRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalflagcalculaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalflagcalculaBlock", propOrder = {
    "icmParamcalflagcalculaRecordSet"
})
public class IcmParamcalflagcalculaBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ParamcalflagcalculaRecordSet", nillable = true)
  protected List<IcmParamcalflagcalculaRecord> icmParamcalflagcalculaRecordSet;

  /**
   * Gets the value of the icmParamcalflagcalculaRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParamcalflagcalculaRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmParamcalflagcalculaRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalflagcalculaRecord }
   *
   *
   */
  public List<IcmParamcalflagcalculaRecord> getIcmParamcalflagcalculaRecordSet() {
    if (icmParamcalflagcalculaRecordSet == null) {
      icmParamcalflagcalculaRecordSet = new ArrayList<IcmParamcalflagcalculaRecord>();
    }
    return this.icmParamcalflagcalculaRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalflagcalculaBlock that = ((IcmParamcalflagcalculaBlock) object);
    {
      List<IcmParamcalflagcalculaRecord> lhsIcmParamcalflagcalculaRecordSet;
      lhsIcmParamcalflagcalculaRecordSet =
          (((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty()))
              ? this.getIcmParamcalflagcalculaRecordSet()
              : null);
      List<IcmParamcalflagcalculaRecord> rhsIcmParamcalflagcalculaRecordSet;
      rhsIcmParamcalflagcalculaRecordSet =
          (((that.icmParamcalflagcalculaRecordSet != null) && (!that.icmParamcalflagcalculaRecordSet.isEmpty()))
              ? that.getIcmParamcalflagcalculaRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalflagcalculaRecordSet", lhsIcmParamcalflagcalculaRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalflagcalculaRecordSet", rhsIcmParamcalflagcalculaRecordSet),
          lhsIcmParamcalflagcalculaRecordSet, rhsIcmParamcalflagcalculaRecordSet,
          ((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty())),
          ((that.icmParamcalflagcalculaRecordSet != null) && (!that.icmParamcalflagcalculaRecordSet.isEmpty())))) {
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
      List<IcmParamcalflagcalculaRecord> theIcmParamcalflagcalculaRecordSet;
      theIcmParamcalflagcalculaRecordSet =
          (((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty()))
              ? this.getIcmParamcalflagcalculaRecordSet()
              : null);
      strategy.appendField(locator, this, "icmParamcalflagcalculaRecordSet", buffer, theIcmParamcalflagcalculaRecordSet,
          ((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmParamcalflagcalculaRecord> theIcmParamcalflagcalculaRecordSet;
      theIcmParamcalflagcalculaRecordSet =
          (((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty()))
              ? this.getIcmParamcalflagcalculaRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmParamcalflagcalculaRecordSet", theIcmParamcalflagcalculaRecordSet),
              currentHashCode, theIcmParamcalflagcalculaRecordSet,
              ((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalflagcalculaBlock) {
      final IcmParamcalflagcalculaBlock copy = ((IcmParamcalflagcalculaBlock) draftCopy);
      {
        Boolean icmParamcalflagcalculaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty())));
        if (icmParamcalflagcalculaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalflagcalculaRecord> sourceIcmParamcalflagcalculaRecordSet;
          sourceIcmParamcalflagcalculaRecordSet =
              (((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty()))
                  ? this.getIcmParamcalflagcalculaRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalflagcalculaRecord> copyIcmParamcalflagcalculaRecordSet = ((List<IcmParamcalflagcalculaRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParamcalflagcalculaRecordSet", sourceIcmParamcalflagcalculaRecordSet),
              sourceIcmParamcalflagcalculaRecordSet,
              ((this.icmParamcalflagcalculaRecordSet != null) && (!this.icmParamcalflagcalculaRecordSet.isEmpty()))));
          copy.icmParamcalflagcalculaRecordSet = null;
          if (copyIcmParamcalflagcalculaRecordSet != null) {
            List<IcmParamcalflagcalculaRecord> uniqueIcmParamcalflagcalculaRecordSetl = copy.getIcmParamcalflagcalculaRecordSet();
            uniqueIcmParamcalflagcalculaRecordSetl.addAll(copyIcmParamcalflagcalculaRecordSet);
          }
        } else {
          if (icmParamcalflagcalculaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalflagcalculaRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalflagcalculaBlock();
  }

}
