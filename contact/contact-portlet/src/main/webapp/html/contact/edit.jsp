<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="org.rsc.liferay.contact.model.Contact"%>
<%@ include file="/html/init.jsp" %>

<%
Contact contactRow = (Contact)request.getAttribute("contactRow");
long contactId = BeanParamUtil.getLong(contactRow, request, "personId");
%>
<portlet:actionURL var="editContactURL">
</portlet:actionURL>

<portlet:renderURL var="backURL">
</portlet:renderURL>

<aui:form action="<%=editContactURL%>" method="post" name="editContact">
    <aui:input name="action" type="hidden" value="<%= (contactId == 0) ? Constants.ADD : Constants.UPDATE %>" />
    <aui:input name="personId" type="hidden" value="<%= contactId %>" />
    <liferay-ui:header
        backURL="<%= backURL %>"
        localizeTitle="<%= (contactRow == null) %>"
        title='<%= (contactRow == null) ? "new-contact" : contactRow.getLastName()+ " "+contactRow.getFirstName() %>'
    />
    <aui:fieldset>
        <aui:column>
            <aui:input type="text" name="lastName" label="First Name" bean="${contactRow}">
                <aui:validator name="required" errorMessage="firstname-required"/>
            </aui:input>
            <aui:input type="text" name="firstName" label="Last Name" bean="${contactRow}">
                <aui:validator name="required" errorMessage="lastname-required"/>
            </aui:input>
            <aui:input type="text" name="mail" label="Email" bean="${contactRow}">
                <aui:validator name="email" />
            </aui:input>
            <aui:input type="text" name="phone" label="Phone No" bean="${contactRow}">
                <aui:validator name="digits" />
            </aui:input>
            <aui:button type="submit" value="Save" />
        </aui:column>
    </aui:fieldset>
</aui:form>