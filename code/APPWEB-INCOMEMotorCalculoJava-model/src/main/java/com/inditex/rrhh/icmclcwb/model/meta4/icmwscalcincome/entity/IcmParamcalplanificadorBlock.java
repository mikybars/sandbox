
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
 * <p>Java class for Icm_ParamcalplanificadorBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalplanificadorBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalplanificadorRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalplanificadorRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalplanificadorBlock", propOrder = {
    "icmParamcalplanificadorRecordSet"
})
public class IcmParamcalplanificadorBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ParamcalplanificadorRecordSet", nillable = true)
  protected List<IcmParamcalplanificadorRecord> icmParamcalplanificadorRecordSet;

  /**
   * Gets the value of the icmParamcalplanificadorRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParamcalplanificadorRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmParamcalplanificadorRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalplanificadorRecord }
   *
   *
   */
  public List<IcmParamcalplanificadorRecord> getIcmParamcalplanificadorRecordSet() {
    if (icmParamcalplanificadorRecordSet == null) {
      icmParamcalplanificadorRecordSet = new ArrayList<IcmParamcalplanificadorRecord>();
    }
    return this.icmParamcalplanificadorRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalplanificadorBlock that = ((IcmParamcalplanificadorBlock) object);
    {
      List<IcmParamcalplanificadorRecord> lhsIcmParamcalplanificadorRecordSet;
      lhsIcmParamcalplanificadorRecordSet =
          (((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty()))
              ? this.getIcmParamcalplanificadorRecordSet()
              : null);
      List<IcmParamcalplanificadorRecord> rhsIcmParamcalplanificadorRecordSet;
      rhsIcmParamcalplanificadorRecordSet =
          (((that.icmParamcalplanificadorRecordSet != null) && (!that.icmParamcalplanificadorRecordSet.isEmpty()))
              ? that.getIcmParamcalplanificadorRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalplanificadorRecordSet", lhsIcmParamcalplanificadorRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalplanificadorRecordSet", rhsIcmParamcalplanificadorRecordSet),
          lhsIcmParamcalplanificadorRecordSet, rhsIcmParamcalplanificadorRecordSet,
          ((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty())),
          ((that.icmParamcalplanificadorRecordSet != null) && (!that.icmParamcalplanificadorRecordSet.isEmpty())))) {
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
      List<IcmParamcalplanificadorRecord> theIcmParamcalplanificadorRecordSet;
      theIcmParamcalplanificadorRecordSet =
          (((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty()))
              ? this.getIcmParamcalplanificadorRecordSet()
              : null);
      strategy.appendField(locator, this, "icmParamcalplanificadorRecordSet", buffer, theIcmParamcalplanificadorRecordSet,
          ((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmParamcalplanificadorRecord> theIcmParamcalplanificadorRecordSet;
      theIcmParamcalplanificadorRecordSet =
          (((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty()))
              ? this.getIcmParamcalplanificadorRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmParamcalplanificadorRecordSet", theIcmParamcalplanificadorRecordSet),
              currentHashCode, theIcmParamcalplanificadorRecordSet,
              ((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalplanificadorBlock) {
      final IcmParamcalplanificadorBlock copy = ((IcmParamcalplanificadorBlock) draftCopy);
      {
        Boolean icmParamcalplanificadorRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty())));
        if (icmParamcalplanificadorRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalplanificadorRecord> sourceIcmParamcalplanificadorRecordSet;
          sourceIcmParamcalplanificadorRecordSet =
              (((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty()))
                  ? this.getIcmParamcalplanificadorRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalplanificadorRecord> copyIcmParamcalplanificadorRecordSet = ((List<IcmParamcalplanificadorRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParamcalplanificadorRecordSet", sourceIcmParamcalplanificadorRecordSet),
              sourceIcmParamcalplanificadorRecordSet,
              ((this.icmParamcalplanificadorRecordSet != null) && (!this.icmParamcalplanificadorRecordSet.isEmpty()))));
          copy.icmParamcalplanificadorRecordSet = null;
          if (copyIcmParamcalplanificadorRecordSet != null) {
            List<IcmParamcalplanificadorRecord> uniqueIcmParamcalplanificadorRecordSetl = copy.getIcmParamcalplanificadorRecordSet();
            uniqueIcmParamcalplanificadorRecordSetl.addAll(copyIcmParamcalplanificadorRecordSet);
          }
        } else {
          if (icmParamcalplanificadorRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalplanificadorRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalplanificadorBlock();
  }

}
