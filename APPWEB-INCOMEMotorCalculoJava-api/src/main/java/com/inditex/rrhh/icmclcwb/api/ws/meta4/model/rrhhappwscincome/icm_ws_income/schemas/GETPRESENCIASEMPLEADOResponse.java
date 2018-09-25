
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
 *         &lt;element name="GETPRESENCIASEMPLEADOReturn" type="{http://schemas.meta4.com/}GetpresenciasempleadoOutput"/&gt;
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
    "getpresenciasempleadoReturn"
})
@XmlRootElement(name = "GETPRESENCIASEMPLEADOResponse")
public class GETPRESENCIASEMPLEADOResponse {

    @XmlElement(name = "GETPRESENCIASEMPLEADOReturn", required = true)
    protected GetpresenciasempleadoOutput getpresenciasempleadoReturn;

    /**
     * Obtiene el valor de la propiedad getpresenciasempleadoReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetpresenciasempleadoOutput }
     *     
     */
    public GetpresenciasempleadoOutput getGETPRESENCIASEMPLEADOReturn() {
        return getpresenciasempleadoReturn;
    }

    /**
     * Define el valor de la propiedad getpresenciasempleadoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetpresenciasempleadoOutput }
     *     
     */
    public void setGETPRESENCIASEMPLEADOReturn(GetpresenciasempleadoOutput value) {
        this.getpresenciasempleadoReturn = value;
    }

}
