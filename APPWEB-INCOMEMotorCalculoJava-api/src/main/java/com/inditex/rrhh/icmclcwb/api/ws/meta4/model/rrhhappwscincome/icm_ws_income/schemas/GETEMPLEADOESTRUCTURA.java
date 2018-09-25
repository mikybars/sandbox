
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
 *         &lt;element name="ICM_PARAMETROSEMPLEADO" type="{http://schemas.meta4.com/}Icm_ParametrosempleadoBlock"/&gt;
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
    "icmparametrosempleado"
})
@XmlRootElement(name = "GETEMPLEADOESTRUCTURA")
public class GETEMPLEADOESTRUCTURA {

    @XmlElement(name = "ICM_PARAMETROSEMPLEADO", required = true)
    protected IcmParametrosempleadoBlock icmparametrosempleado;

    /**
     * Obtiene el valor de la propiedad icmparametrosempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public IcmParametrosempleadoBlock getICMPARAMETROSEMPLEADO() {
        return icmparametrosempleado;
    }

    /**
     * Define el valor de la propiedad icmparametrosempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public void setICMPARAMETROSEMPLEADO(IcmParametrosempleadoBlock value) {
        this.icmparametrosempleado = value;
    }

}
