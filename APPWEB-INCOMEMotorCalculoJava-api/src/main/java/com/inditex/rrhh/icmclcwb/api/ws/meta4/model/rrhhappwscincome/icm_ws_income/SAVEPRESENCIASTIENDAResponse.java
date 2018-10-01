
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
 *         &lt;element name="SAVEPRESENCIASTIENDAReturn" type="{http://schemas.meta4.com/}SavepresenciastiendaOutput"/&gt;
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
    "savepresenciastiendaReturn"
})
@XmlRootElement(name = "SAVEPRESENCIASTIENDAResponse")
public class SAVEPRESENCIASTIENDAResponse {

    @XmlElement(name = "SAVEPRESENCIASTIENDAReturn", required = true)
    protected SavepresenciastiendaOutput savepresenciastiendaReturn;

    /**
     * Obtiene el valor de la propiedad savepresenciastiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link SavepresenciastiendaOutput }
     *     
     */
    public SavepresenciastiendaOutput getSAVEPRESENCIASTIENDAReturn() {
        return savepresenciastiendaReturn;
    }

    /**
     * Define el valor de la propiedad savepresenciastiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SavepresenciastiendaOutput }
     *     
     */
    public void setSAVEPRESENCIASTIENDAReturn(SavepresenciastiendaOutput value) {
        this.savepresenciastiendaReturn = value;
    }

}
