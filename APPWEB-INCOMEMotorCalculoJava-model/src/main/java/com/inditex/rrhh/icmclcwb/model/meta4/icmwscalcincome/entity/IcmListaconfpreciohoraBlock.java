
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
 * <p>Clase Java para Icm_ListaconfpreciohoraBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaconfpreciohoraBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaconfpreciohoraRecordSet" type="{http://schemas.meta4.com/}Icm_ListaconfpreciohoraRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaconfpreciohoraBlock", propOrder = {
    "icmListaconfpreciohoraRecordSet"
})
public class IcmListaconfpreciohoraBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListaconfpreciohoraRecordSet", nillable = true)
  protected List<IcmListaconfpreciohoraRecord> icmListaconfpreciohoraRecordSet;

  /**
   * Gets the value of the icmListaconfpreciohoraRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListaconfpreciohoraRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListaconfpreciohoraRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListaconfpreciohoraRecord }
   *
   *
   */
  public List<IcmListaconfpreciohoraRecord> getIcmListaconfpreciohoraRecordSet() {
    if (icmListaconfpreciohoraRecordSet == null) {
      icmListaconfpreciohoraRecordSet = new ArrayList<IcmListaconfpreciohoraRecord>();
    }
    return this.icmListaconfpreciohoraRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListaconfpreciohoraBlock that = ((IcmListaconfpreciohoraBlock) object);
    {
      List<IcmListaconfpreciohoraRecord> lhsIcmListaconfpreciohoraRecordSet;
      lhsIcmListaconfpreciohoraRecordSet =
          (((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty()))
              ? this.getIcmListaconfpreciohoraRecordSet()
              : null);
      List<IcmListaconfpreciohoraRecord> rhsIcmListaconfpreciohoraRecordSet;
      rhsIcmListaconfpreciohoraRecordSet =
          (((that.icmListaconfpreciohoraRecordSet != null) && (!that.icmListaconfpreciohoraRecordSet.isEmpty()))
              ? that.getIcmListaconfpreciohoraRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfpreciohoraRecordSet", lhsIcmListaconfpreciohoraRecordSet),
          LocatorUtils.property(thatLocator, "icmListaconfpreciohoraRecordSet", rhsIcmListaconfpreciohoraRecordSet),
          lhsIcmListaconfpreciohoraRecordSet, rhsIcmListaconfpreciohoraRecordSet,
          ((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty())),
          ((that.icmListaconfpreciohoraRecordSet != null) && (!that.icmListaconfpreciohoraRecordSet.isEmpty())))) {
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
      List<IcmListaconfpreciohoraRecord> theIcmListaconfpreciohoraRecordSet;
      theIcmListaconfpreciohoraRecordSet =
          (((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty()))
              ? this.getIcmListaconfpreciohoraRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListaconfpreciohoraRecordSet", buffer, theIcmListaconfpreciohoraRecordSet,
          ((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListaconfpreciohoraRecord> theIcmListaconfpreciohoraRecordSet;
      theIcmListaconfpreciohoraRecordSet =
          (((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty()))
              ? this.getIcmListaconfpreciohoraRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListaconfpreciohoraRecordSet", theIcmListaconfpreciohoraRecordSet),
              currentHashCode, theIcmListaconfpreciohoraRecordSet,
              ((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListaconfpreciohoraBlock) {
      final IcmListaconfpreciohoraBlock copy = ((IcmListaconfpreciohoraBlock) draftCopy);
      {
        Boolean icmListaconfpreciohoraRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty())));
        if (icmListaconfpreciohoraRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListaconfpreciohoraRecord> sourceIcmListaconfpreciohoraRecordSet;
          sourceIcmListaconfpreciohoraRecordSet =
              (((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty()))
                  ? this.getIcmListaconfpreciohoraRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListaconfpreciohoraRecord> copyIcmListaconfpreciohoraRecordSet = ((List<IcmListaconfpreciohoraRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListaconfpreciohoraRecordSet", sourceIcmListaconfpreciohoraRecordSet),
              sourceIcmListaconfpreciohoraRecordSet,
              ((this.icmListaconfpreciohoraRecordSet != null) && (!this.icmListaconfpreciohoraRecordSet.isEmpty()))));
          copy.icmListaconfpreciohoraRecordSet = null;
          if (copyIcmListaconfpreciohoraRecordSet != null) {
            List<IcmListaconfpreciohoraRecord> uniqueIcmListaconfpreciohoraRecordSetl = copy.getIcmListaconfpreciohoraRecordSet();
            uniqueIcmListaconfpreciohoraRecordSetl.addAll(copyIcmListaconfpreciohoraRecordSet);
          }
        } else {
          if (icmListaconfpreciohoraRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListaconfpreciohoraRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListaconfpreciohoraBlock();
  }

}
