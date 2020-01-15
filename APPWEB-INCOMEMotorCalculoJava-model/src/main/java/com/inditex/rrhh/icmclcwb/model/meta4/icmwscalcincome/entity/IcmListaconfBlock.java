
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
 * <p>Clase Java para Icm_ListaconfBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ListaconfBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_ListaconfRecordSet" type="{http://schemas.meta4.com/}Icm_ListaconfRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaconfBlock", propOrder = {
    "icmListaconfRecordSet"
})
public class IcmListaconfBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_ListaconfRecordSet", nillable = true)
    protected List<IcmListaconfRecord> icmListaconfRecordSet;

    /**
     * Gets the value of the icmListaconfRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListaconfRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListaconfRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListaconfRecord }
     * 
     * 
     */
    public List<IcmListaconfRecord> getIcmListaconfRecordSet() {
        if (icmListaconfRecordSet == null) {
            icmListaconfRecordSet = new ArrayList<IcmListaconfRecord>();
        }
        return this.icmListaconfRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListaconfBlock that = ((IcmListaconfBlock) object);
        {
            List<IcmListaconfRecord> lhsIcmListaconfRecordSet;
            lhsIcmListaconfRecordSet = (((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty()))?this.getIcmListaconfRecordSet():null);
            List<IcmListaconfRecord> rhsIcmListaconfRecordSet;
            rhsIcmListaconfRecordSet = (((that.icmListaconfRecordSet!= null)&&(!that.icmListaconfRecordSet.isEmpty()))?that.getIcmListaconfRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfRecordSet", lhsIcmListaconfRecordSet), LocatorUtils.property(thatLocator, "icmListaconfRecordSet", rhsIcmListaconfRecordSet), lhsIcmListaconfRecordSet, rhsIcmListaconfRecordSet, ((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty())), ((that.icmListaconfRecordSet!= null)&&(!that.icmListaconfRecordSet.isEmpty())))) {
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
            List<IcmListaconfRecord> theIcmListaconfRecordSet;
            theIcmListaconfRecordSet = (((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty()))?this.getIcmListaconfRecordSet():null);
            strategy.appendField(locator, this, "icmListaconfRecordSet", buffer, theIcmListaconfRecordSet, ((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmListaconfRecord> theIcmListaconfRecordSet;
            theIcmListaconfRecordSet = (((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty()))?this.getIcmListaconfRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaconfRecordSet", theIcmListaconfRecordSet), currentHashCode, theIcmListaconfRecordSet, ((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListaconfBlock) {
            final IcmListaconfBlock copy = ((IcmListaconfBlock) draftCopy);
            {
                Boolean icmListaconfRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty())));
                if (icmListaconfRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListaconfRecord> sourceIcmListaconfRecordSet;
                    sourceIcmListaconfRecordSet = (((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty()))?this.getIcmListaconfRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListaconfRecord> copyIcmListaconfRecordSet = ((List<IcmListaconfRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListaconfRecordSet", sourceIcmListaconfRecordSet), sourceIcmListaconfRecordSet, ((this.icmListaconfRecordSet!= null)&&(!this.icmListaconfRecordSet.isEmpty()))));
                    copy.icmListaconfRecordSet = null;
                    if (copyIcmListaconfRecordSet!= null) {
                        List<IcmListaconfRecord> uniqueIcmListaconfRecordSetl = copy.getIcmListaconfRecordSet();
                        uniqueIcmListaconfRecordSetl.addAll(copyIcmListaconfRecordSet);
                    }
                } else {
                    if (icmListaconfRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconfRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListaconfBlock();
    }

}
