<%@page import="org.rsc.liferay.contact.controller.ContactDisplayTerms"%>
<%@ include file="/html/init.jsp" %>

<%@page import="org.rsc.liferay.contact.controller.ContactSearchContainer"%>

<%
ContactSearchContainer searchContainer = (ContactSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

ContactDisplayTerms displayTerms = (ContactDisplayTerms)searchContainer.getDisplayTerms();
%>
<%=searchContainer %>
<liferay-ui:search-toggle
    autoFocus="true"
    buttonLabel="search"
    displayTerms="<%= displayTerms %>"
    id="toggle_id_users_groups_admin_group_search"
>
    <aui:fieldset>
        <aui:input name="<%= displayTerms.LAST_NAME %>" size="20" value="<%= displayTerms.getLastName() %>" />
        <aui:input name="<%= displayTerms.FIRST_NAME %>" size="20" value="<%= displayTerms.getFirstName() %>" />
    </aui:fieldset>
</liferay-ui:search-toggle>