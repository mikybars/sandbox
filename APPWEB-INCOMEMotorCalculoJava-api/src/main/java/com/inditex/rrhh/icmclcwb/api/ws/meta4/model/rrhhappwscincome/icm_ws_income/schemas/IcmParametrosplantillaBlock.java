
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_ParametrosplantillaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrosplantillaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipocondicion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tiposplantillas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="subtipocondicion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrosplantillaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_ParametrosplantillaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
    @XmlElement(name = "Icm_ParametrosplantillaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmParametrosplantillaRecord icmParametrosplantillaRecordSet;

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
     * Obtiene el valor de la propiedad icmParametrosplantillaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmParametrosplantillaRecord }
     *     
     */
    public ArrayOfIcmParametrosplantillaRecord getIcmParametrosplantillaRecordSet() {
        return icmParametrosplantillaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmParametrosplantillaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmParametrosplantillaRecord }
     *     
     */
    public void setIcmParametrosplantillaRecordSet(ArrayOfIcmParametrosplantillaRecord value) {
        this.icmParametrosplantillaRecordSet = value;
    }

}
