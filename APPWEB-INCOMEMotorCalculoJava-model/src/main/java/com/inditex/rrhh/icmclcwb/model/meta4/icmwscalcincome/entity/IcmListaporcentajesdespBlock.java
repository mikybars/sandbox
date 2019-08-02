
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
 * <p>Clase Java para Icm_ListaporcentajesdespBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ListaporcentajesdespBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ListaporcentajesdespRecordSet" type="{http://schemas.meta4.com/}Icm_ListaporcentajesdespRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaporcentajesdespBlock", propOrder = {
    "idestructura",
    "icmListaporcentajesdespRecordSet"
})
public class IcmListaporcentajesdespBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_ListaporcentajesdespRecordSet", nillable = true)
    protected List<IcmListaporcentajesdespRecord> icmListaporcentajesdespRecordSet;

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
     * Gets the value of the icmListaporcentajesdespRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListaporcentajesdespRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListaporcentajesdespRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListaporcentajesdespRecord }
     * 
     * 
     */
    public List<IcmListaporcentajesdespRecord> getIcmListaporcentajesdespRecordSet() {
        if (icmListaporcentajesdespRecordSet == null) {
            icmListaporcentajesdespRecordSet = new ArrayList<IcmListaporcentajesdespRecord>();
        }
        return this.icmListaporcentajesdespRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListaporcentajesdespBlock that = ((IcmListaporcentajesdespBlock) object);
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
            List<IcmListaporcentajesdespRecord> lhsIcmListaporcentajesdespRecordSet;
            lhsIcmListaporcentajesdespRecordSet = (((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty()))?this.getIcmListaporcentajesdespRecordSet():null);
            List<IcmListaporcentajesdespRecord> rhsIcmListaporcentajesdespRecordSet;
            rhsIcmListaporcentajesdespRecordSet = (((that.icmListaporcentajesdespRecordSet!= null)&&(!that.icmListaporcentajesdespRecordSet.isEmpty()))?that.getIcmListaporcentajesdespRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaporcentajesdespRecordSet", lhsIcmListaporcentajesdespRecordSet), LocatorUtils.property(thatLocator, "icmListaporcentajesdespRecordSet", rhsIcmListaporcentajesdespRecordSet), lhsIcmListaporcentajesdespRecordSet, rhsIcmListaporcentajesdespRecordSet, ((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty())), ((that.icmListaporcentajesdespRecordSet!= null)&&(!that.icmListaporcentajesdespRecordSet.isEmpty())))) {
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
            List<IcmListaporcentajesdespRecord> theIcmListaporcentajesdespRecordSet;
            theIcmListaporcentajesdespRecordSet = (((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty()))?this.getIcmListaporcentajesdespRecordSet():null);
            strategy.appendField(locator, this, "icmListaporcentajesdespRecordSet", buffer, theIcmListaporcentajesdespRecordSet, ((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty())));
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
            List<IcmListaporcentajesdespRecord> theIcmListaporcentajesdespRecordSet;
            theIcmListaporcentajesdespRecordSet = (((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty()))?this.getIcmListaporcentajesdespRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaporcentajesdespRecordSet", theIcmListaporcentajesdespRecordSet), currentHashCode, theIcmListaporcentajesdespRecordSet, ((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListaporcentajesdespBlock) {
            final IcmListaporcentajesdespBlock copy = ((IcmListaporcentajesdespBlock) draftCopy);
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
                Boolean icmListaporcentajesdespRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty())));
                if (icmListaporcentajesdespRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListaporcentajesdespRecord> sourceIcmListaporcentajesdespRecordSet;
                    sourceIcmListaporcentajesdespRecordSet = (((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty()))?this.getIcmListaporcentajesdespRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListaporcentajesdespRecord> copyIcmListaporcentajesdespRecordSet = ((List<IcmListaporcentajesdespRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListaporcentajesdespRecordSet", sourceIcmListaporcentajesdespRecordSet), sourceIcmListaporcentajesdespRecordSet, ((this.icmListaporcentajesdespRecordSet!= null)&&(!this.icmListaporcentajesdespRecordSet.isEmpty()))));
                    copy.icmListaporcentajesdespRecordSet = null;
                    if (copyIcmListaporcentajesdespRecordSet!= null) {
                        List<IcmListaporcentajesdespRecord> uniqueIcmListaporcentajesdespRecordSetl = copy.getIcmListaporcentajesdespRecordSet();
                        uniqueIcmListaporcentajesdespRecordSetl.addAll(copyIcmListaporcentajesdespRecordSet);
                    }
                } else {
                    if (icmListaporcentajesdespRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaporcentajesdespRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListaporcentajesdespBlock();
    }

}
