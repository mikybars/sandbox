
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
 *         &lt;element name="GETTIENDACOMISIONABLEReturn" type="{http://schemas.meta4.com/}GettiendacomisionableOutput"/&gt;
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
    "gettiendacomisionableReturn"
})
@XmlRootElement(name = "GETTIENDACOMISIONABLEResponse")
public class GETTIENDACOMISIONABLEResponse {

    @XmlElement(name = "GETTIENDACOMISIONABLEReturn", required = true)
    protected GettiendacomisionableOutput gettiendacomisionableReturn;

    /**
     * Obtiene el valor de la propiedad gettiendacomisionableReturn.
     * 
     * @return
     *     possible object is
     *     {@link GettiendacomisionableOutput }
     *     
     */
    public GettiendacomisionableOutput getGETTIENDACOMISIONABLEReturn() {
        return gettiendacomisionableReturn;
    }

    /**
     * Define el valor de la propiedad gettiendacomisionableReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GettiendacomisionableOutput }
     *     
     */
    public void setGETTIENDACOMISIONABLEReturn(GettiendacomisionableOutput value) {
        this.gettiendacomisionableReturn = value;
    }

}
