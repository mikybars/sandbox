
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GETCALENDARIOEMPLEADOReturn" type="{http://schemas.meta4.com/}GetcalendarioempleadoOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getcalendarioempleadoReturn"
})
@XmlRootElement(name = "GETCALENDARIOEMPLEADOResponse")
public class GETCALENDARIOEMPLEADOResponse {

    @XmlElement(name = "GETCALENDARIOEMPLEADOReturn", required = true)
    protected GetcalendarioempleadoOutput getcalendarioempleadoReturn;

    /**
     * Obtiene el valor de la propiedad getcalendarioempleadoReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetcalendarioempleadoOutput }
     *     
     */
    public GetcalendarioempleadoOutput getGETCALENDARIOEMPLEADOReturn() {
        return getcalendarioempleadoReturn;
    }

    /**
     * Define el valor de la propiedad getcalendarioempleadoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetcalendarioempleadoOutput }
     *     
     */
    public void setGETCALENDARIOEMPLEADOReturn(GetcalendarioempleadoOutput value) {
        this.getcalendarioempleadoReturn = value;
    }

}
