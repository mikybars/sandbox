
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
 *         &lt;element name="GETPLANTILLACONDICIONESReturn" type="{http://schemas.meta4.com/}GetplantillacondicionesOutput"/>
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
    "getplantillacondicionesReturn"
})
@XmlRootElement(name = "GETPLANTILLACONDICIONESResponse")
public class GETPLANTILLACONDICIONESResponse {

    @XmlElement(name = "GETPLANTILLACONDICIONESReturn", required = true)
    protected GetplantillacondicionesOutput getplantillacondicionesReturn;

    /**
     * Gets the value of the getplantillacondicionesReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetplantillacondicionesOutput }
     *     
     */
    public GetplantillacondicionesOutput getGETPLANTILLACONDICIONESReturn() {
        return getplantillacondicionesReturn;
    }

    /**
     * Sets the value of the getplantillacondicionesReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetplantillacondicionesOutput }
     *     
     */
    public void setGETPLANTILLACONDICIONESReturn(GetplantillacondicionesOutput value) {
        this.getplantillacondicionesReturn = value;
    }

}
