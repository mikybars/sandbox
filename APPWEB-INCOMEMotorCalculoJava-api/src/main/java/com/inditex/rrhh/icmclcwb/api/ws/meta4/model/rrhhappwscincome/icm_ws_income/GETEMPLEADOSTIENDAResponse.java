
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
 *         &lt;element name="GETEMPLEADOSTIENDAReturn" type="{http://schemas.meta4.com/}GetempleadostiendaOutput"/&gt;
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
    "getempleadostiendaReturn"
})
@XmlRootElement(name = "GETEMPLEADOSTIENDAResponse")
public class GETEMPLEADOSTIENDAResponse {

    @XmlElement(name = "GETEMPLEADOSTIENDAReturn", required = true)
    protected GetempleadostiendaOutput getempleadostiendaReturn;

    /**
     * Obtiene el valor de la propiedad getempleadostiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetempleadostiendaOutput }
     *     
     */
    public GetempleadostiendaOutput getGETEMPLEADOSTIENDAReturn() {
        return getempleadostiendaReturn;
    }

    /**
     * Define el valor de la propiedad getempleadostiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetempleadostiendaOutput }
     *     
     */
    public void setGETEMPLEADOSTIENDAReturn(GetempleadostiendaOutput value) {
        this.getempleadostiendaReturn = value;
    }

}
