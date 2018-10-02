
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_CondicionesresaltaBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionesresaltaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orcomision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idplantilla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_CondicionesresaltaRecordSet" type="{http://schemas.meta4.com/}Icm_CondicionesresaltaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionesresaltaBlock", propOrder = {
    "orcomision",
    "idplantilla",
    "idestructura",
    "icmCondicionesresaltaRecordSet"
})
public class IcmCondicionesresaltaBlock {

    @XmlElement(required = true, nillable = true)
    protected String orcomision;
    @XmlElement(required = true, nillable = true)
    protected String idplantilla;
    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_CondicionesresaltaRecordSet", nillable = true)
    protected List<IcmCondicionesresaltaRecord> icmCondicionesresaltaRecordSet;

    /**
     * Gets the value of the orcomision property.
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
     * Sets the value of the orcomision property.
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
     * Gets the value of the idplantilla property.
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
     * Sets the value of the idplantilla property.
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
     * Gets the value of the icmCondicionesresaltaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCondicionesresaltaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCondicionesresaltaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCondicionesresaltaRecord }
     * 
     * 
     */
    public List<IcmCondicionesresaltaRecord> getIcmCondicionesresaltaRecordSet() {
        if (icmCondicionesresaltaRecordSet == null) {
            icmCondicionesresaltaRecordSet = new ArrayList<IcmCondicionesresaltaRecord>();
        }
        return this.icmCondicionesresaltaRecordSet;
    }

}
