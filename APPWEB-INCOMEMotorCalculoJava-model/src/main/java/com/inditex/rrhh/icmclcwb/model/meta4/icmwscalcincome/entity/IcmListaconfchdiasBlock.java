
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
 * <p>Clase Java para Icm_ListaconfchdiasBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaconfchdiasBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaconfchdiasRecordSet" type="{http://schemas.meta4.com/}Icm_ListaconfchdiasRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaconfchdiasBlock", propOrder = {
    "icmListaconfchdiasRecordSet"
})
public class IcmListaconfchdiasBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ListaconfchdiasRecordSet", nillable = true)
  protected List<IcmListaconfchdiasRecord> icmListaconfchdiasRecordSet;

  /**
   * Gets the value of the icmListaconfchdiasRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListaconfchdiasRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListaconfchdiasRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListaconfchdiasRecord }
   *
   *
   */
  public List<IcmListaconfchdiasRecord> getIcmListaconfchdiasRecordSet() {
    if (icmListaconfchdiasRecordSet == null) {
      icmListaconfchdiasRecordSet = new ArrayList<IcmListaconfchdiasRecord>();
    }
    return this.icmListaconfchdiasRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListaconfchdiasBlock that = ((IcmListaconfchdiasBlock) object);
    {
      List<IcmListaconfchdiasRecord> lhsIcmListaconfchdiasRecordSet;
      lhsIcmListaconfchdiasRecordSet = (((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty()))
          ? this.getIcmListaconfchdiasRecordSet()
          : null);
      List<IcmListaconfchdiasRecord> rhsIcmListaconfchdiasRecordSet;
      rhsIcmListaconfchdiasRecordSet = (((that.icmListaconfchdiasRecordSet != null) && (!that.icmListaconfchdiasRecordSet.isEmpty()))
          ? that.getIcmListaconfchdiasRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfchdiasRecordSet", lhsIcmListaconfchdiasRecordSet),
          LocatorUtils.property(thatLocator, "icmListaconfchdiasRecordSet", rhsIcmListaconfchdiasRecordSet), lhsIcmListaconfchdiasRecordSet,
          rhsIcmListaconfchdiasRecordSet, ((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty())),
          ((that.icmListaconfchdiasRecordSet != null) && (!that.icmListaconfchdiasRecordSet.isEmpty())))) {
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
      List<IcmListaconfchdiasRecord> theIcmListaconfchdiasRecordSet;
      theIcmListaconfchdiasRecordSet = (((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty()))
          ? this.getIcmListaconfchdiasRecordSet()
          : null);
      strategy.appendField(locator, this, "icmListaconfchdiasRecordSet", buffer, theIcmListaconfchdiasRecordSet,
          ((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmListaconfchdiasRecord> theIcmListaconfchdiasRecordSet;
      theIcmListaconfchdiasRecordSet = (((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty()))
          ? this.getIcmListaconfchdiasRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaconfchdiasRecordSet", theIcmListaconfchdiasRecordSet),
          currentHashCode, theIcmListaconfchdiasRecordSet,
          ((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListaconfchdiasBlock) {
      final IcmListaconfchdiasBlock copy = ((IcmListaconfchdiasBlock) draftCopy);
      {
        Boolean icmListaconfchdiasRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty())));
        if (icmListaconfchdiasRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListaconfchdiasRecord> sourceIcmListaconfchdiasRecordSet;
          sourceIcmListaconfchdiasRecordSet = (((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty()))
              ? this.getIcmListaconfchdiasRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmListaconfchdiasRecord> copyIcmListaconfchdiasRecordSet = ((List<IcmListaconfchdiasRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmListaconfchdiasRecordSet", sourceIcmListaconfchdiasRecordSet),
              sourceIcmListaconfchdiasRecordSet,
              ((this.icmListaconfchdiasRecordSet != null) && (!this.icmListaconfchdiasRecordSet.isEmpty()))));
          copy.icmListaconfchdiasRecordSet = null;
          if (copyIcmListaconfchdiasRecordSet != null) {
            List<IcmListaconfchdiasRecord> uniqueIcmListaconfchdiasRecordSetl = copy.getIcmListaconfchdiasRecordSet();
            uniqueIcmListaconfchdiasRecordSetl.addAll(copyIcmListaconfchdiasRecordSet);
          }
        } else {
          if (icmListaconfchdiasRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListaconfchdiasRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListaconfchdiasBlock();
  }

}
