
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
 *         &lt;element name="GETVENTAMANUALReturn" type="{http://schemas.meta4.com/}GetventamanualOutput"/&gt;
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
    "getventamanualReturn"
})
@XmlRootElement(name = "GETVENTAMANUALResponse")
public class GETVENTAMANUALResponse {

    @XmlElement(name = "GETVENTAMANUALReturn", required = true)
    protected GetventamanualOutput getventamanualReturn;

    /**
     * Obtiene el valor de la propiedad getventamanualReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetventamanualOutput }
     *     
     */
    public GetventamanualOutput getGETVENTAMANUALReturn() {
        return getventamanualReturn;
    }

    /**
     * Define el valor de la propiedad getventamanualReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetventamanualOutput }
     *     
     */
    public void setGETVENTAMANUALReturn(GetventamanualOutput value) {
        this.getventamanualReturn = value;
    }

}
