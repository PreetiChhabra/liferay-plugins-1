package org.rsc.liferay.contact.index;

import java.util.LinkedHashMap;
import java.util.Locale;

import javax.portlet.PortletURL;

import org.rsc.liferay.contact.model.Contact;
import org.rsc.liferay.contact.service.ContactLocalServiceUtil;
import org.rsc.liferay.contact.service.persistence.ContactActionableDynamicQuery;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

public class ContactIndexer extends BaseIndexer {

	/** The Constant CLASS_NAMES. */
	public static final String[] CLASS_NAMES = { Contact.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return "contact-portlet";
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Contact contact = (Contact) obj;
		deleteDocument(contact.getCompanyId(), contact.getPersonId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Contact contact = (Contact) obj;

		Document document = getBaseModelDocument(this.getPortletId(), contact);
		document.addKeyword(Field.FIRST_NAME, contact.getFirstName());
		document.addKeyword(Field.LAST_NAME, contact.getLastName());
		document.addKeyword(Field.PHONE, contact.getPhone());
		document.addKeyword(Field.MAIL, contact.getMail());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		return null;
	}

	@Override
	protected String doGetSortField(String orderByCol) {
		if (orderByCol.equals("firstName")) {
			return Field.FIRST_NAME;
		} else if (orderByCol.equals("lastName")) {
			return Field.LAST_NAME;
		} else {
			return orderByCol;
		}
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		if (obj instanceof Contact) {
			Contact contact = (Contact) obj;

			Document document = getDocument(contact);

			SearchEngineUtil.updateDocument(getSearchEngineId(),
					contact.getCompanyId(), document);

		}

	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Contact contact = ContactLocalServiceUtil.getContact(classPK);
		doReindex(contact);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexUsers(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return this.getPortletId();
	}

	protected void reindexUsers(long companyId) throws PortalException,
			SystemException {

		ActionableDynamicQuery actionableDynamicQuery = new ContactActionableDynamicQuery() {
			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				Contact contact = (Contact) object;
				Document document = getDocument(contact);
				addDocument(document);
			}
		};
		actionableDynamicQuery.setCompanyId(0);
		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		actionableDynamicQuery.performActions();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		addSearchTerm(searchQuery, searchContext, Field.FIRST_NAME, false);
		addSearchTerm(searchQuery, searchContext, Field.LAST_NAME, false);

		LinkedHashMap<String, Object> params =
			(LinkedHashMap<String, Object>)searchContext.getAttribute("params");

		if (params != null) {
			String expandoAttributes = (String)params.get("expandoAttributes");

			if (Validator.isNotNull(expandoAttributes)) {
				addSearchExpando(searchQuery, searchContext, expandoAttributes);
			}
		}
	}
}
