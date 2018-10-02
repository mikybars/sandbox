
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ParametrosplantillaBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
public class IcmParametrosplantillaBlock {

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
     * Gets the value of the idestructura property.
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
     * Sets the value of the idestructura property.
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
     * Gets the value of the tipocondicion property.
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
     * Sets the value of the tipocondicion property.
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
     * Gets the value of the tiposplantillas property.
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
     * Sets the value of the tiposplantillas property.
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
     * Gets the value of the subtipocondicion property.
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
     * Sets the value of the subtipocondicion property.
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

}
