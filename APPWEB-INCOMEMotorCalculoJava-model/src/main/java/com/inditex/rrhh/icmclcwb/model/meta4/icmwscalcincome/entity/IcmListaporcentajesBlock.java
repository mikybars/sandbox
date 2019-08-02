
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

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
 * <p>Clase Java para Icm_ListaporcentajesBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ListaporcentajesBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ListaporcentajesRecordSet" type="{http://schemas.meta4.com/}Icm_ListaporcentajesRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaporcentajesBlock", propOrder = {
    "idestructura",
    "icmListaporcentajesRecordSet"
})
public class IcmListaporcentajesBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_ListaporcentajesRecordSet", nillable = true)
    protected List<IcmListaporcentajesRecord> icmListaporcentajesRecordSet;

    /**
     * Obtiene el valor de la propiedad idestructura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdestructura() {
        return idestructura;
    }

    /**
     * Define el valor de la propiedad idestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdestructura(String value) {
        this.idestructura = value;
    }

    /**
     * Gets the value of the icmListaporcentajesRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListaporcentajesRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListaporcentajesRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListaporcentajesRecord }
     * 
     * 
     */
    public List<IcmListaporcentajesRecord> getIcmListaporcentajesRecordSet() {
        if (icmListaporcentajesRecordSet == null) {
            icmListaporcentajesRecordSet = new ArrayList<IcmListaporcentajesRecord>();
        }
        return this.icmListaporcentajesRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListaporcentajesBlock that = ((IcmListaporcentajesBlock) object);
        {
            String lhsIdestructura;
            lhsIdestructura = this.getIdestructura();
            String rhsIdestructura;
            rhsIdestructura = that.getIdestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestructura", lhsIdestructura), LocatorUtils.property(thatLocator, "idestructura", rhsIdestructura), lhsIdestructura, rhsIdestructura, (this.idestructura!= null), (that.idestructura!= null))) {
                return false;
            }
        }
        {
            List<IcmListaporcentajesRecord> lhsIcmListaporcentajesRecordSet;
            lhsIcmListaporcentajesRecordSet = (((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty()))?this.getIcmListaporcentajesRecordSet():null);
            List<IcmListaporcentajesRecord> rhsIcmListaporcentajesRecordSet;
            rhsIcmListaporcentajesRecordSet = (((that.icmListaporcentajesRecordSet!= null)&&(!that.icmListaporcentajesRecordSet.isEmpty()))?that.getIcmListaporcentajesRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaporcentajesRecordSet", lhsIcmListaporcentajesRecordSet), LocatorUtils.property(thatLocator, "icmListaporcentajesRecordSet", rhsIcmListaporcentajesRecordSet), lhsIcmListaporcentajesRecordSet, rhsIcmListaporcentajesRecordSet, ((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty())), ((that.icmListaporcentajesRecordSet!= null)&&(!that.icmListaporcentajesRecordSet.isEmpty())))) {
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
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            strategy.appendField(locator, this, "idestructura", buffer, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmListaporcentajesRecord> theIcmListaporcentajesRecordSet;
            theIcmListaporcentajesRecordSet = (((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty()))?this.getIcmListaporcentajesRecordSet():null);
            strategy.appendField(locator, this, "icmListaporcentajesRecordSet", buffer, theIcmListaporcentajesRecordSet, ((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructura", theIdestructura), currentHashCode, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmListaporcentajesRecord> theIcmListaporcentajesRecordSet;
            theIcmListaporcentajesRecordSet = (((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty()))?this.getIcmListaporcentajesRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaporcentajesRecordSet", theIcmListaporcentajesRecordSet), currentHashCode, theIcmListaporcentajesRecordSet, ((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty())));
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
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof IcmListaporcentajesBlock) {
            final IcmListaporcentajesBlock copy = ((IcmListaporcentajesBlock) draftCopy);
            {
                Boolean idestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestructura!= null));
                if (idestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestructura;
                    sourceIdestructura = this.getIdestructura();
                    String copyIdestructura = ((String) strategy.copy(LocatorUtils.property(locator, "idestructura", sourceIdestructura), sourceIdestructura, (this.idestructura!= null)));
                    copy.setIdestructura(copyIdestructura);
                } else {
                    if (idestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestructura = null;
                    }
                }
            }
            {
                Boolean icmListaporcentajesRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty())));
                if (icmListaporcentajesRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListaporcentajesRecord> sourceIcmListaporcentajesRecordSet;
                    sourceIcmListaporcentajesRecordSet = (((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty()))?this.getIcmListaporcentajesRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListaporcentajesRecord> copyIcmListaporcentajesRecordSet = ((List<IcmListaporcentajesRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListaporcentajesRecordSet", sourceIcmListaporcentajesRecordSet), sourceIcmListaporcentajesRecordSet, ((this.icmListaporcentajesRecordSet!= null)&&(!this.icmListaporcentajesRecordSet.isEmpty()))));
                    copy.icmListaporcentajesRecordSet = null;
                    if (copyIcmListaporcentajesRecordSet!= null) {
                        List<IcmListaporcentajesRecord> uniqueIcmListaporcentajesRecordSetl = copy.getIcmListaporcentajesRecordSet();
                        uniqueIcmListaporcentajesRecordSetl.addAll(copyIcmListaporcentajesRecordSet);
                    }
                } else {
                    if (icmListaporcentajesRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaporcentajesRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListaporcentajesBlock();
    }

}
