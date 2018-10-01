
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GetventamanualOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetventamanualOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}LogMessage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Icm_Ventamanual" type="{http://schemas.meta4.com/}Icm_VentamanualBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetventamanualOutput", propOrder = {
    "_return",
    "logMessage",
    "icmVentamanual"
})
public class GetventamanualOutput {

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(nillable = true)
    protected List<LogMessage> logMessage;
    @XmlElement(name = "Icm_Ventamanual", required = true, nillable = true)
    protected IcmVentamanualBlock icmVentamanual;

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
     * Gets the value of the logMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessage }
     * 
     * 
     */
    public List<LogMessage> getLogMessage() {
        if (logMessage == null) {
            logMessage = new ArrayList<LogMessage>();
        }
        return this.logMessage;
    }

    /**
     * Obtiene el valor de la propiedad icmVentamanual.
     * 
     * @return
     *     possible object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public IcmVentamanualBlock getIcmVentamanual() {
        return icmVentamanual;
    }

    /**
     * Define el valor de la propiedad icmVentamanual.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public void setIcmVentamanual(IcmVentamanualBlock value) {
        this.icmVentamanual = value;
    }

}
