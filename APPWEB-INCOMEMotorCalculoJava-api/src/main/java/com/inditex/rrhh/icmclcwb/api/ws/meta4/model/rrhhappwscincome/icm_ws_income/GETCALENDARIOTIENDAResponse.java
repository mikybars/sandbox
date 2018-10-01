
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

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
 *         &lt;element name="GETCALENDARIOTIENDAReturn" type="{http://schemas.meta4.com/}GetcalendariotiendaOutput"/&gt;
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
    "getcalendariotiendaReturn"
})
@XmlRootElement(name = "GETCALENDARIOTIENDAResponse")
public class GETCALENDARIOTIENDAResponse {

    @XmlElement(name = "GETCALENDARIOTIENDAReturn", required = true)
    protected GetcalendariotiendaOutput getcalendariotiendaReturn;

    /**
     * Obtiene el valor de la propiedad getcalendariotiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetcalendariotiendaOutput }
     *     
     */
    public GetcalendariotiendaOutput getGETCALENDARIOTIENDAReturn() {
        return getcalendariotiendaReturn;
    }

    /**
     * Define el valor de la propiedad getcalendariotiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetcalendariotiendaOutput }
     *     
     */
    public void setGETCALENDARIOTIENDAReturn(GetcalendariotiendaOutput value) {
        this.getcalendariotiendaReturn = value;
    }

}
