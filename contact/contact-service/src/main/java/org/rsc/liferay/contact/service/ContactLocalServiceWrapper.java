package org.rsc.liferay.contact.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContactLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContactLocalService
 * @generated
 */
public class ContactLocalServiceWrapper implements ContactLocalService,
    ServiceWrapper<ContactLocalService> {
    private ContactLocalService _contactLocalService;

    public ContactLocalServiceWrapper(ContactLocalService contactLocalService) {
        _contactLocalService = contactLocalService;
    }

    /**
    * Adds the contact to the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact
    * @return the contact that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public org.rsc.liferay.contact.model.Contact addContact(
        org.rsc.liferay.contact.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.addContact(contact);
    }

    /**
    * Creates a new contact with the primary key. Does not add the contact to the database.
    *
    * @param personId the primary key for the new contact
    * @return the new contact
    */
    @Override
    public org.rsc.liferay.contact.model.Contact createContact(long personId) {
        return _contactLocalService.createContact(personId);
    }

    /**
    * Deletes the contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param personId the primary key of the contact
    * @return the contact that was removed
    * @throws PortalException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public org.rsc.liferay.contact.model.Contact deleteContact(long personId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.deleteContact(personId);
    }

    /**
    * Deletes the contact from the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact
    * @return the contact that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public org.rsc.liferay.contact.model.Contact deleteContact(
        org.rsc.liferay.contact.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.deleteContact(contact);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _contactLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public org.rsc.liferay.contact.model.Contact fetchContact(long personId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.fetchContact(personId);
    }

    /**
    * Returns the contact with the primary key.
    *
    * @param personId the primary key of the contact
    * @return the contact
    * @throws PortalException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public org.rsc.liferay.contact.model.Contact getContact(long personId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.getContact(personId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<org.rsc.liferay.contact.model.Contact> getContacts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.getContacts(start, end);
    }

    /**
    * Returns the number of contacts.
    *
    * @return the number of contacts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getContactsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.getContactsCount();
    }

    /**
    * Updates the contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contact the contact
    * @return the contact that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public org.rsc.liferay.contact.model.Contact updateContact(
        org.rsc.liferay.contact.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.updateContact(contact);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _contactLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contactLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _contactLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.countAll();
    }

    @Override
    public java.util.List<org.rsc.liferay.contact.model.Contact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.findAll();
    }

    @Override
    public java.util.List<org.rsc.liferay.contact.model.Contact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.findAll(start, end);
    }

    @Override
    public java.util.List<org.rsc.liferay.contact.model.Contact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.findAll(start, end, orderByComparator);
    }

    @Override
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String keywords,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        int start, int end, com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.search(companyId, keywords, params, start,
            end, sort);
    }

    @Override
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String firstName, java.lang.String lastName,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        boolean andSearch, int start, int end,
        com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactLocalService.search(companyId, firstName, lastName,
            params, andSearch, start, end, sort);
    }

    @Override
    public java.util.List<org.rsc.liferay.contact.model.Contact> getContacts(
        com.liferay.portal.kernel.search.Hits hits) {
        return _contactLocalService.getContacts(hits);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ContactLocalService getWrappedContactLocalService() {
        return _contactLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedContactLocalService(
        ContactLocalService contactLocalService) {
        _contactLocalService = contactLocalService;
    }

    @Override
    public ContactLocalService getWrappedService() {
        return _contactLocalService;
    }

    @Override
    public void setWrappedService(ContactLocalService contactLocalService) {
        _contactLocalService = contactLocalService;
    }
}
