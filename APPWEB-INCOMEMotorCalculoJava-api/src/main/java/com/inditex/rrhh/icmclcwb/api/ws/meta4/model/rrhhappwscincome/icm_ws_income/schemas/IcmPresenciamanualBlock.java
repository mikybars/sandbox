
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_PresenciamanualBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_PresenciamanualBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_PresenciamanualRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_PresenciamanualRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PresenciamanualBlock", propOrder = {
    "icmPresenciamanualRecordSet"
})
public class IcmPresenciamanualBlock {

    @XmlElement(name = "Icm_PresenciamanualRecordSet", required = true, nillable = true)
    protected ArrayOfIcmPresenciamanualRecord icmPresenciamanualRecordSet;

    /**
     * Obtiene el valor de la propiedad icmPresenciamanualRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmPresenciamanualRecord }
     *     
     */
    public ArrayOfIcmPresenciamanualRecord getIcmPresenciamanualRecordSet() {
        return icmPresenciamanualRecordSet;
    }

    /**
     * Define el valor de la propiedad icmPresenciamanualRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmPresenciamanualRecord }
     *     
     */
    public void setIcmPresenciamanualRecordSet(ArrayOfIcmPresenciamanualRecord value) {
        this.icmPresenciamanualRecordSet = value;
    }

}
