
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
 *         &lt;element name="SAVEVENTAREALReturn" type="{http://schemas.meta4.com/}SaveventarealOutput"/>
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
    "saveventarealReturn"
})
@XmlRootElement(name = "SAVEVENTAREALResponse")
public class SAVEVENTAREALResponse {

    @XmlElement(name = "SAVEVENTAREALReturn", required = true)
    protected SaveventarealOutput saveventarealReturn;

    /**
     * Gets the value of the saveventarealReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SaveventarealOutput }
     *     
     */
    public SaveventarealOutput getSAVEVENTAREALReturn() {
        return saveventarealReturn;
    }

    /**
     * Sets the value of the saveventarealReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveventarealOutput }
     *     
     */
    public void setSAVEVENTAREALReturn(SaveventarealOutput value) {
        this.saveventarealReturn = value;
    }

}
