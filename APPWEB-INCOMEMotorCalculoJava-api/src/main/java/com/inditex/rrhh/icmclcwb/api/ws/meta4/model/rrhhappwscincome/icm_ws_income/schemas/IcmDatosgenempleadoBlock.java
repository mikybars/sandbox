
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_DatosgenempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_DatosgenempleadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_DatosgenempleadoRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_DatosgenempleadoRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_DatosgenempleadoBlock", propOrder = {
    "icmDatosgenempleadoRecordSet"
})
public class IcmDatosgenempleadoBlock {

    @XmlElement(name = "Icm_DatosgenempleadoRecordSet", required = true, nillable = true)
    protected ArrayOfIcmDatosgenempleadoRecord icmDatosgenempleadoRecordSet;

    /**
     * Obtiene el valor de la propiedad icmDatosgenempleadoRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmDatosgenempleadoRecord }
     *     
     */
    public ArrayOfIcmDatosgenempleadoRecord getIcmDatosgenempleadoRecordSet() {
        return icmDatosgenempleadoRecordSet;
    }

    /**
     * Define el valor de la propiedad icmDatosgenempleadoRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmDatosgenempleadoRecord }
     *     
     */
    public void setIcmDatosgenempleadoRecordSet(ArrayOfIcmDatosgenempleadoRecord value) {
        this.icmDatosgenempleadoRecordSet = value;
    }

}
