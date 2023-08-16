
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
 * <p>Java class for Icm_ParamcalempleadosdesplazBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalempleadosdesplazBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalempleadosdesplazRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalempleadosdesplazRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalempleadosdesplazBlock", propOrder = {
    "icmParamcalempleadosdesplazRecordSet"
})
public class IcmParamcalempleadosdesplazBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ParamcalempleadosdesplazRecordSet", nillable = true)
    protected List<IcmParamcalempleadosdesplazRecord> icmParamcalempleadosdesplazRecordSet;

    /**
     * Gets the value of the icmParamcalempleadosdesplazRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcalempleadosdesplazRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcalempleadosdesplazRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcalempleadosdesplazRecord }
     *
     *
     */
    public List<IcmParamcalempleadosdesplazRecord> getIcmParamcalempleadosdesplazRecordSet() {
        if (icmParamcalempleadosdesplazRecordSet == null) {
            icmParamcalempleadosdesplazRecordSet = new ArrayList<IcmParamcalempleadosdesplazRecord>();
        }
        return this.icmParamcalempleadosdesplazRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcalempleadosdesplazBlock that = ((IcmParamcalempleadosdesplazBlock) object);
        {
            List<IcmParamcalempleadosdesplazRecord> lhsIcmParamcalempleadosdesplazRecordSet;
            lhsIcmParamcalempleadosdesplazRecordSet = (((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty()))?this.getIcmParamcalempleadosdesplazRecordSet():null);
            List<IcmParamcalempleadosdesplazRecord> rhsIcmParamcalempleadosdesplazRecordSet;
            rhsIcmParamcalempleadosdesplazRecordSet = (((that.icmParamcalempleadosdesplazRecordSet!= null)&&(!that.icmParamcalempleadosdesplazRecordSet.isEmpty()))?that.getIcmParamcalempleadosdesplazRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalempleadosdesplazRecordSet", lhsIcmParamcalempleadosdesplazRecordSet), LocatorUtils.property(thatLocator, "icmParamcalempleadosdesplazRecordSet", rhsIcmParamcalempleadosdesplazRecordSet), lhsIcmParamcalempleadosdesplazRecordSet, rhsIcmParamcalempleadosdesplazRecordSet, ((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty())), ((that.icmParamcalempleadosdesplazRecordSet!= null)&&(!that.icmParamcalempleadosdesplazRecordSet.isEmpty())))) {
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
            List<IcmParamcalempleadosdesplazRecord> theIcmParamcalempleadosdesplazRecordSet;
            theIcmParamcalempleadosdesplazRecordSet = (((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty()))?this.getIcmParamcalempleadosdesplazRecordSet():null);
            strategy.appendField(locator, this, "icmParamcalempleadosdesplazRecordSet", buffer, theIcmParamcalempleadosdesplazRecordSet, ((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmParamcalempleadosdesplazRecord> theIcmParamcalempleadosdesplazRecordSet;
            theIcmParamcalempleadosdesplazRecordSet = (((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty()))?this.getIcmParamcalempleadosdesplazRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalempleadosdesplazRecordSet", theIcmParamcalempleadosdesplazRecordSet), currentHashCode, theIcmParamcalempleadosdesplazRecordSet, ((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcalempleadosdesplazBlock) {
            final IcmParamcalempleadosdesplazBlock copy = ((IcmParamcalempleadosdesplazBlock) draftCopy);
            {
                Boolean icmParamcalempleadosdesplazRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty())));
                if (icmParamcalempleadosdesplazRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcalempleadosdesplazRecord> sourceIcmParamcalempleadosdesplazRecordSet;
                    sourceIcmParamcalempleadosdesplazRecordSet = (((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty()))?this.getIcmParamcalempleadosdesplazRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcalempleadosdesplazRecord> copyIcmParamcalempleadosdesplazRecordSet = ((List<IcmParamcalempleadosdesplazRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcalempleadosdesplazRecordSet", sourceIcmParamcalempleadosdesplazRecordSet), sourceIcmParamcalempleadosdesplazRecordSet, ((this.icmParamcalempleadosdesplazRecordSet!= null)&&(!this.icmParamcalempleadosdesplazRecordSet.isEmpty()))));
                    copy.icmParamcalempleadosdesplazRecordSet = null;
                    if (copyIcmParamcalempleadosdesplazRecordSet!= null) {
                        List<IcmParamcalempleadosdesplazRecord> uniqueIcmParamcalempleadosdesplazRecordSetl = copy.getIcmParamcalempleadosdesplazRecordSet();
                        uniqueIcmParamcalempleadosdesplazRecordSetl.addAll(copyIcmParamcalempleadosdesplazRecordSet);
                    }
                } else {
                    if (icmParamcalempleadosdesplazRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalempleadosdesplazRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcalempleadosdesplazBlock();
    }

}
