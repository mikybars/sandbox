
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
 * <p>Clase Java para Icm_ParamcalusuarioBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalusuarioBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalusuarioRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalusuarioRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalusuarioBlock", propOrder = {
    "icmParamcalusuarioRecordSet"
})
public class IcmParamcalusuarioBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ParamcalusuarioRecordSet", nillable = true)
    protected List<IcmParamcalusuarioRecord> icmParamcalusuarioRecordSet;

    /**
     * Gets the value of the icmParamcalusuarioRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcalusuarioRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcalusuarioRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcalusuarioRecord }
     *
     *
     */
    public List<IcmParamcalusuarioRecord> getIcmParamcalusuarioRecordSet() {
        if (icmParamcalusuarioRecordSet == null) {
            icmParamcalusuarioRecordSet = new ArrayList<IcmParamcalusuarioRecord>();
        }
        return this.icmParamcalusuarioRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcalusuarioBlock that = ((IcmParamcalusuarioBlock) object);
        {
            List<IcmParamcalusuarioRecord> lhsIcmParamcalusuarioRecordSet;
            lhsIcmParamcalusuarioRecordSet = (((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty()))?this.getIcmParamcalusuarioRecordSet():null);
            List<IcmParamcalusuarioRecord> rhsIcmParamcalusuarioRecordSet;
            rhsIcmParamcalusuarioRecordSet = (((that.icmParamcalusuarioRecordSet!= null)&&(!that.icmParamcalusuarioRecordSet.isEmpty()))?that.getIcmParamcalusuarioRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalusuarioRecordSet", lhsIcmParamcalusuarioRecordSet), LocatorUtils.property(thatLocator, "icmParamcalusuarioRecordSet", rhsIcmParamcalusuarioRecordSet), lhsIcmParamcalusuarioRecordSet, rhsIcmParamcalusuarioRecordSet, ((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty())), ((that.icmParamcalusuarioRecordSet!= null)&&(!that.icmParamcalusuarioRecordSet.isEmpty())))) {
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
            List<IcmParamcalusuarioRecord> theIcmParamcalusuarioRecordSet;
            theIcmParamcalusuarioRecordSet = (((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty()))?this.getIcmParamcalusuarioRecordSet():null);
            strategy.appendField(locator, this, "icmParamcalusuarioRecordSet", buffer, theIcmParamcalusuarioRecordSet, ((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmParamcalusuarioRecord> theIcmParamcalusuarioRecordSet;
            theIcmParamcalusuarioRecordSet = (((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty()))?this.getIcmParamcalusuarioRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalusuarioRecordSet", theIcmParamcalusuarioRecordSet), currentHashCode, theIcmParamcalusuarioRecordSet, ((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcalusuarioBlock) {
            final IcmParamcalusuarioBlock copy = ((IcmParamcalusuarioBlock) draftCopy);
            {
                Boolean icmParamcalusuarioRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty())));
                if (icmParamcalusuarioRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcalusuarioRecord> sourceIcmParamcalusuarioRecordSet;
                    sourceIcmParamcalusuarioRecordSet = (((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty()))?this.getIcmParamcalusuarioRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcalusuarioRecord> copyIcmParamcalusuarioRecordSet = ((List<IcmParamcalusuarioRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcalusuarioRecordSet", sourceIcmParamcalusuarioRecordSet), sourceIcmParamcalusuarioRecordSet, ((this.icmParamcalusuarioRecordSet!= null)&&(!this.icmParamcalusuarioRecordSet.isEmpty()))));
                    copy.icmParamcalusuarioRecordSet = null;
                    if (copyIcmParamcalusuarioRecordSet!= null) {
                        List<IcmParamcalusuarioRecord> uniqueIcmParamcalusuarioRecordSetl = copy.getIcmParamcalusuarioRecordSet();
                        uniqueIcmParamcalusuarioRecordSetl.addAll(copyIcmParamcalusuarioRecordSet);
                    }
                } else {
                    if (icmParamcalusuarioRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalusuarioRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcalusuarioBlock();
    }

}
