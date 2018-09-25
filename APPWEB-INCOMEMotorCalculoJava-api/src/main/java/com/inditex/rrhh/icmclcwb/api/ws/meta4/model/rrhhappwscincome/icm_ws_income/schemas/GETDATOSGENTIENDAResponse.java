
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
 *         &lt;element name="GETDATOSGENTIENDAReturn" type="{http://schemas.meta4.com/}GetdatosgentiendaOutput"/&gt;
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
    "getdatosgentiendaReturn"
})
@XmlRootElement(name = "GETDATOSGENTIENDAResponse")
public class GETDATOSGENTIENDAResponse {

    @XmlElement(name = "GETDATOSGENTIENDAReturn", required = true)
    protected GetdatosgentiendaOutput getdatosgentiendaReturn;

    /**
     * Obtiene el valor de la propiedad getdatosgentiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetdatosgentiendaOutput }
     *     
     */
    public GetdatosgentiendaOutput getGETDATOSGENTIENDAReturn() {
        return getdatosgentiendaReturn;
    }

    /**
     * Define el valor de la propiedad getdatosgentiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetdatosgentiendaOutput }
     *     
     */
    public void setGETDATOSGENTIENDAReturn(GetdatosgentiendaOutput value) {
        this.getdatosgentiendaReturn = value;
    }

}
