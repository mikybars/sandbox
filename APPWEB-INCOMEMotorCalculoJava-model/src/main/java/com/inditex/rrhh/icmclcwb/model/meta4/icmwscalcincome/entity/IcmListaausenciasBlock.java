
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
 * <p>Clase Java para Icm_ListaausenciasBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaausenciasBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaausenciasRecordSet" type="{http://schemas.meta4.com/}Icm_ListaausenciasRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaausenciasBlock", propOrder = {
    "icmListaausenciasRecordSet"
})
public class IcmListaausenciasBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListaausenciasRecordSet", nillable = true)
  protected List<IcmListaausenciasRecord> icmListaausenciasRecordSet;

  /**
   * Gets the value of the icmListaausenciasRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListaausenciasRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListaausenciasRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListaausenciasRecord }
   *
   *
   */
  public List<IcmListaausenciasRecord> getIcmListaausenciasRecordSet() {
    if (icmListaausenciasRecordSet == null) {
      icmListaausenciasRecordSet = new ArrayList<IcmListaausenciasRecord>();
    }
    return this.icmListaausenciasRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListaausenciasBlock that = ((IcmListaausenciasBlock) object);
    {
      List<IcmListaausenciasRecord> lhsIcmListaausenciasRecordSet;
      lhsIcmListaausenciasRecordSet = (((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty()))
          ? this.getIcmListaausenciasRecordSet()
          : null);
      List<IcmListaausenciasRecord> rhsIcmListaausenciasRecordSet;
      rhsIcmListaausenciasRecordSet = (((that.icmListaausenciasRecordSet != null) && (!that.icmListaausenciasRecordSet.isEmpty()))
          ? that.getIcmListaausenciasRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaausenciasRecordSet", lhsIcmListaausenciasRecordSet),
          LocatorUtils.property(thatLocator, "icmListaausenciasRecordSet", rhsIcmListaausenciasRecordSet), lhsIcmListaausenciasRecordSet,
          rhsIcmListaausenciasRecordSet, ((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty())),
          ((that.icmListaausenciasRecordSet != null) && (!that.icmListaausenciasRecordSet.isEmpty())))) {
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
      List<IcmListaausenciasRecord> theIcmListaausenciasRecordSet;
      theIcmListaausenciasRecordSet = (((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty()))
          ? this.getIcmListaausenciasRecordSet()
          : null);
      strategy.appendField(locator, this, "icmListaausenciasRecordSet", buffer, theIcmListaausenciasRecordSet,
          ((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListaausenciasRecord> theIcmListaausenciasRecordSet;
      theIcmListaausenciasRecordSet = (((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty()))
          ? this.getIcmListaausenciasRecordSet()
          : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListaausenciasRecordSet", theIcmListaausenciasRecordSet), currentHashCode,
              theIcmListaausenciasRecordSet, ((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListaausenciasBlock) {
      final IcmListaausenciasBlock copy = ((IcmListaausenciasBlock) draftCopy);
      {
        Boolean icmListaausenciasRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty())));
        if (icmListaausenciasRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListaausenciasRecord> sourceIcmListaausenciasRecordSet;
          sourceIcmListaausenciasRecordSet = (((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty()))
              ? this.getIcmListaausenciasRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmListaausenciasRecord> copyIcmListaausenciasRecordSet = ((List<IcmListaausenciasRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListaausenciasRecordSet", sourceIcmListaausenciasRecordSet),
              sourceIcmListaausenciasRecordSet,
              ((this.icmListaausenciasRecordSet != null) && (!this.icmListaausenciasRecordSet.isEmpty()))));
          copy.icmListaausenciasRecordSet = null;
          if (copyIcmListaausenciasRecordSet != null) {
            List<IcmListaausenciasRecord> uniqueIcmListaausenciasRecordSetl = copy.getIcmListaausenciasRecordSet();
            uniqueIcmListaausenciasRecordSetl.addAll(copyIcmListaausenciasRecordSet);
          }
        } else {
          if (icmListaausenciasRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListaausenciasRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListaausenciasBlock();
  }

}
