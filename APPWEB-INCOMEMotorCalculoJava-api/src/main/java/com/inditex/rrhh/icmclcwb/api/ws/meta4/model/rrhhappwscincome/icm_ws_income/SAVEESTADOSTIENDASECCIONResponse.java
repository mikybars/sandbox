
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
 *         &lt;element name="SAVEESTADOSTIENDASECCIONReturn" type="{http://schemas.meta4.com/}SaveestadostiendaseccionOutput"/>
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
    "saveestadostiendaseccionReturn"
})
@XmlRootElement(name = "SAVEESTADOSTIENDASECCIONResponse")
public class SAVEESTADOSTIENDASECCIONResponse {

    @XmlElement(name = "SAVEESTADOSTIENDASECCIONReturn", required = true)
    protected SaveestadostiendaseccionOutput saveestadostiendaseccionReturn;

    /**
     * Gets the value of the saveestadostiendaseccionReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SaveestadostiendaseccionOutput }
     *     
     */
    public SaveestadostiendaseccionOutput getSAVEESTADOSTIENDASECCIONReturn() {
        return saveestadostiendaseccionReturn;
    }

    /**
     * Sets the value of the saveestadostiendaseccionReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveestadostiendaseccionOutput }
     *     
     */
    public void setSAVEESTADOSTIENDASECCIONReturn(SaveestadostiendaseccionOutput value) {
        this.saveestadostiendaseccionReturn = value;
    }

}
