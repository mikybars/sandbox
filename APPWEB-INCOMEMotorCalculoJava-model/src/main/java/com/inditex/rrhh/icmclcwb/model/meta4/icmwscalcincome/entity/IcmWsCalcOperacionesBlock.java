
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
 * <p>Clase Java para Icm_Ws_Calc_OperacionesBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_Ws_Calc_OperacionesBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="icm_P_Trace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_Ws_Calc_OperacionesRecordSet" type="{http://schemas.meta4.com/}Icm_Ws_Calc_OperacionesRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_Ws_Calc_OperacionesBlock", propOrder = {
    "icmPTrace",
    "icmWsCalcOperacionesRecordSet"
})
public class IcmWsCalcOperacionesBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "icm_P_Trace", required = true, nillable = true)
  protected String icmPTrace;

  @XmlElement(name = "Icm_Ws_Calc_OperacionesRecordSet", nillable = true)
  protected List<IcmWsCalcOperacionesRecord> icmWsCalcOperacionesRecordSet;

  /**
   * Obtiene el valor de la propiedad icmPTrace.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIcmPTrace() {
    return icmPTrace;
  }

  /**
   * Define el valor de la propiedad icmPTrace.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIcmPTrace(String value) {
    this.icmPTrace = value;
  }

  /**
   * Gets the value of the icmWsCalcOperacionesRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmWsCalcOperacionesRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmWsCalcOperacionesRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmWsCalcOperacionesRecord }
   *
   *
   */
  public List<IcmWsCalcOperacionesRecord> getIcmWsCalcOperacionesRecordSet() {
    if (icmWsCalcOperacionesRecordSet == null) {
      icmWsCalcOperacionesRecordSet = new ArrayList<IcmWsCalcOperacionesRecord>();
    }
    return this.icmWsCalcOperacionesRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmWsCalcOperacionesBlock that = ((IcmWsCalcOperacionesBlock) object);
    {
      String lhsIcmPTrace;
      lhsIcmPTrace = this.getIcmPTrace();
      String rhsIcmPTrace;
      rhsIcmPTrace = that.getIcmPTrace();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPTrace", lhsIcmPTrace),
          LocatorUtils.property(thatLocator, "icmPTrace", rhsIcmPTrace), lhsIcmPTrace, rhsIcmPTrace, (this.icmPTrace != null),
          (that.icmPTrace != null))) {
        return false;
      }
    }
    {
      List<IcmWsCalcOperacionesRecord> lhsIcmWsCalcOperacionesRecordSet;
      lhsIcmWsCalcOperacionesRecordSet = (((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty()))
          ? this.getIcmWsCalcOperacionesRecordSet()
          : null);
      List<IcmWsCalcOperacionesRecord> rhsIcmWsCalcOperacionesRecordSet;
      rhsIcmWsCalcOperacionesRecordSet = (((that.icmWsCalcOperacionesRecordSet != null) && (!that.icmWsCalcOperacionesRecordSet.isEmpty()))
          ? that.getIcmWsCalcOperacionesRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsCalcOperacionesRecordSet", lhsIcmWsCalcOperacionesRecordSet),
          LocatorUtils.property(thatLocator, "icmWsCalcOperacionesRecordSet", rhsIcmWsCalcOperacionesRecordSet),
          lhsIcmWsCalcOperacionesRecordSet, rhsIcmWsCalcOperacionesRecordSet,
          ((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty())),
          ((that.icmWsCalcOperacionesRecordSet != null) && (!that.icmWsCalcOperacionesRecordSet.isEmpty())))) {
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
      String theIcmPTrace;
      theIcmPTrace = this.getIcmPTrace();
      strategy.appendField(locator, this, "icmPTrace", buffer, theIcmPTrace, (this.icmPTrace != null));
    }
    {
      List<IcmWsCalcOperacionesRecord> theIcmWsCalcOperacionesRecordSet;
      theIcmWsCalcOperacionesRecordSet = (((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty()))
          ? this.getIcmWsCalcOperacionesRecordSet()
          : null);
      strategy.appendField(locator, this, "icmWsCalcOperacionesRecordSet", buffer, theIcmWsCalcOperacionesRecordSet,
          ((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theIcmPTrace;
      theIcmPTrace = this.getIcmPTrace();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPTrace", theIcmPTrace), currentHashCode, theIcmPTrace,
          (this.icmPTrace != null));
    }
    {
      List<IcmWsCalcOperacionesRecord> theIcmWsCalcOperacionesRecordSet;
      theIcmWsCalcOperacionesRecordSet = (((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty()))
          ? this.getIcmWsCalcOperacionesRecordSet()
          : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsCalcOperacionesRecordSet", theIcmWsCalcOperacionesRecordSet),
          currentHashCode, theIcmWsCalcOperacionesRecordSet,
          ((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmWsCalcOperacionesBlock) {
      final IcmWsCalcOperacionesBlock copy = ((IcmWsCalcOperacionesBlock) draftCopy);
      {
        Boolean icmPTraceShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPTrace != null));
        if (icmPTraceShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIcmPTrace;
          sourceIcmPTrace = this.getIcmPTrace();
          String copyIcmPTrace = ((String) strategy.copy(LocatorUtils.property(locator, "icmPTrace", sourceIcmPTrace), sourceIcmPTrace,
              (this.icmPTrace != null)));
          copy.setIcmPTrace(copyIcmPTrace);
        } else {
          if (icmPTraceShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmPTrace = null;
          }
        }
      }
      {
        Boolean icmWsCalcOperacionesRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty())));
        if (icmWsCalcOperacionesRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmWsCalcOperacionesRecord> sourceIcmWsCalcOperacionesRecordSet;
          sourceIcmWsCalcOperacionesRecordSet =
              (((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty()))
                  ? this.getIcmWsCalcOperacionesRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmWsCalcOperacionesRecord> copyIcmWsCalcOperacionesRecordSet = ((List<IcmWsCalcOperacionesRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmWsCalcOperacionesRecordSet", sourceIcmWsCalcOperacionesRecordSet),
              sourceIcmWsCalcOperacionesRecordSet,
              ((this.icmWsCalcOperacionesRecordSet != null) && (!this.icmWsCalcOperacionesRecordSet.isEmpty()))));
          copy.icmWsCalcOperacionesRecordSet = null;
          if (copyIcmWsCalcOperacionesRecordSet != null) {
            List<IcmWsCalcOperacionesRecord> uniqueIcmWsCalcOperacionesRecordSetl = copy.getIcmWsCalcOperacionesRecordSet();
            uniqueIcmWsCalcOperacionesRecordSetl.addAll(copyIcmWsCalcOperacionesRecordSet);
          }
        } else {
          if (icmWsCalcOperacionesRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmWsCalcOperacionesRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmWsCalcOperacionesBlock();
  }

}
