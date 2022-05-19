
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

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
 * <p>Clase Java para M4loginOutput complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="M4loginOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "M4loginOutput", propOrder = {
    "sessionID"
})
public class M4LoginOutput implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String sessionID;

  /**
   * Obtiene el valor de la propiedad sessionID.
   *
   * @return possible object is {@link String }
   *
   */
  public String getSessionID() {
    return sessionID;
  }

  /**
   * Define el valor de la propiedad sessionID.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setSessionID(String value) {
    this.sessionID = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final M4LoginOutput that = ((M4LoginOutput) object);
    {
      String lhsSessionID;
      lhsSessionID = this.getSessionID();
      String rhsSessionID;
      rhsSessionID = that.getSessionID();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "sessionID", lhsSessionID),
          LocatorUtils.property(thatLocator, "sessionID", rhsSessionID), lhsSessionID, rhsSessionID, (this.sessionID != null),
          (that.sessionID != null))) {
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
      String theSessionID;
      theSessionID = this.getSessionID();
      strategy.appendField(locator, this, "sessionID", buffer, theSessionID, (this.sessionID != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theSessionID;
      theSessionID = this.getSessionID();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sessionID", theSessionID), currentHashCode, theSessionID,
          (this.sessionID != null));
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
    if (draftCopy instanceof M4LoginOutput) {
      final M4LoginOutput copy = ((M4LoginOutput) draftCopy);
      {
        Boolean sessionIDShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.sessionID != null));
        if (sessionIDShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceSessionID;
          sourceSessionID = this.getSessionID();
          String copySessionID = ((String) strategy.copy(LocatorUtils.property(locator, "sessionID", sourceSessionID), sourceSessionID,
              (this.sessionID != null)));
          copy.setSessionID(copySessionID);
        } else {
          if (sessionIDShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.sessionID = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new M4LoginOutput();
  }

}
