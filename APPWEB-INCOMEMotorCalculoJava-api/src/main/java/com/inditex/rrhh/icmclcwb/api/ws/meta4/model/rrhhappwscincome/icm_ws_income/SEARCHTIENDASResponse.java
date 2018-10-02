
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
 *         &lt;element name="SEARCHTIENDASReturn" type="{http://schemas.meta4.com/}SearchtiendasOutput"/>
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
    "searchtiendasReturn"
})
@XmlRootElement(name = "SEARCHTIENDASResponse")
public class SEARCHTIENDASResponse {

    @XmlElement(name = "SEARCHTIENDASReturn", required = true)
    protected SearchtiendasOutput searchtiendasReturn;

    /**
     * Gets the value of the searchtiendasReturn property.
     * 
     * @return
     *     possible object is
     *     {@link SearchtiendasOutput }
     *     
     */
    public SearchtiendasOutput getSEARCHTIENDASReturn() {
        return searchtiendasReturn;
    }

    /**
     * Sets the value of the searchtiendasReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchtiendasOutput }
     *     
     */
    public void setSEARCHTIENDASReturn(SearchtiendasOutput value) {
        this.searchtiendasReturn = value;
    }

}
