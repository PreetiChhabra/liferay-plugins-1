<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="org.rsc.liferay.contact.model.Contact"%>
<%@ include file="/html/init.jsp" %>
<%
Contact contact = (Contact)request.getAttribute("contact");
long contactId = BeanParamUtil.getLong(contact, request, "personId");
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
        localizeTitle="<%= (contact == null) %>"
        title='<%= (contact == null) ? "new-contact" : contact.getLastName()+ " "+contact.getFirstName() %>'
    />
    <aui:fieldset>
        <aui:column>
            <aui:input type="text" name="lastName" label="First Name" bean="${contact}">
                <aui:validator name="required" errorMessage="firstname-required"/>
            </aui:input>
            <aui:input type="text" name="firstName" label="Last Name" bean="${contact}">
                <aui:validator name="required" errorMessage="lastname-required"/>
            </aui:input>
            <aui:input type="text" name="mail" label="Email" bean="${contact}">
                <aui:validator name="email" />
            </aui:input>
            <aui:input type="text" name="phone" label="Phone No" bean="${contact}">
                <aui:validator name="digits" />
            </aui:input>
            <aui:button type="submit" value="Save" />
        </aui:column>
    </aui:fieldset>
</aui:form>