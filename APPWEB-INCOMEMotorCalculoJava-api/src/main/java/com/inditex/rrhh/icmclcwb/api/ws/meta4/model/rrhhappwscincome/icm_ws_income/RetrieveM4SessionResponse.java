
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="retrieveM4SessionReturn" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "retrieveM4SessionReturn"
})
@XmlRootElement(name = "retrieveM4SessionResponse")
public class RetrieveM4SessionResponse {

    protected int retrieveM4SessionReturn;

    /**
     * Obtiene el valor de la propiedad retrieveM4SessionReturn.
     * 
     */
    public int getRetrieveM4SessionReturn() {
        return retrieveM4SessionReturn;
    }

    /**
     * Define el valor de la propiedad retrieveM4SessionReturn.
     * 
     */
    public void setRetrieveM4SessionReturn(int value) {
        this.retrieveM4SessionReturn = value;
    }

}
