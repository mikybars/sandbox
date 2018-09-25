
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetdatosgenempleadoOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetdatosgenempleadoOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}ArrayOfLogMessage"/&gt;
 *         &lt;element name="Icm_Datosgenempleado" type="{http://schemas.meta4.com/}Icm_DatosgenempleadoBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetdatosgenempleadoOutput", propOrder = {
    "_return",
    "logMessage",
    "icmDatosgenempleado"
})
public class GetdatosgenempleadoOutput {

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfLogMessage logMessage;
    @XmlElement(name = "Icm_Datosgenempleado", required = true, nillable = true)
    protected IcmDatosgenempleadoBlock icmDatosgenempleado;

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
     * Obtiene el valor de la propiedad icmDatosgenempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmDatosgenempleadoBlock }
     *     
     */
    public IcmDatosgenempleadoBlock getIcmDatosgenempleado() {
        return icmDatosgenempleado;
    }

    /**
     * Define el valor de la propiedad icmDatosgenempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmDatosgenempleadoBlock }
     *     
     */
    public void setIcmDatosgenempleado(IcmDatosgenempleadoBlock value) {
        this.icmDatosgenempleado = value;
    }

}
