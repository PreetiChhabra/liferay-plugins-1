package org.rsc.liferay.contact.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Contact. This utility wraps
 * {@link org.rsc.liferay.contact.service.impl.ContactLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactLocalService
 * @see org.rsc.liferay.contact.service.base.ContactLocalServiceBaseImpl
 * @see org.rsc.liferay.contact.service.impl.ContactLocalServiceImpl
 * @generated
 */
public class ContactLocalServiceUtil {
    private static ContactLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link org.rsc.liferay.contact.service.impl.ContactLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the contact to the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact
    * @return the contact that was added
    * @throws SystemException if a system exception occurred
    */
    public static org.rsc.liferay.contact.model.Contact addContact(
        org.rsc.liferay.contact.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addContact(contact);
    }

    /**
    * Creates a new contact with the primary key. Does not add the contact to the database.
    *
    * @param personId the primary key for the new contact
    * @return the new contact
    */
    public static org.rsc.liferay.contact.model.Contact createContact(
        long personId) {
        return getService().createContact(personId);
    }

    /**
    * Deletes the contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param personId the primary key of the contact
    * @return the contact that was removed
    * @throws PortalException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.rsc.liferay.contact.model.Contact deleteContact(
        long personId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContact(personId);
    }

    /**
    * Deletes the contact from the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact
    * @return the contact that was removed
    * @throws SystemException if a system exception occurred
    */
    public static org.rsc.liferay.contact.model.Contact deleteContact(
        org.rsc.liferay.contact.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContact(contact);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.rsc.liferay.contact.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.rsc.liferay.contact.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static org.rsc.liferay.contact.model.Contact fetchContact(
        long personId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContact(personId);
    }

    /**
    * Returns the contact with the primary key.
    *
    * @param personId the primary key of the contact
    * @return the contact
    * @throws PortalException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.rsc.liferay.contact.model.Contact getContact(
        long personId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContact(personId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.rsc.liferay.contact.model.impl.ContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contacts
    * @param end the upper bound of the range of contacts (not inclusive)
    * @return the range of contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.rsc.liferay.contact.model.Contact> getContacts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContacts(start, end);
    }

    /**
    * Returns the number of contacts.
    *
    * @return the number of contacts
    * @throws SystemException if a system exception occurred
    */
    public static int getContactsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactsCount();
    }

    /**
    * Updates the contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contact the contact
    * @return the contact that was updated
    * @throws SystemException if a system exception occurred
    */
    public static org.rsc.liferay.contact.model.Contact updateContact(
        org.rsc.liferay.contact.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContact(contact);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countAll();
    }

    public static java.util.List<org.rsc.liferay.contact.model.Contact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findAll();
    }

    public static java.util.List<org.rsc.liferay.contact.model.Contact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findAll(start, end);
    }

    public static java.util.List<org.rsc.liferay.contact.model.Contact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findAll(start, end, orderByComparator);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String keywords,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        int start, int end, com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().search(companyId, keywords, params, start, end, sort);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String firstName, java.lang.String lastName,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        boolean andSearch, int start, int end,
        com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .search(companyId, firstName, lastName, params, andSearch,
            start, end, sort);
    }

    public static java.util.List<org.rsc.liferay.contact.model.Contact> getContacts(
        com.liferay.portal.kernel.search.Hits hits) {
        return getService().getContacts(hits);
    }

    public static void clearService() {
        _service = null;
    }

    public static ContactLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ContactLocalService.class.getName());

            if (invokableLocalService instanceof ContactLocalService) {
                _service = (ContactLocalService) invokableLocalService;
            } else {
                _service = new ContactLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ContactLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ContactLocalService service) {
    }
}
