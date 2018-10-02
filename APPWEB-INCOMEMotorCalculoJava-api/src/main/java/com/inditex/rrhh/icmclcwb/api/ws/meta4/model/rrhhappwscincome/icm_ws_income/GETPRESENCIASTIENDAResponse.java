
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
 *         &lt;element name="GETPRESENCIASTIENDAReturn" type="{http://schemas.meta4.com/}GetpresenciastiendaOutput"/>
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
    "getpresenciastiendaReturn"
})
@XmlRootElement(name = "GETPRESENCIASTIENDAResponse")
public class GETPRESENCIASTIENDAResponse {

    @XmlElement(name = "GETPRESENCIASTIENDAReturn", required = true)
    protected GetpresenciastiendaOutput getpresenciastiendaReturn;

    /**
     * Gets the value of the getpresenciastiendaReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetpresenciastiendaOutput }
     *     
     */
    public GetpresenciastiendaOutput getGETPRESENCIASTIENDAReturn() {
        return getpresenciastiendaReturn;
    }

    /**
     * Sets the value of the getpresenciastiendaReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetpresenciastiendaOutput }
     *     
     */
    public void setGETPRESENCIASTIENDAReturn(GetpresenciastiendaOutput value) {
        this.getpresenciastiendaReturn = value;
    }

}
