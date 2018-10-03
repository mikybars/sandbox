
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

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
 * <p>Clase Java para Icm_Ws_OperacionesBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_Ws_OperacionesBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_Ws_OperacionesRecordSet" type="{http://schemas.meta4.com/}Icm_Ws_OperacionesRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_Ws_OperacionesBlock", propOrder = {
    "icmWsOperacionesRecordSet"
})
public class IcmWsOperacionesBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_Ws_OperacionesRecordSet", nillable = true)
    protected List<IcmWsOperacionesRecord> icmWsOperacionesRecordSet;

    /**
     * Gets the value of the icmWsOperacionesRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmWsOperacionesRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmWsOperacionesRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmWsOperacionesRecord }
     * 
     * 
     */
    public List<IcmWsOperacionesRecord> getIcmWsOperacionesRecordSet() {
        if (icmWsOperacionesRecordSet == null) {
            icmWsOperacionesRecordSet = new ArrayList<IcmWsOperacionesRecord>();
        }
        return this.icmWsOperacionesRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmWsOperacionesBlock that = ((IcmWsOperacionesBlock) object);
        {
            List<IcmWsOperacionesRecord> lhsIcmWsOperacionesRecordSet;
            lhsIcmWsOperacionesRecordSet = (((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty()))?this.getIcmWsOperacionesRecordSet():null);
            List<IcmWsOperacionesRecord> rhsIcmWsOperacionesRecordSet;
            rhsIcmWsOperacionesRecordSet = (((that.icmWsOperacionesRecordSet!= null)&&(!that.icmWsOperacionesRecordSet.isEmpty()))?that.getIcmWsOperacionesRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsOperacionesRecordSet", lhsIcmWsOperacionesRecordSet), LocatorUtils.property(thatLocator, "icmWsOperacionesRecordSet", rhsIcmWsOperacionesRecordSet), lhsIcmWsOperacionesRecordSet, rhsIcmWsOperacionesRecordSet, ((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty())), ((that.icmWsOperacionesRecordSet!= null)&&(!that.icmWsOperacionesRecordSet.isEmpty())))) {
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
            List<IcmWsOperacionesRecord> theIcmWsOperacionesRecordSet;
            theIcmWsOperacionesRecordSet = (((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty()))?this.getIcmWsOperacionesRecordSet():null);
            strategy.appendField(locator, this, "icmWsOperacionesRecordSet", buffer, theIcmWsOperacionesRecordSet, ((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmWsOperacionesRecord> theIcmWsOperacionesRecordSet;
            theIcmWsOperacionesRecordSet = (((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty()))?this.getIcmWsOperacionesRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsOperacionesRecordSet", theIcmWsOperacionesRecordSet), currentHashCode, theIcmWsOperacionesRecordSet, ((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmWsOperacionesBlock) {
            final IcmWsOperacionesBlock copy = ((IcmWsOperacionesBlock) draftCopy);
            {
                Boolean icmWsOperacionesRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty())));
                if (icmWsOperacionesRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmWsOperacionesRecord> sourceIcmWsOperacionesRecordSet;
                    sourceIcmWsOperacionesRecordSet = (((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty()))?this.getIcmWsOperacionesRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmWsOperacionesRecord> copyIcmWsOperacionesRecordSet = ((List<IcmWsOperacionesRecord> ) strategy.copy(LocatorUtils.property(locator, "icmWsOperacionesRecordSet", sourceIcmWsOperacionesRecordSet), sourceIcmWsOperacionesRecordSet, ((this.icmWsOperacionesRecordSet!= null)&&(!this.icmWsOperacionesRecordSet.isEmpty()))));
                    copy.icmWsOperacionesRecordSet = null;
                    if (copyIcmWsOperacionesRecordSet!= null) {
                        List<IcmWsOperacionesRecord> uniqueIcmWsOperacionesRecordSetl = copy.getIcmWsOperacionesRecordSet();
                        uniqueIcmWsOperacionesRecordSetl.addAll(copyIcmWsOperacionesRecordSet);
                    }
                } else {
                    if (icmWsOperacionesRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmWsOperacionesRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmWsOperacionesBlock();
    }

}
