package org.rsc.liferay.contact.controller;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.rsc.liferay.contact.model.Contact;
import org.rsc.liferay.contact.model.impl.ContactImpl;
import org.rsc.liferay.contact.search.ContactSearchContainer;
import org.rsc.liferay.contact.service.ContactLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.proxy.ProxyModeThreadLocal;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;

@Controller("contactController")
@RequestMapping("VIEW")
public class ContactController {

	private static final Log LOG = LogFactoryUtil.getLog(ContactController.class);
	
	private static final String LIST_VIEW = "contact/list";
	
	private static final String EDIT_VIEW = "contact/edit";

	@RenderMapping
	public String listContacts(RenderRequest renderRequest,
			RenderResponse renderResponse, Map<String, Object> map) {

		ContactSearchContainer searchContainer = new ContactSearchContainer(
				renderRequest, renderResponse);
		map.put("searchContainer", searchContainer);
		return LIST_VIEW;
	}
	
	@RenderMapping(params = "action=add")
	public String addContactForm(RenderRequest renderRequest,
			RenderResponse renderResponse, Map<String, Object> map) {

		map.put("contact", new ContactImpl());

		return EDIT_VIEW;
	}

	@ActionMapping(params = "action=add")
	public void addContact(ActionRequest actionRequest,
			ActionResponse actionResponse, Model model,
			@ModelAttribute("contact") ContactImpl contact, BindingResult result) {
		try {
			contact.setPersonId(CounterLocalServiceUtil.increment(Contact.class
					.getName()));
			ProxyModeThreadLocal.setForceSync(true);
			ContactLocalServiceUtil.addContact(contact);
			SessionMessages.add(actionRequest, "contact-added-successfully");
		} catch (SystemException ex) {
			SessionErrors.add(actionRequest, "fields-required");
			LOG.error(ex.toString());
		}
	}

	@RenderMapping(params = "action=update")
	public String updateContactForm(RenderRequest renderRequest,
			RenderResponse renderResponse, Map<String, Object> map,
			@RequestParam("contactId") Long contactId) {

		try {
			map.put("contactRow", ContactLocalServiceUtil.getContact(contactId.longValue()));
			return EDIT_VIEW;
		} catch (PortalException | SystemException ex) {
			SessionErrors.add(renderRequest, "contact-not-founded");
			LOG.error(ex.toString());
		}
		return null;
	}

	@ActionMapping(params = "action=update")
	public void updateContact(ActionRequest actionRequest,
			ActionResponse actionResponse, Model model,
			@ModelAttribute("contactRow") ContactImpl contact, BindingResult result) {
		try {
			ProxyModeThreadLocal.setForceSync(true);
			ContactLocalServiceUtil.updateContact(contact);
			SessionMessages.add(actionRequest, "contact-updated-successfully");
		} catch (SystemException ex) {
			SessionErrors.add(actionRequest, "fields-required");
			LOG.error(ex.toString());
		}
	}	

	@ActionMapping(params = "action=delete")
	public void deleteContact(@RequestParam("contactId") Long contactId,
			ActionRequest actionRequest, ActionResponse actionResponse,
			Model model) throws IOException, PortletException {
		try {
			ProxyModeThreadLocal.setForceSync(true);
			ContactLocalServiceUtil.deleteContact(contactId.longValue());
			SessionMessages.add(actionRequest, "contact-deleted-successfully");
		} catch (SystemException | PortalException ex) {
			LOG.error(ex.toString());
		}
	}
	
	public static boolean hasPortletPermission(PermissionChecker permissionChecker, String actionId) throws PortalException, SystemException{
		return PortletPermissionUtil.contains(permissionChecker, "contact_WAR_contactportlet", actionId);
	}
	public static boolean hasContactPermission(PermissionChecker permissionChecker, String actionId) throws PortalException, SystemException{
		return PortletPermissionUtil.contains(permissionChecker, Contact.class.getName(), actionId);
	}
}
