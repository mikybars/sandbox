
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_AvisosguardadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_AvisosguardadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_AvisosguardadoRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_AvisosguardadoRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_AvisosguardadoBlock", propOrder = {
    "resultado",
    "icmAvisosguardadoRecordSet"
})
public class IcmAvisosguardadoBlock {

    @XmlElement(required = true, nillable = true)
    protected String resultado;
    @XmlElement(name = "Icm_AvisosguardadoRecordSet", required = true, nillable = true)
    protected ArrayOfIcmAvisosguardadoRecord icmAvisosguardadoRecordSet;

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
     * Obtiene el valor de la propiedad icmAvisosguardadoRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmAvisosguardadoRecord }
     *     
     */
    public ArrayOfIcmAvisosguardadoRecord getIcmAvisosguardadoRecordSet() {
        return icmAvisosguardadoRecordSet;
    }

    /**
     * Define el valor de la propiedad icmAvisosguardadoRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmAvisosguardadoRecord }
     *     
     */
    public void setIcmAvisosguardadoRecordSet(ArrayOfIcmAvisosguardadoRecord value) {
        this.icmAvisosguardadoRecordSet = value;
    }

}
