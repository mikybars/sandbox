
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
 *         &lt;element name="ai_sUser" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ai_sPassword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ai_sLanguage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "aiSUser",
    "aiSPassword",
    "aiSLanguage"
})
@XmlRootElement(name = "login")
public class Login implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(name = "ai_sUser", required = true)
  protected String aiSUser;

  @XmlElement(name = "ai_sPassword", required = true)
  protected String aiSPassword;

  @XmlElement(name = "ai_sLanguage", required = true)
  protected String aiSLanguage;

  /**
   * Obtiene el valor de la propiedad aiSUser.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAiSUser() {
    return aiSUser;
  }

  /**
   * Define el valor de la propiedad aiSUser.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSUser(String value) {
    this.aiSUser = value;
  }

  /**
   * Obtiene el valor de la propiedad aiSPassword.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAiSPassword() {
    return aiSPassword;
  }

  /**
   * Define el valor de la propiedad aiSPassword.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSPassword(String value) {
    this.aiSPassword = value;
  }

  /**
   * Obtiene el valor de la propiedad aiSLanguage.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAiSLanguage() {
    return aiSLanguage;
  }

  /**
   * Define el valor de la propiedad aiSLanguage.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSLanguage(String value) {
    this.aiSLanguage = value;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final Login that = ((Login) object);
    {
      String lhsAiSUser;
      lhsAiSUser = this.getAiSUser();
      String rhsAiSUser;
      rhsAiSUser = that.getAiSUser();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSUser", lhsAiSUser),
          LocatorUtils.property(thatLocator, "aiSUser", rhsAiSUser), lhsAiSUser, rhsAiSUser, (this.aiSUser != null),
          (that.aiSUser != null))) {
        return false;
      }
    }
    {
      String lhsAiSPassword;
      lhsAiSPassword = this.getAiSPassword();
      String rhsAiSPassword;
      rhsAiSPassword = that.getAiSPassword();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSPassword", lhsAiSPassword),
          LocatorUtils.property(thatLocator, "aiSPassword", rhsAiSPassword), lhsAiSPassword, rhsAiSPassword, (this.aiSPassword != null),
          (that.aiSPassword != null))) {
        return false;
      }
    }
    {
      String lhsAiSLanguage;
      lhsAiSLanguage = this.getAiSLanguage();
      String rhsAiSLanguage;
      rhsAiSLanguage = that.getAiSLanguage();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSLanguage", lhsAiSLanguage),
          LocatorUtils.property(thatLocator, "aiSLanguage", rhsAiSLanguage), lhsAiSLanguage, rhsAiSLanguage, (this.aiSLanguage != null),
          (that.aiSLanguage != null))) {
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
      String theAiSUser;
      theAiSUser = this.getAiSUser();
      strategy.appendField(locator, this, "aiSUser", buffer, theAiSUser, (this.aiSUser != null));
    }
    {
      String theAiSPassword;
      theAiSPassword = this.getAiSPassword();
      strategy.appendField(locator, this, "aiSPassword", buffer, theAiSPassword, (this.aiSPassword != null));
    }
    {
      String theAiSLanguage;
      theAiSLanguage = this.getAiSLanguage();
      strategy.appendField(locator, this, "aiSLanguage", buffer, theAiSLanguage, (this.aiSLanguage != null));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theAiSUser;
      theAiSUser = this.getAiSUser();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "aiSUser", theAiSUser), currentHashCode, theAiSUser, (this.aiSUser != null));
    }
    {
      String theAiSPassword;
      theAiSPassword = this.getAiSPassword();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSPassword", theAiSPassword), currentHashCode, theAiSPassword,
          (this.aiSPassword != null));
    }
    {
      String theAiSLanguage;
      theAiSLanguage = this.getAiSLanguage();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSLanguage", theAiSLanguage), currentHashCode, theAiSLanguage,
          (this.aiSLanguage != null));
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
    if (draftCopy instanceof Login) {
      final Login copy = ((Login) draftCopy);
      {
        Boolean aiSUserShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSUser != null));
        if (aiSUserShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceAiSUser;
          sourceAiSUser = this.getAiSUser();
          String copyAiSUser =
              ((String) strategy.copy(LocatorUtils.property(locator, "aiSUser", sourceAiSUser), sourceAiSUser, (this.aiSUser != null)));
          copy.setAiSUser(copyAiSUser);
        } else {
          if (aiSUserShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSUser = null;
          }
        }
      }
      {
        Boolean aiSPasswordShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSPassword != null));
        if (aiSPasswordShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceAiSPassword;
          sourceAiSPassword = this.getAiSPassword();
          String copyAiSPassword = ((String) strategy.copy(LocatorUtils.property(locator, "aiSPassword", sourceAiSPassword),
              sourceAiSPassword, (this.aiSPassword != null)));
          copy.setAiSPassword(copyAiSPassword);
        } else {
          if (aiSPasswordShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSPassword = null;
          }
        }
      }
      {
        Boolean aiSLanguageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSLanguage != null));
        if (aiSLanguageShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceAiSLanguage;
          sourceAiSLanguage = this.getAiSLanguage();
          String copyAiSLanguage = ((String) strategy.copy(LocatorUtils.property(locator, "aiSLanguage", sourceAiSLanguage),
              sourceAiSLanguage, (this.aiSLanguage != null)));
          copy.setAiSLanguage(copyAiSLanguage);
        } else {
          if (aiSLanguageShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSLanguage = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new Login();
  }

}
