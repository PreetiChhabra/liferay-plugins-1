package org.rsc.liferay.contact.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import org.rsc.liferay.contact.model.Contact;
import org.rsc.liferay.contact.service.ContactService;
import org.rsc.liferay.contact.service.persistence.ContactPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the contact remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.rsc.liferay.contact.service.impl.ContactServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.rsc.liferay.contact.service.impl.ContactServiceImpl
 * @see org.rsc.liferay.contact.service.ContactServiceUtil
 * @generated
 */
public abstract class ContactServiceBaseImpl extends BaseServiceImpl
    implements ContactService, IdentifiableBean {
    @BeanReference(type = org.rsc.liferay.contact.service.ContactLocalService.class)
    protected org.rsc.liferay.contact.service.ContactLocalService contactLocalService;
    @BeanReference(type = org.rsc.liferay.contact.service.ContactService.class)
    protected org.rsc.liferay.contact.service.ContactService contactService;
    @BeanReference(type = ContactPersistence.class)
    protected ContactPersistence contactPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ContactServiceClpInvoker _clpInvoker = new ContactServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link org.rsc.liferay.contact.service.ContactServiceUtil} to access the contact remote service.
     */

    /**
     * Returns the contact local service.
     *
     * @return the contact local service
     */
    public org.rsc.liferay.contact.service.ContactLocalService getContactLocalService() {
        return contactLocalService;
    }

    /**
     * Sets the contact local service.
     *
     * @param contactLocalService the contact local service
     */
    public void setContactLocalService(
        org.rsc.liferay.contact.service.ContactLocalService contactLocalService) {
        this.contactLocalService = contactLocalService;
    }

    /**
     * Returns the contact remote service.
     *
     * @return the contact remote service
     */
    public org.rsc.liferay.contact.service.ContactService getContactService() {
        return contactService;
    }

    /**
     * Sets the contact remote service.
     *
     * @param contactService the contact remote service
     */
    public void setContactService(
        org.rsc.liferay.contact.service.ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * Returns the contact persistence.
     *
     * @return the contact persistence
     */
    public ContactPersistence getContactPersistence() {
        return contactPersistence;
    }

    /**
     * Sets the contact persistence.
     *
     * @param contactPersistence the contact persistence
     */
    public void setContactPersistence(ContactPersistence contactPersistence) {
        this.contactPersistence = contactPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Contact.class;
    }

    protected String getModelClassName() {
        return Contact.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = contactPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
