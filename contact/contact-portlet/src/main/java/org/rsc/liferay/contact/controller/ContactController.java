package org.rsc.liferay.contact.controller;

import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("contactController")
@RequestMapping("VIEW")
public class ContactController {

	@RenderMapping
	public String listContacts(RenderRequest renderRequest,
			RenderResponse renderResponse, Map<String, Object> map) {

		ContactSearchContainer searchContainer = new ContactSearchContainer(
				renderRequest, renderResponse);

		map.put("searchContainer", searchContainer);
		
		return "contact/list";
	}

}
