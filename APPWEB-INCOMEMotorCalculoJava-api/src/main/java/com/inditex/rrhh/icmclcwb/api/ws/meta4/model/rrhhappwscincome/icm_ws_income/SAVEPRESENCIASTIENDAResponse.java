
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SAVEPRESENCIASTIENDAReturn" type="{http://schemas.meta4.com/}SavepresenciastiendaOutput"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Gets the value of the savepresenciastiendaReturn property.
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
     * Sets the value of the savepresenciastiendaReturn property.
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
