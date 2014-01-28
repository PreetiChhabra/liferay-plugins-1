package org.rsc.liferay.contact.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.rsc.liferay.contact.index.Field;
import org.rsc.liferay.contact.model.Contact;
import org.rsc.liferay.contact.service.ContactLocalServiceUtil;
import org.rsc.liferay.contact.service.base.ContactLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the contact local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.rsc.liferay.contact.service.ContactLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
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
	 * Never reference this interface directly. Always use {@link
	 * org.rsc.liferay.contact.service.ContactLocalServiceUtil} to access the
	 * contact local service.
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

	public List<Contact> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return contactPersistence.findAll(start, end, orderByComparator);
	}

	public Hits search(long companyId, String keywords,
			LinkedHashMap<String, Object> params, int start, int end, Sort sort)
			throws SystemException {

		String firstName = null;
		String lastName = null;

		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			firstName = keywords;
			lastName = keywords;
		} else {
			andOperator = true;
		}

		if (params != null) {
			params.put("keywords", keywords);
		}

		return search(companyId, firstName, lastName, params, andOperator,
				start, end, sort);
	}

	public Hits search(long companyId, String firstName, String lastName,
			LinkedHashMap<String, Object> params, boolean andSearch, int start,
			int end, Sort sort) throws SystemException {

		try {
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(Contact.class);

			SearchContext searchContext = buildSearchContext(companyId,
					firstName, lastName, params, andSearch, start, end, sort);

			return indexer.search(searchContext);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected SearchContext buildSearchContext(long companyId,
			String firstName, String lastName,
			LinkedHashMap<String, Object> params, boolean andSearch, int start,
			int end, Sort sort) {

		SearchContext searchContext = new SearchContext();

		searchContext.setAndSearch(andSearch);

		Map<String, Serializable> attributes = new HashMap<String, Serializable>();

		attributes.put(Field.FIRST_NAME, firstName);
		attributes.put(Field.LAST_NAME, lastName);

		searchContext.setAttributes(attributes);

		searchContext.setCompanyId(companyId);
		searchContext.setEnd(end);

		if (params != null) {
			String keywords = (String) params.remove("keywords");

			if (Validator.isNotNull(keywords)) {
				searchContext.setKeywords(keywords);
			}
		}

		QueryConfig queryConfig = new QueryConfig();

		queryConfig.setHighlightEnabled(false);
		queryConfig.setScoreEnabled(false);

		searchContext.setQueryConfig(queryConfig);

		if (sort != null) {
			searchContext.setSorts(sort);
		}

		searchContext.setStart(start);

		return searchContext;
	}

	public List<Contact> getContacts(Hits hits) {
		List<Document> documents = hits.toList();

		List<Contact> contacts = new ArrayList<Contact>(documents.size());

		for (Document document : documents) {
			long classPK = GetterUtil.getLong(document
					.get(Field.ENTRY_CLASS_PK));
			try {
				Contact contact = ContactLocalServiceUtil.fetchContact(classPK);

				if (contact != null) {
					contacts.add(contact);
				}
			} catch (SystemException ex) {
			}
		}

		return contacts;
	}
}
