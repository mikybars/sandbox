
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_EmpleadosestructuraBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadosestructuraBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_EmpleadosestructuraRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_EmpleadosestructuraRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadosestructuraBlock", propOrder = {
    "icmEmpleadosestructuraRecordSet"
})
public class IcmEmpleadosestructuraBlock {

    @XmlElement(name = "Icm_EmpleadosestructuraRecordSet", required = true, nillable = true)
    protected ArrayOfIcmEmpleadosestructuraRecord icmEmpleadosestructuraRecordSet;

    /**
     * Obtiene el valor de la propiedad icmEmpleadosestructuraRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmEmpleadosestructuraRecord }
     *     
     */
    public ArrayOfIcmEmpleadosestructuraRecord getIcmEmpleadosestructuraRecordSet() {
        return icmEmpleadosestructuraRecordSet;
    }

    /**
     * Define el valor de la propiedad icmEmpleadosestructuraRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmEmpleadosestructuraRecord }
     *     
     */
    public void setIcmEmpleadosestructuraRecordSet(ArrayOfIcmEmpleadosestructuraRecord value) {
        this.icmEmpleadosestructuraRecordSet = value;
    }

}
