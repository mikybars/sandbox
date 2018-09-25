
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_EstadostiendaseccionBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EstadostiendaseccionBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_EstadostiendaseccionRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_EstadostiendaseccionRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EstadostiendaseccionBlock", propOrder = {
    "icmEstadostiendaseccionRecordSet"
})
public class IcmEstadostiendaseccionBlock {

    @XmlElement(name = "Icm_EstadostiendaseccionRecordSet", required = true, nillable = true)
    protected ArrayOfIcmEstadostiendaseccionRecord icmEstadostiendaseccionRecordSet;

    /**
     * Obtiene el valor de la propiedad icmEstadostiendaseccionRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmEstadostiendaseccionRecord }
     *     
     */
    public ArrayOfIcmEstadostiendaseccionRecord getIcmEstadostiendaseccionRecordSet() {
        return icmEstadostiendaseccionRecordSet;
    }

    /**
     * Define el valor de la propiedad icmEstadostiendaseccionRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmEstadostiendaseccionRecord }
     *     
     */
    public void setIcmEstadostiendaseccionRecordSet(ArrayOfIcmEstadostiendaseccionRecord value) {
        this.icmEstadostiendaseccionRecordSet = value;
    }

}
