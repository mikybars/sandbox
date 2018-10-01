
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
 *         &lt;element name="ICM_PARAMETROSEXCEL" type="{http://schemas.meta4.com/}Icm_ParametrosexcelBlock"/&gt;
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
    "icmparametrosexcel"
})
@XmlRootElement(name = "SAVEVENTAREALXLS")
public class SAVEVENTAREALXLS {

    @XmlElement(name = "ICM_PARAMETROSEXCEL", required = true)
    protected IcmParametrosexcelBlock icmparametrosexcel;

    /**
     * Obtiene el valor de la propiedad icmparametrosexcel.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosexcelBlock }
     *     
     */
    public IcmParametrosexcelBlock getICMPARAMETROSEXCEL() {
        return icmparametrosexcel;
    }

    /**
     * Define el valor de la propiedad icmparametrosexcel.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosexcelBlock }
     *     
     */
    public void setICMPARAMETROSEXCEL(IcmParametrosexcelBlock value) {
        this.icmparametrosexcel = value;
    }

}
