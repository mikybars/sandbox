
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
 * <p>Clase Java para Icm_ParamcalconfprevalidBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParamcalconfprevalidBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalconfprevalidRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalconfprevalidRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalconfprevalidBlock", propOrder = {
    "icmParamcalconfprevalidRecordSet"
})
public class IcmParamcalconfprevalidBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ParamcalconfprevalidRecordSet", nillable = true)
    protected List<IcmParamcalconfprevalidRecord> icmParamcalconfprevalidRecordSet;

    /**
     * Gets the value of the icmParamcalconfprevalidRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcalconfprevalidRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcalconfprevalidRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcalconfprevalidRecord }
     * 
     * 
     */
    public List<IcmParamcalconfprevalidRecord> getIcmParamcalconfprevalidRecordSet() {
        if (icmParamcalconfprevalidRecordSet == null) {
            icmParamcalconfprevalidRecordSet = new ArrayList<IcmParamcalconfprevalidRecord>();
        }
        return this.icmParamcalconfprevalidRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcalconfprevalidBlock that = ((IcmParamcalconfprevalidBlock) object);
        {
            List<IcmParamcalconfprevalidRecord> lhsIcmParamcalconfprevalidRecordSet;
            lhsIcmParamcalconfprevalidRecordSet = (((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty()))?this.getIcmParamcalconfprevalidRecordSet():null);
            List<IcmParamcalconfprevalidRecord> rhsIcmParamcalconfprevalidRecordSet;
            rhsIcmParamcalconfprevalidRecordSet = (((that.icmParamcalconfprevalidRecordSet!= null)&&(!that.icmParamcalconfprevalidRecordSet.isEmpty()))?that.getIcmParamcalconfprevalidRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalconfprevalidRecordSet", lhsIcmParamcalconfprevalidRecordSet), LocatorUtils.property(thatLocator, "icmParamcalconfprevalidRecordSet", rhsIcmParamcalconfprevalidRecordSet), lhsIcmParamcalconfprevalidRecordSet, rhsIcmParamcalconfprevalidRecordSet, ((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty())), ((that.icmParamcalconfprevalidRecordSet!= null)&&(!that.icmParamcalconfprevalidRecordSet.isEmpty())))) {
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
            List<IcmParamcalconfprevalidRecord> theIcmParamcalconfprevalidRecordSet;
            theIcmParamcalconfprevalidRecordSet = (((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty()))?this.getIcmParamcalconfprevalidRecordSet():null);
            strategy.appendField(locator, this, "icmParamcalconfprevalidRecordSet", buffer, theIcmParamcalconfprevalidRecordSet, ((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmParamcalconfprevalidRecord> theIcmParamcalconfprevalidRecordSet;
            theIcmParamcalconfprevalidRecordSet = (((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty()))?this.getIcmParamcalconfprevalidRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalconfprevalidRecordSet", theIcmParamcalconfprevalidRecordSet), currentHashCode, theIcmParamcalconfprevalidRecordSet, ((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcalconfprevalidBlock) {
            final IcmParamcalconfprevalidBlock copy = ((IcmParamcalconfprevalidBlock) draftCopy);
            {
                Boolean icmParamcalconfprevalidRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty())));
                if (icmParamcalconfprevalidRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcalconfprevalidRecord> sourceIcmParamcalconfprevalidRecordSet;
                    sourceIcmParamcalconfprevalidRecordSet = (((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty()))?this.getIcmParamcalconfprevalidRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcalconfprevalidRecord> copyIcmParamcalconfprevalidRecordSet = ((List<IcmParamcalconfprevalidRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcalconfprevalidRecordSet", sourceIcmParamcalconfprevalidRecordSet), sourceIcmParamcalconfprevalidRecordSet, ((this.icmParamcalconfprevalidRecordSet!= null)&&(!this.icmParamcalconfprevalidRecordSet.isEmpty()))));
                    copy.icmParamcalconfprevalidRecordSet = null;
                    if (copyIcmParamcalconfprevalidRecordSet!= null) {
                        List<IcmParamcalconfprevalidRecord> uniqueIcmParamcalconfprevalidRecordSetl = copy.getIcmParamcalconfprevalidRecordSet();
                        uniqueIcmParamcalconfprevalidRecordSetl.addAll(copyIcmParamcalconfprevalidRecordSet);
                    }
                } else {
                    if (icmParamcalconfprevalidRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalconfprevalidRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcalconfprevalidBlock();
    }

}
