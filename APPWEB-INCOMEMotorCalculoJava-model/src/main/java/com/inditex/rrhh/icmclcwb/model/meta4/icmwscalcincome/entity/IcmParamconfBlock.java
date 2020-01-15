
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
 * <p>Clase Java para Icm_ParamconfBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParamconfBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idorigen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParamconfRecordSet" type="{http://schemas.meta4.com/}Icm_ParamconfRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamconfBlock", propOrder = {
    "idorigen",
    "icmParamconfRecordSet"
})
public class IcmParamconfBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idorigen;
    @XmlElement(name = "Icm_ParamconfRecordSet", nillable = true)
    protected List<IcmParamconfRecord> icmParamconfRecordSet;

    /**
     * Obtiene el valor de la propiedad idorigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdorigen() {
        return idorigen;
    }

    /**
     * Define el valor de la propiedad idorigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdorigen(String value) {
        this.idorigen = value;
    }

    /**
     * Gets the value of the icmParamconfRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamconfRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamconfRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamconfRecord }
     * 
     * 
     */
    public List<IcmParamconfRecord> getIcmParamconfRecordSet() {
        if (icmParamconfRecordSet == null) {
            icmParamconfRecordSet = new ArrayList<IcmParamconfRecord>();
        }
        return this.icmParamconfRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamconfBlock that = ((IcmParamconfBlock) object);
        {
            String lhsIdorigen;
            lhsIdorigen = this.getIdorigen();
            String rhsIdorigen;
            rhsIdorigen = that.getIdorigen();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idorigen", lhsIdorigen), LocatorUtils.property(thatLocator, "idorigen", rhsIdorigen), lhsIdorigen, rhsIdorigen, (this.idorigen!= null), (that.idorigen!= null))) {
                return false;
            }
        }
        {
            List<IcmParamconfRecord> lhsIcmParamconfRecordSet;
            lhsIcmParamconfRecordSet = (((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty()))?this.getIcmParamconfRecordSet():null);
            List<IcmParamconfRecord> rhsIcmParamconfRecordSet;
            rhsIcmParamconfRecordSet = (((that.icmParamconfRecordSet!= null)&&(!that.icmParamconfRecordSet.isEmpty()))?that.getIcmParamconfRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamconfRecordSet", lhsIcmParamconfRecordSet), LocatorUtils.property(thatLocator, "icmParamconfRecordSet", rhsIcmParamconfRecordSet), lhsIcmParamconfRecordSet, rhsIcmParamconfRecordSet, ((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty())), ((that.icmParamconfRecordSet!= null)&&(!that.icmParamconfRecordSet.isEmpty())))) {
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
            String theIdorigen;
            theIdorigen = this.getIdorigen();
            strategy.appendField(locator, this, "idorigen", buffer, theIdorigen, (this.idorigen!= null));
        }
        {
            List<IcmParamconfRecord> theIcmParamconfRecordSet;
            theIcmParamconfRecordSet = (((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty()))?this.getIcmParamconfRecordSet():null);
            strategy.appendField(locator, this, "icmParamconfRecordSet", buffer, theIcmParamconfRecordSet, ((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdorigen;
            theIdorigen = this.getIdorigen();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idorigen", theIdorigen), currentHashCode, theIdorigen, (this.idorigen!= null));
        }
        {
            List<IcmParamconfRecord> theIcmParamconfRecordSet;
            theIcmParamconfRecordSet = (((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty()))?this.getIcmParamconfRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamconfRecordSet", theIcmParamconfRecordSet), currentHashCode, theIcmParamconfRecordSet, ((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamconfBlock) {
            final IcmParamconfBlock copy = ((IcmParamconfBlock) draftCopy);
            {
                Boolean idorigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idorigen!= null));
                if (idorigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdorigen;
                    sourceIdorigen = this.getIdorigen();
                    String copyIdorigen = ((String) strategy.copy(LocatorUtils.property(locator, "idorigen", sourceIdorigen), sourceIdorigen, (this.idorigen!= null)));
                    copy.setIdorigen(copyIdorigen);
                } else {
                    if (idorigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idorigen = null;
                    }
                }
            }
            {
                Boolean icmParamconfRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty())));
                if (icmParamconfRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamconfRecord> sourceIcmParamconfRecordSet;
                    sourceIcmParamconfRecordSet = (((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty()))?this.getIcmParamconfRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamconfRecord> copyIcmParamconfRecordSet = ((List<IcmParamconfRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamconfRecordSet", sourceIcmParamconfRecordSet), sourceIcmParamconfRecordSet, ((this.icmParamconfRecordSet!= null)&&(!this.icmParamconfRecordSet.isEmpty()))));
                    copy.icmParamconfRecordSet = null;
                    if (copyIcmParamconfRecordSet!= null) {
                        List<IcmParamconfRecord> uniqueIcmParamconfRecordSetl = copy.getIcmParamconfRecordSet();
                        uniqueIcmParamconfRecordSetl.addAll(copyIcmParamconfRecordSet);
                    }
                } else {
                    if (icmParamconfRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamconfRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamconfBlock();
    }

}
