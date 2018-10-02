
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
 * <p>Clase Java para Icm_GlobaltiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_GlobaltiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sys_Param_A" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sys_Sentence_A" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_GlobaltiendaRecordSet" type="{http://schemas.meta4.com/}Icm_GlobaltiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_GlobaltiendaBlock", propOrder = {
    "sysParamA",
    "sysSentenceA",
    "icmGlobaltiendaRecordSet"
})
public class IcmGlobaltiendaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "sys_Param_A", required = true, nillable = true)
    protected String sysParamA;
    @XmlElement(name = "sys_Sentence_A", required = true, nillable = true)
    protected String sysSentenceA;
    @XmlElement(name = "Icm_GlobaltiendaRecordSet", nillable = true)
    protected List<IcmGlobaltiendaRecord> icmGlobaltiendaRecordSet;

    /**
     * Obtiene el valor de la propiedad sysParamA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysParamA() {
        return sysParamA;
    }

    /**
     * Define el valor de la propiedad sysParamA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysParamA(String value) {
        this.sysParamA = value;
    }

    /**
     * Obtiene el valor de la propiedad sysSentenceA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysSentenceA() {
        return sysSentenceA;
    }

    /**
     * Define el valor de la propiedad sysSentenceA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysSentenceA(String value) {
        this.sysSentenceA = value;
    }

    /**
     * Gets the value of the icmGlobaltiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmGlobaltiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmGlobaltiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmGlobaltiendaRecord }
     * 
     * 
     */
    public List<IcmGlobaltiendaRecord> getIcmGlobaltiendaRecordSet() {
        if (icmGlobaltiendaRecordSet == null) {
            icmGlobaltiendaRecordSet = new ArrayList<IcmGlobaltiendaRecord>();
        }
        return this.icmGlobaltiendaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmGlobaltiendaBlock that = ((IcmGlobaltiendaBlock) object);
        {
            String lhsSysParamA;
            lhsSysParamA = this.getSysParamA();
            String rhsSysParamA;
            rhsSysParamA = that.getSysParamA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sysParamA", lhsSysParamA), LocatorUtils.property(thatLocator, "sysParamA", rhsSysParamA), lhsSysParamA, rhsSysParamA, (this.sysParamA!= null), (that.sysParamA!= null))) {
                return false;
            }
        }
        {
            String lhsSysSentenceA;
            lhsSysSentenceA = this.getSysSentenceA();
            String rhsSysSentenceA;
            rhsSysSentenceA = that.getSysSentenceA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sysSentenceA", lhsSysSentenceA), LocatorUtils.property(thatLocator, "sysSentenceA", rhsSysSentenceA), lhsSysSentenceA, rhsSysSentenceA, (this.sysSentenceA!= null), (that.sysSentenceA!= null))) {
                return false;
            }
        }
        {
            List<IcmGlobaltiendaRecord> lhsIcmGlobaltiendaRecordSet;
            lhsIcmGlobaltiendaRecordSet = (((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty()))?this.getIcmGlobaltiendaRecordSet():null);
            List<IcmGlobaltiendaRecord> rhsIcmGlobaltiendaRecordSet;
            rhsIcmGlobaltiendaRecordSet = (((that.icmGlobaltiendaRecordSet!= null)&&(!that.icmGlobaltiendaRecordSet.isEmpty()))?that.getIcmGlobaltiendaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmGlobaltiendaRecordSet", lhsIcmGlobaltiendaRecordSet), LocatorUtils.property(thatLocator, "icmGlobaltiendaRecordSet", rhsIcmGlobaltiendaRecordSet), lhsIcmGlobaltiendaRecordSet, rhsIcmGlobaltiendaRecordSet, ((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty())), ((that.icmGlobaltiendaRecordSet!= null)&&(!that.icmGlobaltiendaRecordSet.isEmpty())))) {
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
            String theSysParamA;
            theSysParamA = this.getSysParamA();
            strategy.appendField(locator, this, "sysParamA", buffer, theSysParamA, (this.sysParamA!= null));
        }
        {
            String theSysSentenceA;
            theSysSentenceA = this.getSysSentenceA();
            strategy.appendField(locator, this, "sysSentenceA", buffer, theSysSentenceA, (this.sysSentenceA!= null));
        }
        {
            List<IcmGlobaltiendaRecord> theIcmGlobaltiendaRecordSet;
            theIcmGlobaltiendaRecordSet = (((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty()))?this.getIcmGlobaltiendaRecordSet():null);
            strategy.appendField(locator, this, "icmGlobaltiendaRecordSet", buffer, theIcmGlobaltiendaRecordSet, ((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theSysParamA;
            theSysParamA = this.getSysParamA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sysParamA", theSysParamA), currentHashCode, theSysParamA, (this.sysParamA!= null));
        }
        {
            String theSysSentenceA;
            theSysSentenceA = this.getSysSentenceA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sysSentenceA", theSysSentenceA), currentHashCode, theSysSentenceA, (this.sysSentenceA!= null));
        }
        {
            List<IcmGlobaltiendaRecord> theIcmGlobaltiendaRecordSet;
            theIcmGlobaltiendaRecordSet = (((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty()))?this.getIcmGlobaltiendaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmGlobaltiendaRecordSet", theIcmGlobaltiendaRecordSet), currentHashCode, theIcmGlobaltiendaRecordSet, ((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmGlobaltiendaBlock) {
            final IcmGlobaltiendaBlock copy = ((IcmGlobaltiendaBlock) draftCopy);
            {
                Boolean sysParamAShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.sysParamA!= null));
                if (sysParamAShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceSysParamA;
                    sourceSysParamA = this.getSysParamA();
                    String copySysParamA = ((String) strategy.copy(LocatorUtils.property(locator, "sysParamA", sourceSysParamA), sourceSysParamA, (this.sysParamA!= null)));
                    copy.setSysParamA(copySysParamA);
                } else {
                    if (sysParamAShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.sysParamA = null;
                    }
                }
            }
            {
                Boolean sysSentenceAShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.sysSentenceA!= null));
                if (sysSentenceAShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceSysSentenceA;
                    sourceSysSentenceA = this.getSysSentenceA();
                    String copySysSentenceA = ((String) strategy.copy(LocatorUtils.property(locator, "sysSentenceA", sourceSysSentenceA), sourceSysSentenceA, (this.sysSentenceA!= null)));
                    copy.setSysSentenceA(copySysSentenceA);
                } else {
                    if (sysSentenceAShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.sysSentenceA = null;
                    }
                }
            }
            {
                Boolean icmGlobaltiendaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty())));
                if (icmGlobaltiendaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmGlobaltiendaRecord> sourceIcmGlobaltiendaRecordSet;
                    sourceIcmGlobaltiendaRecordSet = (((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty()))?this.getIcmGlobaltiendaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmGlobaltiendaRecord> copyIcmGlobaltiendaRecordSet = ((List<IcmGlobaltiendaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmGlobaltiendaRecordSet", sourceIcmGlobaltiendaRecordSet), sourceIcmGlobaltiendaRecordSet, ((this.icmGlobaltiendaRecordSet!= null)&&(!this.icmGlobaltiendaRecordSet.isEmpty()))));
                    copy.icmGlobaltiendaRecordSet = null;
                    if (copyIcmGlobaltiendaRecordSet!= null) {
                        List<IcmGlobaltiendaRecord> uniqueIcmGlobaltiendaRecordSetl = copy.getIcmGlobaltiendaRecordSet();
                        uniqueIcmGlobaltiendaRecordSetl.addAll(copyIcmGlobaltiendaRecordSet);
                    }
                } else {
                    if (icmGlobaltiendaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmGlobaltiendaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmGlobaltiendaBlock();
    }

}
