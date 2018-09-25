
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_CondicionesventaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionesventaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_CondicionesventaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_CondicionesventaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionesventaBlock", propOrder = {
    "icmCondicionesventaRecordSet"
})
public class IcmCondicionesventaBlock {

    @XmlElement(name = "Icm_CondicionesventaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmCondicionesventaRecord icmCondicionesventaRecordSet;

    /**
     * Obtiene el valor de la propiedad icmCondicionesventaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmCondicionesventaRecord }
     *     
     */
    public ArrayOfIcmCondicionesventaRecord getIcmCondicionesventaRecordSet() {
        return icmCondicionesventaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmCondicionesventaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmCondicionesventaRecord }
     *     
     */
    public void setIcmCondicionesventaRecordSet(ArrayOfIcmCondicionesventaRecord value) {
        this.icmCondicionesventaRecordSet = value;
    }

}
