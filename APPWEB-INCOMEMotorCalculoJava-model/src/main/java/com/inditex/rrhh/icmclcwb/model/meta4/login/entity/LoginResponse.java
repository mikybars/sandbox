
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loginReturn" type="{http://schemas.meta4.com/}M4loginOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "loginReturn"
})
@XmlRootElement(name = "loginResponse")
public class LoginResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true)
  protected M4LoginOutput loginReturn;

  /**
   * Obtiene el valor de la propiedad loginReturn.
   *
   * @return possible object is {@link M4LoginOutput }
   *
   */
  public M4LoginOutput getLoginReturn() {
    return loginReturn;
  }

  /**
   * Define el valor de la propiedad loginReturn.
   *
   * @param value allowed object is {@link M4LoginOutput }
   *
   */
  public void setLoginReturn(M4LoginOutput value) {
    this.loginReturn = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final LoginResponse that = ((LoginResponse) object);
    {
      M4LoginOutput lhsLoginReturn;
      lhsLoginReturn = this.getLoginReturn();
      M4LoginOutput rhsLoginReturn;
      rhsLoginReturn = that.getLoginReturn();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "loginReturn", lhsLoginReturn),
          LocatorUtils.property(thatLocator, "loginReturn", rhsLoginReturn), lhsLoginReturn, rhsLoginReturn, (this.loginReturn != null),
          (that.loginReturn != null))) {
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
      M4LoginOutput theLoginReturn;
      theLoginReturn = this.getLoginReturn();
      strategy.appendField(locator, this, "loginReturn", buffer, theLoginReturn, (this.loginReturn != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      M4LoginOutput theLoginReturn;
      theLoginReturn = this.getLoginReturn();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "loginReturn", theLoginReturn), currentHashCode, theLoginReturn,
          (this.loginReturn != null));
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
    if (draftCopy instanceof LoginResponse) {
      final LoginResponse copy = ((LoginResponse) draftCopy);
      {
        Boolean loginReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.loginReturn != null));
        if (loginReturnShouldBeCopiedAndSet == Boolean.TRUE) {
          M4LoginOutput sourceLoginReturn;
          sourceLoginReturn = this.getLoginReturn();
          M4LoginOutput copyLoginReturn = ((M4LoginOutput) strategy.copy(LocatorUtils.property(locator, "loginReturn", sourceLoginReturn),
              sourceLoginReturn, (this.loginReturn != null)));
          copy.setLoginReturn(copyLoginReturn);
        } else {
          if (loginReturnShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.loginReturn = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new LoginResponse();
  }

}
