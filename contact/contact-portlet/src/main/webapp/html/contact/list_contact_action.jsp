<%@page import="org.rsc.liferay.contact.controller.ContactActionKeys"%>
<%@page import="org.rsc.liferay.contact.controller.ContactController"%>
<%@ page import="org.rsc.liferay.contact.model.Contact"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@ include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Contact contactRow = (Contact)row.getObject();
%>
<liferay-ui:icon-menu>
    <c:if test='<%=ContactController.hasContactPermission(permissionChecker, ContactActionKeys.UPDATE_CONTACT) %>'>
		<portlet:renderURL var="editURL">
	        <portlet:param name="action" value="update"/>
	        <portlet:param name="contactId" value="<%=String.valueOf(contactRow.getPersonId())%>"/>
		</portlet:renderURL>    
	    <liferay-ui:icon image="edit" url="<%= editURL %>" />
    </c:if>
	<c:if test='<%=ContactController.hasContactPermission(permissionChecker, ContactActionKeys.DELETE_CONTACT) %>'>
		<portlet:actionURL var="deleteContactURL">
		    <portlet:param name="action" value="delete"/>
		    <portlet:param name="contactId" value="<%=String.valueOf(contactRow.getPersonId())%>"/>
		</portlet:actionURL>
	    <liferay-ui:icon image="delete" url="<%= deleteContactURL %>" />
    </c:if>
</liferay-ui:icon-menu>