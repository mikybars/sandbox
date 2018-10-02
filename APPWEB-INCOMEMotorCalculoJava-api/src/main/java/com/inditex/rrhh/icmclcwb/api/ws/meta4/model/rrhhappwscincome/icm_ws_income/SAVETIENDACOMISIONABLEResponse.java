
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
 *         &lt;element name="SAVETIENDACOMISIONABLEReturn" type="{http://schemas.meta4.com/}SavetiendacomisionableOutput"/>
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
    "savetiendacomisionableReturn"
})
@XmlRootElement(name = "SAVETIENDACOMISIONABLEResponse")
public class SAVETIENDACOMISIONABLEResponse {

    @XmlElement(name = "SAVETIENDACOMISIONABLEReturn", required = true)
    protected SavetiendacomisionableOutput savetiendacomisionableReturn;

    /**
     * Gets the value of the savetiendacomisionableReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SavetiendacomisionableOutput }
     *     
     */
    public SavetiendacomisionableOutput getSAVETIENDACOMISIONABLEReturn() {
        return savetiendacomisionableReturn;
    }

    /**
     * Sets the value of the savetiendacomisionableReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SavetiendacomisionableOutput }
     *     
     */
    public void setSAVETIENDACOMISIONABLEReturn(SavetiendacomisionableOutput value) {
        this.savetiendacomisionableReturn = value;
    }

}
