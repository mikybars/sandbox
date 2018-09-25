
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
 *         &lt;element name="GETVENTAREALReturn" type="{http://schemas.meta4.com/}GetventarealOutput"/&gt;
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
    "getventarealReturn"
})
@XmlRootElement(name = "GETVENTAREALResponse")
public class GETVENTAREALResponse {

    @XmlElement(name = "GETVENTAREALReturn", required = true)
    protected GetventarealOutput getventarealReturn;

    /**
     * Obtiene el valor de la propiedad getventarealReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetventarealOutput }
     *     
     */
    public GetventarealOutput getGETVENTAREALReturn() {
        return getventarealReturn;
    }

    /**
     * Define el valor de la propiedad getventarealReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetventarealOutput }
     *     
     */
    public void setGETVENTAREALReturn(GetventarealOutput value) {
        this.getventarealReturn = value;
    }

}
