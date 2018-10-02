
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
 *         &lt;element name="SAVEEMPLEADOESTRUCTURAReturn" type="{http://schemas.meta4.com/}SaveempleadoestructuraOutput"/>
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
    "saveempleadoestructuraReturn"
})
@XmlRootElement(name = "SAVEEMPLEADOESTRUCTURAResponse")
public class SAVEEMPLEADOESTRUCTURAResponse {

    @XmlElement(name = "SAVEEMPLEADOESTRUCTURAReturn", required = true)
    protected SaveempleadoestructuraOutput saveempleadoestructuraReturn;

    /**
     * Gets the value of the saveempleadoestructuraReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SaveempleadoestructuraOutput }
     *     
     */
    public SaveempleadoestructuraOutput getSAVEEMPLEADOESTRUCTURAReturn() {
        return saveempleadoestructuraReturn;
    }

    /**
     * Sets the value of the saveempleadoestructuraReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveempleadoestructuraOutput }
     *     
     */
    public void setSAVEEMPLEADOESTRUCTURAReturn(SaveempleadoestructuraOutput value) {
        this.saveempleadoestructuraReturn = value;
    }

}
