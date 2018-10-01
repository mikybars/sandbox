
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
 *         &lt;element name="ICM_PARAMETROSPAISCADENA" type="{http://schemas.meta4.com/}Icm_ParametrospaiscadenaBlock"/&gt;
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
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
    "icmparametrospaiscadena",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "GETTPCALCULOPAISCADENA")
public class GETTPCALCULOPAISCADENA {

    @XmlElement(name = "ICM_PARAMETROSPAISCADENA", required = true)
    protected IcmParametrospaiscadenaBlock icmparametrospaiscadena;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

    /**
     * Obtiene el valor de la propiedad icmparametrospaiscadena.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public IcmParametrospaiscadenaBlock getICMPARAMETROSPAISCADENA() {
        return icmparametrospaiscadena;
    }

    /**
     * Define el valor de la propiedad icmparametrospaiscadena.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public void setICMPARAMETROSPAISCADENA(IcmParametrospaiscadenaBlock value) {
        this.icmparametrospaiscadena = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrospaginacion.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
        return icmparametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmparametrospaginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public void setICMPARAMETROSPAGINACION(IcmParametrospaginacionBlock value) {
        this.icmparametrospaginacion = value;
    }

}
