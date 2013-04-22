
package com.sdltridion.security;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sdltridion.security package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AdditionalAttributes_QNAME = new QName("http://www.sdltridion.com/Security", "AdditionalAttributes");
    private final static QName _ArrayOfWindowsUser_QNAME = new QName("http://www.sdltridion.com/Security", "ArrayOfWindowsUser");
    private final static QName _DirectoryUsersFilter_QNAME = new QName("http://www.sdltridion.com/Security", "DirectoryUsersFilter");
    private final static QName _DirectoryServiceUser_QNAME = new QName("http://www.sdltridion.com/Security", "DirectoryServiceUser");
    private final static QName _UserNameSearchMode_QNAME = new QName("http://www.sdltridion.com/Security", "UserNameSearchMode");
    private final static QName _WindowsUser_QNAME = new QName("http://www.sdltridion.com/Security", "WindowsUser");
    private final static QName _ArrayOfDirectoryServiceUser_QNAME = new QName("http://www.sdltridion.com/Security", "ArrayOfDirectoryServiceUser");
    private final static QName _ExternalUser_QNAME = new QName("http://www.sdltridion.com/Security", "ExternalUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sdltridion.security
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DirectoryUsersFilter }
     * 
     */
    public DirectoryUsersFilter createDirectoryUsersFilter() {
        return new DirectoryUsersFilter();
    }

    /**
     * Create an instance of {@link AdditionalAttributes }
     * 
     */
    public AdditionalAttributes createAdditionalAttributes() {
        return new AdditionalAttributes();
    }

    /**
     * Create an instance of {@link ArrayOfWindowsUser }
     * 
     */
    public ArrayOfWindowsUser createArrayOfWindowsUser() {
        return new ArrayOfWindowsUser();
    }

    /**
     * Create an instance of {@link DirectoryServiceUser }
     * 
     */
    public DirectoryServiceUser createDirectoryServiceUser() {
        return new DirectoryServiceUser();
    }

    /**
     * Create an instance of {@link ArrayOfDirectoryServiceUser }
     * 
     */
    public ArrayOfDirectoryServiceUser createArrayOfDirectoryServiceUser() {
        return new ArrayOfDirectoryServiceUser();
    }

    /**
     * Create an instance of {@link AdditionalAttributes.AdditionalAttribute }
     * 
     */
    public AdditionalAttributes.AdditionalAttribute createAdditionalAttributesAdditionalAttribute() {
        return new AdditionalAttributes.AdditionalAttribute();
    }

    /**
     * Create an instance of {@link WindowsUser }
     * 
     */
    public WindowsUser createWindowsUser() {
        return new WindowsUser();
    }

    /**
     * Create an instance of {@link ExternalUser }
     * 
     */
    public ExternalUser createExternalUser() {
        return new ExternalUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionalAttributes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "AdditionalAttributes")
    public JAXBElement<AdditionalAttributes> createAdditionalAttributes(AdditionalAttributes value) {
        return new JAXBElement<AdditionalAttributes>(_AdditionalAttributes_QNAME, AdditionalAttributes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfWindowsUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "ArrayOfWindowsUser")
    public JAXBElement<ArrayOfWindowsUser> createArrayOfWindowsUser(ArrayOfWindowsUser value) {
        return new JAXBElement<ArrayOfWindowsUser>(_ArrayOfWindowsUser_QNAME, ArrayOfWindowsUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectoryUsersFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "DirectoryUsersFilter")
    public JAXBElement<DirectoryUsersFilter> createDirectoryUsersFilter(DirectoryUsersFilter value) {
        return new JAXBElement<DirectoryUsersFilter>(_DirectoryUsersFilter_QNAME, DirectoryUsersFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectoryServiceUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "DirectoryServiceUser")
    public JAXBElement<DirectoryServiceUser> createDirectoryServiceUser(DirectoryServiceUser value) {
        return new JAXBElement<DirectoryServiceUser>(_DirectoryServiceUser_QNAME, DirectoryServiceUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNameSearchMode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "UserNameSearchMode")
    public JAXBElement<UserNameSearchMode> createUserNameSearchMode(UserNameSearchMode value) {
        return new JAXBElement<UserNameSearchMode>(_UserNameSearchMode_QNAME, UserNameSearchMode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WindowsUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "WindowsUser")
    public JAXBElement<WindowsUser> createWindowsUser(WindowsUser value) {
        return new JAXBElement<WindowsUser>(_WindowsUser_QNAME, WindowsUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfDirectoryServiceUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "ArrayOfDirectoryServiceUser")
    public JAXBElement<ArrayOfDirectoryServiceUser> createArrayOfDirectoryServiceUser(ArrayOfDirectoryServiceUser value) {
        return new JAXBElement<ArrayOfDirectoryServiceUser>(_ArrayOfDirectoryServiceUser_QNAME, ArrayOfDirectoryServiceUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.sdltridion.com/Security", name = "ExternalUser")
    public JAXBElement<ExternalUser> createExternalUser(ExternalUser value) {
        return new JAXBElement<ExternalUser>(_ExternalUser_QNAME, ExternalUser.class, null, value);
    }

}
