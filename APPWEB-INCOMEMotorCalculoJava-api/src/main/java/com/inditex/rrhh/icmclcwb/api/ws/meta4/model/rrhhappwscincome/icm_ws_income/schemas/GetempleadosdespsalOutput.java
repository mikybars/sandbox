
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetempleadosdespsalOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetempleadosdespsalOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}ArrayOfLogMessage"/&gt;
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *         &lt;element name="Icm_Empleadosdespsal" type="{http://schemas.meta4.com/}Icm_EmpleadosdespsalBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetempleadosdespsalOutput", propOrder = {
    "_return",
    "logMessage",
    "icmParametrospaginacion",
    "icmEmpleadosdespsal"
})
public class GetempleadosdespsalOutput {

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfLogMessage logMessage;
    @XmlElement(name = "Icm_Parametrospaginacion", required = true, nillable = true)
    protected IcmParametrospaginacionBlock icmParametrospaginacion;
    @XmlElement(name = "Icm_Empleadosdespsal", required = true, nillable = true)
    protected IcmEmpleadosdespsalBlock icmEmpleadosdespsal;

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
     * Obtiene el valor de la propiedad icmEmpleadosdespsal.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosdespsalBlock }
     *     
     */
    public IcmEmpleadosdespsalBlock getIcmEmpleadosdespsal() {
        return icmEmpleadosdespsal;
    }

    /**
     * Define el valor de la propiedad icmEmpleadosdespsal.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosdespsalBlock }
     *     
     */
    public void setIcmEmpleadosdespsal(IcmEmpleadosdespsalBlock value) {
        this.icmEmpleadosdespsal = value;
    }

}
