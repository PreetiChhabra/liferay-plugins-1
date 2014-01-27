package org.rsc.liferay.contact.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.rsc.liferay.contact.model.Contact;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactCacheModel implements CacheModel<Contact>, Externalizable {
    public long personId;
    public long companyId;
    public String lastName;
    public String firstName;
    public String mail;
    public String phone;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{personId=");
        sb.append(personId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", mail=");
        sb.append(mail);
        sb.append(", phone=");
        sb.append(phone);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Contact toEntityModel() {
        ContactImpl contactImpl = new ContactImpl();

        contactImpl.setPersonId(personId);
        contactImpl.setCompanyId(companyId);

        if (lastName == null) {
            contactImpl.setLastName(StringPool.BLANK);
        } else {
            contactImpl.setLastName(lastName);
        }

        if (firstName == null) {
            contactImpl.setFirstName(StringPool.BLANK);
        } else {
            contactImpl.setFirstName(firstName);
        }

        if (mail == null) {
            contactImpl.setMail(StringPool.BLANK);
        } else {
            contactImpl.setMail(mail);
        }

        if (phone == null) {
            contactImpl.setPhone(StringPool.BLANK);
        } else {
            contactImpl.setPhone(phone);
        }

        contactImpl.resetOriginalValues();

        return contactImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        personId = objectInput.readLong();
        companyId = objectInput.readLong();
        lastName = objectInput.readUTF();
        firstName = objectInput.readUTF();
        mail = objectInput.readUTF();
        phone = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(personId);
        objectOutput.writeLong(companyId);

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }

        if (mail == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mail);
        }

        if (phone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(phone);
        }
    }
}
