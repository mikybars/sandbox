
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity;

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
 * <p>Clase Java para Icm_ParametrosplantillaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrosplantillaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipocondicion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tiposplantillas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subtipocondicion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrosplantillaRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrosplantillaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrosplantillaBlock", propOrder = {
    "idestructura",
    "tipocondicion",
    "tiposplantillas",
    "subtipocondicion",
    "icmParametrosplantillaRecordSet"
})
public class IcmParametrosplantillaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(required = true, nillable = true)
    protected String tipocondicion;
    @XmlElement(required = true, nillable = true)
    protected String tiposplantillas;
    @XmlElement(required = true, nillable = true)
    protected String subtipocondicion;
    @XmlElement(name = "Icm_ParametrosplantillaRecordSet", nillable = true)
    protected List<IcmParametrosplantillaRecord> icmParametrosplantillaRecordSet;

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
     * Obtiene el valor de la propiedad tipocondicion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipocondicion() {
        return tipocondicion;
    }

    /**
     * Define el valor de la propiedad tipocondicion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipocondicion(String value) {
        this.tipocondicion = value;
    }

    /**
     * Obtiene el valor de la propiedad tiposplantillas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTiposplantillas() {
        return tiposplantillas;
    }

    /**
     * Define el valor de la propiedad tiposplantillas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTiposplantillas(String value) {
        this.tiposplantillas = value;
    }

    /**
     * Obtiene el valor de la propiedad subtipocondicion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtipocondicion() {
        return subtipocondicion;
    }

    /**
     * Define el valor de la propiedad subtipocondicion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtipocondicion(String value) {
        this.subtipocondicion = value;
    }

    /**
     * Gets the value of the icmParametrosplantillaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParametrosplantillaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParametrosplantillaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParametrosplantillaRecord }
     * 
     * 
     */
    public List<IcmParametrosplantillaRecord> getIcmParametrosplantillaRecordSet() {
        if (icmParametrosplantillaRecordSet == null) {
            icmParametrosplantillaRecordSet = new ArrayList<IcmParametrosplantillaRecord>();
        }
        return this.icmParametrosplantillaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParametrosplantillaBlock that = ((IcmParametrosplantillaBlock) object);
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
            String lhsTipocondicion;
            lhsTipocondicion = this.getTipocondicion();
            String rhsTipocondicion;
            rhsTipocondicion = that.getTipocondicion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tipocondicion", lhsTipocondicion), LocatorUtils.property(thatLocator, "tipocondicion", rhsTipocondicion), lhsTipocondicion, rhsTipocondicion, (this.tipocondicion!= null), (that.tipocondicion!= null))) {
                return false;
            }
        }
        {
            String lhsTiposplantillas;
            lhsTiposplantillas = this.getTiposplantillas();
            String rhsTiposplantillas;
            rhsTiposplantillas = that.getTiposplantillas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tiposplantillas", lhsTiposplantillas), LocatorUtils.property(thatLocator, "tiposplantillas", rhsTiposplantillas), lhsTiposplantillas, rhsTiposplantillas, (this.tiposplantillas!= null), (that.tiposplantillas!= null))) {
                return false;
            }
        }
        {
            String lhsSubtipocondicion;
            lhsSubtipocondicion = this.getSubtipocondicion();
            String rhsSubtipocondicion;
            rhsSubtipocondicion = that.getSubtipocondicion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "subtipocondicion", lhsSubtipocondicion), LocatorUtils.property(thatLocator, "subtipocondicion", rhsSubtipocondicion), lhsSubtipocondicion, rhsSubtipocondicion, (this.subtipocondicion!= null), (that.subtipocondicion!= null))) {
                return false;
            }
        }
        {
            List<IcmParametrosplantillaRecord> lhsIcmParametrosplantillaRecordSet;
            lhsIcmParametrosplantillaRecordSet = (((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty()))?this.getIcmParametrosplantillaRecordSet():null);
            List<IcmParametrosplantillaRecord> rhsIcmParametrosplantillaRecordSet;
            rhsIcmParametrosplantillaRecordSet = (((that.icmParametrosplantillaRecordSet!= null)&&(!that.icmParametrosplantillaRecordSet.isEmpty()))?that.getIcmParametrosplantillaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosplantillaRecordSet", lhsIcmParametrosplantillaRecordSet), LocatorUtils.property(thatLocator, "icmParametrosplantillaRecordSet", rhsIcmParametrosplantillaRecordSet), lhsIcmParametrosplantillaRecordSet, rhsIcmParametrosplantillaRecordSet, ((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty())), ((that.icmParametrosplantillaRecordSet!= null)&&(!that.icmParametrosplantillaRecordSet.isEmpty())))) {
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
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            strategy.appendField(locator, this, "idestructura", buffer, theIdestructura, (this.idestructura!= null));
        }
        {
            String theTipocondicion;
            theTipocondicion = this.getTipocondicion();
            strategy.appendField(locator, this, "tipocondicion", buffer, theTipocondicion, (this.tipocondicion!= null));
        }
        {
            String theTiposplantillas;
            theTiposplantillas = this.getTiposplantillas();
            strategy.appendField(locator, this, "tiposplantillas", buffer, theTiposplantillas, (this.tiposplantillas!= null));
        }
        {
            String theSubtipocondicion;
            theSubtipocondicion = this.getSubtipocondicion();
            strategy.appendField(locator, this, "subtipocondicion", buffer, theSubtipocondicion, (this.subtipocondicion!= null));
        }
        {
            List<IcmParametrosplantillaRecord> theIcmParametrosplantillaRecordSet;
            theIcmParametrosplantillaRecordSet = (((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty()))?this.getIcmParametrosplantillaRecordSet():null);
            strategy.appendField(locator, this, "icmParametrosplantillaRecordSet", buffer, theIcmParametrosplantillaRecordSet, ((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructura", theIdestructura), currentHashCode, theIdestructura, (this.idestructura!= null));
        }
        {
            String theTipocondicion;
            theTipocondicion = this.getTipocondicion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tipocondicion", theTipocondicion), currentHashCode, theTipocondicion, (this.tipocondicion!= null));
        }
        {
            String theTiposplantillas;
            theTiposplantillas = this.getTiposplantillas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tiposplantillas", theTiposplantillas), currentHashCode, theTiposplantillas, (this.tiposplantillas!= null));
        }
        {
            String theSubtipocondicion;
            theSubtipocondicion = this.getSubtipocondicion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "subtipocondicion", theSubtipocondicion), currentHashCode, theSubtipocondicion, (this.subtipocondicion!= null));
        }
        {
            List<IcmParametrosplantillaRecord> theIcmParametrosplantillaRecordSet;
            theIcmParametrosplantillaRecordSet = (((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty()))?this.getIcmParametrosplantillaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosplantillaRecordSet", theIcmParametrosplantillaRecordSet), currentHashCode, theIcmParametrosplantillaRecordSet, ((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParametrosplantillaBlock) {
            final IcmParametrosplantillaBlock copy = ((IcmParametrosplantillaBlock) draftCopy);
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
                Boolean tipocondicionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.tipocondicion!= null));
                if (tipocondicionShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceTipocondicion;
                    sourceTipocondicion = this.getTipocondicion();
                    String copyTipocondicion = ((String) strategy.copy(LocatorUtils.property(locator, "tipocondicion", sourceTipocondicion), sourceTipocondicion, (this.tipocondicion!= null)));
                    copy.setTipocondicion(copyTipocondicion);
                } else {
                    if (tipocondicionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.tipocondicion = null;
                    }
                }
            }
            {
                Boolean tiposplantillasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.tiposplantillas!= null));
                if (tiposplantillasShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceTiposplantillas;
                    sourceTiposplantillas = this.getTiposplantillas();
                    String copyTiposplantillas = ((String) strategy.copy(LocatorUtils.property(locator, "tiposplantillas", sourceTiposplantillas), sourceTiposplantillas, (this.tiposplantillas!= null)));
                    copy.setTiposplantillas(copyTiposplantillas);
                } else {
                    if (tiposplantillasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.tiposplantillas = null;
                    }
                }
            }
            {
                Boolean subtipocondicionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.subtipocondicion!= null));
                if (subtipocondicionShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceSubtipocondicion;
                    sourceSubtipocondicion = this.getSubtipocondicion();
                    String copySubtipocondicion = ((String) strategy.copy(LocatorUtils.property(locator, "subtipocondicion", sourceSubtipocondicion), sourceSubtipocondicion, (this.subtipocondicion!= null)));
                    copy.setSubtipocondicion(copySubtipocondicion);
                } else {
                    if (subtipocondicionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.subtipocondicion = null;
                    }
                }
            }
            {
                Boolean icmParametrosplantillaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty())));
                if (icmParametrosplantillaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParametrosplantillaRecord> sourceIcmParametrosplantillaRecordSet;
                    sourceIcmParametrosplantillaRecordSet = (((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty()))?this.getIcmParametrosplantillaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParametrosplantillaRecord> copyIcmParametrosplantillaRecordSet = ((List<IcmParametrosplantillaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParametrosplantillaRecordSet", sourceIcmParametrosplantillaRecordSet), sourceIcmParametrosplantillaRecordSet, ((this.icmParametrosplantillaRecordSet!= null)&&(!this.icmParametrosplantillaRecordSet.isEmpty()))));
                    copy.icmParametrosplantillaRecordSet = null;
                    if (copyIcmParametrosplantillaRecordSet!= null) {
                        List<IcmParametrosplantillaRecord> uniqueIcmParametrosplantillaRecordSetl = copy.getIcmParametrosplantillaRecordSet();
                        uniqueIcmParametrosplantillaRecordSetl.addAll(copyIcmParametrosplantillaRecordSet);
                    }
                } else {
                    if (icmParametrosplantillaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosplantillaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParametrosplantillaBlock();
    }

}
