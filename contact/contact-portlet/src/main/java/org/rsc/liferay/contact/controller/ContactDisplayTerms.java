package org.rsc.liferay.contact.controller;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ContactDisplayTerms extends DisplayTerms {

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public ContactDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		firstName = ParamUtil.getString(portletRequest, FIRST_NAME);
		lastName = ParamUtil.getString(portletRequest, LAST_NAME);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	protected String firstName;
	protected String lastName;

}
