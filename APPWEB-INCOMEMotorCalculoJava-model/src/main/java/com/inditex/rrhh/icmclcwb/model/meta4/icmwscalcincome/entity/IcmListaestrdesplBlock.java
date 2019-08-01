
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
 * <p>Clase Java para Icm_ListaestrdesplBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ListaestrdesplBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ListaestrdesplRecordSet" type="{http://schemas.meta4.com/}Icm_ListaestrdesplRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaestrdesplBlock", propOrder = {
    "idestructura",
    "icmListaestrdesplRecordSet"
})
public class IcmListaestrdesplBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_ListaestrdesplRecordSet", nillable = true)
    protected List<IcmListaestrdesplRecord> icmListaestrdesplRecordSet;

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
     * Gets the value of the icmListaestrdesplRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListaestrdesplRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListaestrdesplRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListaestrdesplRecord }
     * 
     * 
     */
    public List<IcmListaestrdesplRecord> getIcmListaestrdesplRecordSet() {
        if (icmListaestrdesplRecordSet == null) {
            icmListaestrdesplRecordSet = new ArrayList<IcmListaestrdesplRecord>();
        }
        return this.icmListaestrdesplRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListaestrdesplBlock that = ((IcmListaestrdesplBlock) object);
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
            List<IcmListaestrdesplRecord> lhsIcmListaestrdesplRecordSet;
            lhsIcmListaestrdesplRecordSet = (((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty()))?this.getIcmListaestrdesplRecordSet():null);
            List<IcmListaestrdesplRecord> rhsIcmListaestrdesplRecordSet;
            rhsIcmListaestrdesplRecordSet = (((that.icmListaestrdesplRecordSet!= null)&&(!that.icmListaestrdesplRecordSet.isEmpty()))?that.getIcmListaestrdesplRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaestrdesplRecordSet", lhsIcmListaestrdesplRecordSet), LocatorUtils.property(thatLocator, "icmListaestrdesplRecordSet", rhsIcmListaestrdesplRecordSet), lhsIcmListaestrdesplRecordSet, rhsIcmListaestrdesplRecordSet, ((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty())), ((that.icmListaestrdesplRecordSet!= null)&&(!that.icmListaestrdesplRecordSet.isEmpty())))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
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
            List<IcmListaestrdesplRecord> theIcmListaestrdesplRecordSet;
            theIcmListaestrdesplRecordSet = (((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty()))?this.getIcmListaestrdesplRecordSet():null);
            strategy.appendField(locator, this, "icmListaestrdesplRecordSet", buffer, theIcmListaestrdesplRecordSet, ((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty())));
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
            List<IcmListaestrdesplRecord> theIcmListaestrdesplRecordSet;
            theIcmListaestrdesplRecordSet = (((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty()))?this.getIcmListaestrdesplRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaestrdesplRecordSet", theIcmListaestrdesplRecordSet), currentHashCode, theIcmListaestrdesplRecordSet, ((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty())));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof IcmListaestrdesplBlock) {
            final IcmListaestrdesplBlock copy = ((IcmListaestrdesplBlock) draftCopy);
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
                Boolean icmListaestrdesplRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty())));
                if (icmListaestrdesplRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListaestrdesplRecord> sourceIcmListaestrdesplRecordSet;
                    sourceIcmListaestrdesplRecordSet = (((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty()))?this.getIcmListaestrdesplRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListaestrdesplRecord> copyIcmListaestrdesplRecordSet = ((List<IcmListaestrdesplRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListaestrdesplRecordSet", sourceIcmListaestrdesplRecordSet), sourceIcmListaestrdesplRecordSet, ((this.icmListaestrdesplRecordSet!= null)&&(!this.icmListaestrdesplRecordSet.isEmpty()))));
                    copy.icmListaestrdesplRecordSet = null;
                    if (copyIcmListaestrdesplRecordSet!= null) {
                        List<IcmListaestrdesplRecord> uniqueIcmListaestrdesplRecordSetl = copy.getIcmListaestrdesplRecordSet();
                        uniqueIcmListaestrdesplRecordSetl.addAll(copyIcmListaestrdesplRecordSet);
                    }
                } else {
                    if (icmListaestrdesplRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaestrdesplRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListaestrdesplBlock();
    }

}
