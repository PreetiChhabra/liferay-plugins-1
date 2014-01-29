<%@page import="org.rsc.liferay.contact.controller.ContactController"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="org.rsc.liferay.contact.controller.ContactActionKeys"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.permission.PortalPermissionUtil"%>
<%@page import="org.rsc.liferay.contact.NoSuchContactException"%>

<%@ include file="/html/init.jsp" %>

<liferay-ui:success key="contact-added-successfully" message="contact-added-successfully" translateMessage="true"/>
<liferay-ui:success key="contact-updated-successfully" message="contact-updated-successfully" translateMessage="true"/>
<liferay-ui:success key="contact-deleted-successfully" message="contact-deleted-successfully" translateMessage="true"/>

<h3>Contacts</h3>
<liferay-ui:error exception="<%= NoSuchContactException.class %>" message="contact-not-found" />
<liferay-ui:search-container searchContainer="${searchContainer}" 
headerNames="firstName,lastName,mail,phone" orderByCol="${searchContainer.orderByCol}" orderByType="${searchContainer.orderByType}">
	<aui:nav-bar>
	   <c:if test='<%=ContactController.hasPortletPermission(permissionChecker, ContactActionKeys.ADD_CONTACT) %>'>
		    <aui:nav>
		        <liferay-portlet:renderURL varImpl="addContactURL">
		            <portlet:param name="action" value="add" />
		        </liferay-portlet:renderURL>
		        <aui:nav-item href="<%= addContactURL.toString() %>" iconCssClass="icon-plus" label="add" />
		    </aui:nav>
	    </c:if>
	    <aui:nav-bar-search cssClass="pull-right" file="/html/contact/list_search.jsp" searchContainer="${searchContainer}" />
	</aui:nav-bar>
	
    <liferay-ui:search-container-row
        className="org.rsc.liferay.contact.model.Contact"
        escapedModel="<%= true %>"
        keyProperty="personId"
        modelVar="curPerson">
        <liferay-ui:search-container-column-text
            name="lastName"
            property="lastName"
            orderable="true"
        />
        <liferay-ui:search-container-column-text
            name="firstName"
            property="firstName"
            orderable="true"
        />
        <liferay-ui:search-container-column-text
            name="mail"
            property="mail"
        />
        <liferay-ui:search-container-column-text
            name="phone"
            property="phone"
        />
        <liferay-ui:search-container-column-jsp
            align="right"
            path="/html/contact/list_contact_action.jsp"
        />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator type="regular"/>
</liferay-ui:search-container>
