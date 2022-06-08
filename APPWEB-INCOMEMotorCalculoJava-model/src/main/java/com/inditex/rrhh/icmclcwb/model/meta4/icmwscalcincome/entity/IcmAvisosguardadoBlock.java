
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
 * <p>Clase Java para Icm_AvisosguardadoBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_AvisosguardadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_AvisosguardadoRecordSet" type="{http://schemas.meta4.com/}Icm_AvisosguardadoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_AvisosguardadoBlock", propOrder = {
    "resultado",
    "icmAvisosguardadoRecordSet"
})
public class IcmAvisosguardadoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String resultado;

  @XmlElement(name = "Icm_AvisosguardadoRecordSet", nillable = true)
  protected List<IcmAvisosguardadoRecord> icmAvisosguardadoRecordSet;

  /**
   * Obtiene el valor de la propiedad resultado.
   *
   * @return possible object is {@link String }
   *
   */
  public String getResultado() {
    return resultado;
  }

  /**
   * Define el valor de la propiedad resultado.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setResultado(String value) {
    this.resultado = value;
  }

  /**
   * Gets the value of the icmAvisosguardadoRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmAvisosguardadoRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmAvisosguardadoRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmAvisosguardadoRecord }
   *
   *
   */
  public List<IcmAvisosguardadoRecord> getIcmAvisosguardadoRecordSet() {
    if (icmAvisosguardadoRecordSet == null) {
      icmAvisosguardadoRecordSet = new ArrayList<IcmAvisosguardadoRecord>();
    }
    return this.icmAvisosguardadoRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmAvisosguardadoBlock that = ((IcmAvisosguardadoBlock) object);
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
      List<IcmAvisosguardadoRecord> lhsIcmAvisosguardadoRecordSet;
      lhsIcmAvisosguardadoRecordSet = (((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty()))
          ? this.getIcmAvisosguardadoRecordSet()
          : null);
      List<IcmAvisosguardadoRecord> rhsIcmAvisosguardadoRecordSet;
      rhsIcmAvisosguardadoRecordSet = (((that.icmAvisosguardadoRecordSet != null) && (!that.icmAvisosguardadoRecordSet.isEmpty()))
          ? that.getIcmAvisosguardadoRecordSet()
          : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmAvisosguardadoRecordSet", lhsIcmAvisosguardadoRecordSet),
          LocatorUtils.property(thatLocator, "icmAvisosguardadoRecordSet", rhsIcmAvisosguardadoRecordSet), lhsIcmAvisosguardadoRecordSet,
          rhsIcmAvisosguardadoRecordSet, ((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty())),
          ((that.icmAvisosguardadoRecordSet != null) && (!that.icmAvisosguardadoRecordSet.isEmpty())))) {
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
      List<IcmAvisosguardadoRecord> theIcmAvisosguardadoRecordSet;
      theIcmAvisosguardadoRecordSet = (((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty()))
          ? this.getIcmAvisosguardadoRecordSet()
          : null);
      strategy.appendField(locator, this, "icmAvisosguardadoRecordSet", buffer, theIcmAvisosguardadoRecordSet,
          ((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty())));
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
      List<IcmAvisosguardadoRecord> theIcmAvisosguardadoRecordSet;
      theIcmAvisosguardadoRecordSet = (((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty()))
          ? this.getIcmAvisosguardadoRecordSet()
          : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmAvisosguardadoRecordSet", theIcmAvisosguardadoRecordSet), currentHashCode,
              theIcmAvisosguardadoRecordSet, ((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmAvisosguardadoBlock) {
      final IcmAvisosguardadoBlock copy = ((IcmAvisosguardadoBlock) draftCopy);
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
        Boolean icmAvisosguardadoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty())));
        if (icmAvisosguardadoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmAvisosguardadoRecord> sourceIcmAvisosguardadoRecordSet;
          sourceIcmAvisosguardadoRecordSet = (((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty()))
              ? this.getIcmAvisosguardadoRecordSet()
              : null);
          @SuppressWarnings("unchecked")
          List<IcmAvisosguardadoRecord> copyIcmAvisosguardadoRecordSet = ((List<IcmAvisosguardadoRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmAvisosguardadoRecordSet", sourceIcmAvisosguardadoRecordSet),
              sourceIcmAvisosguardadoRecordSet,
              ((this.icmAvisosguardadoRecordSet != null) && (!this.icmAvisosguardadoRecordSet.isEmpty()))));
          copy.icmAvisosguardadoRecordSet = null;
          if (copyIcmAvisosguardadoRecordSet != null) {
            List<IcmAvisosguardadoRecord> uniqueIcmAvisosguardadoRecordSetl = copy.getIcmAvisosguardadoRecordSet();
            uniqueIcmAvisosguardadoRecordSetl.addAll(copyIcmAvisosguardadoRecordSet);
          }
        } else {
          if (icmAvisosguardadoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmAvisosguardadoRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmAvisosguardadoBlock();
  }

}
