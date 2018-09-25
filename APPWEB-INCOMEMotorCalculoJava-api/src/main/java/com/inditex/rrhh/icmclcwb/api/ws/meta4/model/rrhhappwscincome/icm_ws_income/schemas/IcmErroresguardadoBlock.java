
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_ErroresguardadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ErroresguardadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ErroresguardadoRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_ErroresguardadoRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ErroresguardadoBlock", propOrder = {
    "resultado",
    "icmErroresguardadoRecordSet"
})
public class IcmErroresguardadoBlock {

    @XmlElement(required = true, nillable = true)
    protected String resultado;
    @XmlElement(name = "Icm_ErroresguardadoRecordSet", required = true, nillable = true)
    protected ArrayOfIcmErroresguardadoRecord icmErroresguardadoRecordSet;

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmErroresguardadoRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmErroresguardadoRecord }
     *     
     */
    public ArrayOfIcmErroresguardadoRecord getIcmErroresguardadoRecordSet() {
        return icmErroresguardadoRecordSet;
    }

    /**
     * Define el valor de la propiedad icmErroresguardadoRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmErroresguardadoRecord }
     *     
     */
    public void setIcmErroresguardadoRecordSet(ArrayOfIcmErroresguardadoRecord value) {
        this.icmErroresguardadoRecordSet = value;
    }

}
