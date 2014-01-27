package org.rsc.liferay.contact.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.rsc.liferay.contact.service.ClpSerializer;
import org.rsc.liferay.contact.service.ContactLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ContactClp extends BaseModelImpl<Contact> implements Contact {
    private long _personId;
    private long _companyId;
    private String _lastName;
    private String _firstName;
    private String _mail;
    private String _phone;
    private BaseModel<?> _contactRemoteModel;

    public ContactClp() {
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
    public long getPrimaryKey() {
        return _personId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPersonId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _personId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getPersonId() {
        return _personId;
    }

    @Override
    public void setPersonId(long personId) {
        _personId = personId;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setPersonId", long.class);

                method.invoke(_contactRemoteModel, personId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_contactRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setLastName", String.class);

                method.invoke(_contactRemoteModel, lastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstName", String.class);

                method.invoke(_contactRemoteModel, firstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMail() {
        return _mail;
    }

    @Override
    public void setMail(String mail) {
        _mail = mail;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setMail", String.class);

                method.invoke(_contactRemoteModel, mail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPhone() {
        return _phone;
    }

    @Override
    public void setPhone(String phone) {
        _phone = phone;

        if (_contactRemoteModel != null) {
            try {
                Class<?> clazz = _contactRemoteModel.getClass();

                Method method = clazz.getMethod("setPhone", String.class);

                method.invoke(_contactRemoteModel, phone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getContactRemoteModel() {
        return _contactRemoteModel;
    }

    public void setContactRemoteModel(BaseModel<?> contactRemoteModel) {
        _contactRemoteModel = contactRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _contactRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_contactRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContactLocalServiceUtil.addContact(this);
        } else {
            ContactLocalServiceUtil.updateContact(this);
        }
    }

    @Override
    public Contact toEscapedModel() {
        return (Contact) ProxyUtil.newProxyInstance(Contact.class.getClassLoader(),
            new Class[] { Contact.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContactClp clone = new ContactClp();

        clone.setPersonId(getPersonId());
        clone.setCompanyId(getCompanyId());
        clone.setLastName(getLastName());
        clone.setFirstName(getFirstName());
        clone.setMail(getMail());
        clone.setPhone(getPhone());

        return clone;
    }

    @Override
    public int compareTo(Contact contact) {
        int value = 0;

        value = getLastName().compareToIgnoreCase(contact.getLastName());

        if (value != 0) {
            return value;
        }

        value = getFirstName().compareToIgnoreCase(contact.getFirstName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactClp)) {
            return false;
        }

        ContactClp contact = (ContactClp) obj;

        long primaryKey = contact.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{personId=");
        sb.append(getPersonId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", mail=");
        sb.append(getMail());
        sb.append(", phone=");
        sb.append(getPhone());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("org.rsc.liferay.contact.model.Contact");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>personId</column-name><column-value><![CDATA[");
        sb.append(getPersonId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mail</column-name><column-value><![CDATA[");
        sb.append(getMail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>phone</column-name><column-value><![CDATA[");
        sb.append(getPhone());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
