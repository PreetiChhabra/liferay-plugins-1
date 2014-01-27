package org.rsc.liferay.contact.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.rsc.liferay.contact.service.http.ContactServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see org.rsc.liferay.contact.service.http.ContactServiceSoap
 * @generated
 */
public class ContactSoap implements Serializable {
    private long _personId;
    private long _companyId;
    private String _lastName;
    private String _firstName;
    private String _mail;
    private String _phone;

    public ContactSoap() {
    }

    public static ContactSoap toSoapModel(Contact model) {
        ContactSoap soapModel = new ContactSoap();

        soapModel.setPersonId(model.getPersonId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setLastName(model.getLastName());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setMail(model.getMail());
        soapModel.setPhone(model.getPhone());

        return soapModel;
    }

    public static ContactSoap[] toSoapModels(Contact[] models) {
        ContactSoap[] soapModels = new ContactSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContactSoap[][] toSoapModels(Contact[][] models) {
        ContactSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContactSoap[models.length][models[0].length];
        } else {
            soapModels = new ContactSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContactSoap[] toSoapModels(List<Contact> models) {
        List<ContactSoap> soapModels = new ArrayList<ContactSoap>(models.size());

        for (Contact model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContactSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _personId;
    }

    public void setPrimaryKey(long pk) {
        setPersonId(pk);
    }

    public long getPersonId() {
        return _personId;
    }

    public void setPersonId(long personId) {
        _personId = personId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getMail() {
        return _mail;
    }

    public void setMail(String mail) {
        _mail = mail;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }
}
