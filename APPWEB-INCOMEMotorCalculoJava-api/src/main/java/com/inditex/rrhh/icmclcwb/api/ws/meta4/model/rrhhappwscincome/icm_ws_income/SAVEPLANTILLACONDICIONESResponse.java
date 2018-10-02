
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
 *         &lt;element name="SAVEPLANTILLACONDICIONESReturn" type="{http://schemas.meta4.com/}SaveplantillacondicionesOutput"/>
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
    "saveplantillacondicionesReturn"
})
@XmlRootElement(name = "SAVEPLANTILLACONDICIONESResponse")
public class SAVEPLANTILLACONDICIONESResponse {

    @XmlElement(name = "SAVEPLANTILLACONDICIONESReturn", required = true)
    protected SaveplantillacondicionesOutput saveplantillacondicionesReturn;

    /**
     * Gets the value of the saveplantillacondicionesReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SaveplantillacondicionesOutput }
     *     
     */
    public SaveplantillacondicionesOutput getSAVEPLANTILLACONDICIONESReturn() {
        return saveplantillacondicionesReturn;
    }

    /**
     * Sets the value of the saveplantillacondicionesReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveplantillacondicionesOutput }
     *     
     */
    public void setSAVEPLANTILLACONDICIONESReturn(SaveplantillacondicionesOutput value) {
        this.saveplantillacondicionesReturn = value;
    }

}
