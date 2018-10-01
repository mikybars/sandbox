
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_CondicionesfijasBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionesfijasBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idplantilla" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_CondicionesfijasRecordSet" type="{http://schemas.meta4.com/}Icm_CondicionesfijasRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionesfijasBlock", propOrder = {
    "idplantilla",
    "idestructura",
    "icmCondicionesfijasRecordSet"
})
public class IcmCondicionesfijasBlock {

    @XmlElement(required = true, nillable = true)
    protected String idplantilla;
    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_CondicionesfijasRecordSet", nillable = true)
    protected List<IcmCondicionesfijasRecord> icmCondicionesfijasRecordSet;

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
     * Gets the value of the icmCondicionesfijasRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCondicionesfijasRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCondicionesfijasRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCondicionesfijasRecord }
     * 
     * 
     */
    public List<IcmCondicionesfijasRecord> getIcmCondicionesfijasRecordSet() {
        if (icmCondicionesfijasRecordSet == null) {
            icmCondicionesfijasRecordSet = new ArrayList<IcmCondicionesfijasRecord>();
        }
        return this.icmCondicionesfijasRecordSet;
    }

}
