package org.rsc.liferay.contact.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.rsc.liferay.contact.model.Contact;
import org.rsc.liferay.contact.service.ContactLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContactActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ContactActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ContactLocalServiceUtil.getService());
        setClass(Contact.class);

        setClassLoader(org.rsc.liferay.contact.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("personId");
    }
}
