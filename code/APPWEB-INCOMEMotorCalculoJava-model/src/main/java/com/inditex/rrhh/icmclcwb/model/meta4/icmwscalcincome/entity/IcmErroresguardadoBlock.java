
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
 * <p>Java class for Icm_ErroresguardadoBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ErroresguardadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ErroresguardadoRecordSet" type="{http://schemas.meta4.com/}Icm_ErroresguardadoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ErroresguardadoBlock", propOrder = {
    "resultado",
    "icmErroresguardadoRecordSet"
})
public class IcmErroresguardadoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String resultado;

  @XmlElement(name = "Icm_ErroresguardadoRecordSet", nillable = true)
  protected List<IcmErroresguardadoRecord> icmErroresguardadoRecordSet;

  /**
   * Gets the value of the resultado property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getResultado() {
    return resultado;
  }

  /**
   * Sets the value of the resultado property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setResultado(String value) {
    this.resultado = value;
  }

  /**
   * Gets the value of the icmErroresguardadoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmErroresguardadoRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmErroresguardadoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmErroresguardadoRecord }
   *
   *
   */
  public List<IcmErroresguardadoRecord> getIcmErroresguardadoRecordSet() {
    if (icmErroresguardadoRecordSet == null) {
      icmErroresguardadoRecordSet = new ArrayList<IcmErroresguardadoRecord>();
    }
    return this.icmErroresguardadoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmErroresguardadoBlock that = ((IcmErroresguardadoBlock) object);
    {
      String lhsResultado;
      lhsResultado = this.getResultado();
      String rhsResultado;
      rhsResultado = that.getResultado();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "resultado", lhsResultado),
          LocatorUtils.property(thatLocator, "resultado", rhsResultado), lhsResultado, rhsResultado, (this.resultado != null),
          (that.resultado != null))) {
        return false;
      }
    }
    {
      List<IcmErroresguardadoRecord> lhsIcmErroresguardadoRecordSet;
      lhsIcmErroresguardadoRecordSet = (((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty()))
          ? this.getIcmErroresguardadoRecordSet()
          : null);
      List<IcmErroresguardadoRecord> rhsIcmErroresguardadoRecordSet;
      rhsIcmErroresguardadoRecordSet = (((that.icmErroresguardadoRecordSet != null) && (!that.icmErroresguardadoRecordSet.isEmpty()))
          ? that.getIcmErroresguardadoRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmErroresguardadoRecordSet", lhsIcmErroresguardadoRecordSet),
          LocatorUtils.property(thatLocator, "icmErroresguardadoRecordSet", rhsIcmErroresguardadoRecordSet), lhsIcmErroresguardadoRecordSet,
          rhsIcmErroresguardadoRecordSet, ((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty())),
          ((that.icmErroresguardadoRecordSet != null) && (!that.icmErroresguardadoRecordSet.isEmpty())))) {
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
      String theResultado;
      theResultado = this.getResultado();
      strategy.appendField(locator, this, "resultado", buffer, theResultado, (this.resultado != null));
    }
    {
      List<IcmErroresguardadoRecord> theIcmErroresguardadoRecordSet;
      theIcmErroresguardadoRecordSet = (((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty()))
          ? this.getIcmErroresguardadoRecordSet()
          : null);
      strategy.appendField(locator, this, "icmErroresguardadoRecordSet", buffer, theIcmErroresguardadoRecordSet,
          ((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theResultado;
      theResultado = this.getResultado();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resultado", theResultado), currentHashCode, theResultado,
          (this.resultado != null));
    }
    {
      List<IcmErroresguardadoRecord> theIcmErroresguardadoRecordSet;
      theIcmErroresguardadoRecordSet = (((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty()))
          ? this.getIcmErroresguardadoRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmErroresguardadoRecordSet", theIcmErroresguardadoRecordSet),
          currentHashCode, theIcmErroresguardadoRecordSet,
          ((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmErroresguardadoBlock) {
      final IcmErroresguardadoBlock copy = ((IcmErroresguardadoBlock) draftCopy);
      {
        Boolean resultadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.resultado != null));
        if (resultadoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceResultado;
          sourceResultado = this.getResultado();
          String copyResultado = ((String) strategy.copy(LocatorUtils.property(locator, "resultado", sourceResultado), sourceResultado,
              (this.resultado != null)));
          copy.setResultado(copyResultado);
        } else {
          if (resultadoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.resultado = null;
          }
        }
      }
      {
        Boolean icmErroresguardadoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty())));
        if (icmErroresguardadoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmErroresguardadoRecord> sourceIcmErroresguardadoRecordSet;
          sourceIcmErroresguardadoRecordSet = (((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty()))
              ? this.getIcmErroresguardadoRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmErroresguardadoRecord> copyIcmErroresguardadoRecordSet = ((List<IcmErroresguardadoRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmErroresguardadoRecordSet", sourceIcmErroresguardadoRecordSet),
              sourceIcmErroresguardadoRecordSet,
              ((this.icmErroresguardadoRecordSet != null) && (!this.icmErroresguardadoRecordSet.isEmpty()))));
          copy.icmErroresguardadoRecordSet = null;
          if (copyIcmErroresguardadoRecordSet != null) {
            List<IcmErroresguardadoRecord> uniqueIcmErroresguardadoRecordSetl = copy.getIcmErroresguardadoRecordSet();
            uniqueIcmErroresguardadoRecordSetl.addAll(copyIcmErroresguardadoRecordSet);
          }
        } else {
          if (icmErroresguardadoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmErroresguardadoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmErroresguardadoBlock();
  }

}
