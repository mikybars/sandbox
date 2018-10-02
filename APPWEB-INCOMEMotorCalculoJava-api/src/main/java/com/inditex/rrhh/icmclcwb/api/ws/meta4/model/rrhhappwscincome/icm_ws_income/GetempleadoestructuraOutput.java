
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetempleadoestructuraOutput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetempleadoestructuraOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}LogMessage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Icm_Empleadosestructura" type="{http://schemas.meta4.com/}Icm_EmpleadosestructuraBlock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetempleadoestructuraOutput", propOrder = {
    "_return",
    "logMessage",
    "icmEmpleadosestructura"
})
public class GetempleadoestructuraOutput {

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(nillable = true)
    protected List<LogMessage> logMessage;
    @XmlElement(name = "Icm_Empleadosestructura", required = true, nillable = true)
    protected IcmEmpleadosestructuraBlock icmEmpleadosestructura;

    /**
     * Gets the value of the return property.
     * 
     */
    public double getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
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
     * Gets the value of the icmEmpleadosestructura property.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public IcmEmpleadosestructuraBlock getIcmEmpleadosestructura() {
        return icmEmpleadosestructura;
    }

    /**
     * Sets the value of the icmEmpleadosestructura property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public void setIcmEmpleadosestructura(IcmEmpleadosestructuraBlock value) {
        this.icmEmpleadosestructura = value;
    }

}
