
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
 *         &lt;element name="GETVENTAREALReturn" type="{http://schemas.meta4.com/}GetventarealOutput"/>
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
    "getventarealReturn"
})
@XmlRootElement(name = "GETVENTAREALResponse")
public class GETVENTAREALResponse {

    @XmlElement(name = "GETVENTAREALReturn", required = true)
    protected GetventarealOutput getventarealReturn;

    /**
     * Gets the value of the getventarealReturn property.
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
     * Sets the value of the getventarealReturn property.
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
