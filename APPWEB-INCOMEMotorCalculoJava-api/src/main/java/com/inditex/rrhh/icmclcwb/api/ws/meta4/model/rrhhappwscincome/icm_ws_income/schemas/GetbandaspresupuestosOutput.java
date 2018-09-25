
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetbandaspresupuestosOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetbandaspresupuestosOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}ArrayOfLogMessage"/&gt;
 *         &lt;element name="Icm_Bandaspresupuestos" type="{http://schemas.meta4.com/}Icm_BandaspresupuestosBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetbandaspresupuestosOutput", propOrder = {
    "_return",
    "logMessage",
    "icmBandaspresupuestos"
})
public class GetbandaspresupuestosOutput {

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfLogMessage logMessage;
    @XmlElement(name = "Icm_Bandaspresupuestos", required = true, nillable = true)
    protected IcmBandaspresupuestosBlock icmBandaspresupuestos;

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
     * Obtiene el valor de la propiedad icmBandaspresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmBandaspresupuestosBlock }
     *     
     */
    public IcmBandaspresupuestosBlock getIcmBandaspresupuestos() {
        return icmBandaspresupuestos;
    }

    /**
     * Define el valor de la propiedad icmBandaspresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmBandaspresupuestosBlock }
     *     
     */
    public void setIcmBandaspresupuestos(IcmBandaspresupuestosBlock value) {
        this.icmBandaspresupuestos = value;
    }

}
