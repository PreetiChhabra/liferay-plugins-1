package org.rsc.liferay.contact.service.impl;

import java.util.List;

import org.rsc.liferay.contact.model.Contact;
import org.rsc.liferay.contact.service.base.ContactLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.rsc.liferay.contact.service.ContactLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.rsc.liferay.contact.service.base.ContactLocalServiceBaseImpl
 * @see org.rsc.liferay.contact.service.ContactLocalServiceUtil
 */
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link org.rsc.liferay.contact.service.ContactLocalServiceUtil} to access the contact local service.
     */
	public int countAll() throws SystemException {
		return contactPersistence.countAll();
	}

	public List<Contact> findAll() throws SystemException {
		return contactPersistence.findAll();
	}

	public List<Contact> findAll(int start, int end) throws SystemException {
		return contactPersistence.findAll(start, end);
	}

	public List<Contact> findAll(int start, int end, OrderByComparator orderByComparator) throws SystemException {
		return contactPersistence.findAll(start, end, orderByComparator);
	}

}
