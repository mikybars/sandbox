
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SEARCHTIENDASReturn" type="{http://schemas.meta4.com/}SearchtiendasOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * Obtiene el valor de la propiedad searchtiendasReturn.
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
     * Define el valor de la propiedad searchtiendasReturn.
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
