
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_Ws_ToolsBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_Ws_ToolsBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sys_Param" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="icm_Prp_Copy" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="sys_Sentence" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="icm_M4_Object" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="icm_Have_Paging" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="icm_Parent_Node" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="icm_Share_Policy" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="icm_Close_Channel" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="icm_Prp_Copy_Type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="icm_Prp_Load_Type" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="icm_Prp_Last_Level" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="icm_Prp_Load_Depth" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="icm_Have_Idexecution" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Icm_Ws_ToolsRecordSet" type="{http://schemas.meta4.com/}Icm_Ws_ToolsRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_Ws_ToolsBlock", propOrder = {
    "sysParam",
    "icmPrpCopy",
    "sysSentence",
    "icmM4Object",
    "icmHavePaging",
    "icmParentNode",
    "icmSharePolicy",
    "icmCloseChannel",
    "icmPrpCopyType",
    "icmPrpLoadType",
    "icmPrpLastLevel",
    "icmPrpLoadDepth",
    "icmHaveIdexecution",
    "icmWsToolsRecordSet"
})
public class IcmWsToolsBlock {

    @XmlElement(name = "sys_Param", required = true, nillable = true)
    protected String sysParam;
    @XmlElement(name = "icm_Prp_Copy", required = true, type = Double.class, nillable = true)
    protected Double icmPrpCopy;
    @XmlElement(name = "sys_Sentence", required = true, nillable = true)
    protected String sysSentence;
    @XmlElement(name = "icm_M4_Object", required = true, nillable = true)
    protected String icmM4Object;
    @XmlElement(name = "icm_Have_Paging", required = true, type = Double.class, nillable = true)
    protected Double icmHavePaging;
    @XmlElement(name = "icm_Parent_Node", required = true, nillable = true)
    protected String icmParentNode;
    @XmlElement(name = "icm_Share_Policy", required = true, type = Double.class, nillable = true)
    protected Double icmSharePolicy;
    @XmlElement(name = "icm_Close_Channel", required = true, type = Double.class, nillable = true)
    protected Double icmCloseChannel;
    @XmlElement(name = "icm_Prp_Copy_Type", required = true, nillable = true)
    protected String icmPrpCopyType;
    @XmlElement(name = "icm_Prp_Load_Type", required = true, type = Double.class, nillable = true)
    protected Double icmPrpLoadType;
    @XmlElement(name = "icm_Prp_Last_Level", required = true, type = Double.class, nillable = true)
    protected Double icmPrpLastLevel;
    @XmlElement(name = "icm_Prp_Load_Depth", required = true, type = Double.class, nillable = true)
    protected Double icmPrpLoadDepth;
    @XmlElement(name = "icm_Have_Idexecution", required = true, type = Double.class, nillable = true)
    protected Double icmHaveIdexecution;
    @XmlElement(name = "Icm_Ws_ToolsRecordSet", nillable = true)
    protected List<IcmWsToolsRecord> icmWsToolsRecordSet;

    /**
     * Obtiene el valor de la propiedad sysParam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysParam() {
        return sysParam;
    }

    /**
     * Define el valor de la propiedad sysParam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysParam(String value) {
        this.sysParam = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPrpCopy.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmPrpCopy() {
        return icmPrpCopy;
    }

    /**
     * Define el valor de la propiedad icmPrpCopy.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmPrpCopy(Double value) {
        this.icmPrpCopy = value;
    }

    /**
     * Obtiene el valor de la propiedad sysSentence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysSentence() {
        return sysSentence;
    }

    /**
     * Define el valor de la propiedad sysSentence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysSentence(String value) {
        this.sysSentence = value;
    }

    /**
     * Obtiene el valor de la propiedad icmM4Object.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcmM4Object() {
        return icmM4Object;
    }

    /**
     * Define el valor de la propiedad icmM4Object.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcmM4Object(String value) {
        this.icmM4Object = value;
    }

    /**
     * Obtiene el valor de la propiedad icmHavePaging.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmHavePaging() {
        return icmHavePaging;
    }

    /**
     * Define el valor de la propiedad icmHavePaging.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmHavePaging(Double value) {
        this.icmHavePaging = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParentNode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcmParentNode() {
        return icmParentNode;
    }

    /**
     * Define el valor de la propiedad icmParentNode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcmParentNode(String value) {
        this.icmParentNode = value;
    }

    /**
     * Obtiene el valor de la propiedad icmSharePolicy.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmSharePolicy() {
        return icmSharePolicy;
    }

    /**
     * Define el valor de la propiedad icmSharePolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmSharePolicy(Double value) {
        this.icmSharePolicy = value;
    }

    /**
     * Obtiene el valor de la propiedad icmCloseChannel.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmCloseChannel() {
        return icmCloseChannel;
    }

    /**
     * Define el valor de la propiedad icmCloseChannel.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmCloseChannel(Double value) {
        this.icmCloseChannel = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPrpCopyType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcmPrpCopyType() {
        return icmPrpCopyType;
    }

    /**
     * Define el valor de la propiedad icmPrpCopyType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcmPrpCopyType(String value) {
        this.icmPrpCopyType = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPrpLoadType.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmPrpLoadType() {
        return icmPrpLoadType;
    }

    /**
     * Define el valor de la propiedad icmPrpLoadType.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmPrpLoadType(Double value) {
        this.icmPrpLoadType = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPrpLastLevel.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmPrpLastLevel() {
        return icmPrpLastLevel;
    }

    /**
     * Define el valor de la propiedad icmPrpLastLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmPrpLastLevel(Double value) {
        this.icmPrpLastLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad icmPrpLoadDepth.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmPrpLoadDepth() {
        return icmPrpLoadDepth;
    }

    /**
     * Define el valor de la propiedad icmPrpLoadDepth.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmPrpLoadDepth(Double value) {
        this.icmPrpLoadDepth = value;
    }

    /**
     * Obtiene el valor de la propiedad icmHaveIdexecution.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIcmHaveIdexecution() {
        return icmHaveIdexecution;
    }

    /**
     * Define el valor de la propiedad icmHaveIdexecution.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIcmHaveIdexecution(Double value) {
        this.icmHaveIdexecution = value;
    }

    /**
     * Gets the value of the icmWsToolsRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmWsToolsRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmWsToolsRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmWsToolsRecord }
     * 
     * 
     */
    public List<IcmWsToolsRecord> getIcmWsToolsRecordSet() {
        if (icmWsToolsRecordSet == null) {
            icmWsToolsRecordSet = new ArrayList<IcmWsToolsRecord>();
        }
        return this.icmWsToolsRecordSet;
    }

}
