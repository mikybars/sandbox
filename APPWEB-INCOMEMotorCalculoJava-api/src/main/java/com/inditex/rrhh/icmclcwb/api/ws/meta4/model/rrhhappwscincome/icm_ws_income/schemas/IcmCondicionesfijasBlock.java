
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

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
 *         &lt;element name="Icm_CondicionesfijasRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_CondicionesfijasRecord"/&gt;
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
    @XmlElement(name = "Icm_CondicionesfijasRecordSet", required = true, nillable = true)
    protected ArrayOfIcmCondicionesfijasRecord icmCondicionesfijasRecordSet;

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
     * Obtiene el valor de la propiedad icmCondicionesfijasRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmCondicionesfijasRecord }
     *     
     */
    public ArrayOfIcmCondicionesfijasRecord getIcmCondicionesfijasRecordSet() {
        return icmCondicionesfijasRecordSet;
    }

    /**
     * Define el valor de la propiedad icmCondicionesfijasRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmCondicionesfijasRecord }
     *     
     */
    public void setIcmCondicionesfijasRecordSet(ArrayOfIcmCondicionesfijasRecord value) {
        this.icmCondicionesfijasRecordSet = value;
    }

}
