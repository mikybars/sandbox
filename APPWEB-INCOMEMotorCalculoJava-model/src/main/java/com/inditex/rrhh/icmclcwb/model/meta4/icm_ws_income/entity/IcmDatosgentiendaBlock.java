
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity;

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
 * <p>Clase Java para Icm_DatosgentiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_DatosgentiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_DatosgentiendaRecordSet" type="{http://schemas.meta4.com/}Icm_DatosgentiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_DatosgentiendaBlock", propOrder = {
    "icmDatosgentiendaRecordSet"
})
public class IcmDatosgentiendaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_DatosgentiendaRecordSet", nillable = true)
    protected List<IcmDatosgentiendaRecord> icmDatosgentiendaRecordSet;

    /**
     * Gets the value of the icmDatosgentiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmDatosgentiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmDatosgentiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmDatosgentiendaRecord }
     * 
     * 
     */
    public List<IcmDatosgentiendaRecord> getIcmDatosgentiendaRecordSet() {
        if (icmDatosgentiendaRecordSet == null) {
            icmDatosgentiendaRecordSet = new ArrayList<IcmDatosgentiendaRecord>();
        }
        return this.icmDatosgentiendaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmDatosgentiendaBlock that = ((IcmDatosgentiendaBlock) object);
        {
            List<IcmDatosgentiendaRecord> lhsIcmDatosgentiendaRecordSet;
            lhsIcmDatosgentiendaRecordSet = (((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty()))?this.getIcmDatosgentiendaRecordSet():null);
            List<IcmDatosgentiendaRecord> rhsIcmDatosgentiendaRecordSet;
            rhsIcmDatosgentiendaRecordSet = (((that.icmDatosgentiendaRecordSet!= null)&&(!that.icmDatosgentiendaRecordSet.isEmpty()))?that.getIcmDatosgentiendaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmDatosgentiendaRecordSet", lhsIcmDatosgentiendaRecordSet), LocatorUtils.property(thatLocator, "icmDatosgentiendaRecordSet", rhsIcmDatosgentiendaRecordSet), lhsIcmDatosgentiendaRecordSet, rhsIcmDatosgentiendaRecordSet, ((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty())), ((that.icmDatosgentiendaRecordSet!= null)&&(!that.icmDatosgentiendaRecordSet.isEmpty())))) {
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
            List<IcmDatosgentiendaRecord> theIcmDatosgentiendaRecordSet;
            theIcmDatosgentiendaRecordSet = (((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty()))?this.getIcmDatosgentiendaRecordSet():null);
            strategy.appendField(locator, this, "icmDatosgentiendaRecordSet", buffer, theIcmDatosgentiendaRecordSet, ((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmDatosgentiendaRecord> theIcmDatosgentiendaRecordSet;
            theIcmDatosgentiendaRecordSet = (((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty()))?this.getIcmDatosgentiendaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmDatosgentiendaRecordSet", theIcmDatosgentiendaRecordSet), currentHashCode, theIcmDatosgentiendaRecordSet, ((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmDatosgentiendaBlock) {
            final IcmDatosgentiendaBlock copy = ((IcmDatosgentiendaBlock) draftCopy);
            {
                Boolean icmDatosgentiendaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty())));
                if (icmDatosgentiendaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmDatosgentiendaRecord> sourceIcmDatosgentiendaRecordSet;
                    sourceIcmDatosgentiendaRecordSet = (((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty()))?this.getIcmDatosgentiendaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmDatosgentiendaRecord> copyIcmDatosgentiendaRecordSet = ((List<IcmDatosgentiendaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmDatosgentiendaRecordSet", sourceIcmDatosgentiendaRecordSet), sourceIcmDatosgentiendaRecordSet, ((this.icmDatosgentiendaRecordSet!= null)&&(!this.icmDatosgentiendaRecordSet.isEmpty()))));
                    copy.icmDatosgentiendaRecordSet = null;
                    if (copyIcmDatosgentiendaRecordSet!= null) {
                        List<IcmDatosgentiendaRecord> uniqueIcmDatosgentiendaRecordSetl = copy.getIcmDatosgentiendaRecordSet();
                        uniqueIcmDatosgentiendaRecordSetl.addAll(copyIcmDatosgentiendaRecordSet);
                    }
                } else {
                    if (icmDatosgentiendaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmDatosgentiendaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmDatosgentiendaBlock();
    }

}
