
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
 * <p>Clase Java para Icm_ListaconfiguracionBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaconfiguracionBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaconfiguracionRecordSet" type="{http://schemas.meta4.com/}Icm_ListaconfiguracionRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaconfiguracionBlock", propOrder = {
    "icmListaconfiguracionRecordSet"
})
public class IcmListaconfiguracionBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListaconfiguracionRecordSet", nillable = true)
  protected List<IcmListaconfiguracionRecord> icmListaconfiguracionRecordSet;

  /**
   * Gets the value of the icmListaconfiguracionRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListaconfiguracionRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListaconfiguracionRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListaconfiguracionRecord }
   *
   *
   */
  public List<IcmListaconfiguracionRecord> getIcmListaconfiguracionRecordSet() {
    if (icmListaconfiguracionRecordSet == null) {
      icmListaconfiguracionRecordSet = new ArrayList<IcmListaconfiguracionRecord>();
    }
    return this.icmListaconfiguracionRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListaconfiguracionBlock that = ((IcmListaconfiguracionBlock) object);
    {
      List<IcmListaconfiguracionRecord> lhsIcmListaconfiguracionRecordSet;
      lhsIcmListaconfiguracionRecordSet =
          (((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty()))
              ? this.getIcmListaconfiguracionRecordSet()
              : null);
      List<IcmListaconfiguracionRecord> rhsIcmListaconfiguracionRecordSet;
      rhsIcmListaconfiguracionRecordSet =
          (((that.icmListaconfiguracionRecordSet != null) && (!that.icmListaconfiguracionRecordSet.isEmpty()))
              ? that.getIcmListaconfiguracionRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfiguracionRecordSet", lhsIcmListaconfiguracionRecordSet),
          LocatorUtils.property(thatLocator, "icmListaconfiguracionRecordSet", rhsIcmListaconfiguracionRecordSet),
          lhsIcmListaconfiguracionRecordSet, rhsIcmListaconfiguracionRecordSet,
          ((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty())),
          ((that.icmListaconfiguracionRecordSet != null) && (!that.icmListaconfiguracionRecordSet.isEmpty())))) {
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
      List<IcmListaconfiguracionRecord> theIcmListaconfiguracionRecordSet;
      theIcmListaconfiguracionRecordSet =
          (((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty()))
              ? this.getIcmListaconfiguracionRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListaconfiguracionRecordSet", buffer, theIcmListaconfiguracionRecordSet,
          ((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListaconfiguracionRecord> theIcmListaconfiguracionRecordSet;
      theIcmListaconfiguracionRecordSet =
          (((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty()))
              ? this.getIcmListaconfiguracionRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListaconfiguracionRecordSet", theIcmListaconfiguracionRecordSet),
              currentHashCode, theIcmListaconfiguracionRecordSet,
              ((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListaconfiguracionBlock) {
      final IcmListaconfiguracionBlock copy = ((IcmListaconfiguracionBlock) draftCopy);
      {
        Boolean icmListaconfiguracionRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty())));
        if (icmListaconfiguracionRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListaconfiguracionRecord> sourceIcmListaconfiguracionRecordSet;
          sourceIcmListaconfiguracionRecordSet =
              (((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty()))
                  ? this.getIcmListaconfiguracionRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListaconfiguracionRecord> copyIcmListaconfiguracionRecordSet = ((List<IcmListaconfiguracionRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListaconfiguracionRecordSet", sourceIcmListaconfiguracionRecordSet),
              sourceIcmListaconfiguracionRecordSet,
              ((this.icmListaconfiguracionRecordSet != null) && (!this.icmListaconfiguracionRecordSet.isEmpty()))));
          copy.icmListaconfiguracionRecordSet = null;
          if (copyIcmListaconfiguracionRecordSet != null) {
            List<IcmListaconfiguracionRecord> uniqueIcmListaconfiguracionRecordSetl = copy.getIcmListaconfiguracionRecordSet();
            uniqueIcmListaconfiguracionRecordSetl.addAll(copyIcmListaconfiguracionRecordSet);
          }
        } else {
          if (icmListaconfiguracionRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListaconfiguracionRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListaconfiguracionBlock();
  }

}
