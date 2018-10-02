
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
 *         &lt;element name="SAVEVENTAREALXLSReturn" type="{http://schemas.meta4.com/}SaveventarealxlsOutput"/>
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
    "saveventarealxlsReturn"
})
@XmlRootElement(name = "SAVEVENTAREALXLSResponse")
public class SAVEVENTAREALXLSResponse {

    @XmlElement(name = "SAVEVENTAREALXLSReturn", required = true)
    protected SaveventarealxlsOutput saveventarealxlsReturn;

    /**
     * Gets the value of the saveventarealxlsReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SaveventarealxlsOutput }
     *     
     */
    public SaveventarealxlsOutput getSAVEVENTAREALXLSReturn() {
        return saveventarealxlsReturn;
    }

    /**
     * Sets the value of the saveventarealxlsReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveventarealxlsOutput }
     *     
     */
    public void setSAVEVENTAREALXLSReturn(SaveventarealxlsOutput value) {
        this.saveventarealxlsReturn = value;
    }

}
