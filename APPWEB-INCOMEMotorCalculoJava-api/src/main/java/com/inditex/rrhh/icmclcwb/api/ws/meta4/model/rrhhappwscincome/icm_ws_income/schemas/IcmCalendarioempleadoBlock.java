
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_CalendarioempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CalendarioempleadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_CalendarioempleadoRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_CalendarioempleadoRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CalendarioempleadoBlock", propOrder = {
    "icmCalendarioempleadoRecordSet"
})
public class IcmCalendarioempleadoBlock {

    @XmlElement(name = "Icm_CalendarioempleadoRecordSet", required = true, nillable = true)
    protected ArrayOfIcmCalendarioempleadoRecord icmCalendarioempleadoRecordSet;

    /**
     * Obtiene el valor de la propiedad icmCalendarioempleadoRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmCalendarioempleadoRecord }
     *     
     */
    public ArrayOfIcmCalendarioempleadoRecord getIcmCalendarioempleadoRecordSet() {
        return icmCalendarioempleadoRecordSet;
    }

    /**
     * Define el valor de la propiedad icmCalendarioempleadoRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmCalendarioempleadoRecord }
     *     
     */
    public void setIcmCalendarioempleadoRecordSet(ArrayOfIcmCalendarioempleadoRecord value) {
        this.icmCalendarioempleadoRecordSet = value;
    }

}
