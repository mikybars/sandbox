
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
 *         &lt;element name="ICM_PARAMETROSPRESUPUESTO" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoBlock"/&gt;
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
    "icmparametrospresupuesto"
})
@XmlRootElement(name = "GETBANDASPRESUPUESTOS")
public class GETBANDASPRESUPUESTOS {

    @XmlElement(name = "ICM_PARAMETROSPRESUPUESTO", required = true)
    protected IcmParametrospresupuestoBlock icmparametrospresupuesto;

    /**
     * Obtiene el valor de la propiedad icmparametrospresupuesto.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public IcmParametrospresupuestoBlock getICMPARAMETROSPRESUPUESTO() {
        return icmparametrospresupuesto;
    }

    /**
     * Define el valor de la propiedad icmparametrospresupuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public void setICMPARAMETROSPRESUPUESTO(IcmParametrospresupuestoBlock value) {
        this.icmparametrospresupuesto = value;
    }

}
