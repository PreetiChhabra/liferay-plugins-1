package org.rsc.liferay.contact.controller;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class ContactSearchContainer extends SearchContainer<Contact>{

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
	
	public ContactSearchContainer(PortletRequest portletRequest, RenderResponse renderResponse) {
		this(portletRequest, renderResponse.createRenderURL());
	}
	
	public ContactSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {

		super(portletRequest, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		try {
			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			if (Validator.isNull(orderByType)) {
				orderByType = "asc";
			}
			OrderByComparator orderByComparator = getOrderByComparator(
					orderByCol, orderByType);

			this.setOrderableHeaders(orderableHeaders);
			this.setOrderByCol(orderByCol);
			this.setOrderByType(orderByType);
			this.setOrderByComparator(orderByComparator);
			
			List<Contact> contactList = ContactLocalServiceUtil.findAll(
					this.getStart(), this.getEnd(),
					this.getOrderByComparator());
			this.setTotal(ContactLocalServiceUtil.countAll());
			this.setResults(contactList);
		}
		catch (Exception e) {
			_log.error(e);
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
	private static Log _log = LogFactoryUtil.getLog(ContactSearchContainer.class);
	
}
