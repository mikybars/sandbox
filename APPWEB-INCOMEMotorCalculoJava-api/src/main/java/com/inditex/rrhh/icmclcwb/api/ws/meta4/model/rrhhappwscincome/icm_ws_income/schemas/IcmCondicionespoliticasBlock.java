
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_CondicionespoliticasBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionespoliticasBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idplantilla" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_CondicionespoliticasRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_CondicionespoliticasRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionespoliticasBlock", propOrder = {
    "idplantilla",
    "idestructura",
    "icmCondicionespoliticasRecordSet"
})
public class IcmCondicionespoliticasBlock {

    @XmlElement(required = true, nillable = true)
    protected String idplantilla;
    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_CondicionespoliticasRecordSet", required = true, nillable = true)
    protected ArrayOfIcmCondicionespoliticasRecord icmCondicionespoliticasRecordSet;

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
     * Obtiene el valor de la propiedad icmCondicionespoliticasRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmCondicionespoliticasRecord }
     *     
     */
    public ArrayOfIcmCondicionespoliticasRecord getIcmCondicionespoliticasRecordSet() {
        return icmCondicionespoliticasRecordSet;
    }

    /**
     * Define el valor de la propiedad icmCondicionespoliticasRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmCondicionespoliticasRecord }
     *     
     */
    public void setIcmCondicionespoliticasRecordSet(ArrayOfIcmCondicionespoliticasRecord value) {
        this.icmCondicionespoliticasRecordSet = value;
    }

}
