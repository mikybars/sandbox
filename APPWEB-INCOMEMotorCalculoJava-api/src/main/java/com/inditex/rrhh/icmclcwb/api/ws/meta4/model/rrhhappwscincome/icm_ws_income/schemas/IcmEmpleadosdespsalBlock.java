
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_EmpleadosdespsalBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadosdespsalBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_EmpleadosdespsalRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_EmpleadosdespsalRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadosdespsalBlock", propOrder = {
    "icmEmpleadosdespsalRecordSet"
})
public class IcmEmpleadosdespsalBlock {

    @XmlElement(name = "Icm_EmpleadosdespsalRecordSet", required = true, nillable = true)
    protected ArrayOfIcmEmpleadosdespsalRecord icmEmpleadosdespsalRecordSet;

    /**
     * Obtiene el valor de la propiedad icmEmpleadosdespsalRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmEmpleadosdespsalRecord }
     *     
     */
    public ArrayOfIcmEmpleadosdespsalRecord getIcmEmpleadosdespsalRecordSet() {
        return icmEmpleadosdespsalRecordSet;
    }

    /**
     * Define el valor de la propiedad icmEmpleadosdespsalRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmEmpleadosdespsalRecord }
     *     
     */
    public void setIcmEmpleadosdespsalRecordSet(ArrayOfIcmEmpleadosdespsalRecord value) {
        this.icmEmpleadosdespsalRecordSet = value;
    }

}
