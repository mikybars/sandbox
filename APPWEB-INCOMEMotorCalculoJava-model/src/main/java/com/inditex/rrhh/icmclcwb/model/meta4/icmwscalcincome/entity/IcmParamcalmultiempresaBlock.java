
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
 * <p>Clase Java para Icm_ParamcalmultiempresaBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalmultiempresaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalmultiempresaRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalmultiempresaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalmultiempresaBlock", propOrder = {
    "icmParamcalmultiempresaRecordSet"
})
public class IcmParamcalmultiempresaBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ParamcalmultiempresaRecordSet", nillable = true)
    protected List<IcmParamcalmultiempresaRecord> icmParamcalmultiempresaRecordSet;

    /**
     * Gets the value of the icmParamcalmultiempresaRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcalmultiempresaRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcalmultiempresaRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcalmultiempresaRecord }
     *
     *
     */
    public List<IcmParamcalmultiempresaRecord> getIcmParamcalmultiempresaRecordSet() {
        if (icmParamcalmultiempresaRecordSet == null) {
            icmParamcalmultiempresaRecordSet = new ArrayList<IcmParamcalmultiempresaRecord>();
        }
        return this.icmParamcalmultiempresaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcalmultiempresaBlock that = ((IcmParamcalmultiempresaBlock) object);
        {
            List<IcmParamcalmultiempresaRecord> lhsIcmParamcalmultiempresaRecordSet;
            lhsIcmParamcalmultiempresaRecordSet = (((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty()))?this.getIcmParamcalmultiempresaRecordSet():null);
            List<IcmParamcalmultiempresaRecord> rhsIcmParamcalmultiempresaRecordSet;
            rhsIcmParamcalmultiempresaRecordSet = (((that.icmParamcalmultiempresaRecordSet!= null)&&(!that.icmParamcalmultiempresaRecordSet.isEmpty()))?that.getIcmParamcalmultiempresaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalmultiempresaRecordSet", lhsIcmParamcalmultiempresaRecordSet), LocatorUtils.property(thatLocator, "icmParamcalmultiempresaRecordSet", rhsIcmParamcalmultiempresaRecordSet), lhsIcmParamcalmultiempresaRecordSet, rhsIcmParamcalmultiempresaRecordSet, ((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty())), ((that.icmParamcalmultiempresaRecordSet!= null)&&(!that.icmParamcalmultiempresaRecordSet.isEmpty())))) {
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
            List<IcmParamcalmultiempresaRecord> theIcmParamcalmultiempresaRecordSet;
            theIcmParamcalmultiempresaRecordSet = (((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty()))?this.getIcmParamcalmultiempresaRecordSet():null);
            strategy.appendField(locator, this, "icmParamcalmultiempresaRecordSet", buffer, theIcmParamcalmultiempresaRecordSet, ((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmParamcalmultiempresaRecord> theIcmParamcalmultiempresaRecordSet;
            theIcmParamcalmultiempresaRecordSet = (((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty()))?this.getIcmParamcalmultiempresaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalmultiempresaRecordSet", theIcmParamcalmultiempresaRecordSet), currentHashCode, theIcmParamcalmultiempresaRecordSet, ((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcalmultiempresaBlock) {
            final IcmParamcalmultiempresaBlock copy = ((IcmParamcalmultiempresaBlock) draftCopy);
            {
                Boolean icmParamcalmultiempresaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty())));
                if (icmParamcalmultiempresaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcalmultiempresaRecord> sourceIcmParamcalmultiempresaRecordSet;
                    sourceIcmParamcalmultiempresaRecordSet = (((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty()))?this.getIcmParamcalmultiempresaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcalmultiempresaRecord> copyIcmParamcalmultiempresaRecordSet = ((List<IcmParamcalmultiempresaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcalmultiempresaRecordSet", sourceIcmParamcalmultiempresaRecordSet), sourceIcmParamcalmultiempresaRecordSet, ((this.icmParamcalmultiempresaRecordSet!= null)&&(!this.icmParamcalmultiempresaRecordSet.isEmpty()))));
                    copy.icmParamcalmultiempresaRecordSet = null;
                    if (copyIcmParamcalmultiempresaRecordSet!= null) {
                        List<IcmParamcalmultiempresaRecord> uniqueIcmParamcalmultiempresaRecordSetl = copy.getIcmParamcalmultiempresaRecordSet();
                        uniqueIcmParamcalmultiempresaRecordSetl.addAll(copyIcmParamcalmultiempresaRecordSet);
                    }
                } else {
                    if (icmParamcalmultiempresaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalmultiempresaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcalmultiempresaBlock();
    }

}
