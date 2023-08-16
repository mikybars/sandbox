
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.inditex.rrhh.icmclcwb.model.meta4.login.entity.generated package. <p>An ObjectFactory allows you to programatically construct new
 * instances of the Java representation for XML content. The Java representation of XML content can consist of schema derived interfaces and
 * classes representing the binding of schema type definitions, element declarations and model groups. Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _Fault_QNAME = new QName("http://schemas.meta4.com/", "fault");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
   * com.inditex.rrhh.icmclcwb.model.meta4.login.entity.generated
   *
   */
  public ObjectFactory() {
  }

  /**
   * Create an instance of {@link LoginWithCertificate }
   *
   */
  public LoginWithCertificate createLoginWithCertificate() {
    return new LoginWithCertificate();
  }

  /**
   * Create an instance of {@link LoginWithCertificateResponse }
   *
   */
  public LoginWithCertificateResponse createLoginWithCertificateResponse() {
    return new LoginWithCertificateResponse();
  }

  /**
   * Create an instance of {@link M4LoginOutput }
   *
   */
  public M4LoginOutput createM4LoginOutput() {
    return new M4LoginOutput();
  }

  /**
   * Create an instance of {@link M4SoapException }
   *
   */
  public M4SoapException createM4SoapException() {
    return new M4SoapException();
  }

  /**
   * Create an instance of {@link LoginWithRole }
   *
   */
  public LoginWithRole createLoginWithRole() {
    return new LoginWithRole();
  }

  /**
   * Create an instance of {@link LoginWithRoleResponse }
   *
   */
  public LoginWithRoleResponse createLoginWithRoleResponse() {
    return new LoginWithRoleResponse();
  }

  /**
   * Create an instance of {@link Login }
   *
   */
  public Login createLogin() {
    return new Login();
  }

  /**
   * Create an instance of {@link LoginResponse }
   *
   */
  public LoginResponse createLoginResponse() {
    return new LoginResponse();
  }

  /**
   * Create an instance of {@link Logout }
   *
   */
  public Logout createLogout() {
    return new Logout();
  }

  /**
   * Create an instance of {@link LogoutResponse }
   *
   */
  public LogoutResponse createLogoutResponse() {
    return new LogoutResponse();
  }

  /**
   * Create an instance of {@link RetrieveM4Session }
   *
   */
  public RetrieveM4Session createRetrieveM4Session() {
    return new RetrieveM4Session();
  }

  /**
   * Create an instance of {@link RetrieveM4SessionResponse }
   *
   */
  public RetrieveM4SessionResponse createRetrieveM4SessionResponse() {
    return new RetrieveM4SessionResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link M4SoapException }{@code >}
   *
   * @param value Java instance representing xml element's value.
   * @return the new instance of {@link JAXBElement }{@code <}{@link M4SoapException }{@code >}
   */
  @XmlElementDecl(namespace = "http://schemas.meta4.com/", name = "fault")
  public JAXBElement<M4SoapException> createFault(M4SoapException value) {
    return new JAXBElement<M4SoapException>(_Fault_QNAME, M4SoapException.class, null, value);
  }

}
