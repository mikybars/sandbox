
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_VentamanualBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_VentamanualBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_VentamanualRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_VentamanualRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_VentamanualBlock", propOrder = {
    "icmVentamanualRecordSet"
})
public class IcmVentamanualBlock {

    @XmlElement(name = "Icm_VentamanualRecordSet", required = true, nillable = true)
    protected ArrayOfIcmVentamanualRecord icmVentamanualRecordSet;

    /**
     * Obtiene el valor de la propiedad icmVentamanualRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmVentamanualRecord }
     *     
     */
    public ArrayOfIcmVentamanualRecord getIcmVentamanualRecordSet() {
        return icmVentamanualRecordSet;
    }

    /**
     * Define el valor de la propiedad icmVentamanualRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmVentamanualRecord }
     *     
     */
    public void setIcmVentamanualRecordSet(ArrayOfIcmVentamanualRecord value) {
        this.icmVentamanualRecordSet = value;
    }

}
