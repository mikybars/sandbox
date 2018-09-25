
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_EmpleadostiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadostiendaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_EmpleadostiendaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_EmpleadostiendaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadostiendaBlock", propOrder = {
    "icmEmpleadostiendaRecordSet"
})
public class IcmEmpleadostiendaBlock {

    @XmlElement(name = "Icm_EmpleadostiendaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmEmpleadostiendaRecord icmEmpleadostiendaRecordSet;

    /**
     * Obtiene el valor de la propiedad icmEmpleadostiendaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmEmpleadostiendaRecord }
     *     
     */
    public ArrayOfIcmEmpleadostiendaRecord getIcmEmpleadostiendaRecordSet() {
        return icmEmpleadostiendaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmEmpleadostiendaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmEmpleadostiendaRecord }
     *     
     */
    public void setIcmEmpleadostiendaRecordSet(ArrayOfIcmEmpleadostiendaRecord value) {
        this.icmEmpleadostiendaRecordSet = value;
    }

}
