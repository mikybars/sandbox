
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
 *         &lt;element name="GETESTADOSTIENDASECCIONReturn" type="{http://schemas.meta4.com/}GetestadostiendaseccionOutput"/>
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
    "getestadostiendaseccionReturn"
})
@XmlRootElement(name = "GETESTADOSTIENDASECCIONResponse")
public class GETESTADOSTIENDASECCIONResponse {

    @XmlElement(name = "GETESTADOSTIENDASECCIONReturn", required = true)
    protected GetestadostiendaseccionOutput getestadostiendaseccionReturn;

    /**
     * Gets the value of the getestadostiendaseccionReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetestadostiendaseccionOutput }
     *     
     */
    public GetestadostiendaseccionOutput getGETESTADOSTIENDASECCIONReturn() {
        return getestadostiendaseccionReturn;
    }

    /**
     * Sets the value of the getestadostiendaseccionReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetestadostiendaseccionOutput }
     *     
     */
    public void setGETESTADOSTIENDASECCIONReturn(GetestadostiendaseccionOutput value) {
        this.getestadostiendaseccionReturn = value;
    }

}
