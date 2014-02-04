<%@ include file="/html/init.jsp" %>

<%@page import="org.rsc.liferay.contact.search.ContactDisplayTerms"%>
<%@page import="org.rsc.liferay.contact.search.ContactSearchContainer"%>

<%
ContactSearchContainer searchContainer = (ContactSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
ContactDisplayTerms displayTerms = (ContactDisplayTerms)searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle
    autoFocus="true"
    buttonLabel="search"
    displayTerms="<%= displayTerms %>"
    id="toggle_id_contact_search">
    <aui:fieldset>
        <aui:input name="<%= ContactDisplayTerms.LAST_NAME %>" size="20" value="<%= displayTerms.getLastName() %>" />
        <aui:input name="<%= ContactDisplayTerms.FIRST_NAME %>" size="20" value="<%= displayTerms.getFirstName() %>" />
    </aui:fieldset>
</liferay-ui:search-toggle>