
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_PresupuestosBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_PresupuestosBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_PresupuestosRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_PresupuestosRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PresupuestosBlock", propOrder = {
    "icmPresupuestosRecordSet"
})
public class IcmPresupuestosBlock {

    @XmlElement(name = "Icm_PresupuestosRecordSet", required = true, nillable = true)
    protected ArrayOfIcmPresupuestosRecord icmPresupuestosRecordSet;

    /**
     * Obtiene el valor de la propiedad icmPresupuestosRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmPresupuestosRecord }
     *     
     */
    public ArrayOfIcmPresupuestosRecord getIcmPresupuestosRecordSet() {
        return icmPresupuestosRecordSet;
    }

    /**
     * Define el valor de la propiedad icmPresupuestosRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmPresupuestosRecord }
     *     
     */
    public void setIcmPresupuestosRecordSet(ArrayOfIcmPresupuestosRecord value) {
        this.icmPresupuestosRecordSet = value;
    }

}
