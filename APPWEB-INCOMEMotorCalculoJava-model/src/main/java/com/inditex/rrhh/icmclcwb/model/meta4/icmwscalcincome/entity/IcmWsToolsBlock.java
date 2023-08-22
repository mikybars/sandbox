
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

/**
 * <p>Java class for Icm_Ws_ToolsBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
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
 *         &lt;element name="icm_Have_Validation" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
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
    "icmHaveValidation",
    "icmHaveIdexecution",
    "icmWsToolsRecordSet"
})
public class IcmWsToolsBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

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

  @XmlElement(name = "icm_Have_Validation", required = true, type = Double.class, nillable = true)
  protected Double icmHaveValidation;

  @XmlElement(name = "icm_Have_Idexecution", required = true, type = Double.class, nillable = true)
  protected Double icmHaveIdexecution;

  @XmlElement(name = "Icm_Ws_ToolsRecordSet", nillable = true)
  protected List<IcmWsToolsRecord> icmWsToolsRecordSet;

  /**
   * Gets the value of the sysParam property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getSysParam() {
    return sysParam;
  }

  /**
   * Sets the value of the sysParam property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setSysParam(String value) {
    this.sysParam = value;
  }

  /**
   * Gets the value of the icmPrpCopy property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmPrpCopy() {
    return icmPrpCopy;
  }

  /**
   * Sets the value of the icmPrpCopy property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmPrpCopy(Double value) {
    this.icmPrpCopy = value;
  }

  /**
   * Gets the value of the sysSentence property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getSysSentence() {
    return sysSentence;
  }

  /**
   * Sets the value of the sysSentence property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setSysSentence(String value) {
    this.sysSentence = value;
  }

  /**
   * Gets the value of the icmM4Object property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIcmM4Object() {
    return icmM4Object;
  }

  /**
   * Sets the value of the icmM4Object property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIcmM4Object(String value) {
    this.icmM4Object = value;
  }

  /**
   * Gets the value of the icmHavePaging property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmHavePaging() {
    return icmHavePaging;
  }

  /**
   * Sets the value of the icmHavePaging property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmHavePaging(Double value) {
    this.icmHavePaging = value;
  }

  /**
   * Gets the value of the icmParentNode property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIcmParentNode() {
    return icmParentNode;
  }

  /**
   * Sets the value of the icmParentNode property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIcmParentNode(String value) {
    this.icmParentNode = value;
  }

  /**
   * Gets the value of the icmSharePolicy property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmSharePolicy() {
    return icmSharePolicy;
  }

  /**
   * Sets the value of the icmSharePolicy property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmSharePolicy(Double value) {
    this.icmSharePolicy = value;
  }

  /**
   * Gets the value of the icmCloseChannel property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmCloseChannel() {
    return icmCloseChannel;
  }

  /**
   * Sets the value of the icmCloseChannel property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmCloseChannel(Double value) {
    this.icmCloseChannel = value;
  }

  /**
   * Gets the value of the icmPrpCopyType property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIcmPrpCopyType() {
    return icmPrpCopyType;
  }

  /**
   * Sets the value of the icmPrpCopyType property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIcmPrpCopyType(String value) {
    this.icmPrpCopyType = value;
  }

  /**
   * Gets the value of the icmPrpLoadType property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmPrpLoadType() {
    return icmPrpLoadType;
  }

  /**
   * Sets the value of the icmPrpLoadType property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmPrpLoadType(Double value) {
    this.icmPrpLoadType = value;
  }

  /**
   * Gets the value of the icmPrpLastLevel property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmPrpLastLevel() {
    return icmPrpLastLevel;
  }

  /**
   * Sets the value of the icmPrpLastLevel property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmPrpLastLevel(Double value) {
    this.icmPrpLastLevel = value;
  }

  /**
   * Gets the value of the icmPrpLoadDepth property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmPrpLoadDepth() {
    return icmPrpLoadDepth;
  }

  /**
   * Sets the value of the icmPrpLoadDepth property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmPrpLoadDepth(Double value) {
    this.icmPrpLoadDepth = value;
  }

  /**
   * Gets the value of the icmHaveValidation property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmHaveValidation() {
    return icmHaveValidation;
  }

  /**
   * Sets the value of the icmHaveValidation property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmHaveValidation(Double value) {
    this.icmHaveValidation = value;
  }

  /**
   * Gets the value of the icmHaveIdexecution property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getIcmHaveIdexecution() {
    return icmHaveIdexecution;
  }

  /**
   * Sets the value of the icmHaveIdexecution property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setIcmHaveIdexecution(Double value) {
    this.icmHaveIdexecution = value;
  }

  /**
   * Gets the value of the icmWsToolsRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmWsToolsRecordSet property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmWsToolsRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmWsToolsRecord }
   *
   *
   */
  public List<IcmWsToolsRecord> getIcmWsToolsRecordSet() {
    if (icmWsToolsRecordSet == null) {
      icmWsToolsRecordSet = new ArrayList<IcmWsToolsRecord>();
    }
    return this.icmWsToolsRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmWsToolsBlock that = ((IcmWsToolsBlock) object);
    {
      String lhsSysParam;
      lhsSysParam = this.getSysParam();
      String rhsSysParam;
      rhsSysParam = that.getSysParam();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "sysParam", lhsSysParam),
          LocatorUtils.property(thatLocator, "sysParam", rhsSysParam), lhsSysParam, rhsSysParam, (this.sysParam != null),
          (that.sysParam != null))) {
        return false;
      }
    }
    {
      Double lhsIcmPrpCopy;
      lhsIcmPrpCopy = this.getIcmPrpCopy();
      Double rhsIcmPrpCopy;
      rhsIcmPrpCopy = that.getIcmPrpCopy();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPrpCopy", lhsIcmPrpCopy),
          LocatorUtils.property(thatLocator, "icmPrpCopy", rhsIcmPrpCopy), lhsIcmPrpCopy, rhsIcmPrpCopy, (this.icmPrpCopy != null),
          (that.icmPrpCopy != null))) {
        return false;
      }
    }
    {
      String lhsSysSentence;
      lhsSysSentence = this.getSysSentence();
      String rhsSysSentence;
      rhsSysSentence = that.getSysSentence();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "sysSentence", lhsSysSentence),
          LocatorUtils.property(thatLocator, "sysSentence", rhsSysSentence), lhsSysSentence, rhsSysSentence, (this.sysSentence != null),
          (that.sysSentence != null))) {
        return false;
      }
    }
    {
      String lhsIcmM4Object;
      lhsIcmM4Object = this.getIcmM4Object();
      String rhsIcmM4Object;
      rhsIcmM4Object = that.getIcmM4Object();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmM4Object", lhsIcmM4Object),
          LocatorUtils.property(thatLocator, "icmM4Object", rhsIcmM4Object), lhsIcmM4Object, rhsIcmM4Object, (this.icmM4Object != null),
          (that.icmM4Object != null))) {
        return false;
      }
    }
    {
      Double lhsIcmHavePaging;
      lhsIcmHavePaging = this.getIcmHavePaging();
      Double rhsIcmHavePaging;
      rhsIcmHavePaging = that.getIcmHavePaging();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmHavePaging", lhsIcmHavePaging),
          LocatorUtils.property(thatLocator, "icmHavePaging", rhsIcmHavePaging), lhsIcmHavePaging, rhsIcmHavePaging,
          (this.icmHavePaging != null), (that.icmHavePaging != null))) {
        return false;
      }
    }
    {
      String lhsIcmParentNode;
      lhsIcmParentNode = this.getIcmParentNode();
      String rhsIcmParentNode;
      rhsIcmParentNode = that.getIcmParentNode();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParentNode", lhsIcmParentNode),
          LocatorUtils.property(thatLocator, "icmParentNode", rhsIcmParentNode), lhsIcmParentNode, rhsIcmParentNode,
          (this.icmParentNode != null), (that.icmParentNode != null))) {
        return false;
      }
    }
    {
      Double lhsIcmSharePolicy;
      lhsIcmSharePolicy = this.getIcmSharePolicy();
      Double rhsIcmSharePolicy;
      rhsIcmSharePolicy = that.getIcmSharePolicy();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmSharePolicy", lhsIcmSharePolicy),
          LocatorUtils.property(thatLocator, "icmSharePolicy", rhsIcmSharePolicy), lhsIcmSharePolicy, rhsIcmSharePolicy,
          (this.icmSharePolicy != null), (that.icmSharePolicy != null))) {
        return false;
      }
    }
    {
      Double lhsIcmCloseChannel;
      lhsIcmCloseChannel = this.getIcmCloseChannel();
      Double rhsIcmCloseChannel;
      rhsIcmCloseChannel = that.getIcmCloseChannel();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCloseChannel", lhsIcmCloseChannel),
          LocatorUtils.property(thatLocator, "icmCloseChannel", rhsIcmCloseChannel), lhsIcmCloseChannel, rhsIcmCloseChannel,
          (this.icmCloseChannel != null), (that.icmCloseChannel != null))) {
        return false;
      }
    }
    {
      String lhsIcmPrpCopyType;
      lhsIcmPrpCopyType = this.getIcmPrpCopyType();
      String rhsIcmPrpCopyType;
      rhsIcmPrpCopyType = that.getIcmPrpCopyType();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPrpCopyType", lhsIcmPrpCopyType),
          LocatorUtils.property(thatLocator, "icmPrpCopyType", rhsIcmPrpCopyType), lhsIcmPrpCopyType, rhsIcmPrpCopyType,
          (this.icmPrpCopyType != null), (that.icmPrpCopyType != null))) {
        return false;
      }
    }
    {
      Double lhsIcmPrpLoadType;
      lhsIcmPrpLoadType = this.getIcmPrpLoadType();
      Double rhsIcmPrpLoadType;
      rhsIcmPrpLoadType = that.getIcmPrpLoadType();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPrpLoadType", lhsIcmPrpLoadType),
          LocatorUtils.property(thatLocator, "icmPrpLoadType", rhsIcmPrpLoadType), lhsIcmPrpLoadType, rhsIcmPrpLoadType,
          (this.icmPrpLoadType != null), (that.icmPrpLoadType != null))) {
        return false;
      }
    }
    {
      Double lhsIcmPrpLastLevel;
      lhsIcmPrpLastLevel = this.getIcmPrpLastLevel();
      Double rhsIcmPrpLastLevel;
      rhsIcmPrpLastLevel = that.getIcmPrpLastLevel();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPrpLastLevel", lhsIcmPrpLastLevel),
          LocatorUtils.property(thatLocator, "icmPrpLastLevel", rhsIcmPrpLastLevel), lhsIcmPrpLastLevel, rhsIcmPrpLastLevel,
          (this.icmPrpLastLevel != null), (that.icmPrpLastLevel != null))) {
        return false;
      }
    }
    {
      Double lhsIcmPrpLoadDepth;
      lhsIcmPrpLoadDepth = this.getIcmPrpLoadDepth();
      Double rhsIcmPrpLoadDepth;
      rhsIcmPrpLoadDepth = that.getIcmPrpLoadDepth();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPrpLoadDepth", lhsIcmPrpLoadDepth),
          LocatorUtils.property(thatLocator, "icmPrpLoadDepth", rhsIcmPrpLoadDepth), lhsIcmPrpLoadDepth, rhsIcmPrpLoadDepth,
          (this.icmPrpLoadDepth != null), (that.icmPrpLoadDepth != null))) {
        return false;
      }
    }
    {
      Double lhsIcmHaveValidation;
      lhsIcmHaveValidation = this.getIcmHaveValidation();
      Double rhsIcmHaveValidation;
      rhsIcmHaveValidation = that.getIcmHaveValidation();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmHaveValidation", lhsIcmHaveValidation),
          LocatorUtils.property(thatLocator, "icmHaveValidation", rhsIcmHaveValidation), lhsIcmHaveValidation, rhsIcmHaveValidation,
          (this.icmHaveValidation != null), (that.icmHaveValidation != null))) {
        return false;
      }
    }
    {
      Double lhsIcmHaveIdexecution;
      lhsIcmHaveIdexecution = this.getIcmHaveIdexecution();
      Double rhsIcmHaveIdexecution;
      rhsIcmHaveIdexecution = that.getIcmHaveIdexecution();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmHaveIdexecution", lhsIcmHaveIdexecution),
          LocatorUtils.property(thatLocator, "icmHaveIdexecution", rhsIcmHaveIdexecution), lhsIcmHaveIdexecution, rhsIcmHaveIdexecution,
          (this.icmHaveIdexecution != null), (that.icmHaveIdexecution != null))) {
        return false;
      }
    }
    {
      List<IcmWsToolsRecord> lhsIcmWsToolsRecordSet;
      lhsIcmWsToolsRecordSet =
          (((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())) ? this.getIcmWsToolsRecordSet() : null);
      List<IcmWsToolsRecord> rhsIcmWsToolsRecordSet;
      rhsIcmWsToolsRecordSet =
          (((that.icmWsToolsRecordSet != null) && (!that.icmWsToolsRecordSet.isEmpty())) ? that.getIcmWsToolsRecordSet() : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsToolsRecordSet", lhsIcmWsToolsRecordSet),
          LocatorUtils.property(thatLocator, "icmWsToolsRecordSet", rhsIcmWsToolsRecordSet), lhsIcmWsToolsRecordSet, rhsIcmWsToolsRecordSet,
          ((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())),
          ((that.icmWsToolsRecordSet != null) && (!that.icmWsToolsRecordSet.isEmpty())))) {
        return false;
      }
    }
    return true;
  }

  public boolean equals(Object object) {
    final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
    return equals(null, null, object, strategy);
  }

  public String toString() {
    final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
    final StringBuilder buffer = new StringBuilder();
    append(null, buffer, strategy);
    return buffer.toString();
  }

  public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
    strategy.appendStart(locator, this, buffer);
    appendFields(locator, buffer, strategy);
    strategy.appendEnd(locator, this, buffer);
    return buffer;
  }

  public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
    {
      String theSysParam;
      theSysParam = this.getSysParam();
      strategy.appendField(locator, this, "sysParam", buffer, theSysParam, (this.sysParam != null));
    }
    {
      Double theIcmPrpCopy;
      theIcmPrpCopy = this.getIcmPrpCopy();
      strategy.appendField(locator, this, "icmPrpCopy", buffer, theIcmPrpCopy, (this.icmPrpCopy != null));
    }
    {
      String theSysSentence;
      theSysSentence = this.getSysSentence();
      strategy.appendField(locator, this, "sysSentence", buffer, theSysSentence, (this.sysSentence != null));
    }
    {
      String theIcmM4Object;
      theIcmM4Object = this.getIcmM4Object();
      strategy.appendField(locator, this, "icmM4Object", buffer, theIcmM4Object, (this.icmM4Object != null));
    }
    {
      Double theIcmHavePaging;
      theIcmHavePaging = this.getIcmHavePaging();
      strategy.appendField(locator, this, "icmHavePaging", buffer, theIcmHavePaging, (this.icmHavePaging != null));
    }
    {
      String theIcmParentNode;
      theIcmParentNode = this.getIcmParentNode();
      strategy.appendField(locator, this, "icmParentNode", buffer, theIcmParentNode, (this.icmParentNode != null));
    }
    {
      Double theIcmSharePolicy;
      theIcmSharePolicy = this.getIcmSharePolicy();
      strategy.appendField(locator, this, "icmSharePolicy", buffer, theIcmSharePolicy, (this.icmSharePolicy != null));
    }
    {
      Double theIcmCloseChannel;
      theIcmCloseChannel = this.getIcmCloseChannel();
      strategy.appendField(locator, this, "icmCloseChannel", buffer, theIcmCloseChannel, (this.icmCloseChannel != null));
    }
    {
      String theIcmPrpCopyType;
      theIcmPrpCopyType = this.getIcmPrpCopyType();
      strategy.appendField(locator, this, "icmPrpCopyType", buffer, theIcmPrpCopyType, (this.icmPrpCopyType != null));
    }
    {
      Double theIcmPrpLoadType;
      theIcmPrpLoadType = this.getIcmPrpLoadType();
      strategy.appendField(locator, this, "icmPrpLoadType", buffer, theIcmPrpLoadType, (this.icmPrpLoadType != null));
    }
    {
      Double theIcmPrpLastLevel;
      theIcmPrpLastLevel = this.getIcmPrpLastLevel();
      strategy.appendField(locator, this, "icmPrpLastLevel", buffer, theIcmPrpLastLevel, (this.icmPrpLastLevel != null));
    }
    {
      Double theIcmPrpLoadDepth;
      theIcmPrpLoadDepth = this.getIcmPrpLoadDepth();
      strategy.appendField(locator, this, "icmPrpLoadDepth", buffer, theIcmPrpLoadDepth, (this.icmPrpLoadDepth != null));
    }
    {
      Double theIcmHaveValidation;
      theIcmHaveValidation = this.getIcmHaveValidation();
      strategy.appendField(locator, this, "icmHaveValidation", buffer, theIcmHaveValidation, (this.icmHaveValidation != null));
    }
    {
      Double theIcmHaveIdexecution;
      theIcmHaveIdexecution = this.getIcmHaveIdexecution();
      strategy.appendField(locator, this, "icmHaveIdexecution", buffer, theIcmHaveIdexecution, (this.icmHaveIdexecution != null));
    }
    {
      List<IcmWsToolsRecord> theIcmWsToolsRecordSet;
      theIcmWsToolsRecordSet =
          (((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())) ? this.getIcmWsToolsRecordSet() : null);
      strategy.appendField(locator, this, "icmWsToolsRecordSet", buffer, theIcmWsToolsRecordSet,
          ((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theSysParam;
      theSysParam = this.getSysParam();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "sysParam", theSysParam), currentHashCode, theSysParam, (this.sysParam != null));
    }
    {
      Double theIcmPrpCopy;
      theIcmPrpCopy = this.getIcmPrpCopy();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPrpCopy", theIcmPrpCopy), currentHashCode, theIcmPrpCopy,
          (this.icmPrpCopy != null));
    }
    {
      String theSysSentence;
      theSysSentence = this.getSysSentence();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sysSentence", theSysSentence), currentHashCode, theSysSentence,
          (this.sysSentence != null));
    }
    {
      String theIcmM4Object;
      theIcmM4Object = this.getIcmM4Object();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmM4Object", theIcmM4Object), currentHashCode, theIcmM4Object,
          (this.icmM4Object != null));
    }
    {
      Double theIcmHavePaging;
      theIcmHavePaging = this.getIcmHavePaging();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmHavePaging", theIcmHavePaging), currentHashCode,
          theIcmHavePaging, (this.icmHavePaging != null));
    }
    {
      String theIcmParentNode;
      theIcmParentNode = this.getIcmParentNode();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParentNode", theIcmParentNode), currentHashCode,
          theIcmParentNode, (this.icmParentNode != null));
    }
    {
      Double theIcmSharePolicy;
      theIcmSharePolicy = this.getIcmSharePolicy();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmSharePolicy", theIcmSharePolicy), currentHashCode,
          theIcmSharePolicy, (this.icmSharePolicy != null));
    }
    {
      Double theIcmCloseChannel;
      theIcmCloseChannel = this.getIcmCloseChannel();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCloseChannel", theIcmCloseChannel), currentHashCode,
          theIcmCloseChannel, (this.icmCloseChannel != null));
    }
    {
      String theIcmPrpCopyType;
      theIcmPrpCopyType = this.getIcmPrpCopyType();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPrpCopyType", theIcmPrpCopyType), currentHashCode,
          theIcmPrpCopyType, (this.icmPrpCopyType != null));
    }
    {
      Double theIcmPrpLoadType;
      theIcmPrpLoadType = this.getIcmPrpLoadType();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPrpLoadType", theIcmPrpLoadType), currentHashCode,
          theIcmPrpLoadType, (this.icmPrpLoadType != null));
    }
    {
      Double theIcmPrpLastLevel;
      theIcmPrpLastLevel = this.getIcmPrpLastLevel();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPrpLastLevel", theIcmPrpLastLevel), currentHashCode,
          theIcmPrpLastLevel, (this.icmPrpLastLevel != null));
    }
    {
      Double theIcmPrpLoadDepth;
      theIcmPrpLoadDepth = this.getIcmPrpLoadDepth();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPrpLoadDepth", theIcmPrpLoadDepth), currentHashCode,
          theIcmPrpLoadDepth, (this.icmPrpLoadDepth != null));
    }
    {
      Double theIcmHaveValidation;
      theIcmHaveValidation = this.getIcmHaveValidation();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmHaveValidation", theIcmHaveValidation), currentHashCode,
          theIcmHaveValidation, (this.icmHaveValidation != null));
    }
    {
      Double theIcmHaveIdexecution;
      theIcmHaveIdexecution = this.getIcmHaveIdexecution();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmHaveIdexecution", theIcmHaveIdexecution), currentHashCode,
          theIcmHaveIdexecution, (this.icmHaveIdexecution != null));
    }
    {
      List<IcmWsToolsRecord> theIcmWsToolsRecordSet;
      theIcmWsToolsRecordSet =
          (((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())) ? this.getIcmWsToolsRecordSet() : null);
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsToolsRecordSet", theIcmWsToolsRecordSet), currentHashCode,
          theIcmWsToolsRecordSet, ((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())));
    }
    return currentHashCode;
  }

  public int hashCode() {
    final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
    return this.hashCode(null, strategy);
  }

  public Object clone() {
    return copyTo(createNewInstance());
  }

  public Object copyTo(Object target) {
    final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
    return copyTo(null, target, strategy);
  }

  public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
    final Object draftCopy = ((target == null) ? createNewInstance() : target);
    if (draftCopy instanceof IcmWsToolsBlock) {
      final IcmWsToolsBlock copy = ((IcmWsToolsBlock) draftCopy);
      {
        Boolean sysParamShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.sysParam != null));
        if (sysParamShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceSysParam;
          sourceSysParam = this.getSysParam();
          String copySysParam =
              ((String) strategy.copy(LocatorUtils.property(locator, "sysParam", sourceSysParam), sourceSysParam, (this.sysParam != null)));
          copy.setSysParam(copySysParam);
        } else {
          if (sysParamShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.sysParam = null;
          }
        }
      }
      {
        Boolean icmPrpCopyShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPrpCopy != null));
        if (icmPrpCopyShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmPrpCopy;
          sourceIcmPrpCopy = this.getIcmPrpCopy();
          Double copyIcmPrpCopy = ((Double) strategy.copy(LocatorUtils.property(locator, "icmPrpCopy", sourceIcmPrpCopy), sourceIcmPrpCopy,
              (this.icmPrpCopy != null)));
          copy.setIcmPrpCopy(copyIcmPrpCopy);
        } else {
          if (icmPrpCopyShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmPrpCopy = null;
          }
        }
      }
      {
        Boolean sysSentenceShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.sysSentence != null));
        if (sysSentenceShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceSysSentence;
          sourceSysSentence = this.getSysSentence();
          String copySysSentence = ((String) strategy.copy(LocatorUtils.property(locator, "sysSentence", sourceSysSentence),
              sourceSysSentence, (this.sysSentence != null)));
          copy.setSysSentence(copySysSentence);
        } else {
          if (sysSentenceShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.sysSentence = null;
          }
        }
      }
      {
        Boolean icmM4ObjectShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmM4Object != null));
        if (icmM4ObjectShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIcmM4Object;
          sourceIcmM4Object = this.getIcmM4Object();
          String copyIcmM4Object = ((String) strategy.copy(LocatorUtils.property(locator, "icmM4Object", sourceIcmM4Object),
              sourceIcmM4Object, (this.icmM4Object != null)));
          copy.setIcmM4Object(copyIcmM4Object);
        } else {
          if (icmM4ObjectShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmM4Object = null;
          }
        }
      }
      {
        Boolean icmHavePagingShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmHavePaging != null));
        if (icmHavePagingShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmHavePaging;
          sourceIcmHavePaging = this.getIcmHavePaging();
          Double copyIcmHavePaging = ((Double) strategy.copy(LocatorUtils.property(locator, "icmHavePaging", sourceIcmHavePaging),
              sourceIcmHavePaging, (this.icmHavePaging != null)));
          copy.setIcmHavePaging(copyIcmHavePaging);
        } else {
          if (icmHavePagingShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmHavePaging = null;
          }
        }
      }
      {
        Boolean icmParentNodeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParentNode != null));
        if (icmParentNodeShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIcmParentNode;
          sourceIcmParentNode = this.getIcmParentNode();
          String copyIcmParentNode = ((String) strategy.copy(LocatorUtils.property(locator, "icmParentNode", sourceIcmParentNode),
              sourceIcmParentNode, (this.icmParentNode != null)));
          copy.setIcmParentNode(copyIcmParentNode);
        } else {
          if (icmParentNodeShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParentNode = null;
          }
        }
      }
      {
        Boolean icmSharePolicyShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmSharePolicy != null));
        if (icmSharePolicyShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmSharePolicy;
          sourceIcmSharePolicy = this.getIcmSharePolicy();
          Double copyIcmSharePolicy = ((Double) strategy.copy(LocatorUtils.property(locator, "icmSharePolicy", sourceIcmSharePolicy),
              sourceIcmSharePolicy, (this.icmSharePolicy != null)));
          copy.setIcmSharePolicy(copyIcmSharePolicy);
        } else {
          if (icmSharePolicyShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmSharePolicy = null;
          }
        }
      }
      {
        Boolean icmCloseChannelShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmCloseChannel != null));
        if (icmCloseChannelShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmCloseChannel;
          sourceIcmCloseChannel = this.getIcmCloseChannel();
          Double copyIcmCloseChannel = ((Double) strategy.copy(LocatorUtils.property(locator, "icmCloseChannel", sourceIcmCloseChannel),
              sourceIcmCloseChannel, (this.icmCloseChannel != null)));
          copy.setIcmCloseChannel(copyIcmCloseChannel);
        } else {
          if (icmCloseChannelShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmCloseChannel = null;
          }
        }
      }
      {
        Boolean icmPrpCopyTypeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPrpCopyType != null));
        if (icmPrpCopyTypeShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIcmPrpCopyType;
          sourceIcmPrpCopyType = this.getIcmPrpCopyType();
          String copyIcmPrpCopyType = ((String) strategy.copy(LocatorUtils.property(locator, "icmPrpCopyType", sourceIcmPrpCopyType),
              sourceIcmPrpCopyType, (this.icmPrpCopyType != null)));
          copy.setIcmPrpCopyType(copyIcmPrpCopyType);
        } else {
          if (icmPrpCopyTypeShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmPrpCopyType = null;
          }
        }
      }
      {
        Boolean icmPrpLoadTypeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPrpLoadType != null));
        if (icmPrpLoadTypeShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmPrpLoadType;
          sourceIcmPrpLoadType = this.getIcmPrpLoadType();
          Double copyIcmPrpLoadType = ((Double) strategy.copy(LocatorUtils.property(locator, "icmPrpLoadType", sourceIcmPrpLoadType),
              sourceIcmPrpLoadType, (this.icmPrpLoadType != null)));
          copy.setIcmPrpLoadType(copyIcmPrpLoadType);
        } else {
          if (icmPrpLoadTypeShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmPrpLoadType = null;
          }
        }
      }
      {
        Boolean icmPrpLastLevelShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPrpLastLevel != null));
        if (icmPrpLastLevelShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmPrpLastLevel;
          sourceIcmPrpLastLevel = this.getIcmPrpLastLevel();
          Double copyIcmPrpLastLevel = ((Double) strategy.copy(LocatorUtils.property(locator, "icmPrpLastLevel", sourceIcmPrpLastLevel),
              sourceIcmPrpLastLevel, (this.icmPrpLastLevel != null)));
          copy.setIcmPrpLastLevel(copyIcmPrpLastLevel);
        } else {
          if (icmPrpLastLevelShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmPrpLastLevel = null;
          }
        }
      }
      {
        Boolean icmPrpLoadDepthShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmPrpLoadDepth != null));
        if (icmPrpLoadDepthShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmPrpLoadDepth;
          sourceIcmPrpLoadDepth = this.getIcmPrpLoadDepth();
          Double copyIcmPrpLoadDepth = ((Double) strategy.copy(LocatorUtils.property(locator, "icmPrpLoadDepth", sourceIcmPrpLoadDepth),
              sourceIcmPrpLoadDepth, (this.icmPrpLoadDepth != null)));
          copy.setIcmPrpLoadDepth(copyIcmPrpLoadDepth);
        } else {
          if (icmPrpLoadDepthShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmPrpLoadDepth = null;
          }
        }
      }
      {
        Boolean icmHaveValidationShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmHaveValidation != null));
        if (icmHaveValidationShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmHaveValidation;
          sourceIcmHaveValidation = this.getIcmHaveValidation();
          Double copyIcmHaveValidation =
              ((Double) strategy.copy(LocatorUtils.property(locator, "icmHaveValidation", sourceIcmHaveValidation), sourceIcmHaveValidation,
                  (this.icmHaveValidation != null)));
          copy.setIcmHaveValidation(copyIcmHaveValidation);
        } else {
          if (icmHaveValidationShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmHaveValidation = null;
          }
        }
      }
      {
        Boolean icmHaveIdexecutionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmHaveIdexecution != null));
        if (icmHaveIdexecutionShouldBeCopiedAndSet == Boolean.TRUE) {
          Double sourceIcmHaveIdexecution;
          sourceIcmHaveIdexecution = this.getIcmHaveIdexecution();
          Double copyIcmHaveIdexecution =
              ((Double) strategy.copy(LocatorUtils.property(locator, "icmHaveIdexecution", sourceIcmHaveIdexecution),
                  sourceIcmHaveIdexecution, (this.icmHaveIdexecution != null)));
          copy.setIcmHaveIdexecution(copyIcmHaveIdexecution);
        } else {
          if (icmHaveIdexecutionShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmHaveIdexecution = null;
          }
        }
      }
      {
        Boolean icmWsToolsRecordSetShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, ((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())));
        if (icmWsToolsRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmWsToolsRecord> sourceIcmWsToolsRecordSet;
          sourceIcmWsToolsRecordSet =
              (((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty())) ? this.getIcmWsToolsRecordSet() : null);
          @SuppressWarnings("unchecked")
          List<IcmWsToolsRecord> copyIcmWsToolsRecordSet =
              ((List<IcmWsToolsRecord>) strategy.copy(LocatorUtils.property(locator, "icmWsToolsRecordSet", sourceIcmWsToolsRecordSet),
                  sourceIcmWsToolsRecordSet, ((this.icmWsToolsRecordSet != null) && (!this.icmWsToolsRecordSet.isEmpty()))));
          copy.icmWsToolsRecordSet = null;
          if (copyIcmWsToolsRecordSet != null) {
            List<IcmWsToolsRecord> uniqueIcmWsToolsRecordSetl = copy.getIcmWsToolsRecordSet();
            uniqueIcmWsToolsRecordSetl.addAll(copyIcmWsToolsRecordSet);
          }
        } else {
          if (icmWsToolsRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmWsToolsRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmWsToolsBlock();
  }

}
