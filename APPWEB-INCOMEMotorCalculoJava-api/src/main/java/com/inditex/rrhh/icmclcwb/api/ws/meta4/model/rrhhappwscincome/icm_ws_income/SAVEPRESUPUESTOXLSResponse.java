
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
 *         &lt;element name="SAVEPRESUPUESTOXLSReturn" type="{http://schemas.meta4.com/}SavepresupuestoxlsOutput"/>
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
    "savepresupuestoxlsReturn"
})
@XmlRootElement(name = "SAVEPRESUPUESTOXLSResponse")
public class SAVEPRESUPUESTOXLSResponse {

    @XmlElement(name = "SAVEPRESUPUESTOXLSReturn", required = true)
    protected SavepresupuestoxlsOutput savepresupuestoxlsReturn;

    /**
     * Gets the value of the savepresupuestoxlsReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SavepresupuestoxlsOutput }
     *     
     */
    public SavepresupuestoxlsOutput getSAVEPRESUPUESTOXLSReturn() {
        return savepresupuestoxlsReturn;
    }

    /**
     * Sets the value of the savepresupuestoxlsReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SavepresupuestoxlsOutput }
     *     
     */
    public void setSAVEPRESUPUESTOXLSReturn(SavepresupuestoxlsOutput value) {
        this.savepresupuestoxlsReturn = value;
    }

}
