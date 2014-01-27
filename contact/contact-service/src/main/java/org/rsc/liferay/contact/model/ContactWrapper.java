package org.rsc.liferay.contact.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactWrapper implements Contact, ModelWrapper<Contact> {
    private Contact _contact;

    public ContactWrapper(Contact contact) {
        _contact = contact;
    }

    @Override
    public Class<?> getModelClass() {
        return Contact.class;
    }

    @Override
    public String getModelClassName() {
        return Contact.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("personId", getPersonId());
        attributes.put("companyId", getCompanyId());
        attributes.put("lastName", getLastName());
        attributes.put("firstName", getFirstName());
        attributes.put("mail", getMail());
        attributes.put("phone", getPhone());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long personId = (Long) attributes.get("personId");

        if (personId != null) {
            setPersonId(personId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String mail = (String) attributes.get("mail");

        if (mail != null) {
            setMail(mail);
        }

        String phone = (String) attributes.get("phone");

        if (phone != null) {
            setPhone(phone);
        }
    }

    /**
    * Returns the primary key of this contact.
    *
    * @return the primary key of this contact
    */
    @Override
    public long getPrimaryKey() {
        return _contact.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contact.
    *
    * @param primaryKey the primary key of this contact
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _contact.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the person ID of this contact.
    *
    * @return the person ID of this contact
    */
    @Override
    public long getPersonId() {
        return _contact.getPersonId();
    }

    /**
    * Sets the person ID of this contact.
    *
    * @param personId the person ID of this contact
    */
    @Override
    public void setPersonId(long personId) {
        _contact.setPersonId(personId);
    }

    /**
    * Returns the company ID of this contact.
    *
    * @return the company ID of this contact
    */
    @Override
    public long getCompanyId() {
        return _contact.getCompanyId();
    }

    /**
    * Sets the company ID of this contact.
    *
    * @param companyId the company ID of this contact
    */
    @Override
    public void setCompanyId(long companyId) {
        _contact.setCompanyId(companyId);
    }

    /**
    * Returns the last name of this contact.
    *
    * @return the last name of this contact
    */
    @Override
    public java.lang.String getLastName() {
        return _contact.getLastName();
    }

    /**
    * Sets the last name of this contact.
    *
    * @param lastName the last name of this contact
    */
    @Override
    public void setLastName(java.lang.String lastName) {
        _contact.setLastName(lastName);
    }

    /**
    * Returns the first name of this contact.
    *
    * @return the first name of this contact
    */
    @Override
    public java.lang.String getFirstName() {
        return _contact.getFirstName();
    }

    /**
    * Sets the first name of this contact.
    *
    * @param firstName the first name of this contact
    */
    @Override
    public void setFirstName(java.lang.String firstName) {
        _contact.setFirstName(firstName);
    }

    /**
    * Returns the mail of this contact.
    *
    * @return the mail of this contact
    */
    @Override
    public java.lang.String getMail() {
        return _contact.getMail();
    }

    /**
    * Sets the mail of this contact.
    *
    * @param mail the mail of this contact
    */
    @Override
    public void setMail(java.lang.String mail) {
        _contact.setMail(mail);
    }

    /**
    * Returns the phone of this contact.
    *
    * @return the phone of this contact
    */
    @Override
    public java.lang.String getPhone() {
        return _contact.getPhone();
    }

    /**
    * Sets the phone of this contact.
    *
    * @param phone the phone of this contact
    */
    @Override
    public void setPhone(java.lang.String phone) {
        _contact.setPhone(phone);
    }

    @Override
    public boolean isNew() {
        return _contact.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _contact.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _contact.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _contact.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _contact.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _contact.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contact.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contact.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _contact.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _contact.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contact.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContactWrapper((Contact) _contact.clone());
    }

    @Override
    public int compareTo(Contact contact) {
        return _contact.compareTo(contact);
    }

    @Override
    public int hashCode() {
        return _contact.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Contact> toCacheModel() {
        return _contact.toCacheModel();
    }

    @Override
    public Contact toEscapedModel() {
        return new ContactWrapper(_contact.toEscapedModel());
    }

    @Override
    public Contact toUnescapedModel() {
        return new ContactWrapper(_contact.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contact.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _contact.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contact.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactWrapper)) {
            return false;
        }

        ContactWrapper contactWrapper = (ContactWrapper) obj;

        if (Validator.equals(_contact, contactWrapper._contact)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Contact getWrappedContact() {
        return _contact;
    }

    @Override
    public Contact getWrappedModel() {
        return _contact;
    }

    @Override
    public void resetOriginalValues() {
        _contact.resetOriginalValues();
    }
}
