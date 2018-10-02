
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
 *         &lt;element name="GETVENTAMANUALReturn" type="{http://schemas.meta4.com/}GetventamanualOutput"/>
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
    "getventamanualReturn"
})
@XmlRootElement(name = "GETVENTAMANUALResponse")
public class GETVENTAMANUALResponse {

    @XmlElement(name = "GETVENTAMANUALReturn", required = true)
    protected GetventamanualOutput getventamanualReturn;

    /**
     * Gets the value of the getventamanualReturn property.
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
     * Sets the value of the getventamanualReturn property.
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
