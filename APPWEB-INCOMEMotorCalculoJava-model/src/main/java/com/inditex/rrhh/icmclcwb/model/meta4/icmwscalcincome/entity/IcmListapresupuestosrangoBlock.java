
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
 * <p>Java class for Icm_ListapresupuestosrangoBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListapresupuestosrangoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListapresupuestosrangoRecordSet" type="{http://schemas.meta4.com/}Icm_ListapresupuestosrangoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListapresupuestosrangoBlock", propOrder = {
    "icmListapresupuestosrangoRecordSet"
})
public class IcmListapresupuestosrangoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListapresupuestosrangoRecordSet", nillable = true)
  protected List<IcmListapresupuestosrangoRecord> icmListapresupuestosrangoRecordSet;

  /**
   * Gets the value of the icmListapresupuestosrangoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListapresupuestosrangoRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListapresupuestosrangoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListapresupuestosrangoRecord }
   *
   *
   */
  public List<IcmListapresupuestosrangoRecord> getIcmListapresupuestosrangoRecordSet() {
    if (icmListapresupuestosrangoRecordSet == null) {
      icmListapresupuestosrangoRecordSet = new ArrayList<IcmListapresupuestosrangoRecord>();
    }
    return this.icmListapresupuestosrangoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListapresupuestosrangoBlock that = ((IcmListapresupuestosrangoBlock) object);
    {
      List<IcmListapresupuestosrangoRecord> lhsIcmListapresupuestosrangoRecordSet;
      lhsIcmListapresupuestosrangoRecordSet =
          (((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty()))
              ? this.getIcmListapresupuestosrangoRecordSet()
              : null);
      List<IcmListapresupuestosrangoRecord> rhsIcmListapresupuestosrangoRecordSet;
      rhsIcmListapresupuestosrangoRecordSet =
          (((that.icmListapresupuestosrangoRecordSet != null) && (!that.icmListapresupuestosrangoRecordSet.isEmpty()))
              ? that.getIcmListapresupuestosrangoRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListapresupuestosrangoRecordSet", lhsIcmListapresupuestosrangoRecordSet),
          LocatorUtils.property(thatLocator, "icmListapresupuestosrangoRecordSet", rhsIcmListapresupuestosrangoRecordSet),
          lhsIcmListapresupuestosrangoRecordSet, rhsIcmListapresupuestosrangoRecordSet,
          ((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty())),
          ((that.icmListapresupuestosrangoRecordSet != null) && (!that.icmListapresupuestosrangoRecordSet.isEmpty())))) {
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
      List<IcmListapresupuestosrangoRecord> theIcmListapresupuestosrangoRecordSet;
      theIcmListapresupuestosrangoRecordSet =
          (((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty()))
              ? this.getIcmListapresupuestosrangoRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListapresupuestosrangoRecordSet", buffer, theIcmListapresupuestosrangoRecordSet,
          ((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListapresupuestosrangoRecord> theIcmListapresupuestosrangoRecordSet;
      theIcmListapresupuestosrangoRecordSet =
          (((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty()))
              ? this.getIcmListapresupuestosrangoRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListapresupuestosrangoRecordSet", theIcmListapresupuestosrangoRecordSet),
              currentHashCode, theIcmListapresupuestosrangoRecordSet,
              ((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListapresupuestosrangoBlock) {
      final IcmListapresupuestosrangoBlock copy = ((IcmListapresupuestosrangoBlock) draftCopy);
      {
        Boolean icmListapresupuestosrangoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty())));
        if (icmListapresupuestosrangoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListapresupuestosrangoRecord> sourceIcmListapresupuestosrangoRecordSet;
          sourceIcmListapresupuestosrangoRecordSet =
              (((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty()))
                  ? this.getIcmListapresupuestosrangoRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListapresupuestosrangoRecord> copyIcmListapresupuestosrangoRecordSet = ((List<IcmListapresupuestosrangoRecord>) strategy
              .copy(LocatorUtils.property(locator, "icmListapresupuestosrangoRecordSet", sourceIcmListapresupuestosrangoRecordSet),
                  sourceIcmListapresupuestosrangoRecordSet,
                  ((this.icmListapresupuestosrangoRecordSet != null) && (!this.icmListapresupuestosrangoRecordSet.isEmpty()))));
          copy.icmListapresupuestosrangoRecordSet = null;
          if (copyIcmListapresupuestosrangoRecordSet != null) {
            List<IcmListapresupuestosrangoRecord> uniqueIcmListapresupuestosrangoRecordSetl = copy.getIcmListapresupuestosrangoRecordSet();
            uniqueIcmListapresupuestosrangoRecordSetl.addAll(copyIcmListapresupuestosrangoRecordSet);
          }
        } else {
          if (icmListapresupuestosrangoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListapresupuestosrangoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListapresupuestosrangoBlock();
  }

}
