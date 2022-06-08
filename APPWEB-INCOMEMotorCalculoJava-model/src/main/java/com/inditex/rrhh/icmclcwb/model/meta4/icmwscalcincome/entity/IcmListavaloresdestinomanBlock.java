
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
 * <p>Clase Java para Icm_ListavaloresdestinomanBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListavaloresdestinomanBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idestructuradestino" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ListavaloresdestinomanRecordSet" type="{http://schemas.meta4.com/}Icm_ListavaloresdestinomanRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListavaloresdestinomanBlock", propOrder = {
    "idestructuradestino",
    "icmListavaloresdestinomanRecordSet"
})
public class IcmListavaloresdestinomanBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String idestructuradestino;

  @XmlElement(name = "Icm_ListavaloresdestinomanRecordSet", nillable = true)
  protected List<IcmListavaloresdestinomanRecord> icmListavaloresdestinomanRecordSet;

  /**
   * Obtiene el valor de la propiedad idestructuradestino.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdestructuradestino() {
    return idestructuradestino;
  }

  /**
   * Define el valor de la propiedad idestructuradestino.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdestructuradestino(String value) {
    this.idestructuradestino = value;
  }

  /**
   * Gets the value of the icmListavaloresdestinomanRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmListavaloresdestinomanRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmListavaloresdestinomanRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmListavaloresdestinomanRecord }
   *
   *
   */
  public List<IcmListavaloresdestinomanRecord> getIcmListavaloresdestinomanRecordSet() {
    if (icmListavaloresdestinomanRecordSet == null) {
      icmListavaloresdestinomanRecordSet = new ArrayList<IcmListavaloresdestinomanRecord>();
    }
    return this.icmListavaloresdestinomanRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmListavaloresdestinomanBlock that = ((IcmListavaloresdestinomanBlock) object);
    {
      String lhsIdestructuradestino;
      lhsIdestructuradestino = this.getIdestructuradestino();
      String rhsIdestructuradestino;
      rhsIdestructuradestino = that.getIdestructuradestino();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idestructuradestino", lhsIdestructuradestino),
          LocatorUtils.property(thatLocator, "idestructuradestino", rhsIdestructuradestino), lhsIdestructuradestino, rhsIdestructuradestino,
          (this.idestructuradestino != null), (that.idestructuradestino != null))) {
        return false;
      }
    }
    {
      List<IcmListavaloresdestinomanRecord> lhsIcmListavaloresdestinomanRecordSet;
      lhsIcmListavaloresdestinomanRecordSet =
          (((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty()))
              ? this.getIcmListavaloresdestinomanRecordSet()
              : null);
      List<IcmListavaloresdestinomanRecord> rhsIcmListavaloresdestinomanRecordSet;
      rhsIcmListavaloresdestinomanRecordSet =
          (((that.icmListavaloresdestinomanRecordSet != null) && (!that.icmListavaloresdestinomanRecordSet.isEmpty()))
              ? that.getIcmListavaloresdestinomanRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListavaloresdestinomanRecordSet", lhsIcmListavaloresdestinomanRecordSet),
          LocatorUtils.property(thatLocator, "icmListavaloresdestinomanRecordSet", rhsIcmListavaloresdestinomanRecordSet),
          lhsIcmListavaloresdestinomanRecordSet, rhsIcmListavaloresdestinomanRecordSet,
          ((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty())),
          ((that.icmListavaloresdestinomanRecordSet != null) && (!that.icmListavaloresdestinomanRecordSet.isEmpty())))) {
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
      String theIdestructuradestino;
      theIdestructuradestino = this.getIdestructuradestino();
      strategy.appendField(locator, this, "idestructuradestino", buffer, theIdestructuradestino, (this.idestructuradestino != null));
    }
    {
      List<IcmListavaloresdestinomanRecord> theIcmListavaloresdestinomanRecordSet;
      theIcmListavaloresdestinomanRecordSet =
          (((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty()))
              ? this.getIcmListavaloresdestinomanRecordSet()
              : null);
      strategy.appendField(locator, this, "icmListavaloresdestinomanRecordSet", buffer, theIcmListavaloresdestinomanRecordSet,
          ((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theIdestructuradestino;
      theIdestructuradestino = this.getIdestructuradestino();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructuradestino", theIdestructuradestino), currentHashCode,
          theIdestructuradestino, (this.idestructuradestino != null));
    }
    {
      List<IcmListavaloresdestinomanRecord> theIcmListavaloresdestinomanRecordSet;
      theIcmListavaloresdestinomanRecordSet =
          (((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty()))
              ? this.getIcmListavaloresdestinomanRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmListavaloresdestinomanRecordSet", theIcmListavaloresdestinomanRecordSet),
              currentHashCode, theIcmListavaloresdestinomanRecordSet,
              ((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty())));
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
    if (draftCopy instanceof IcmListavaloresdestinomanBlock) {
      final IcmListavaloresdestinomanBlock copy = ((IcmListavaloresdestinomanBlock) draftCopy);
      {
        Boolean idestructuradestinoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestructuradestino != null));
        if (idestructuradestinoShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdestructuradestino;
          sourceIdestructuradestino = this.getIdestructuradestino();
          String copyIdestructuradestino =
              ((String) strategy.copy(LocatorUtils.property(locator, "idestructuradestino", sourceIdestructuradestino),
                  sourceIdestructuradestino, (this.idestructuradestino != null)));
          copy.setIdestructuradestino(copyIdestructuradestino);
        } else {
          if (idestructuradestinoShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idestructuradestino = null;
          }
        }
      }
      {
        Boolean icmListavaloresdestinomanRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty())));
        if (icmListavaloresdestinomanRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmListavaloresdestinomanRecord> sourceIcmListavaloresdestinomanRecordSet;
          sourceIcmListavaloresdestinomanRecordSet =
              (((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty()))
                  ? this.getIcmListavaloresdestinomanRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmListavaloresdestinomanRecord> copyIcmListavaloresdestinomanRecordSet = ((List<IcmListavaloresdestinomanRecord>) strategy
              .copy(LocatorUtils.property(locator, "icmListavaloresdestinomanRecordSet", sourceIcmListavaloresdestinomanRecordSet),
                  sourceIcmListavaloresdestinomanRecordSet,
                  ((this.icmListavaloresdestinomanRecordSet != null) && (!this.icmListavaloresdestinomanRecordSet.isEmpty()))));
          copy.icmListavaloresdestinomanRecordSet = null;
          if (copyIcmListavaloresdestinomanRecordSet != null) {
            List<IcmListavaloresdestinomanRecord> uniqueIcmListavaloresdestinomanRecordSetl = copy.getIcmListavaloresdestinomanRecordSet();
            uniqueIcmListavaloresdestinomanRecordSetl.addAll(copyIcmListavaloresdestinomanRecordSet);
          }
        } else {
          if (icmListavaloresdestinomanRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmListavaloresdestinomanRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmListavaloresdestinomanBlock();
  }

}
