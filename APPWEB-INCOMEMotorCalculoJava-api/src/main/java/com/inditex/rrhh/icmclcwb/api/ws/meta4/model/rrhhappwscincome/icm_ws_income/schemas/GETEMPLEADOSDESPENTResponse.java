
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
 *         &lt;element name="GETEMPLEADOSDESPENTReturn" type="{http://schemas.meta4.com/}GetempleadosdespentOutput"/&gt;
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
    "getempleadosdespentReturn"
})
@XmlRootElement(name = "GETEMPLEADOSDESPENTResponse")
public class GETEMPLEADOSDESPENTResponse {

    @XmlElement(name = "GETEMPLEADOSDESPENTReturn", required = true)
    protected GetempleadosdespentOutput getempleadosdespentReturn;

    /**
     * Obtiene el valor de la propiedad getempleadosdespentReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetempleadosdespentOutput }
     *     
     */
    public GetempleadosdespentOutput getGETEMPLEADOSDESPENTReturn() {
        return getempleadosdespentReturn;
    }

    /**
     * Define el valor de la propiedad getempleadosdespentReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetempleadosdespentOutput }
     *     
     */
    public void setGETEMPLEADOSDESPENTReturn(GetempleadosdespentOutput value) {
        this.getempleadosdespentReturn = value;
    }

}
