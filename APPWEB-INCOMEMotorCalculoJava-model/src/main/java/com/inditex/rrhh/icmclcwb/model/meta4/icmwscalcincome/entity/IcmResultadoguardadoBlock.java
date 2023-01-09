
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
 * <p>Clase Java para Icm_ResultadoguardadoBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ResultadoguardadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ResultadoguardadoRecordSet" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ResultadoguardadoBlock", propOrder = {
    "icmResultadoguardadoRecordSet"
})
public class IcmResultadoguardadoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ResultadoguardadoRecordSet", nillable = true)
  protected List<IcmResultadoguardadoRecord> icmResultadoguardadoRecordSet;

  /**
   * Gets the value of the icmResultadoguardadoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmResultadoguardadoRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmResultadoguardadoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmResultadoguardadoRecord }
   *
   *
   */
  public List<IcmResultadoguardadoRecord> getIcmResultadoguardadoRecordSet() {
    if (icmResultadoguardadoRecordSet == null) {
      icmResultadoguardadoRecordSet = new ArrayList<IcmResultadoguardadoRecord>();
    }
    return this.icmResultadoguardadoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmResultadoguardadoBlock that = ((IcmResultadoguardadoBlock) object);
    {
      List<IcmResultadoguardadoRecord> lhsIcmResultadoguardadoRecordSet;
      lhsIcmResultadoguardadoRecordSet = (((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty()))
          ? this.getIcmResultadoguardadoRecordSet()
          : null);
      List<IcmResultadoguardadoRecord> rhsIcmResultadoguardadoRecordSet;
      rhsIcmResultadoguardadoRecordSet = (((that.icmResultadoguardadoRecordSet != null) && (!that.icmResultadoguardadoRecordSet.isEmpty()))
          ? that.getIcmResultadoguardadoRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmResultadoguardadoRecordSet", lhsIcmResultadoguardadoRecordSet),
          LocatorUtils.property(thatLocator, "icmResultadoguardadoRecordSet", rhsIcmResultadoguardadoRecordSet),
          lhsIcmResultadoguardadoRecordSet, rhsIcmResultadoguardadoRecordSet,
          ((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty())),
          ((that.icmResultadoguardadoRecordSet != null) && (!that.icmResultadoguardadoRecordSet.isEmpty())))) {
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
      List<IcmResultadoguardadoRecord> theIcmResultadoguardadoRecordSet;
      theIcmResultadoguardadoRecordSet = (((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty()))
          ? this.getIcmResultadoguardadoRecordSet()
          : null);
      strategy.appendField(locator, this, "icmResultadoguardadoRecordSet", buffer, theIcmResultadoguardadoRecordSet,
          ((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmResultadoguardadoRecord> theIcmResultadoguardadoRecordSet;
      theIcmResultadoguardadoRecordSet = (((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty()))
          ? this.getIcmResultadoguardadoRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmResultadoguardadoRecordSet", theIcmResultadoguardadoRecordSet),
          currentHashCode, theIcmResultadoguardadoRecordSet,
          ((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmResultadoguardadoBlock) {
      final IcmResultadoguardadoBlock copy = ((IcmResultadoguardadoBlock) draftCopy);
      {
        Boolean icmResultadoguardadoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty())));
        if (icmResultadoguardadoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmResultadoguardadoRecord> sourceIcmResultadoguardadoRecordSet;
          sourceIcmResultadoguardadoRecordSet =
              (((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty()))
                  ? this.getIcmResultadoguardadoRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmResultadoguardadoRecord> copyIcmResultadoguardadoRecordSet = ((List<IcmResultadoguardadoRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmResultadoguardadoRecordSet", sourceIcmResultadoguardadoRecordSet),
              sourceIcmResultadoguardadoRecordSet,
              ((this.icmResultadoguardadoRecordSet != null) && (!this.icmResultadoguardadoRecordSet.isEmpty()))));
          copy.icmResultadoguardadoRecordSet = null;
          if (copyIcmResultadoguardadoRecordSet != null) {
            List<IcmResultadoguardadoRecord> uniqueIcmResultadoguardadoRecordSetl = copy.getIcmResultadoguardadoRecordSet();
            uniqueIcmResultadoguardadoRecordSetl.addAll(copyIcmResultadoguardadoRecordSet);
          }
        } else {
          if (icmResultadoguardadoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmResultadoguardadoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmResultadoguardadoBlock();
  }

}
