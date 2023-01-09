
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
 * <p>Clase Java para Icm_ParamcalempleadosBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalempleadosBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalempleadosRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalempleadosRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalempleadosBlock", propOrder = {
    "icmParamcalempleadosRecordSet"
})
public class IcmParamcalempleadosBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "Icm_ParamcalempleadosRecordSet", nillable = true)
  protected List<IcmParamcalempleadosRecord> icmParamcalempleadosRecordSet;

  /**
   * Gets the value of the icmParamcalempleadosRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParamcalempleadosRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmParamcalempleadosRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParamcalempleadosRecord }
   *
   *
   */
  public List<IcmParamcalempleadosRecord> getIcmParamcalempleadosRecordSet() {
    if (icmParamcalempleadosRecordSet == null) {
      icmParamcalempleadosRecordSet = new ArrayList<IcmParamcalempleadosRecord>();
    }
    return this.icmParamcalempleadosRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParamcalempleadosBlock that = ((IcmParamcalempleadosBlock) object);
    {
      List<IcmParamcalempleadosRecord> lhsIcmParamcalempleadosRecordSet;
      lhsIcmParamcalempleadosRecordSet = (((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty()))
          ? this.getIcmParamcalempleadosRecordSet()
          : null);
      List<IcmParamcalempleadosRecord> rhsIcmParamcalempleadosRecordSet;
      rhsIcmParamcalempleadosRecordSet = (((that.icmParamcalempleadosRecordSet != null) && (!that.icmParamcalempleadosRecordSet.isEmpty()))
          ? that.getIcmParamcalempleadosRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalempleadosRecordSet", lhsIcmParamcalempleadosRecordSet),
          LocatorUtils.property(thatLocator, "icmParamcalempleadosRecordSet", rhsIcmParamcalempleadosRecordSet),
          lhsIcmParamcalempleadosRecordSet, rhsIcmParamcalempleadosRecordSet,
          ((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty())),
          ((that.icmParamcalempleadosRecordSet != null) && (!that.icmParamcalempleadosRecordSet.isEmpty())))) {
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
      List<IcmParamcalempleadosRecord> theIcmParamcalempleadosRecordSet;
      theIcmParamcalempleadosRecordSet = (((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty()))
          ? this.getIcmParamcalempleadosRecordSet()
          : null);
      strategy.appendField(locator, this, "icmParamcalempleadosRecordSet", buffer, theIcmParamcalempleadosRecordSet,
          ((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      List<IcmParamcalempleadosRecord> theIcmParamcalempleadosRecordSet;
      theIcmParamcalempleadosRecordSet = (((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty()))
          ? this.getIcmParamcalempleadosRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalempleadosRecordSet", theIcmParamcalempleadosRecordSet),
          currentHashCode, theIcmParamcalempleadosRecordSet,
          ((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmParamcalempleadosBlock) {
      final IcmParamcalempleadosBlock copy = ((IcmParamcalempleadosBlock) draftCopy);
      {
        Boolean icmParamcalempleadosRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty())));
        if (icmParamcalempleadosRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParamcalempleadosRecord> sourceIcmParamcalempleadosRecordSet;
          sourceIcmParamcalempleadosRecordSet =
              (((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty()))
                  ? this.getIcmParamcalempleadosRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParamcalempleadosRecord> copyIcmParamcalempleadosRecordSet = ((List<IcmParamcalempleadosRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParamcalempleadosRecordSet", sourceIcmParamcalempleadosRecordSet),
              sourceIcmParamcalempleadosRecordSet,
              ((this.icmParamcalempleadosRecordSet != null) && (!this.icmParamcalempleadosRecordSet.isEmpty()))));
          copy.icmParamcalempleadosRecordSet = null;
          if (copyIcmParamcalempleadosRecordSet != null) {
            List<IcmParamcalempleadosRecord> uniqueIcmParamcalempleadosRecordSetl = copy.getIcmParamcalempleadosRecordSet();
            uniqueIcmParamcalempleadosRecordSetl.addAll(copyIcmParamcalempleadosRecordSet);
          }
        } else {
          if (icmParamcalempleadosRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParamcalempleadosRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParamcalempleadosBlock();
  }

}
