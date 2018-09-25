
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_CabeceraempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CabeceraempleadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_CabeceraempleadoRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_CabeceraempleadoRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CabeceraempleadoBlock", propOrder = {
    "icmCabeceraempleadoRecordSet"
})
public class IcmCabeceraempleadoBlock {

    @XmlElement(name = "Icm_CabeceraempleadoRecordSet", required = true, nillable = true)
    protected ArrayOfIcmCabeceraempleadoRecord icmCabeceraempleadoRecordSet;

    /**
     * Obtiene el valor de la propiedad icmCabeceraempleadoRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmCabeceraempleadoRecord }
     *     
     */
    public ArrayOfIcmCabeceraempleadoRecord getIcmCabeceraempleadoRecordSet() {
        return icmCabeceraempleadoRecordSet;
    }

    /**
     * Define el valor de la propiedad icmCabeceraempleadoRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmCabeceraempleadoRecord }
     *     
     */
    public void setIcmCabeceraempleadoRecordSet(ArrayOfIcmCabeceraempleadoRecord value) {
        this.icmCabeceraempleadoRecordSet = value;
    }

}
