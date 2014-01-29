<%@ page import="org.rsc.liferay.contact.model.Contact"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@ include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Contact contact = (Contact)row.getObject();
%>
<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
        <portlet:param name="action" value="update"/>
        <portlet:param name="contactId" value="<%=String.valueOf(contact.getPersonId())%>"/>
	</portlet:renderURL>    
    <liferay-ui:icon image="edit" url="<%= editURL %>" />

	<portlet:actionURL var="deleteContactURL">
	    <portlet:param name="action" value="delete"/>
	    <portlet:param name="contactId" value="<%=String.valueOf(contact.getPersonId())%>"/>
	</portlet:actionURL>
    <liferay-ui:icon image="delete" url="<%= deleteContactURL %>" />
</liferay-ui:icon-menu>