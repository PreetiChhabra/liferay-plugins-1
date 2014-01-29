package org.rsc.liferay.contact.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import org.rsc.liferay.contact.comparator.ContactDefaultComparator;
import org.rsc.liferay.contact.comparator.ContactFirstNameComparator;
import org.rsc.liferay.contact.comparator.ContactLastNameComparator;
import org.rsc.liferay.contact.comparator.ContactMailComparator;
import org.rsc.liferay.contact.model.Contact;
import org.rsc.liferay.contact.service.ContactLocalServiceUtil;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

public class ContactSearchContainer extends SearchContainer<Contact> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("firstName");
		headerNames.add("lastName");
		headerNames.add("mail");
		headerNames.add("phone");

		orderableHeaders.put("firstName", "firstName");
		orderableHeaders.put("lastName", "lastName");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-contacts-were-found";

	public ContactSearchContainer(PortletRequest portletRequest,
			RenderResponse renderResponse) {
		this(portletRequest, renderResponse.createRenderURL());
	}

	public ContactSearchContainer(PortletRequest portletRequest,
			PortletURL iteratorURL) {

		super(portletRequest, new ContactDisplayTerms(portletRequest),
				new ContactDisplayTerms(portletRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		ContactDisplayTerms displayTerms = (ContactDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(ContactDisplayTerms.LAST_NAME,
				displayTerms.getLastName());
		iteratorURL.setParameter(ContactDisplayTerms.FIRST_NAME,
				displayTerms.getFirstName());

		try {
			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");

			if (Validator.isNull(orderByType)) {
				orderByType = "asc";
			}

			this.setOrderableHeaders(orderableHeaders);
			this.setOrderByCol(orderByCol);
			this.setOrderByType(orderByType);
			this.setOrderByComparator(getOrderByComparator(orderByCol,
					orderByType));

			List<Contact> contactList = new ArrayList<Contact>();
			if (Boolean
					.parseBoolean(PortletProps.get("contact.search.with.index"))) {
				Sort sort = SortFactoryUtil.getSort(Contact.class,
						this.getOrderByCol(), this.getOrderByType());
				Hits hits = ContactLocalServiceUtil.search(0,
						displayTerms.getKeywords(), null, this.getStart(),
						this.getEnd(), sort);
				if (hits.getLength() > 0) {
					contactList = ContactLocalServiceUtil.getContacts(hits);
				}
				this.setTotal(hits.getLength());
			} else {
				contactList = ContactLocalServiceUtil.findAll(this.getStart(),
						this.getEnd(), this.getOrderByComparator());
				this.setTotal(ContactLocalServiceUtil.countAll());
			}
			this.setResults(contactList);
		} catch (Exception e) {
			LOG.error(e);
		}
	}

	private OrderByComparator getOrderByComparator(String orderByCol,
			String orderByType) {

		boolean orderByAsc = true;

		if (orderByType.equals("desc")) {
			orderByAsc = false;
		}

		switch (orderByCol) {
		case "firstName":
			return new ContactFirstNameComparator(orderByAsc);
		case "lastName":
			return new ContactLastNameComparator(orderByAsc);
		case "mail":
			return new ContactMailComparator(orderByAsc);
		default:
			return new ContactDefaultComparator(orderByAsc);
		}
	}

	private static Log LOG = LogFactoryUtil
			.getLog(ContactSearchContainer.class);

}
