
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
 * <p>Clase Java para Icm_ListaprevalidBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ListaprevalidBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaprevalidRecordSet" type="{http://schemas.meta4.com/}Icm_ListaprevalidRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaprevalidBlock", propOrder = {
    "icmListaprevalidRecordSet"
})
public class IcmListaprevalidBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ListaprevalidRecordSet", nillable = true)
    protected List<IcmListaprevalidRecord> icmListaprevalidRecordSet;

    /**
     * Gets the value of the icmListaprevalidRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListaprevalidRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListaprevalidRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListaprevalidRecord }
     * 
     * 
     */
    public List<IcmListaprevalidRecord> getIcmListaprevalidRecordSet() {
        if (icmListaprevalidRecordSet == null) {
            icmListaprevalidRecordSet = new ArrayList<IcmListaprevalidRecord>();
        }
        return this.icmListaprevalidRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListaprevalidBlock that = ((IcmListaprevalidBlock) object);
        {
            List<IcmListaprevalidRecord> lhsIcmListaprevalidRecordSet;
            lhsIcmListaprevalidRecordSet = (((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty()))?this.getIcmListaprevalidRecordSet():null);
            List<IcmListaprevalidRecord> rhsIcmListaprevalidRecordSet;
            rhsIcmListaprevalidRecordSet = (((that.icmListaprevalidRecordSet!= null)&&(!that.icmListaprevalidRecordSet.isEmpty()))?that.getIcmListaprevalidRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaprevalidRecordSet", lhsIcmListaprevalidRecordSet), LocatorUtils.property(thatLocator, "icmListaprevalidRecordSet", rhsIcmListaprevalidRecordSet), lhsIcmListaprevalidRecordSet, rhsIcmListaprevalidRecordSet, ((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty())), ((that.icmListaprevalidRecordSet!= null)&&(!that.icmListaprevalidRecordSet.isEmpty())))) {
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
            List<IcmListaprevalidRecord> theIcmListaprevalidRecordSet;
            theIcmListaprevalidRecordSet = (((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty()))?this.getIcmListaprevalidRecordSet():null);
            strategy.appendField(locator, this, "icmListaprevalidRecordSet", buffer, theIcmListaprevalidRecordSet, ((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmListaprevalidRecord> theIcmListaprevalidRecordSet;
            theIcmListaprevalidRecordSet = (((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty()))?this.getIcmListaprevalidRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaprevalidRecordSet", theIcmListaprevalidRecordSet), currentHashCode, theIcmListaprevalidRecordSet, ((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListaprevalidBlock) {
            final IcmListaprevalidBlock copy = ((IcmListaprevalidBlock) draftCopy);
            {
                Boolean icmListaprevalidRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty())));
                if (icmListaprevalidRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListaprevalidRecord> sourceIcmListaprevalidRecordSet;
                    sourceIcmListaprevalidRecordSet = (((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty()))?this.getIcmListaprevalidRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListaprevalidRecord> copyIcmListaprevalidRecordSet = ((List<IcmListaprevalidRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListaprevalidRecordSet", sourceIcmListaprevalidRecordSet), sourceIcmListaprevalidRecordSet, ((this.icmListaprevalidRecordSet!= null)&&(!this.icmListaprevalidRecordSet.isEmpty()))));
                    copy.icmListaprevalidRecordSet = null;
                    if (copyIcmListaprevalidRecordSet!= null) {
                        List<IcmListaprevalidRecord> uniqueIcmListaprevalidRecordSetl = copy.getIcmListaprevalidRecordSet();
                        uniqueIcmListaprevalidRecordSetl.addAll(copyIcmListaprevalidRecordSet);
                    }
                } else {
                    if (icmListaprevalidRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaprevalidRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListaprevalidBlock();
    }

}
