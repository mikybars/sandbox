
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
 *         &lt;element name="GETPRESUPUESTOSReturn" type="{http://schemas.meta4.com/}GetpresupuestosOutput"/&gt;
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
    "getpresupuestosReturn"
})
@XmlRootElement(name = "GETPRESUPUESTOSResponse")
public class GETPRESUPUESTOSResponse {

    @XmlElement(name = "GETPRESUPUESTOSReturn", required = true)
    protected GetpresupuestosOutput getpresupuestosReturn;

    /**
     * Obtiene el valor de la propiedad getpresupuestosReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetpresupuestosOutput }
     *     
     */
    public GetpresupuestosOutput getGETPRESUPUESTOSReturn() {
        return getpresupuestosReturn;
    }

    /**
     * Define el valor de la propiedad getpresupuestosReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetpresupuestosOutput }
     *     
     */
    public void setGETPRESUPUESTOSReturn(GetpresupuestosOutput value) {
        this.getpresupuestosReturn = value;
    }

}
