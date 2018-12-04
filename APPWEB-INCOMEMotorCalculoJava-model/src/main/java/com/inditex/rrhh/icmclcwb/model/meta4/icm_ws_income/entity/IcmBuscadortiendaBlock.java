
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
 * <p>Clase Java para Icm_BuscadortiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_BuscadortiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_BuscadortiendaRecordSet" type="{http://schemas.meta4.com/}Icm_BuscadortiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_BuscadortiendaBlock", propOrder = {
    "icmBuscadortiendaRecordSet"
})
public class IcmBuscadortiendaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_BuscadortiendaRecordSet", nillable = true)
    protected List<IcmBuscadortiendaRecord> icmBuscadortiendaRecordSet;

    /**
     * Gets the value of the icmBuscadortiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmBuscadortiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmBuscadortiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmBuscadortiendaRecord }
     * 
     * 
     */
    public List<IcmBuscadortiendaRecord> getIcmBuscadortiendaRecordSet() {
        if (icmBuscadortiendaRecordSet == null) {
            icmBuscadortiendaRecordSet = new ArrayList<IcmBuscadortiendaRecord>();
        }
        return this.icmBuscadortiendaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmBuscadortiendaBlock that = ((IcmBuscadortiendaBlock) object);
        {
            List<IcmBuscadortiendaRecord> lhsIcmBuscadortiendaRecordSet;
            lhsIcmBuscadortiendaRecordSet = (((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty()))?this.getIcmBuscadortiendaRecordSet():null);
            List<IcmBuscadortiendaRecord> rhsIcmBuscadortiendaRecordSet;
            rhsIcmBuscadortiendaRecordSet = (((that.icmBuscadortiendaRecordSet!= null)&&(!that.icmBuscadortiendaRecordSet.isEmpty()))?that.getIcmBuscadortiendaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmBuscadortiendaRecordSet", lhsIcmBuscadortiendaRecordSet), LocatorUtils.property(thatLocator, "icmBuscadortiendaRecordSet", rhsIcmBuscadortiendaRecordSet), lhsIcmBuscadortiendaRecordSet, rhsIcmBuscadortiendaRecordSet, ((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty())), ((that.icmBuscadortiendaRecordSet!= null)&&(!that.icmBuscadortiendaRecordSet.isEmpty())))) {
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
            List<IcmBuscadortiendaRecord> theIcmBuscadortiendaRecordSet;
            theIcmBuscadortiendaRecordSet = (((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty()))?this.getIcmBuscadortiendaRecordSet():null);
            strategy.appendField(locator, this, "icmBuscadortiendaRecordSet", buffer, theIcmBuscadortiendaRecordSet, ((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmBuscadortiendaRecord> theIcmBuscadortiendaRecordSet;
            theIcmBuscadortiendaRecordSet = (((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty()))?this.getIcmBuscadortiendaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmBuscadortiendaRecordSet", theIcmBuscadortiendaRecordSet), currentHashCode, theIcmBuscadortiendaRecordSet, ((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmBuscadortiendaBlock) {
            final IcmBuscadortiendaBlock copy = ((IcmBuscadortiendaBlock) draftCopy);
            {
                Boolean icmBuscadortiendaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty())));
                if (icmBuscadortiendaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmBuscadortiendaRecord> sourceIcmBuscadortiendaRecordSet;
                    sourceIcmBuscadortiendaRecordSet = (((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty()))?this.getIcmBuscadortiendaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmBuscadortiendaRecord> copyIcmBuscadortiendaRecordSet = ((List<IcmBuscadortiendaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmBuscadortiendaRecordSet", sourceIcmBuscadortiendaRecordSet), sourceIcmBuscadortiendaRecordSet, ((this.icmBuscadortiendaRecordSet!= null)&&(!this.icmBuscadortiendaRecordSet.isEmpty()))));
                    copy.icmBuscadortiendaRecordSet = null;
                    if (copyIcmBuscadortiendaRecordSet!= null) {
                        List<IcmBuscadortiendaRecord> uniqueIcmBuscadortiendaRecordSetl = copy.getIcmBuscadortiendaRecordSet();
                        uniqueIcmBuscadortiendaRecordSetl.addAll(copyIcmBuscadortiendaRecordSet);
                    }
                } else {
                    if (icmBuscadortiendaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmBuscadortiendaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmBuscadortiendaBlock();
    }

}
