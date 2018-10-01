
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_EmpleadosestructuraBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadosestructuraBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_EmpleadosestructuraRecordSet" type="{http://schemas.meta4.com/}Icm_EmpleadosestructuraRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadosestructuraBlock", propOrder = {
    "icmEmpleadosestructuraRecordSet"
})
public class IcmEmpleadosestructuraBlock {

    @XmlElement(name = "Icm_EmpleadosestructuraRecordSet", nillable = true)
    protected List<IcmEmpleadosestructuraRecord> icmEmpleadosestructuraRecordSet;

    /**
     * Gets the value of the icmEmpleadosestructuraRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmEmpleadosestructuraRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmEmpleadosestructuraRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmEmpleadosestructuraRecord }
     * 
     * 
     */
    public List<IcmEmpleadosestructuraRecord> getIcmEmpleadosestructuraRecordSet() {
        if (icmEmpleadosestructuraRecordSet == null) {
            icmEmpleadosestructuraRecordSet = new ArrayList<IcmEmpleadosestructuraRecord>();
        }
        return this.icmEmpleadosestructuraRecordSet;
    }

}
