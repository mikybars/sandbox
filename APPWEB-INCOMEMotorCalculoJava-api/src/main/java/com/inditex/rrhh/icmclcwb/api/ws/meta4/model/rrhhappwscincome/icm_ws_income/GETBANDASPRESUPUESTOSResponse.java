
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

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
 *         &lt;element name="GETBANDASPRESUPUESTOSReturn" type="{http://schemas.meta4.com/}GetbandaspresupuestosOutput"/&gt;
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
    "getbandaspresupuestosReturn"
})
@XmlRootElement(name = "GETBANDASPRESUPUESTOSResponse")
public class GETBANDASPRESUPUESTOSResponse {

    @XmlElement(name = "GETBANDASPRESUPUESTOSReturn", required = true)
    protected GetbandaspresupuestosOutput getbandaspresupuestosReturn;

    /**
     * Obtiene el valor de la propiedad getbandaspresupuestosReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetbandaspresupuestosOutput }
     *     
     */
    public GetbandaspresupuestosOutput getGETBANDASPRESUPUESTOSReturn() {
        return getbandaspresupuestosReturn;
    }

    /**
     * Define el valor de la propiedad getbandaspresupuestosReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetbandaspresupuestosOutput }
     *     
     */
    public void setGETBANDASPRESUPUESTOSReturn(GetbandaspresupuestosOutput value) {
        this.getbandaspresupuestosReturn = value;
    }

}
