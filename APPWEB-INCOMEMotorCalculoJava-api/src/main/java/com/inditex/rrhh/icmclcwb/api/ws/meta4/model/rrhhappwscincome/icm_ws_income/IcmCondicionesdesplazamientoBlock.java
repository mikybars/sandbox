
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
 * <p>Clase Java para Icm_CondicionesdesplazamientoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionesdesplazamientoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orcomision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idplantilla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_CondicionesdesplazamientoRecordSet" type="{http://schemas.meta4.com/}Icm_CondicionesdesplazamientoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionesdesplazamientoBlock", propOrder = {
    "orcomision",
    "idplantilla",
    "idestructura",
    "icmCondicionesdesplazamientoRecordSet"
})
public class IcmCondicionesdesplazamientoBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String orcomision;
    @XmlElement(required = true, nillable = true)
    protected String idplantilla;
    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_CondicionesdesplazamientoRecordSet", nillable = true)
    protected List<IcmCondicionesdesplazamientoRecord> icmCondicionesdesplazamientoRecordSet;

    /**
     * Obtiene el valor de la propiedad orcomision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrcomision() {
        return orcomision;
    }

    /**
     * Define el valor de la propiedad orcomision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrcomision(String value) {
        this.orcomision = value;
    }

    /**
     * Obtiene el valor de la propiedad idplantilla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdplantilla() {
        return idplantilla;
    }

    /**
     * Define el valor de la propiedad idplantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdplantilla(String value) {
        this.idplantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad idestructura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdestructura() {
        return idestructura;
    }

    /**
     * Define el valor de la propiedad idestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdestructura(String value) {
        this.idestructura = value;
    }

    /**
     * Gets the value of the icmCondicionesdesplazamientoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCondicionesdesplazamientoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCondicionesdesplazamientoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCondicionesdesplazamientoRecord }
     * 
     * 
     */
    public List<IcmCondicionesdesplazamientoRecord> getIcmCondicionesdesplazamientoRecordSet() {
        if (icmCondicionesdesplazamientoRecordSet == null) {
            icmCondicionesdesplazamientoRecordSet = new ArrayList<IcmCondicionesdesplazamientoRecord>();
        }
        return this.icmCondicionesdesplazamientoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmCondicionesdesplazamientoBlock that = ((IcmCondicionesdesplazamientoBlock) object);
        {
            String lhsOrcomision;
            lhsOrcomision = this.getOrcomision();
            String rhsOrcomision;
            rhsOrcomision = that.getOrcomision();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orcomision", lhsOrcomision), LocatorUtils.property(thatLocator, "orcomision", rhsOrcomision), lhsOrcomision, rhsOrcomision, (this.orcomision!= null), (that.orcomision!= null))) {
                return false;
            }
        }
        {
            String lhsIdplantilla;
            lhsIdplantilla = this.getIdplantilla();
            String rhsIdplantilla;
            rhsIdplantilla = that.getIdplantilla();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idplantilla", lhsIdplantilla), LocatorUtils.property(thatLocator, "idplantilla", rhsIdplantilla), lhsIdplantilla, rhsIdplantilla, (this.idplantilla!= null), (that.idplantilla!= null))) {
                return false;
            }
        }
        {
            String lhsIdestructura;
            lhsIdestructura = this.getIdestructura();
            String rhsIdestructura;
            rhsIdestructura = that.getIdestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestructura", lhsIdestructura), LocatorUtils.property(thatLocator, "idestructura", rhsIdestructura), lhsIdestructura, rhsIdestructura, (this.idestructura!= null), (that.idestructura!= null))) {
                return false;
            }
        }
        {
            List<IcmCondicionesdesplazamientoRecord> lhsIcmCondicionesdesplazamientoRecordSet;
            lhsIcmCondicionesdesplazamientoRecordSet = (((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty()))?this.getIcmCondicionesdesplazamientoRecordSet():null);
            List<IcmCondicionesdesplazamientoRecord> rhsIcmCondicionesdesplazamientoRecordSet;
            rhsIcmCondicionesdesplazamientoRecordSet = (((that.icmCondicionesdesplazamientoRecordSet!= null)&&(!that.icmCondicionesdesplazamientoRecordSet.isEmpty()))?that.getIcmCondicionesdesplazamientoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCondicionesdesplazamientoRecordSet", lhsIcmCondicionesdesplazamientoRecordSet), LocatorUtils.property(thatLocator, "icmCondicionesdesplazamientoRecordSet", rhsIcmCondicionesdesplazamientoRecordSet), lhsIcmCondicionesdesplazamientoRecordSet, rhsIcmCondicionesdesplazamientoRecordSet, ((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty())), ((that.icmCondicionesdesplazamientoRecordSet!= null)&&(!that.icmCondicionesdesplazamientoRecordSet.isEmpty())))) {
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
            String theOrcomision;
            theOrcomision = this.getOrcomision();
            strategy.appendField(locator, this, "orcomision", buffer, theOrcomision, (this.orcomision!= null));
        }
        {
            String theIdplantilla;
            theIdplantilla = this.getIdplantilla();
            strategy.appendField(locator, this, "idplantilla", buffer, theIdplantilla, (this.idplantilla!= null));
        }
        {
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            strategy.appendField(locator, this, "idestructura", buffer, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmCondicionesdesplazamientoRecord> theIcmCondicionesdesplazamientoRecordSet;
            theIcmCondicionesdesplazamientoRecordSet = (((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty()))?this.getIcmCondicionesdesplazamientoRecordSet():null);
            strategy.appendField(locator, this, "icmCondicionesdesplazamientoRecordSet", buffer, theIcmCondicionesdesplazamientoRecordSet, ((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theOrcomision;
            theOrcomision = this.getOrcomision();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orcomision", theOrcomision), currentHashCode, theOrcomision, (this.orcomision!= null));
        }
        {
            String theIdplantilla;
            theIdplantilla = this.getIdplantilla();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idplantilla", theIdplantilla), currentHashCode, theIdplantilla, (this.idplantilla!= null));
        }
        {
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructura", theIdestructura), currentHashCode, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmCondicionesdesplazamientoRecord> theIcmCondicionesdesplazamientoRecordSet;
            theIcmCondicionesdesplazamientoRecordSet = (((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty()))?this.getIcmCondicionesdesplazamientoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCondicionesdesplazamientoRecordSet", theIcmCondicionesdesplazamientoRecordSet), currentHashCode, theIcmCondicionesdesplazamientoRecordSet, ((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmCondicionesdesplazamientoBlock) {
            final IcmCondicionesdesplazamientoBlock copy = ((IcmCondicionesdesplazamientoBlock) draftCopy);
            {
                Boolean orcomisionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.orcomision!= null));
                if (orcomisionShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceOrcomision;
                    sourceOrcomision = this.getOrcomision();
                    String copyOrcomision = ((String) strategy.copy(LocatorUtils.property(locator, "orcomision", sourceOrcomision), sourceOrcomision, (this.orcomision!= null)));
                    copy.setOrcomision(copyOrcomision);
                } else {
                    if (orcomisionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.orcomision = null;
                    }
                }
            }
            {
                Boolean idplantillaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idplantilla!= null));
                if (idplantillaShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdplantilla;
                    sourceIdplantilla = this.getIdplantilla();
                    String copyIdplantilla = ((String) strategy.copy(LocatorUtils.property(locator, "idplantilla", sourceIdplantilla), sourceIdplantilla, (this.idplantilla!= null)));
                    copy.setIdplantilla(copyIdplantilla);
                } else {
                    if (idplantillaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idplantilla = null;
                    }
                }
            }
            {
                Boolean idestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestructura!= null));
                if (idestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestructura;
                    sourceIdestructura = this.getIdestructura();
                    String copyIdestructura = ((String) strategy.copy(LocatorUtils.property(locator, "idestructura", sourceIdestructura), sourceIdestructura, (this.idestructura!= null)));
                    copy.setIdestructura(copyIdestructura);
                } else {
                    if (idestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestructura = null;
                    }
                }
            }
            {
                Boolean icmCondicionesdesplazamientoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty())));
                if (icmCondicionesdesplazamientoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmCondicionesdesplazamientoRecord> sourceIcmCondicionesdesplazamientoRecordSet;
                    sourceIcmCondicionesdesplazamientoRecordSet = (((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty()))?this.getIcmCondicionesdesplazamientoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmCondicionesdesplazamientoRecord> copyIcmCondicionesdesplazamientoRecordSet = ((List<IcmCondicionesdesplazamientoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmCondicionesdesplazamientoRecordSet", sourceIcmCondicionesdesplazamientoRecordSet), sourceIcmCondicionesdesplazamientoRecordSet, ((this.icmCondicionesdesplazamientoRecordSet!= null)&&(!this.icmCondicionesdesplazamientoRecordSet.isEmpty()))));
                    copy.icmCondicionesdesplazamientoRecordSet = null;
                    if (copyIcmCondicionesdesplazamientoRecordSet!= null) {
                        List<IcmCondicionesdesplazamientoRecord> uniqueIcmCondicionesdesplazamientoRecordSetl = copy.getIcmCondicionesdesplazamientoRecordSet();
                        uniqueIcmCondicionesdesplazamientoRecordSetl.addAll(copyIcmCondicionesdesplazamientoRecordSet);
                    }
                } else {
                    if (icmCondicionesdesplazamientoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCondicionesdesplazamientoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmCondicionesdesplazamientoBlock();
    }

}
