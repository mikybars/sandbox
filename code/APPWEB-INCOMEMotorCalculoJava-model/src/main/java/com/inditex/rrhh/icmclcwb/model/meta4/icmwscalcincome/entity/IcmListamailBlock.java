
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
 * <p>Java class for Icm_ListamailBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListamailBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListamailRecordSet" type="{http://schemas.meta4.com/}Icm_ListamailRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListamailBlock", propOrder = {
    "icmListamailRecordSet"
})
public class IcmListamailBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListamailRecordSet", nillable = true)
  protected List<IcmListamailRecord> icmListamailRecordSet;

  /**
   * Gets the value of the icmListamailRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListamailRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListamailRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListamailRecord }
   *
   *
   */
  public List<IcmListamailRecord> getIcmListamailRecordSet() {
    if (icmListamailRecordSet == null) {
      icmListamailRecordSet = new ArrayList<IcmListamailRecord>();
    }
    return this.icmListamailRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListamailBlock that = ((IcmListamailBlock) object);
    {
      List<IcmListamailRecord> lhsIcmListamailRecordSet;
      lhsIcmListamailRecordSet =
          (((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())) ? this.getIcmListamailRecordSet() : null);
      List<IcmListamailRecord> rhsIcmListamailRecordSet;
      rhsIcmListamailRecordSet =
          (((that.icmListamailRecordSet != null) && (!that.icmListamailRecordSet.isEmpty())) ? that.getIcmListamailRecordSet() : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListamailRecordSet", lhsIcmListamailRecordSet),
          LocatorUtils.property(thatLocator, "icmListamailRecordSet", rhsIcmListamailRecordSet), lhsIcmListamailRecordSet,
          rhsIcmListamailRecordSet, ((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())),
          ((that.icmListamailRecordSet != null) && (!that.icmListamailRecordSet.isEmpty())))) {
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
      List<IcmListamailRecord> theIcmListamailRecordSet;
      theIcmListamailRecordSet =
          (((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())) ? this.getIcmListamailRecordSet() : null);
      strategy.appendField(locator, this, "icmListamailRecordSet", buffer, theIcmListamailRecordSet,
          ((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListamailRecord> theIcmListamailRecordSet;
      theIcmListamailRecordSet =
          (((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())) ? this.getIcmListamailRecordSet() : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListamailRecordSet", theIcmListamailRecordSet),
          currentHashCode, theIcmListamailRecordSet, ((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListamailBlock) {
      final IcmListamailBlock copy = ((IcmListamailBlock) draftCopy);
      {
        Boolean icmListamailRecordSetShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, ((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())));
        if (icmListamailRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListamailRecord> sourceIcmListamailRecordSet;
          sourceIcmListamailRecordSet =
              (((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty())) ? this.getIcmListamailRecordSet() : null);
          @SuppressWarnings("unchecked")
          List<IcmListamailRecord> copyIcmListamailRecordSet = ((List<IcmListamailRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListamailRecordSet", sourceIcmListamailRecordSet), sourceIcmListamailRecordSet,
              ((this.icmListamailRecordSet != null) && (!this.icmListamailRecordSet.isEmpty()))));
          copy.icmListamailRecordSet = null;
          if (copyIcmListamailRecordSet != null) {
            List<IcmListamailRecord> uniqueIcmListamailRecordSetl = copy.getIcmListamailRecordSet();
            uniqueIcmListamailRecordSetl.addAll(copyIcmListamailRecordSet);
          }
        } else {
          if (icmListamailRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListamailRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListamailBlock();
  }

}
