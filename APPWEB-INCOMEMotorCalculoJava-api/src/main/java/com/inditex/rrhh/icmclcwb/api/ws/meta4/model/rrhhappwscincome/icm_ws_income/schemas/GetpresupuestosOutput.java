
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetpresupuestosOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetpresupuestosOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}ArrayOfLogMessage"/&gt;
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *         &lt;element name="Icm_Presupuestos" type="{http://schemas.meta4.com/}Icm_PresupuestosBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetpresupuestosOutput", propOrder = {
    "_return",
    "logMessage",
    "icmParametrospaginacion",
    "icmPresupuestos"
})
public class GetpresupuestosOutput {

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfLogMessage logMessage;
    @XmlElement(name = "Icm_Parametrospaginacion", required = true, nillable = true)
    protected IcmParametrospaginacionBlock icmParametrospaginacion;
    @XmlElement(name = "Icm_Presupuestos", required = true, nillable = true)
    protected IcmPresupuestosBlock icmPresupuestos;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     */
    public double getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     */
    public void setReturn(double value) {
        this._return = value;
    }

    /**
     * Obtiene el valor de la propiedad logMessage.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLogMessage }
     *     
     */
    public ArrayOfLogMessage getLogMessage() {
        return logMessage;
    }

    /**
     * Define el valor de la propiedad logMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLogMessage }
     *     
     */
    public void setLogMessage(ArrayOfLogMessage value) {
        this.logMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospaginacion.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public IcmParametrospaginacionBlock getIcmParametrospaginacion() {
        return icmParametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmParametrospaginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public void setIcmParametrospaginacion(IcmParametrospaginacionBlock value) {
        this.icmParametrospaginacion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public IcmPresupuestosBlock getIcmPresupuestos() {
        return icmPresupuestos;
    }

    /**
     * Define el valor de la propiedad icmPresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public void setIcmPresupuestos(IcmPresupuestosBlock value) {
        this.icmPresupuestos = value;
    }

}
