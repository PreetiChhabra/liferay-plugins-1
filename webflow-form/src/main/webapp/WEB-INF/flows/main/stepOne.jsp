<%@ include file="/WEB-INF/flows/init.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Edit Form</h2>
<portlet:actionURL var="actionUrl">
	<portlet:param name="execution" value="${flowExecutionKey}" />
</portlet:actionURL>

<aui:form action="${actionUrl}" method="post" name="claimForm_fm">
	<aui:input type="hidden" name="execution" value="${flowExecutionKey}" inlineLabel="true" useNamespace="false" />
    <aui:input type="text" name="lastname" label="First Name" bean="${claimForm}" inlineLabel="true">
        <!--<aui:validator name="required" errorMessage="firstname-required"/>-->
    </aui:input>
    <aui:input type="text" name="firstname" label="Last Name" bean="${claimForm}" inlineLabel="true">
        <!--<aui:validator name="required" errorMessage="lastname-required"/>-->
    </aui:input>
    <aui:input type="text" name="email" label="Email" bean="${claimForm}" inlineLabel="true">
        <!--<aui:validator name="email" />-->
    </aui:input>
    <aui:button type="submit" name="_eventId_cancel" value="Cancel"  />
	<aui:button type="submit" name="_eventId_next" value="Next" primary="true"/>
	<input type="submit" name="_eventId_next" value="Next" />&#160;	
</aui:form>

