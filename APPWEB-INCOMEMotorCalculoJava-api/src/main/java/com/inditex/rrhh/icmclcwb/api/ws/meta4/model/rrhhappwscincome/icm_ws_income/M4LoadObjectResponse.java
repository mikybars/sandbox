
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
 *         &lt;element name="M4LoadObjectReturn" type="{http://schemas.meta4.com/}M4LoadobjectOutput"/>
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
    "m4LoadObjectReturn"
})
@XmlRootElement(name = "M4LoadObjectResponse")
public class M4LoadObjectResponse {

    @XmlElement(name = "M4LoadObjectReturn", required = true)
    protected M4LoadobjectOutput m4LoadObjectReturn;

    /**
     * Gets the value of the m4LoadObjectReturn property.
     * 
     * @return
     *     possible object is
     *     {@link M4LoadobjectOutput }
     *     
     */
    public M4LoadobjectOutput getM4LoadObjectReturn() {
        return m4LoadObjectReturn;
    }

    /**
     * Sets the value of the m4LoadObjectReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link M4LoadobjectOutput }
     *     
     */
    public void setM4LoadObjectReturn(M4LoadobjectOutput value) {
        this.m4LoadObjectReturn = value;
    }

}
