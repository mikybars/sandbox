
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_EmpleadosdespentBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadosdespentBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_EmpleadosdespentRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_EmpleadosdespentRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadosdespentBlock", propOrder = {
    "icmEmpleadosdespentRecordSet"
})
public class IcmEmpleadosdespentBlock {

    @XmlElement(name = "Icm_EmpleadosdespentRecordSet", required = true, nillable = true)
    protected ArrayOfIcmEmpleadosdespentRecord icmEmpleadosdespentRecordSet;

    /**
     * Obtiene el valor de la propiedad icmEmpleadosdespentRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmEmpleadosdespentRecord }
     *     
     */
    public ArrayOfIcmEmpleadosdespentRecord getIcmEmpleadosdespentRecordSet() {
        return icmEmpleadosdespentRecordSet;
    }

    /**
     * Define el valor de la propiedad icmEmpleadosdespentRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmEmpleadosdespentRecord }
     *     
     */
    public void setIcmEmpleadosdespentRecordSet(ArrayOfIcmEmpleadosdespentRecord value) {
        this.icmEmpleadosdespentRecordSet = value;
    }

}
