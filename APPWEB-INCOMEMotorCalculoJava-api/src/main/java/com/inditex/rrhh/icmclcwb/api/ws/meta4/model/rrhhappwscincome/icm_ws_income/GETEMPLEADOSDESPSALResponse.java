
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
 *         &lt;element name="GETEMPLEADOSDESPSALReturn" type="{http://schemas.meta4.com/}GetempleadosdespsalOutput"/&gt;
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
    "getempleadosdespsalReturn"
})
@XmlRootElement(name = "GETEMPLEADOSDESPSALResponse")
public class GETEMPLEADOSDESPSALResponse {

    @XmlElement(name = "GETEMPLEADOSDESPSALReturn", required = true)
    protected GetempleadosdespsalOutput getempleadosdespsalReturn;

    /**
     * Obtiene el valor de la propiedad getempleadosdespsalReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetempleadosdespsalOutput }
     *     
     */
    public GetempleadosdespsalOutput getGETEMPLEADOSDESPSALReturn() {
        return getempleadosdespsalReturn;
    }

    /**
     * Define el valor de la propiedad getempleadosdespsalReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetempleadosdespsalOutput }
     *     
     */
    public void setGETEMPLEADOSDESPSALReturn(GetempleadosdespsalOutput value) {
        this.getempleadosdespsalReturn = value;
    }

}
