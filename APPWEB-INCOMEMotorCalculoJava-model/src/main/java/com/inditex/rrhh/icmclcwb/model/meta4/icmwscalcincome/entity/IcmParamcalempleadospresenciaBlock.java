
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
 * <p>Java class for Icm_ParamcalempleadospresenciaBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalempleadospresenciaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalempleadospresenciaRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalempleadospresenciaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalempleadospresenciaBlock", propOrder = {
    "icmParamcalempleadospresenciaRecordSet"
})
public class IcmParamcalempleadospresenciaBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ParamcalempleadospresenciaRecordSet", nillable = true)
  protected List<IcmParamcalempleadospresenciaRecord> icmParamcalempleadospresenciaRecordSet;

  /**
   * Gets the value of the icmParamcalempleadospresenciaRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
   * icmParamcalempleadospresenciaRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmParamcalempleadospresenciaRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalempleadospresenciaRecord }
   *
   *
   */
  public List<IcmParamcalempleadospresenciaRecord> getIcmParamcalempleadospresenciaRecordSet() {
    if (icmParamcalempleadospresenciaRecordSet == null) {
      icmParamcalempleadospresenciaRecordSet = new ArrayList<IcmParamcalempleadospresenciaRecord>();
    }
    return this.icmParamcalempleadospresenciaRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalempleadospresenciaBlock that = ((IcmParamcalempleadospresenciaBlock) object);
    {
      List<IcmParamcalempleadospresenciaRecord> lhsIcmParamcalempleadospresenciaRecordSet;
      lhsIcmParamcalempleadospresenciaRecordSet =
          (((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty()))
              ? this.getIcmParamcalempleadospresenciaRecordSet()
              : null);
      List<IcmParamcalempleadospresenciaRecord> rhsIcmParamcalempleadospresenciaRecordSet;
      rhsIcmParamcalempleadospresenciaRecordSet =
          (((that.icmParamcalempleadospresenciaRecordSet != null) && (!that.icmParamcalempleadospresenciaRecordSet.isEmpty()))
              ? that.getIcmParamcalempleadospresenciaRecordSet()
              : null);
      if (!strategy.equals(
          LocatorUtils.property(thisLocator, "icmParamcalempleadospresenciaRecordSet", lhsIcmParamcalempleadospresenciaRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalempleadospresenciaRecordSet", rhsIcmParamcalempleadospresenciaRecordSet),
          lhsIcmParamcalempleadospresenciaRecordSet, rhsIcmParamcalempleadospresenciaRecordSet,
          ((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty())),
          ((that.icmParamcalempleadospresenciaRecordSet != null) && (!that.icmParamcalempleadospresenciaRecordSet.isEmpty())))) {
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
      List<IcmParamcalempleadospresenciaRecord> theIcmParamcalempleadospresenciaRecordSet;
      theIcmParamcalempleadospresenciaRecordSet =
          (((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty()))
              ? this.getIcmParamcalempleadospresenciaRecordSet()
              : null);
      strategy.appendField(locator, this, "icmParamcalempleadospresenciaRecordSet", buffer, theIcmParamcalempleadospresenciaRecordSet,
          ((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmParamcalempleadospresenciaRecord> theIcmParamcalempleadospresenciaRecordSet;
      theIcmParamcalempleadospresenciaRecordSet =
          (((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty()))
              ? this.getIcmParamcalempleadospresenciaRecordSet()
              : null);
      currentHashCode = strategy.hashCode(
          LocatorUtils.property(locator, "icmParamcalempleadospresenciaRecordSet", theIcmParamcalempleadospresenciaRecordSet),
          currentHashCode, theIcmParamcalempleadospresenciaRecordSet,
          ((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalempleadospresenciaBlock) {
      final IcmParamcalempleadospresenciaBlock copy = ((IcmParamcalempleadospresenciaBlock) draftCopy);
      {
        Boolean icmParamcalempleadospresenciaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty())));
        if (icmParamcalempleadospresenciaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalempleadospresenciaRecord> sourceIcmParamcalempleadospresenciaRecordSet;
          sourceIcmParamcalempleadospresenciaRecordSet =
              (((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty()))
                  ? this.getIcmParamcalempleadospresenciaRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalempleadospresenciaRecord> copyIcmParamcalempleadospresenciaRecordSet =
              ((List<IcmParamcalempleadospresenciaRecord>) strategy.copy(
                  LocatorUtils.property(locator, "icmParamcalempleadospresenciaRecordSet", sourceIcmParamcalempleadospresenciaRecordSet),
                  sourceIcmParamcalempleadospresenciaRecordSet,
                  ((this.icmParamcalempleadospresenciaRecordSet != null) && (!this.icmParamcalempleadospresenciaRecordSet.isEmpty()))));
          copy.icmParamcalempleadospresenciaRecordSet = null;
          if (copyIcmParamcalempleadospresenciaRecordSet != null) {
            List<IcmParamcalempleadospresenciaRecord> uniqueIcmParamcalempleadospresenciaRecordSetl =
                copy.getIcmParamcalempleadospresenciaRecordSet();
            uniqueIcmParamcalempleadospresenciaRecordSetl.addAll(copyIcmParamcalempleadospresenciaRecordSet);
          }
        } else {
          if (icmParamcalempleadospresenciaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalempleadospresenciaRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalempleadospresenciaBlock();
  }

}
