
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
 *         &lt;element name="GETDATOSGENTIENDAReturn" type="{http://schemas.meta4.com/}GetdatosgentiendaOutput"/>
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
    "getdatosgentiendaReturn"
})
@XmlRootElement(name = "GETDATOSGENTIENDAResponse")
public class GETDATOSGENTIENDAResponse {

    @XmlElement(name = "GETDATOSGENTIENDAReturn", required = true)
    protected GetdatosgentiendaOutput getdatosgentiendaReturn;

    /**
     * Gets the value of the getdatosgentiendaReturn property.
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
     * Sets the value of the getdatosgentiendaReturn property.
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
