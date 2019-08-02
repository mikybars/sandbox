
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
 * <p>Clase Java para Icm_ListavalidacionBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ListavalidacionBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_ListavalidacionRecordSet" type="{http://schemas.meta4.com/}Icm_ListavalidacionRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListavalidacionBlock", propOrder = {
    "icmListavalidacionRecordSet"
})
public class IcmListavalidacionBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_ListavalidacionRecordSet", nillable = true)
    protected List<IcmListavalidacionRecord> icmListavalidacionRecordSet;

    /**
     * Gets the value of the icmListavalidacionRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListavalidacionRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListavalidacionRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListavalidacionRecord }
     * 
     * 
     */
    public List<IcmListavalidacionRecord> getIcmListavalidacionRecordSet() {
        if (icmListavalidacionRecordSet == null) {
            icmListavalidacionRecordSet = new ArrayList<IcmListavalidacionRecord>();
        }
        return this.icmListavalidacionRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListavalidacionBlock that = ((IcmListavalidacionBlock) object);
        {
            List<IcmListavalidacionRecord> lhsIcmListavalidacionRecordSet;
            lhsIcmListavalidacionRecordSet = (((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty()))?this.getIcmListavalidacionRecordSet():null);
            List<IcmListavalidacionRecord> rhsIcmListavalidacionRecordSet;
            rhsIcmListavalidacionRecordSet = (((that.icmListavalidacionRecordSet!= null)&&(!that.icmListavalidacionRecordSet.isEmpty()))?that.getIcmListavalidacionRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListavalidacionRecordSet", lhsIcmListavalidacionRecordSet), LocatorUtils.property(thatLocator, "icmListavalidacionRecordSet", rhsIcmListavalidacionRecordSet), lhsIcmListavalidacionRecordSet, rhsIcmListavalidacionRecordSet, ((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty())), ((that.icmListavalidacionRecordSet!= null)&&(!that.icmListavalidacionRecordSet.isEmpty())))) {
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
            List<IcmListavalidacionRecord> theIcmListavalidacionRecordSet;
            theIcmListavalidacionRecordSet = (((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty()))?this.getIcmListavalidacionRecordSet():null);
            strategy.appendField(locator, this, "icmListavalidacionRecordSet", buffer, theIcmListavalidacionRecordSet, ((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmListavalidacionRecord> theIcmListavalidacionRecordSet;
            theIcmListavalidacionRecordSet = (((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty()))?this.getIcmListavalidacionRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListavalidacionRecordSet", theIcmListavalidacionRecordSet), currentHashCode, theIcmListavalidacionRecordSet, ((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListavalidacionBlock) {
            final IcmListavalidacionBlock copy = ((IcmListavalidacionBlock) draftCopy);
            {
                Boolean icmListavalidacionRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty())));
                if (icmListavalidacionRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListavalidacionRecord> sourceIcmListavalidacionRecordSet;
                    sourceIcmListavalidacionRecordSet = (((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty()))?this.getIcmListavalidacionRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListavalidacionRecord> copyIcmListavalidacionRecordSet = ((List<IcmListavalidacionRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListavalidacionRecordSet", sourceIcmListavalidacionRecordSet), sourceIcmListavalidacionRecordSet, ((this.icmListavalidacionRecordSet!= null)&&(!this.icmListavalidacionRecordSet.isEmpty()))));
                    copy.icmListavalidacionRecordSet = null;
                    if (copyIcmListavalidacionRecordSet!= null) {
                        List<IcmListavalidacionRecord> uniqueIcmListavalidacionRecordSetl = copy.getIcmListavalidacionRecordSet();
                        uniqueIcmListavalidacionRecordSetl.addAll(copyIcmListavalidacionRecordSet);
                    }
                } else {
                    if (icmListavalidacionRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListavalidacionRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListavalidacionBlock();
    }

}
